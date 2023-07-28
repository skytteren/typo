/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import adventureworks.TypoLocalDateTime
import adventureworks.sales.currency.CurrencyId
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

case class CurrencyrateRow(
  /** Primary key for CurrencyRate records. */
  currencyrateid: CurrencyrateId,
  /** Date and time the exchange rate was obtained. */
  currencyratedate: TypoLocalDateTime,
  /** Exchange rate was converted from this currency code.
      Points to [[currency.CurrencyRow.currencycode]] */
  fromcurrencycode: CurrencyId,
  /** Exchange rate was converted to this currency code.
      Points to [[currency.CurrencyRow.currencycode]] */
  tocurrencycode: CurrencyId,
  /** Average exchange rate for the day. */
  averagerate: BigDecimal,
  /** Final exchange rate for the day. */
  endofdayrate: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object CurrencyrateRow {
  implicit val reads: Reads[CurrencyrateRow] = Reads[CurrencyrateRow](json => JsResult.fromTry(
      Try(
        CurrencyrateRow(
          currencyrateid = json.\("currencyrateid").as[CurrencyrateId],
          currencyratedate = json.\("currencyratedate").as[TypoLocalDateTime],
          fromcurrencycode = json.\("fromcurrencycode").as[CurrencyId],
          tocurrencycode = json.\("tocurrencycode").as[CurrencyId],
          averagerate = json.\("averagerate").as[BigDecimal],
          endofdayrate = json.\("endofdayrate").as[BigDecimal],
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CurrencyrateRow] = RowParser[CurrencyrateRow] { row =>
    Success(
      CurrencyrateRow(
        currencyrateid = row[CurrencyrateId](idx + 0),
        currencyratedate = row[TypoLocalDateTime](idx + 1),
        fromcurrencycode = row[CurrencyId](idx + 2),
        tocurrencycode = row[CurrencyId](idx + 3),
        averagerate = row[BigDecimal](idx + 4),
        endofdayrate = row[BigDecimal](idx + 5),
        modifieddate = row[TypoLocalDateTime](idx + 6)
      )
    )
  }
  implicit val writes: OWrites[CurrencyrateRow] = OWrites[CurrencyrateRow](o =>
    new JsObject(ListMap[String, JsValue](
      "currencyrateid" -> Json.toJson(o.currencyrateid),
      "currencyratedate" -> Json.toJson(o.currencyratedate),
      "fromcurrencycode" -> Json.toJson(o.fromcurrencycode),
      "tocurrencycode" -> Json.toJson(o.tocurrencycode),
      "averagerate" -> Json.toJson(o.averagerate),
      "endofdayrate" -> Json.toJson(o.endofdayrate),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
