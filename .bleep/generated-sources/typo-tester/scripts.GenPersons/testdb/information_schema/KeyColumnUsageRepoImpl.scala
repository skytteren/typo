package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait KeyColumnUsageRepoImpl extends KeyColumnUsageRepo {
  override def selectAll(implicit c: Connection): List[KeyColumnUsageRow] = {
    SQL"""select constraint_catalog, constraint_schema, constraint_name, table_catalog, table_schema, table_name, column_name, ordinal_position, position_in_unique_constraint from information_schema.key_column_usage""".as(KeyColumnUsageRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[KeyColumnUsageFieldValue[_]])(implicit c: Connection): List[KeyColumnUsageRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case KeyColumnUsageFieldValue.constraintCatalog(value) => NamedParameter("constraint_catalog", ParameterValue.from(value))
          case KeyColumnUsageFieldValue.constraintSchema(value) => NamedParameter("constraint_schema", ParameterValue.from(value))
          case KeyColumnUsageFieldValue.constraintName(value) => NamedParameter("constraint_name", ParameterValue.from(value))
          case KeyColumnUsageFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case KeyColumnUsageFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case KeyColumnUsageFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case KeyColumnUsageFieldValue.columnName(value) => NamedParameter("column_name", ParameterValue.from(value))
          case KeyColumnUsageFieldValue.ordinalPosition(value) => NamedParameter("ordinal_position", ParameterValue.from(value))
          case KeyColumnUsageFieldValue.positionInUniqueConstraint(value) => NamedParameter("position_in_unique_constraint", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.key_column_usage where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(KeyColumnUsageRow.rowParser.*)
    }

  }
}