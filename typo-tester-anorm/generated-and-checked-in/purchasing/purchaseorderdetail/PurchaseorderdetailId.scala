/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `purchasing.purchaseorderdetail` */
case class PurchaseorderdetailId(purchaseorderid: PurchaseorderheaderId, purchaseorderdetailid: Int)
object PurchaseorderdetailId {
  implicit val ordering: Ordering[PurchaseorderdetailId] = Ordering.by(x => (x.purchaseorderid, x.purchaseorderdetailid))
  implicit val reads: Reads[PurchaseorderdetailId] = Reads[PurchaseorderdetailId](json => JsResult.fromTry(
      Try(
        PurchaseorderdetailId(
          purchaseorderid = json.\("purchaseorderid").as[PurchaseorderheaderId],
          purchaseorderdetailid = json.\("purchaseorderdetailid").as[Int]
        )
      )
    ),
  )
  implicit val writes: OWrites[PurchaseorderdetailId] = OWrites[PurchaseorderdetailId](o =>
    new JsObject(ListMap[String, JsValue](
      "purchaseorderid" -> Json.toJson(o.purchaseorderid),
      "purchaseorderdetailid" -> Json.toJson(o.purchaseorderdetailid)
    ))
  )
}
