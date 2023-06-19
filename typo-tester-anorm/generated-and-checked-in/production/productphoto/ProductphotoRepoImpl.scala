/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object ProductphotoRepoImpl extends ProductphotoRepo {
  override def delete(productphotoid: ProductphotoId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productphoto where productphotoid = $productphotoid".executeUpdate() > 0
  }
  override def insert(unsaved: ProductphotoRow)(implicit c: Connection): ProductphotoRow = {
    SQL"""insert into production.productphoto(productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate)
          values (${unsaved.productphotoid}::int4, ${unsaved.thumbnailphoto}::bytea, ${unsaved.thumbnailphotofilename}, ${unsaved.largephoto}::bytea, ${unsaved.largephotofilename}, ${unsaved.modifieddate}::timestamp)
          returning productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate
       """
      .executeInsert(ProductphotoRow.rowParser.single)
  
  }
  override def insert(unsaved: ProductphotoRowUnsaved)(implicit c: Connection): ProductphotoRow = {
    val namedParameters = List(
      Some((NamedParameter("thumbnailphoto", ParameterValue.from(unsaved.thumbnailphoto)), "::bytea")),
      Some((NamedParameter("thumbnailphotofilename", ParameterValue.from(unsaved.thumbnailphotofilename)), "")),
      Some((NamedParameter("largephoto", ParameterValue.from(unsaved.largephoto)), "::bytea")),
      Some((NamedParameter("largephotofilename", ParameterValue.from(unsaved.largephotofilename)), "")),
      unsaved.productphotoid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productphotoid", ParameterValue.from[ProductphotoId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productphoto default values
            returning productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate
         """
        .executeInsert(ProductphotoRow.rowParser.single)
    } else {
      val q = s"""insert into production.productphoto(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ProductphotoRow.rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ProductphotoRow] = {
    SQL"""select productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate
          from production.productphoto
       """.as(ProductphotoRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductphotoFieldOrIdValue[_]])(implicit c: Connection): List[ProductphotoRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductphotoFieldValue.productphotoid(value) => NamedParameter("productphotoid", ParameterValue.from(value))
          case ProductphotoFieldValue.thumbnailphoto(value) => NamedParameter("thumbnailphoto", ParameterValue.from(value))
          case ProductphotoFieldValue.thumbnailphotofilename(value) => NamedParameter("thumbnailphotofilename", ParameterValue.from(value))
          case ProductphotoFieldValue.largephoto(value) => NamedParameter("largephoto", ParameterValue.from(value))
          case ProductphotoFieldValue.largephotofilename(value) => NamedParameter("largephotofilename", ParameterValue.from(value))
          case ProductphotoFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate
                    from production.productphoto
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(ProductphotoRow.rowParser.*)
    }
  
  }
  override def selectById(productphotoid: ProductphotoId)(implicit c: Connection): Option[ProductphotoRow] = {
    SQL"""select productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate
          from production.productphoto
          where productphotoid = $productphotoid
       """.as(ProductphotoRow.rowParser.singleOpt)
  }
  override def selectByIds(productphotoids: Array[ProductphotoId])(implicit c: Connection): List[ProductphotoRow] = {
    implicit val toStatement: ToStatement[Array[ProductphotoId]] =
      (s: PreparedStatement, index: Int, v: Array[ProductphotoId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate
          from production.productphoto
          where productphotoid = ANY($productphotoids)
       """.as(ProductphotoRow.rowParser.*)
  
  }
  override def update(row: ProductphotoRow)(implicit c: Connection): Boolean = {
    val productphotoid = row.productphotoid
    SQL"""update production.productphoto
          set thumbnailphoto = ${row.thumbnailphoto}::bytea,
              thumbnailphotofilename = ${row.thumbnailphotofilename},
              largephoto = ${row.largephoto}::bytea,
              largephotofilename = ${row.largephotofilename},
              modifieddate = ${row.modifieddate}::timestamp
          where productphotoid = $productphotoid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(productphotoid: ProductphotoId, fieldValues: List[ProductphotoFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductphotoFieldValue.thumbnailphoto(value) => NamedParameter("thumbnailphoto", ParameterValue.from(value))
          case ProductphotoFieldValue.thumbnailphotofilename(value) => NamedParameter("thumbnailphotofilename", ParameterValue.from(value))
          case ProductphotoFieldValue.largephoto(value) => NamedParameter("largephoto", ParameterValue.from(value))
          case ProductphotoFieldValue.largephotofilename(value) => NamedParameter("largephotofilename", ParameterValue.from(value))
          case ProductphotoFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.productphoto
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where productphotoid = {productphotoid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("productphotoid", ParameterValue.from(productphotoid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: ProductphotoRow)(implicit c: Connection): ProductphotoRow = {
    SQL"""insert into production.productphoto(productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate)
          values (
            ${unsaved.productphotoid}::int4,
            ${unsaved.thumbnailphoto}::bytea,
            ${unsaved.thumbnailphotofilename},
            ${unsaved.largephoto}::bytea,
            ${unsaved.largephotofilename},
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productphotoid)
          do update set
            thumbnailphoto = EXCLUDED.thumbnailphoto,
            thumbnailphotofilename = EXCLUDED.thumbnailphotofilename,
            largephoto = EXCLUDED.largephoto,
            largephotofilename = EXCLUDED.largephotofilename,
            modifieddate = EXCLUDED.modifieddate
          returning productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate
       """
      .executeInsert(ProductphotoRow.rowParser.single)
  
  }
}
