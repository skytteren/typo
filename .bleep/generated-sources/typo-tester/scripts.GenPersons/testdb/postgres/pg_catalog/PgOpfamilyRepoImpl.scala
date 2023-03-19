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
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgOpfamilyRepoImpl extends PgOpfamilyRepo {
  override def selectAll(implicit c: Connection): List[PgOpfamilyRow] = {
    SQL"""select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily""".as(PgOpfamilyRow.rowParser.*)
  }
  override def selectById(oid: PgOpfamilyId)(implicit c: Connection): Option[PgOpfamilyRow] = {
    SQL"""select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily where oid = $oid""".as(PgOpfamilyRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgOpfamilyId])(implicit c: Connection): List[PgOpfamilyRow] = {
    SQL"""select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily where oid in $oids""".as(PgOpfamilyRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgOpfamilyFieldValue[_]])(implicit c: Connection): List[PgOpfamilyRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgOpfamilyFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgOpfamilyFieldValue.opfmethod(value) => NamedParameter("opfmethod", ParameterValue.from(value))
          case PgOpfamilyFieldValue.opfname(value) => NamedParameter("opfname", ParameterValue.from(value))
          case PgOpfamilyFieldValue.opfnamespace(value) => NamedParameter("opfnamespace", ParameterValue.from(value))
          case PgOpfamilyFieldValue.opfowner(value) => NamedParameter("opfowner", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_opfamily where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgOpfamilyRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgOpfamilyId, fieldValues: List[PgOpfamilyFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgOpfamilyFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgOpfamilyFieldValue.opfmethod(value) => NamedParameter("opfmethod", ParameterValue.from(value))
          case PgOpfamilyFieldValue.opfname(value) => NamedParameter("opfname", ParameterValue.from(value))
          case PgOpfamilyFieldValue.opfnamespace(value) => NamedParameter("opfnamespace", ParameterValue.from(value))
          case PgOpfamilyFieldValue.opfowner(value) => NamedParameter("opfowner", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_opfamily
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgOpfamilyId, unsaved: PgOpfamilyRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("opfmethod", ParameterValue.from(unsaved.opfmethod))),
      Some(NamedParameter("opfname", ParameterValue.from(unsaved.opfname))),
      Some(NamedParameter("opfnamespace", ParameterValue.from(unsaved.opfnamespace))),
      Some(NamedParameter("opfowner", ParameterValue.from(unsaved.opfowner)))
    ).flatten

    SQL"""insert into pg_catalog.pg_opfamily(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgOpfamilyId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_opfamily where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(opfmethod: Long, opfname: String, opfnamespace: Long)(implicit c: Connection): Option[PgOpfamilyRow] = {
    ???
  }
}
