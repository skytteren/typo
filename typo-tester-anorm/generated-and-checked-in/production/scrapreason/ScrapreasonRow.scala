/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ScrapreasonRow(
  /** Primary key for ScrapReason records. */
  scrapreasonid: ScrapreasonId,
  /** Failure description. */
  name: Name,
  modifieddate: LocalDateTime
)

object ScrapreasonRow {
  val rowParser: RowParser[ScrapreasonRow] =
    RowParser[ScrapreasonRow] { row =>
      Success(
        ScrapreasonRow(
          scrapreasonid = row[ScrapreasonId]("scrapreasonid"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[ScrapreasonRow] = new OFormat[ScrapreasonRow]{
    override def writes(o: ScrapreasonRow): JsObject =
      Json.obj(
        "scrapreasonid" -> o.scrapreasonid,
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ScrapreasonRow] = {
      JsResult.fromTry(
        Try(
          ScrapreasonRow(
            scrapreasonid = json.\("scrapreasonid").as[ScrapreasonId],
            name = json.\("name").as[Name],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
