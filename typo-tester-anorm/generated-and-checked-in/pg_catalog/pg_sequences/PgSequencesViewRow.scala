/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequences

import adventureworks.TypoRegtype
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

case class PgSequencesViewRow(
  schemaname: Option[String],
  sequencename: Option[String],
  sequenceowner: Option[String],
  dataType: Option[TypoRegtype],
  startValue: Option[Long],
  minValue: Option[Long],
  maxValue: Option[Long],
  incrementBy: Option[Long],
  cycle: Option[Boolean],
  cacheSize: Option[Long],
  lastValue: Option[Long]
)

object PgSequencesViewRow {
  implicit val reads: Reads[PgSequencesViewRow] = Reads[PgSequencesViewRow](json => JsResult.fromTry(
      Try(
        PgSequencesViewRow(
          schemaname = json.\("schemaname").toOption.map(_.as[String]),
          sequencename = json.\("sequencename").toOption.map(_.as[String]),
          sequenceowner = json.\("sequenceowner").toOption.map(_.as[String]),
          dataType = json.\("data_type").toOption.map(_.as[TypoRegtype]),
          startValue = json.\("start_value").toOption.map(_.as[Long]),
          minValue = json.\("min_value").toOption.map(_.as[Long]),
          maxValue = json.\("max_value").toOption.map(_.as[Long]),
          incrementBy = json.\("increment_by").toOption.map(_.as[Long]),
          cycle = json.\("cycle").toOption.map(_.as[Boolean]),
          cacheSize = json.\("cache_size").toOption.map(_.as[Long]),
          lastValue = json.\("last_value").toOption.map(_.as[Long])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgSequencesViewRow] = RowParser[PgSequencesViewRow] { row =>
    Success(
      PgSequencesViewRow(
        schemaname = row[Option[String]](idx + 0),
        sequencename = row[Option[String]](idx + 1),
        sequenceowner = row[Option[String]](idx + 2),
        dataType = row[Option[TypoRegtype]](idx + 3),
        startValue = row[Option[Long]](idx + 4),
        minValue = row[Option[Long]](idx + 5),
        maxValue = row[Option[Long]](idx + 6),
        incrementBy = row[Option[Long]](idx + 7),
        cycle = row[Option[Boolean]](idx + 8),
        cacheSize = row[Option[Long]](idx + 9),
        lastValue = row[Option[Long]](idx + 10)
      )
    )
  }
  implicit val writes: OWrites[PgSequencesViewRow] = OWrites[PgSequencesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schemaname" -> Json.toJson(o.schemaname),
      "sequencename" -> Json.toJson(o.sequencename),
      "sequenceowner" -> Json.toJson(o.sequenceowner),
      "data_type" -> Json.toJson(o.dataType),
      "start_value" -> Json.toJson(o.startValue),
      "min_value" -> Json.toJson(o.minValue),
      "max_value" -> Json.toJson(o.maxValue),
      "increment_by" -> Json.toJson(o.incrementBy),
      "cycle" -> Json.toJson(o.cycle),
      "cache_size" -> Json.toJson(o.cacheSize),
      "last_value" -> Json.toJson(o.lastValue)
    ))
  )
}
