/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `purchasing.productvendor` which has not been persisted yet */
case class ProductvendorRowUnsaved(
  /** Primary key. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Primary key. Foreign key to Vendor.BusinessEntityID.
      Points to [[vendor.VendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** The average span of time (in days) between placing an order with the vendor and receiving the purchased product. */
  averageleadtime: Int,
  /** The vendor's usual selling price. */
  standardprice: BigDecimal,
  /** The selling price when last purchased. */
  lastreceiptcost: Option[BigDecimal],
  /** Date the product was last received by the vendor. */
  lastreceiptdate: Option[LocalDateTime],
  /** The maximum quantity that should be ordered. */
  minorderqty: Int,
  /** The minimum quantity that should be ordered. */
  maxorderqty: Int,
  /** The quantity currently on order. */
  onorderqty: Option[Int],
  /** The product's unit of measure.
      Points to [[production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): ProductvendorRow =
    ProductvendorRow(
      productid = productid,
      businessentityid = businessentityid,
      averageleadtime = averageleadtime,
      standardprice = standardprice,
      lastreceiptcost = lastreceiptcost,
      lastreceiptdate = lastreceiptdate,
      minorderqty = minorderqty,
      maxorderqty = maxorderqty,
      onorderqty = onorderqty,
      unitmeasurecode = unitmeasurecode,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductvendorRowUnsaved {
  implicit val oFormat: OFormat[ProductvendorRowUnsaved] = new OFormat[ProductvendorRowUnsaved]{
    override def writes(o: ProductvendorRowUnsaved): JsObject =
      Json.obj(
        "productid" -> o.productid,
        "businessentityid" -> o.businessentityid,
        "averageleadtime" -> o.averageleadtime,
        "standardprice" -> o.standardprice,
        "lastreceiptcost" -> o.lastreceiptcost,
        "lastreceiptdate" -> o.lastreceiptdate,
        "minorderqty" -> o.minorderqty,
        "maxorderqty" -> o.maxorderqty,
        "onorderqty" -> o.onorderqty,
        "unitmeasurecode" -> o.unitmeasurecode,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductvendorRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductvendorRowUnsaved(
            productid = json.\("productid").as[ProductId],
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            averageleadtime = json.\("averageleadtime").as[Int],
            standardprice = json.\("standardprice").as[BigDecimal],
            lastreceiptcost = json.\("lastreceiptcost").toOption.map(_.as[BigDecimal]),
            lastreceiptdate = json.\("lastreceiptdate").toOption.map(_.as[LocalDateTime]),
            minorderqty = json.\("minorderqty").as[Int],
            maxorderqty = json.\("maxorderqty").as[Int],
            onorderqty = json.\("onorderqty").toOption.map(_.as[Int]),
            unitmeasurecode = json.\("unitmeasurecode").as[UnitmeasureId],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}