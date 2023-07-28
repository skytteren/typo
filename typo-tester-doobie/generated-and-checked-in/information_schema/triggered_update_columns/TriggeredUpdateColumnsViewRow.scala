/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggered_update_columns

import adventureworks.information_schema.SqlIdentifier
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

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
  implicit val decoder: Decoder[TriggeredUpdateColumnsViewRow] =
    (c: HCursor) =>
      for {
        triggerCatalog <- c.downField("trigger_catalog").as[Option[SqlIdentifier]]
        triggerSchema <- c.downField("trigger_schema").as[Option[SqlIdentifier]]
        triggerName <- c.downField("trigger_name").as[Option[SqlIdentifier]]
        eventObjectCatalog <- c.downField("event_object_catalog").as[Option[SqlIdentifier]]
        eventObjectSchema <- c.downField("event_object_schema").as[Option[SqlIdentifier]]
        eventObjectTable <- c.downField("event_object_table").as[Option[SqlIdentifier]]
        eventObjectColumn <- c.downField("event_object_column").as[Option[SqlIdentifier]]
      } yield TriggeredUpdateColumnsViewRow(triggerCatalog, triggerSchema, triggerName, eventObjectCatalog, eventObjectSchema, eventObjectTable, eventObjectColumn)
  implicit val encoder: Encoder[TriggeredUpdateColumnsViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "trigger_catalog" := row.triggerCatalog,
        "trigger_schema" := row.triggerSchema,
        "trigger_name" := row.triggerName,
        "event_object_catalog" := row.eventObjectCatalog,
        "event_object_schema" := row.eventObjectSchema,
        "event_object_table" := row.eventObjectTable,
        "event_object_column" := row.eventObjectColumn
      )}
  implicit val read: Read[TriggeredUpdateColumnsViewRow] =
    new Read[TriggeredUpdateColumnsViewRow](
      gets = List(
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => TriggeredUpdateColumnsViewRow(
        triggerCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 0),
        triggerSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 1),
        triggerName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 2),
        eventObjectCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 3),
        eventObjectSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 4),
        eventObjectTable = Get[SqlIdentifier].unsafeGetNullable(rs, i + 5),
        eventObjectColumn = Get[SqlIdentifier].unsafeGetNullable(rs, i + 6)
      )
    )
  

}