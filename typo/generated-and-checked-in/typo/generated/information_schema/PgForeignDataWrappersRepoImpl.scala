/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgForeignDataWrappersRepoImpl extends PgForeignDataWrappersRepo {
  override def selectAll(implicit c: Connection): List[PgForeignDataWrappersRow] = {
    SQL"""select oid, fdwowner, fdwoptions, foreign_data_wrapper_catalog, foreign_data_wrapper_name, authorization_identifier, foreign_data_wrapper_language from information_schema._pg_foreign_data_wrappers""".as(PgForeignDataWrappersRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgForeignDataWrappersFieldValue[_]])(implicit c: Connection): List[PgForeignDataWrappersRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignDataWrappersFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgForeignDataWrappersFieldValue.fdwowner(value) => NamedParameter("fdwowner", ParameterValue.from(value))
          case PgForeignDataWrappersFieldValue.fdwoptions(value) => NamedParameter("fdwoptions", ParameterValue.from(value))
          case PgForeignDataWrappersFieldValue.foreignDataWrapperCatalog(value) => NamedParameter("foreign_data_wrapper_catalog", ParameterValue.from(value))
          case PgForeignDataWrappersFieldValue.foreignDataWrapperName(value) => NamedParameter("foreign_data_wrapper_name", ParameterValue.from(value))
          case PgForeignDataWrappersFieldValue.authorizationIdentifier(value) => NamedParameter("authorization_identifier", ParameterValue.from(value))
          case PgForeignDataWrappersFieldValue.foreignDataWrapperLanguage(value) => NamedParameter("foreign_data_wrapper_language", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema._pg_foreign_data_wrappers where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgForeignDataWrappersRow.rowParser.*)
    }

  }
}