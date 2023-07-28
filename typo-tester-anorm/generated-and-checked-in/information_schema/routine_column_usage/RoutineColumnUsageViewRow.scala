/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_column_usage

import adventureworks.information_schema.SqlIdentifier
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class RoutineColumnUsageViewRow(
  specificCatalog: Option[SqlIdentifier],
  specificSchema: Option[SqlIdentifier],
  specificName: Option[SqlIdentifier],
  routineCatalog: Option[SqlIdentifier],
  routineSchema: Option[SqlIdentifier],
  routineName: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier]
)

object RoutineColumnUsageViewRow {
  implicit val reads: Reads[RoutineColumnUsageViewRow] = Reads[RoutineColumnUsageViewRow](json => JsResult.fromTry(
      Try(
        RoutineColumnUsageViewRow(
          specificCatalog = json.\("specific_catalog").toOption.map(_.as[SqlIdentifier]),
          specificSchema = json.\("specific_schema").toOption.map(_.as[SqlIdentifier]),
          specificName = json.\("specific_name").toOption.map(_.as[SqlIdentifier]),
          routineCatalog = json.\("routine_catalog").toOption.map(_.as[SqlIdentifier]),
          routineSchema = json.\("routine_schema").toOption.map(_.as[SqlIdentifier]),
          routineName = json.\("routine_name").toOption.map(_.as[SqlIdentifier]),
          tableCatalog = json.\("table_catalog").toOption.map(_.as[SqlIdentifier]),
          tableSchema = json.\("table_schema").toOption.map(_.as[SqlIdentifier]),
          tableName = json.\("table_name").toOption.map(_.as[SqlIdentifier]),
          columnName = json.\("column_name").toOption.map(_.as[SqlIdentifier])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[RoutineColumnUsageViewRow] = RowParser[RoutineColumnUsageViewRow] { row =>
    Success(
      RoutineColumnUsageViewRow(
        specificCatalog = row[Option[SqlIdentifier]](idx + 0),
        specificSchema = row[Option[SqlIdentifier]](idx + 1),
        specificName = row[Option[SqlIdentifier]](idx + 2),
        routineCatalog = row[Option[SqlIdentifier]](idx + 3),
        routineSchema = row[Option[SqlIdentifier]](idx + 4),
        routineName = row[Option[SqlIdentifier]](idx + 5),
        tableCatalog = row[Option[SqlIdentifier]](idx + 6),
        tableSchema = row[Option[SqlIdentifier]](idx + 7),
        tableName = row[Option[SqlIdentifier]](idx + 8),
        columnName = row[Option[SqlIdentifier]](idx + 9)
      )
    )
  }
  implicit val writes: OWrites[RoutineColumnUsageViewRow] = OWrites[RoutineColumnUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "specific_catalog" -> Json.toJson(o.specificCatalog),
      "specific_schema" -> Json.toJson(o.specificSchema),
      "specific_name" -> Json.toJson(o.specificName),
      "routine_catalog" -> Json.toJson(o.routineCatalog),
      "routine_schema" -> Json.toJson(o.routineSchema),
      "routine_name" -> Json.toJson(o.routineName),
      "table_catalog" -> Json.toJson(o.tableCatalog),
      "table_schema" -> Json.toJson(o.tableSchema),
      "table_name" -> Json.toJson(o.tableName),
      "column_name" -> Json.toJson(o.columnName)
    ))
  )
}
