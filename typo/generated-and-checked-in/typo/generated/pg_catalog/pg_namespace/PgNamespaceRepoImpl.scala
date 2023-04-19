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
package pg_namespace

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

object PgNamespaceRepoImpl extends PgNamespaceRepo {
  override def delete(oid: PgNamespaceId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_namespace where oid = $oid".executeUpdate() > 0
  }
  override def insert(oid: PgNamespaceId, unsaved: PgNamespaceRowUnsaved)(implicit c: Connection): Boolean = {
    SQL"""insert into pg_catalog.pg_namespace(oid, nspname, nspowner, nspacl)
          values (${oid}, ${unsaved.nspname}, ${unsaved.nspowner}, ${unsaved.nspacl})
    """.execute()
  
  }
  override def selectAll(implicit c: Connection): List[PgNamespaceRow] = {
    SQL"select oid, nspname, nspowner, nspacl from pg_catalog.pg_namespace".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgNamespaceFieldOrIdValue[_]])(implicit c: Connection): List[PgNamespaceRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgNamespaceFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspname(value) => NamedParameter("nspname", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspowner(value) => NamedParameter("nspowner", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspacl(value) => NamedParameter("nspacl", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_namespace where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(oid: PgNamespaceId)(implicit c: Connection): Option[PgNamespaceRow] = {
    SQL"select oid, nspname, nspowner, nspacl from pg_catalog.pg_namespace where oid = $oid".as(rowParser.singleOpt)
  }
  override def selectByIds(oids: Array[PgNamespaceId])(implicit c: Connection): List[PgNamespaceRow] = {
    implicit val arrayToSql: ToSql[Array[PgNamespaceId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[PgNamespaceId]] =
      (s: PreparedStatement, index: Int, v: Array[PgNamespaceId]) =>
        s.setArray(index, s.getConnection.createArrayOf("oid", v.map(x => x.value: java.lang.Long)))
    
    SQL"select oid, nspname, nspowner, nspacl from pg_catalog.pg_namespace where oid = ANY($oids)".as(rowParser.*)
  
  }
  override def selectByUnique(nspname: String)(implicit c: Connection): Option[PgNamespaceRow] = {
    selectByFieldValues(List(PgNamespaceFieldValue.nspname(nspname))).headOption
  }
  override def update(row: PgNamespaceRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_namespace
          set nspname = ${row.nspname},
              nspowner = ${row.nspowner},
              nspacl = ${row.nspacl}
          where oid = $oid""".executeUpdate() > 0
  }
  override def updateFieldValues(oid: PgNamespaceId, fieldValues: List[PgNamespaceFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgNamespaceFieldValue.nspname(value) => NamedParameter("nspname", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspowner(value) => NamedParameter("nspowner", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspacl(value) => NamedParameter("nspacl", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_namespace
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where oid = $oid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[PgNamespaceRow] =
    RowParser[PgNamespaceRow] { row =>
      Success(
        PgNamespaceRow(
          oid = row[PgNamespaceId]("oid"),
          nspname = row[String]("nspname"),
          nspowner = row[/* oid */ Long]("nspowner"),
          nspacl = row[Option[Array[/* aclitem */ PGobject]]]("nspacl")
        )
      )
    }
  val idRowParser: RowParser[PgNamespaceId] =
    SqlParser.get[PgNamespaceId]("oid")
}
