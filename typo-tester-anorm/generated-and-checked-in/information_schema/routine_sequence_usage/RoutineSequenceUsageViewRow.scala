/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_sequence_usage

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

case class RoutineSequenceUsageViewRow(
  specificCatalog: Option[SqlIdentifier],
  specificSchema: Option[SqlIdentifier],
  specificName: Option[SqlIdentifier],
  routineCatalog: Option[SqlIdentifier],
  routineSchema: Option[SqlIdentifier],
  routineName: Option[SqlIdentifier],
  sequenceCatalog: Option[SqlIdentifier],
  sequenceSchema: Option[SqlIdentifier],
  sequenceName: Option[SqlIdentifier]
)

object RoutineSequenceUsageViewRow {
  implicit val reads: Reads[RoutineSequenceUsageViewRow] = Reads[RoutineSequenceUsageViewRow](json => JsResult.fromTry(
      Try(
        RoutineSequenceUsageViewRow(
          specificCatalog = json.\("specific_catalog").toOption.map(_.as[SqlIdentifier]),
          specificSchema = json.\("specific_schema").toOption.map(_.as[SqlIdentifier]),
          specificName = json.\("specific_name").toOption.map(_.as[SqlIdentifier]),
          routineCatalog = json.\("routine_catalog").toOption.map(_.as[SqlIdentifier]),
          routineSchema = json.\("routine_schema").toOption.map(_.as[SqlIdentifier]),
          routineName = json.\("routine_name").toOption.map(_.as[SqlIdentifier]),
          sequenceCatalog = json.\("sequence_catalog").toOption.map(_.as[SqlIdentifier]),
          sequenceSchema = json.\("sequence_schema").toOption.map(_.as[SqlIdentifier]),
          sequenceName = json.\("sequence_name").toOption.map(_.as[SqlIdentifier])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[RoutineSequenceUsageViewRow] = RowParser[RoutineSequenceUsageViewRow] { row =>
    Success(
      RoutineSequenceUsageViewRow(
        specificCatalog = row[Option[SqlIdentifier]](idx + 0),
        specificSchema = row[Option[SqlIdentifier]](idx + 1),
        specificName = row[Option[SqlIdentifier]](idx + 2),
        routineCatalog = row[Option[SqlIdentifier]](idx + 3),
        routineSchema = row[Option[SqlIdentifier]](idx + 4),
        routineName = row[Option[SqlIdentifier]](idx + 5),
        sequenceCatalog = row[Option[SqlIdentifier]](idx + 6),
        sequenceSchema = row[Option[SqlIdentifier]](idx + 7),
        sequenceName = row[Option[SqlIdentifier]](idx + 8)
      )
    )
  }
  implicit val writes: OWrites[RoutineSequenceUsageViewRow] = OWrites[RoutineSequenceUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "specific_catalog" -> Json.toJson(o.specificCatalog),
      "specific_schema" -> Json.toJson(o.specificSchema),
      "specific_name" -> Json.toJson(o.specificName),
      "routine_catalog" -> Json.toJson(o.routineCatalog),
      "routine_schema" -> Json.toJson(o.routineSchema),
      "routine_name" -> Json.toJson(o.routineName),
      "sequence_catalog" -> Json.toJson(o.sequenceCatalog),
      "sequence_schema" -> Json.toJson(o.sequenceSchema),
      "sequence_name" -> Json.toJson(o.sequenceName)
    ))
  )
}
