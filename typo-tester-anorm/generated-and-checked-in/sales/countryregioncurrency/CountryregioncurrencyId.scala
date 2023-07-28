/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `sales.countryregioncurrency` */
case class CountryregioncurrencyId(countryregioncode: CountryregionId, currencycode: CurrencyId)
object CountryregioncurrencyId {
  implicit val ordering: Ordering[CountryregioncurrencyId] = Ordering.by(x => (x.countryregioncode, x.currencycode))
  implicit val reads: Reads[CountryregioncurrencyId] = Reads[CountryregioncurrencyId](json => JsResult.fromTry(
      Try(
        CountryregioncurrencyId(
          countryregioncode = json.\("countryregioncode").as[CountryregionId],
          currencycode = json.\("currencycode").as[CurrencyId]
        )
      )
    ),
  )
  implicit val writes: OWrites[CountryregioncurrencyId] = OWrites[CountryregioncurrencyId](o =>
    new JsObject(ListMap[String, JsValue](
      "countryregioncode" -> Json.toJson(o.countryregioncode),
      "currencycode" -> Json.toJson(o.currencycode)
    ))
  )
}
