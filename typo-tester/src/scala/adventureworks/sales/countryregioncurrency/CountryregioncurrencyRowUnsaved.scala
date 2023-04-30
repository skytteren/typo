/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.Defaulted
import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `sales.countryregioncurrency` which has not been persisted yet */
case class CountryregioncurrencyRowUnsaved(
  /** ISO code for countries and regions. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** ISO standard currency code. Foreign key to Currency.CurrencyCode.
      Points to [[currency.CurrencyRow.currencycode]] */
  currencycode: CurrencyId,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): CountryregioncurrencyRow =
    CountryregioncurrencyRow(
      countryregioncode = countryregioncode,
      currencycode = currencycode,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CountryregioncurrencyRowUnsaved {
  implicit val oFormat: OFormat[CountryregioncurrencyRowUnsaved] = new OFormat[CountryregioncurrencyRowUnsaved]{
    override def writes(o: CountryregioncurrencyRowUnsaved): JsObject =
      Json.obj(
        "countryregioncode" -> o.countryregioncode,
        "currencycode" -> o.currencycode,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CountryregioncurrencyRowUnsaved] = {
      JsResult.fromTry(
        Try(
          CountryregioncurrencyRowUnsaved(
            countryregioncode = json.\("countryregioncode").as[CountryregionId],
            currencycode = json.\("currencycode").as[CurrencyId],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}