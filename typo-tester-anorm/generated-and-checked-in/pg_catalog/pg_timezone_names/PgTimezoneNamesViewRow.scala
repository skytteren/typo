/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_timezone_names

import adventureworks.TypoInterval
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTimezoneNamesViewRow(
  name: Option[String],
  abbrev: Option[String],
  utcOffset: Option[TypoInterval],
  isDst: Option[Boolean]
)

object PgTimezoneNamesViewRow {
  def rowParser(idx: Int): RowParser[PgTimezoneNamesViewRow] =
    RowParser[PgTimezoneNamesViewRow] { row =>
      Success(
        PgTimezoneNamesViewRow(
          name = row[Option[String]](idx + 0),
          abbrev = row[Option[String]](idx + 1),
          utcOffset = row[Option[TypoInterval]](idx + 2),
          isDst = row[Option[Boolean]](idx + 3)
        )
      )
    }
  implicit val oFormat: OFormat[PgTimezoneNamesViewRow] = new OFormat[PgTimezoneNamesViewRow]{
    override def writes(o: PgTimezoneNamesViewRow): JsObject =
      Json.obj(
        "name" -> o.name,
        "abbrev" -> o.abbrev,
        "utc_offset" -> o.utcOffset,
        "is_dst" -> o.isDst
      )
  
    override def reads(json: JsValue): JsResult[PgTimezoneNamesViewRow] = {
      JsResult.fromTry(
        Try(
          PgTimezoneNamesViewRow(
            name = json.\("name").toOption.map(_.as[String]),
            abbrev = json.\("abbrev").toOption.map(_.as[String]),
            utcOffset = json.\("utc_offset").toOption.map(_.as[TypoInterval]),
            isDst = json.\("is_dst").toOption.map(_.as[Boolean])
          )
        )
      )
    }
  }
}