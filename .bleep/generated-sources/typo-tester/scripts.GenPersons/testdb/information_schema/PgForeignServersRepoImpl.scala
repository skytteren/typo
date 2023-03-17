package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgForeignServersRepoImpl extends PgForeignServersRepo {
  override def selectAll(implicit c: Connection): List[PgForeignServersRow] = {
    SQL"""select oid, srvoptions, foreign_server_catalog, foreign_server_name, foreign_data_wrapper_catalog, foreign_data_wrapper_name, foreign_server_type, foreign_server_version, authorization_identifier from information_schema._pg_foreign_servers""".as(PgForeignServersRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgForeignServersFieldValue[_]])(implicit c: Connection): List[PgForeignServersRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignServersFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgForeignServersFieldValue.srvoptions(value) => NamedParameter("srvoptions", ParameterValue.from(value))
          case PgForeignServersFieldValue.foreignServerCatalog(value) => NamedParameter("foreign_server_catalog", ParameterValue.from(value))
          case PgForeignServersFieldValue.foreignServerName(value) => NamedParameter("foreign_server_name", ParameterValue.from(value))
          case PgForeignServersFieldValue.foreignDataWrapperCatalog(value) => NamedParameter("foreign_data_wrapper_catalog", ParameterValue.from(value))
          case PgForeignServersFieldValue.foreignDataWrapperName(value) => NamedParameter("foreign_data_wrapper_name", ParameterValue.from(value))
          case PgForeignServersFieldValue.foreignServerType(value) => NamedParameter("foreign_server_type", ParameterValue.from(value))
          case PgForeignServersFieldValue.foreignServerVersion(value) => NamedParameter("foreign_server_version", ParameterValue.from(value))
          case PgForeignServersFieldValue.authorizationIdentifier(value) => NamedParameter("authorization_identifier", ParameterValue.from(value))
        }
        SQL"""select * from information_schema._pg_foreign_servers where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgForeignServersRow.rowParser.*)
    }

  }
}