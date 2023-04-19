/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_constraint

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToSql
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import org.postgresql.util.PGobject

object PgConstraintRepoImpl extends PgConstraintRepo {
  override def delete(oid: PgConstraintId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_constraint where oid = $oid""".executeUpdate() > 0
  }
  override def insert(oid: PgConstraintId, unsaved: PgConstraintRowUnsaved)(implicit c: Connection): Boolean = {
    SQL"""insert into pg_catalog.pg_constraint(oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin)
          values (${oid}, ${unsaved.conname}, ${unsaved.connamespace}, ${unsaved.contype}, ${unsaved.condeferrable}, ${unsaved.condeferred}, ${unsaved.convalidated}, ${unsaved.conrelid}, ${unsaved.contypid}, ${unsaved.conindid}, ${unsaved.conparentid}, ${unsaved.confrelid}, ${unsaved.confupdtype}, ${unsaved.confdeltype}, ${unsaved.confmatchtype}, ${unsaved.conislocal}, ${unsaved.coninhcount}, ${unsaved.connoinherit}, ${unsaved.conkey}, ${unsaved.confkey}, ${unsaved.conpfeqop}, ${unsaved.conppeqop}, ${unsaved.conffeqop}, ${unsaved.conexclop}, ${unsaved.conbin})
    """.execute()
  
  }
  override def selectAll(implicit c: Connection): List[PgConstraintRow] = {
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgConstraintFieldOrIdValue[_]])(implicit c: Connection): List[PgConstraintRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgConstraintFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgConstraintFieldValue.conname(value) => NamedParameter("conname", ParameterValue.from(value))
          case PgConstraintFieldValue.connamespace(value) => NamedParameter("connamespace", ParameterValue.from(value))
          case PgConstraintFieldValue.contype(value) => NamedParameter("contype", ParameterValue.from(value))
          case PgConstraintFieldValue.condeferrable(value) => NamedParameter("condeferrable", ParameterValue.from(value))
          case PgConstraintFieldValue.condeferred(value) => NamedParameter("condeferred", ParameterValue.from(value))
          case PgConstraintFieldValue.convalidated(value) => NamedParameter("convalidated", ParameterValue.from(value))
          case PgConstraintFieldValue.conrelid(value) => NamedParameter("conrelid", ParameterValue.from(value))
          case PgConstraintFieldValue.contypid(value) => NamedParameter("contypid", ParameterValue.from(value))
          case PgConstraintFieldValue.conindid(value) => NamedParameter("conindid", ParameterValue.from(value))
          case PgConstraintFieldValue.conparentid(value) => NamedParameter("conparentid", ParameterValue.from(value))
          case PgConstraintFieldValue.confrelid(value) => NamedParameter("confrelid", ParameterValue.from(value))
          case PgConstraintFieldValue.confupdtype(value) => NamedParameter("confupdtype", ParameterValue.from(value))
          case PgConstraintFieldValue.confdeltype(value) => NamedParameter("confdeltype", ParameterValue.from(value))
          case PgConstraintFieldValue.confmatchtype(value) => NamedParameter("confmatchtype", ParameterValue.from(value))
          case PgConstraintFieldValue.conislocal(value) => NamedParameter("conislocal", ParameterValue.from(value))
          case PgConstraintFieldValue.coninhcount(value) => NamedParameter("coninhcount", ParameterValue.from(value))
          case PgConstraintFieldValue.connoinherit(value) => NamedParameter("connoinherit", ParameterValue.from(value))
          case PgConstraintFieldValue.conkey(value) => NamedParameter("conkey", ParameterValue.from(value))
          case PgConstraintFieldValue.confkey(value) => NamedParameter("confkey", ParameterValue.from(value))
          case PgConstraintFieldValue.conpfeqop(value) => NamedParameter("conpfeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conppeqop(value) => NamedParameter("conppeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conffeqop(value) => NamedParameter("conffeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conexclop(value) => NamedParameter("conexclop", ParameterValue.from(value))
          case PgConstraintFieldValue.conbin(value) => NamedParameter("conbin", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_constraint where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(oid: PgConstraintId)(implicit c: Connection): Option[PgConstraintRow] = {
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint where oid = $oid""".as(rowParser.singleOpt)
  }
  override def selectByIds(oids: Array[PgConstraintId])(implicit c: Connection): List[PgConstraintRow] = {
    implicit val arrayToSql: ToSql[Array[PgConstraintId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[PgConstraintId]] =
      (s: PreparedStatement, index: Int, v: Array[PgConstraintId]) =>
        s.setArray(index, s.getConnection.createArrayOf("oid", v.map(x => x.value: java.lang.Long)))
    
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint where oid = ANY($oids)""".as(rowParser.*)
  
  }
  override def selectByUnique(conrelid: /* oid */ Long, contypid: /* oid */ Long, conname: String)(implicit c: Connection): Option[PgConstraintRow] = {
    selectByFieldValues(List(PgConstraintFieldValue.conrelid(conrelid), PgConstraintFieldValue.contypid(contypid), PgConstraintFieldValue.conname(conname))).headOption
  }
  override def update(row: PgConstraintRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_constraint
          set conname = ${row.conname},
              connamespace = ${row.connamespace},
              contype = ${row.contype},
              condeferrable = ${row.condeferrable},
              condeferred = ${row.condeferred},
              convalidated = ${row.convalidated},
              conrelid = ${row.conrelid},
              contypid = ${row.contypid},
              conindid = ${row.conindid},
              conparentid = ${row.conparentid},
              confrelid = ${row.confrelid},
              confupdtype = ${row.confupdtype},
              confdeltype = ${row.confdeltype},
              confmatchtype = ${row.confmatchtype},
              conislocal = ${row.conislocal},
              coninhcount = ${row.coninhcount},
              connoinherit = ${row.connoinherit},
              conkey = ${row.conkey},
              confkey = ${row.confkey},
              conpfeqop = ${row.conpfeqop},
              conppeqop = ${row.conppeqop},
              conffeqop = ${row.conffeqop},
              conexclop = ${row.conexclop},
              conbin = ${row.conbin}
          where oid = $oid""".executeUpdate() > 0
  }
  override def updateFieldValues(oid: PgConstraintId, fieldValues: List[PgConstraintFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgConstraintFieldValue.conname(value) => NamedParameter("conname", ParameterValue.from(value))
          case PgConstraintFieldValue.connamespace(value) => NamedParameter("connamespace", ParameterValue.from(value))
          case PgConstraintFieldValue.contype(value) => NamedParameter("contype", ParameterValue.from(value))
          case PgConstraintFieldValue.condeferrable(value) => NamedParameter("condeferrable", ParameterValue.from(value))
          case PgConstraintFieldValue.condeferred(value) => NamedParameter("condeferred", ParameterValue.from(value))
          case PgConstraintFieldValue.convalidated(value) => NamedParameter("convalidated", ParameterValue.from(value))
          case PgConstraintFieldValue.conrelid(value) => NamedParameter("conrelid", ParameterValue.from(value))
          case PgConstraintFieldValue.contypid(value) => NamedParameter("contypid", ParameterValue.from(value))
          case PgConstraintFieldValue.conindid(value) => NamedParameter("conindid", ParameterValue.from(value))
          case PgConstraintFieldValue.conparentid(value) => NamedParameter("conparentid", ParameterValue.from(value))
          case PgConstraintFieldValue.confrelid(value) => NamedParameter("confrelid", ParameterValue.from(value))
          case PgConstraintFieldValue.confupdtype(value) => NamedParameter("confupdtype", ParameterValue.from(value))
          case PgConstraintFieldValue.confdeltype(value) => NamedParameter("confdeltype", ParameterValue.from(value))
          case PgConstraintFieldValue.confmatchtype(value) => NamedParameter("confmatchtype", ParameterValue.from(value))
          case PgConstraintFieldValue.conislocal(value) => NamedParameter("conislocal", ParameterValue.from(value))
          case PgConstraintFieldValue.coninhcount(value) => NamedParameter("coninhcount", ParameterValue.from(value))
          case PgConstraintFieldValue.connoinherit(value) => NamedParameter("connoinherit", ParameterValue.from(value))
          case PgConstraintFieldValue.conkey(value) => NamedParameter("conkey", ParameterValue.from(value))
          case PgConstraintFieldValue.confkey(value) => NamedParameter("confkey", ParameterValue.from(value))
          case PgConstraintFieldValue.conpfeqop(value) => NamedParameter("conpfeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conppeqop(value) => NamedParameter("conppeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conffeqop(value) => NamedParameter("conffeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conexclop(value) => NamedParameter("conexclop", ParameterValue.from(value))
          case PgConstraintFieldValue.conbin(value) => NamedParameter("conbin", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_constraint
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where oid = $oid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[PgConstraintRow] =
    RowParser[PgConstraintRow] { row =>
      Success(
        PgConstraintRow(
          oid = row[PgConstraintId]("oid"),
          conname = row[String]("conname"),
          connamespace = row[/* oid */ Long]("connamespace"),
          contype = row[String]("contype"),
          condeferrable = row[Boolean]("condeferrable"),
          condeferred = row[Boolean]("condeferred"),
          convalidated = row[Boolean]("convalidated"),
          conrelid = row[/* oid */ Long]("conrelid"),
          contypid = row[/* oid */ Long]("contypid"),
          conindid = row[/* oid */ Long]("conindid"),
          conparentid = row[/* oid */ Long]("conparentid"),
          confrelid = row[/* oid */ Long]("confrelid"),
          confupdtype = row[String]("confupdtype"),
          confdeltype = row[String]("confdeltype"),
          confmatchtype = row[String]("confmatchtype"),
          conislocal = row[Boolean]("conislocal"),
          coninhcount = row[Int]("coninhcount"),
          connoinherit = row[Boolean]("connoinherit"),
          conkey = row[Option[Array[Int]]]("conkey"),
          confkey = row[Option[Array[Int]]]("confkey"),
          conpfeqop = row[Option[Array[/* oid */ Long]]]("conpfeqop"),
          conppeqop = row[Option[Array[/* oid */ Long]]]("conppeqop"),
          conffeqop = row[Option[Array[/* oid */ Long]]]("conffeqop"),
          conexclop = row[Option[Array[/* oid */ Long]]]("conexclop"),
          conbin = row[Option[/* pg_node_tree */ PGobject]]("conbin")
        )
      )
    }
  val idRowParser: RowParser[PgConstraintId] =
    SqlParser.get[PgConstraintId]("oid")
}
