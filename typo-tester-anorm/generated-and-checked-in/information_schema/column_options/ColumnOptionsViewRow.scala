/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_options

import adventureworks.information_schema.CharacterData
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

case class ColumnOptionsViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  optionName: Option[SqlIdentifier],
  optionValue: Option[CharacterData]
)

object ColumnOptionsViewRow {
  implicit val reads: Reads[ColumnOptionsViewRow] = Reads[ColumnOptionsViewRow](json => JsResult.fromTry(
      Try(
        ColumnOptionsViewRow(
          tableCatalog = json.\("table_catalog").toOption.map(_.as[SqlIdentifier]),
          tableSchema = json.\("table_schema").toOption.map(_.as[SqlIdentifier]),
          tableName = json.\("table_name").toOption.map(_.as[SqlIdentifier]),
          columnName = json.\("column_name").toOption.map(_.as[SqlIdentifier]),
          optionName = json.\("option_name").toOption.map(_.as[SqlIdentifier]),
          optionValue = json.\("option_value").toOption.map(_.as[CharacterData])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ColumnOptionsViewRow] = RowParser[ColumnOptionsViewRow] { row =>
    Success(
      ColumnOptionsViewRow(
        tableCatalog = row[Option[SqlIdentifier]](idx + 0),
        tableSchema = row[Option[SqlIdentifier]](idx + 1),
        tableName = row[Option[SqlIdentifier]](idx + 2),
        columnName = row[Option[SqlIdentifier]](idx + 3),
        optionName = row[Option[SqlIdentifier]](idx + 4),
        optionValue = row[Option[CharacterData]](idx + 5)
      )
    )
  }
  implicit val writes: OWrites[ColumnOptionsViewRow] = OWrites[ColumnOptionsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_catalog" -> Json.toJson(o.tableCatalog),
      "table_schema" -> Json.toJson(o.tableSchema),
      "table_name" -> Json.toJson(o.tableName),
      "column_name" -> Json.toJson(o.columnName),
      "option_name" -> Json.toJson(o.optionName),
      "option_value" -> Json.toJson(o.optionValue)
    ))
  )
}
