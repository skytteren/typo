/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.salesorderheadersalesreason` which has not been persisted yet */
case class SalesorderheadersalesreasonRowUnsaved(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. Foreign key to SalesReason.SalesReasonID.
      Points to [[salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): SalesorderheadersalesreasonRow =
    SalesorderheadersalesreasonRow(
      salesorderid = salesorderid,
      salesreasonid = salesreasonid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalesorderheadersalesreasonRowUnsaved {
  implicit val reads: Reads[SalesorderheadersalesreasonRowUnsaved] = Reads[SalesorderheadersalesreasonRowUnsaved](json => JsResult.fromTry(
      Try(
        SalesorderheadersalesreasonRowUnsaved(
          salesorderid = json.\("salesorderid").as[SalesorderheaderId],
          salesreasonid = json.\("salesreasonid").as[SalesreasonId],
          modifieddate = json.\("modifieddate").as[Defaulted[TypoLocalDateTime]]
        )
      )
    ),
  )
  implicit val writes: OWrites[SalesorderheadersalesreasonRowUnsaved] = OWrites[SalesorderheadersalesreasonRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "salesorderid" -> Json.toJson(o.salesorderid),
      "salesreasonid" -> Json.toJson(o.salesreasonid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
