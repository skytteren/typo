/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `sales.currency` which has not been persisted yet */
case class CurrencyRowUnsaved(
  /** The ISO code for the Currency. */
  currencycode: CurrencyId,
  /** Currency name. */
  name: Name,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): CurrencyRow =
    CurrencyRow(
      currencycode = currencycode,
      name = name,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CurrencyRowUnsaved {
  implicit val oFormat: OFormat[CurrencyRowUnsaved] = new OFormat[CurrencyRowUnsaved]{
    override def writes(o: CurrencyRowUnsaved): JsObject =
      Json.obj(
        "currencycode" -> o.currencycode,
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CurrencyRowUnsaved] = {
      JsResult.fromTry(
        Try(
          CurrencyRowUnsaved(
            currencycode = json.\("currencycode").as[CurrencyId],
            name = json.\("name").as[Name],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}