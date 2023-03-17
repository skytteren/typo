package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait ForeignTablesRepoImpl extends ForeignTablesRepo {
  override def selectAll(implicit c: Connection): List[ForeignTablesRow] = {
    SQL"""select foreign_table_catalog, foreign_table_schema, foreign_table_name, foreign_server_catalog, foreign_server_name from information_schema.foreign_tables""".as(ForeignTablesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ForeignTablesFieldValue[_]])(implicit c: Connection): List[ForeignTablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ForeignTablesFieldValue.foreignTableCatalog(value) => NamedParameter("foreign_table_catalog", ParameterValue.from(value))
          case ForeignTablesFieldValue.foreignTableSchema(value) => NamedParameter("foreign_table_schema", ParameterValue.from(value))
          case ForeignTablesFieldValue.foreignTableName(value) => NamedParameter("foreign_table_name", ParameterValue.from(value))
          case ForeignTablesFieldValue.foreignServerCatalog(value) => NamedParameter("foreign_server_catalog", ParameterValue.from(value))
          case ForeignTablesFieldValue.foreignServerName(value) => NamedParameter("foreign_server_name", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.foreign_tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(ForeignTablesRow.rowParser.*)
    }

  }
}