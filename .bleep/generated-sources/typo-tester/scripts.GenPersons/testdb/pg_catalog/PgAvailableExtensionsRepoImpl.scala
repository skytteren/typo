package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgAvailableExtensionsRepoImpl extends PgAvailableExtensionsRepo {
  override def selectAll(implicit c: Connection): List[PgAvailableExtensionsRow] = {
    SQL"""select name, default_version, installed_version, comment from pg_catalog.pg_available_extensions""".as(PgAvailableExtensionsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgAvailableExtensionsFieldValue[_]])(implicit c: Connection): List[PgAvailableExtensionsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAvailableExtensionsFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PgAvailableExtensionsFieldValue.defaultVersion(value) => NamedParameter("default_version", ParameterValue.from(value))
          case PgAvailableExtensionsFieldValue.installedVersion(value) => NamedParameter("installed_version", ParameterValue.from(value))
          case PgAvailableExtensionsFieldValue.comment(value) => NamedParameter("comment", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_available_extensions where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgAvailableExtensionsRow.rowParser.*)
    }

  }
}