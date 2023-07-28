/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_column_usage

import adventureworks.information_schema.SqlIdentifier
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ConstraintColumnUsageViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  constraintCatalog: Option[SqlIdentifier],
  constraintSchema: Option[SqlIdentifier],
  constraintName: Option[SqlIdentifier]
)

object ConstraintColumnUsageViewRow {
  def rowParser(idx: Int): RowParser[ConstraintColumnUsageViewRow] =
    RowParser[ConstraintColumnUsageViewRow] { row =>
      Success(
        ConstraintColumnUsageViewRow(
          tableCatalog = row[Option[SqlIdentifier]](idx + 0),
          tableSchema = row[Option[SqlIdentifier]](idx + 1),
          tableName = row[Option[SqlIdentifier]](idx + 2),
          columnName = row[Option[SqlIdentifier]](idx + 3),
          constraintCatalog = row[Option[SqlIdentifier]](idx + 4),
          constraintSchema = row[Option[SqlIdentifier]](idx + 5),
          constraintName = row[Option[SqlIdentifier]](idx + 6)
        )
      )
    }
  implicit val oFormat: OFormat[ConstraintColumnUsageViewRow] = new OFormat[ConstraintColumnUsageViewRow]{
    override def writes(o: ConstraintColumnUsageViewRow): JsObject =
      Json.obj(
        "table_catalog" -> o.tableCatalog,
        "table_schema" -> o.tableSchema,
        "table_name" -> o.tableName,
        "column_name" -> o.columnName,
        "constraint_catalog" -> o.constraintCatalog,
        "constraint_schema" -> o.constraintSchema,
        "constraint_name" -> o.constraintName
      )
  
    override def reads(json: JsValue): JsResult[ConstraintColumnUsageViewRow] = {
      JsResult.fromTry(
        Try(
          ConstraintColumnUsageViewRow(
            tableCatalog = json.\("table_catalog").toOption.map(_.as[SqlIdentifier]),
            tableSchema = json.\("table_schema").toOption.map(_.as[SqlIdentifier]),
            tableName = json.\("table_name").toOption.map(_.as[SqlIdentifier]),
            columnName = json.\("column_name").toOption.map(_.as[SqlIdentifier]),
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[SqlIdentifier]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[SqlIdentifier]),
            constraintName = json.\("constraint_name").toOption.map(_.as[SqlIdentifier])
          )
        )
      )
    }
  }
}