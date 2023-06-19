/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ProductvendorRow(
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
  modifieddate: LocalDateTime
){
   val compositeId: ProductvendorId = ProductvendorId(productid, businessentityid)
 }

object ProductvendorRow {
  val rowParser: RowParser[ProductvendorRow] =
    RowParser[ProductvendorRow] { row =>
      Success(
        ProductvendorRow(
          productid = row[ProductId]("productid"),
          businessentityid = row[BusinessentityId]("businessentityid"),
          averageleadtime = row[Int]("averageleadtime"),
          standardprice = row[BigDecimal]("standardprice"),
          lastreceiptcost = row[Option[BigDecimal]]("lastreceiptcost"),
          lastreceiptdate = row[Option[LocalDateTime]]("lastreceiptdate"),
          minorderqty = row[Int]("minorderqty"),
          maxorderqty = row[Int]("maxorderqty"),
          onorderqty = row[Option[Int]]("onorderqty"),
          unitmeasurecode = row[UnitmeasureId]("unitmeasurecode"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[ProductvendorRow] = new OFormat[ProductvendorRow]{
    override def writes(o: ProductvendorRow): JsObject =
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
  
    override def reads(json: JsValue): JsResult[ProductvendorRow] = {
      JsResult.fromTry(
        Try(
          ProductvendorRow(
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
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
