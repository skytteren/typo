package typo
package internal

import typo.internal.rewriteDependentData.Eval

case class TableComputed(
    options: InternalOptions,
    default: DefaultComputed,
    dbTable: db.Table,
    naming: Naming,
    scalaTypeMapper: TypeMapperScala,
    eval: Eval[db.RelationName, Either[ViewComputed, TableComputed]]
) {
  val pointsTo: Map[db.ColName, (db.RelationName, db.ColName)] =
    dbTable.foreignKeys.flatMap(fk => fk.cols.zip(fk.otherCols.map(cn => (fk.otherTable, cn)))).toMap
  val dbColsByName: Map[db.ColName, db.Col] =
    dbTable.cols.map(col => (col.name, col)).toMap

  val maybeId: Option[IdComputed] =
    dbTable.primaryKey.flatMap { pk =>
      val qident = naming.idName(dbTable.name)
      pk.colNames match {
        case Nil => None
        case colName :: Nil =>
          val dbCol = dbColsByName(colName)
          val underlying = scalaTypeMapper(Right(dbTable.name), dbCol, None)
          val col = ColumnComputed(
            pointsTo = pointsTo.get(dbCol.name),
            name = naming.field(dbCol.name),
            tpe = underlying,
            dbName = dbCol.name,
            hasDefault = dbCol.hasDefault,
            jsonDescription = dbCol.jsonDescription
          )
          if (sc.Type.containsUserDefined(underlying))
            Some(IdComputed.UnaryUserSpecified(col, underlying))
          else
            Some(IdComputed.UnaryNormal(col, qident))

        case colNames =>
          val cols: List[ColumnComputed] =
            colNames.map { colName =>
              val dbCol = dbColsByName(colName)
              ColumnComputed(
                pointsTo = None,
                name = naming.field(colName),
                tpe = deriveType(dbCol),
                dbName = dbCol.name,
                hasDefault = dbCol.hasDefault,
                jsonDescription = dbCol.jsonDescription
              )
            }
          Some(IdComputed.Composite(cols, qident, paramName = sc.Ident("compositeId")))
      }
    }

  val dbColsAndCols: List[(db.Col, ColumnComputed)] = {
    dbTable.cols.map { dbCol =>
      val tpe = deriveType(dbCol)

      val computed = ColumnComputed(
        pointsTo = pointsTo.get(dbCol.name),
        name = naming.field(dbCol.name),
        tpe = tpe,
        dbName = dbCol.name,
        hasDefault = dbCol.hasDefault,
        jsonDescription = dbCol.jsonDescription
      )

      dbCol -> computed
    }
  }

  def deriveType(dbCol: db.Col) = {
    // we let types flow through constraints down to this column, the point is to reuse id types downstream
    val typeFromFk: Option[sc.Type] =
      pointsTo.get(dbCol.name) match {
        case Some((otherTableName, otherColName)) if otherTableName != dbTable.name =>
          eval(otherTableName).get match {
            case Some(otherTable) =>
              val cols = otherTable match {
                case Left(view)   => view.cols
                case Right(table) => table.cols
              }
              cols.find(_.dbName == otherColName).map(_.tpe)
            case None =>
              System.err.println(s"Unexpected circular dependency involving ${dbTable.name.value} => ${otherTableName.value}")
              None
          }

        case _ => None
      }

    val typeFromId: Option[sc.Type] =
      maybeId match {
        case Some(id: IdComputed.Unary) if id.col.dbName == dbCol.name => Some(id.tpe)
        case _                                                         => None
      }

    val tpe = scalaTypeMapper(Right(dbTable.name), dbCol, typeFromFk.orElse(typeFromId))

    tpe
  }

  val cols: List[ColumnComputed] = dbColsAndCols.map { case (_, col) => col }

  val relation = RelationComputed(naming, dbTable.name, cols, maybeId)

  val colsUnsaved: Option[List[ColumnComputed]] = maybeId
    .map { _ =>
      dbColsAndCols
        .filterNot { case (_, col) => dbTable.primaryKey.exists(_.colNames.contains(col.dbName)) }
        .map { case (dbCol, col) =>
          val newType = if (dbCol.hasDefault) sc.Type.TApply(default.DefaultedType, List(col.tpe)) else col.tpe
          col.copy(tpe = newType)
        }
    }
    .filter(_.nonEmpty)

  val RowUnsavedName: Option[sc.QIdent] =
    if (colsUnsaved.nonEmpty) Some(naming.rowUnsaved(dbTable.name)) else None

  val RowJoined: Option[RowJoinedComputed] =
    if (dbTable.foreignKeys.nonEmpty) {
      val name = naming.joinedRow(dbTable.name)

      val maybeParams = dbTable.foreignKeys.flatMap {
        case fk if fk.otherTable == dbTable.name => None
        case fk =>
          eval(fk.otherTable).get match {
            case Some(Right(nonCircularTable)) =>
              val tpe = sc.Type.Qualified(nonCircularTable.relation.RowName)
              val fkContainsNullableRow = fk.cols.exists { colName =>
                dbColsByName(colName).nullability != Nullability.NoNulls
              }
              val tpeWithNullability = if (fkContainsNullableRow) sc.Type.Option.of(tpe) else tpe

              val newParam = RowJoinedComputed.Param(
                name = naming.field(fk.cols),
                tpe = tpeWithNullability,
                isOptional = fkContainsNullableRow,
                table = nonCircularTable
              )

              Some(newParam)
            case Some(Left(_)) =>
              System.err.println(s"Unexpected dependency on view ${dbTable.name.value} => ${fk.otherTable.value}")
              None
            case None =>
              System.err.println(s"Unexpected circular dependency ${dbTable.name.value} => ${fk.otherTable.value}")
              None
          }
      }
      maybeParams match {
        case Nil =>
          None
        case params =>
          val thisParam = RowJoinedComputed.Param(sc.Ident("value"), sc.Type.Qualified(relation.RowName), isOptional = false, table = this)
          Some(RowJoinedComputed(name, thisParam :: params))
      }

    } else None

  val repoMethods: Option[List[RepoMethod]] = {
    val RowType = sc.Type.Qualified(relation.RowName)

    val fieldValuesParam = sc.Param(
      sc.Ident("fieldValues"),
      sc.Type.List.of(sc.Type.Qualified(relation.FieldValueName).of(sc.Type.Wildcard))
    )

    val maybeMethods = List(
      maybeId match {
        case Some(id) =>
          val updateMethod = RowUnsavedName.zip(colsUnsaved).map { case (unsaved, colsUnsaved) =>
            val unsavedParam = sc.Param(sc.Ident("unsaved"), sc.Type.Qualified(unsaved))

            if (id.cols.forall(_.hasDefault))
              RepoMethod.InsertDbGeneratedKey(id, colsUnsaved, unsavedParam, default)
            else
              RepoMethod.InsertProvidedKey(id, colsUnsaved, unsavedParam, default)
          }

          List[Iterable[RepoMethod]](
            Some(RepoMethod.SelectAll(RowType)),
            Some(RepoMethod.SelectById(id, RowType)),
            id match {
              case unary: IdComputed.Unary =>
                Some(RepoMethod.SelectAllByIds(unary, sc.Param(id.paramName.appended("s"), sc.Type.List.of(id.tpe)), RowType))
              case IdComputed.Composite(_, _, _) =>
                None
            },
            Some(RepoMethod.SelectByFieldValues(fieldValuesParam, RowType)),
            Some(RepoMethod.UpdateFieldValues(id, fieldValuesParam)),
            updateMethod,
            Some(RepoMethod.Delete(id))
          ).flatten
        case None =>
          List(
            RepoMethod.SelectAll(RowType),
            RepoMethod.SelectByFieldValues(fieldValuesParam, RowType)
          )
      },
      dbTable.uniqueKeys.map { uk =>
        val params = uk.cols.map(colName => cols.find(_.dbName == colName).get)
        RepoMethod.SelectByUnique(params, RowType)
      }
    )
    Some(maybeMethods.flatten).filter(_.nonEmpty)
  }
}