/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggered_update_columns

import adventureworks.information_schema.SqlIdentifier
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class TriggeredUpdateColumnsViewRow(
  triggerCatalog: Option[SqlIdentifier],
  triggerSchema: Option[SqlIdentifier],
  triggerName: Option[SqlIdentifier],
  eventObjectCatalog: Option[SqlIdentifier],
  eventObjectSchema: Option[SqlIdentifier],
  eventObjectTable: Option[SqlIdentifier],
  eventObjectColumn: Option[SqlIdentifier]
)

object TriggeredUpdateColumnsViewRow {
  def rowParser(idx: Int): RowParser[TriggeredUpdateColumnsViewRow] =
    RowParser[TriggeredUpdateColumnsViewRow] { row =>
      Success(
        TriggeredUpdateColumnsViewRow(
          triggerCatalog = row[Option[SqlIdentifier]](idx + 0),
          triggerSchema = row[Option[SqlIdentifier]](idx + 1),
          triggerName = row[Option[SqlIdentifier]](idx + 2),
          eventObjectCatalog = row[Option[SqlIdentifier]](idx + 3),
          eventObjectSchema = row[Option[SqlIdentifier]](idx + 4),
          eventObjectTable = row[Option[SqlIdentifier]](idx + 5),
          eventObjectColumn = row[Option[SqlIdentifier]](idx + 6)
        )
      )
    }
  implicit val oFormat: OFormat[TriggeredUpdateColumnsViewRow] = new OFormat[TriggeredUpdateColumnsViewRow]{
    override def writes(o: TriggeredUpdateColumnsViewRow): JsObject =
      Json.obj(
        "trigger_catalog" -> o.triggerCatalog,
        "trigger_schema" -> o.triggerSchema,
        "trigger_name" -> o.triggerName,
        "event_object_catalog" -> o.eventObjectCatalog,
        "event_object_schema" -> o.eventObjectSchema,
        "event_object_table" -> o.eventObjectTable,
        "event_object_column" -> o.eventObjectColumn
      )
  
    override def reads(json: JsValue): JsResult[TriggeredUpdateColumnsViewRow] = {
      JsResult.fromTry(
        Try(
          TriggeredUpdateColumnsViewRow(
            triggerCatalog = json.\("trigger_catalog").toOption.map(_.as[SqlIdentifier]),
            triggerSchema = json.\("trigger_schema").toOption.map(_.as[SqlIdentifier]),
            triggerName = json.\("trigger_name").toOption.map(_.as[SqlIdentifier]),
            eventObjectCatalog = json.\("event_object_catalog").toOption.map(_.as[SqlIdentifier]),
            eventObjectSchema = json.\("event_object_schema").toOption.map(_.as[SqlIdentifier]),
            eventObjectTable = json.\("event_object_table").toOption.map(_.as[SqlIdentifier]),
            eventObjectColumn = json.\("event_object_column").toOption.map(_.as[SqlIdentifier])
          )
        )
      )
    }
  }
}