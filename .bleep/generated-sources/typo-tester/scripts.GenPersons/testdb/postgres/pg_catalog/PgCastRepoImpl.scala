/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgCastRepoImpl extends PgCastRepo {
  override def selectAll(implicit c: Connection): List[PgCastRow] = {
    SQL"""select oid, castsource, casttarget, castfunc, castcontext, castmethod from pg_catalog.pg_cast""".as(PgCastRow.rowParser.*)
  }
  override def selectById(oid: PgCastId)(implicit c: Connection): Option[PgCastRow] = {
    SQL"""select oid, castsource, casttarget, castfunc, castcontext, castmethod from pg_catalog.pg_cast where oid = $oid""".as(PgCastRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgCastId])(implicit c: Connection): List[PgCastRow] = {
    SQL"""select oid, castsource, casttarget, castfunc, castcontext, castmethod from pg_catalog.pg_cast where oid in $oids""".as(PgCastRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgCastFieldValue[_]])(implicit c: Connection): List[PgCastRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgCastFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgCastFieldValue.castsource(value) => NamedParameter("castsource", ParameterValue.from(value))
          case PgCastFieldValue.casttarget(value) => NamedParameter("casttarget", ParameterValue.from(value))
          case PgCastFieldValue.castfunc(value) => NamedParameter("castfunc", ParameterValue.from(value))
          case PgCastFieldValue.castcontext(value) => NamedParameter("castcontext", ParameterValue.from(value))
          case PgCastFieldValue.castmethod(value) => NamedParameter("castmethod", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_cast where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgCastRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgCastId, fieldValues: List[PgCastFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgCastFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgCastFieldValue.castsource(value) => NamedParameter("castsource", ParameterValue.from(value))
          case PgCastFieldValue.casttarget(value) => NamedParameter("casttarget", ParameterValue.from(value))
          case PgCastFieldValue.castfunc(value) => NamedParameter("castfunc", ParameterValue.from(value))
          case PgCastFieldValue.castcontext(value) => NamedParameter("castcontext", ParameterValue.from(value))
          case PgCastFieldValue.castmethod(value) => NamedParameter("castmethod", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_cast
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgCastId, unsaved: PgCastRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("castsource", ParameterValue.from(unsaved.castsource))),
      Some(NamedParameter("casttarget", ParameterValue.from(unsaved.casttarget))),
      Some(NamedParameter("castfunc", ParameterValue.from(unsaved.castfunc))),
      Some(NamedParameter("castcontext", ParameterValue.from(unsaved.castcontext))),
      Some(NamedParameter("castmethod", ParameterValue.from(unsaved.castmethod)))
    ).flatten

    SQL"""insert into pg_catalog.pg_cast(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgCastId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_cast where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(castsource: Long, casttarget: Long)(implicit c: Connection): Option[PgCastRow] = {
    ???
  }
}
