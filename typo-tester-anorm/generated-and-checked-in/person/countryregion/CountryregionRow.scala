/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

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

case class CountryregionRow(
  /** ISO standard code for countries and regions. */
  countryregioncode: CountryregionId,
  /** Country or region name. */
  name: Name,
  modifieddate: LocalDateTime
)

object CountryregionRow {
  val rowParser: RowParser[CountryregionRow] =
    RowParser[CountryregionRow] { row =>
      Success(
        CountryregionRow(
          countryregioncode = row[CountryregionId]("countryregioncode"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[CountryregionRow] = new OFormat[CountryregionRow]{
    override def writes(o: CountryregionRow): JsObject =
      Json.obj(
        "countryregioncode" -> o.countryregioncode,
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CountryregionRow] = {
      JsResult.fromTry(
        Try(
          CountryregionRow(
            countryregioncode = json.\("countryregioncode").as[CountryregionId],
            name = json.\("name").as[Name],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
