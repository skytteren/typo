/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class CrcRow(
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.countryregioncode]] */
  countryregioncode: Option[CountryregionId],
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.currencycode]] */
  currencycode: Option[CurrencyId],
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object CrcRow {
  implicit val oFormat: OFormat[CrcRow] = new OFormat[CrcRow]{
    override def writes(o: CrcRow): JsObject =
      Json.obj(
        "countryregioncode" -> o.countryregioncode,
        "currencycode" -> o.currencycode,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CrcRow] = {
      JsResult.fromTry(
        Try(
          CrcRow(
            countryregioncode = json.\("countryregioncode").toOption.map(_.as[CountryregionId]),
            currencycode = json.\("currencycode").toOption.map(_.as[CurrencyId]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}