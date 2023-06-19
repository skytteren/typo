/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SalesorderdetailRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. One incremental unique number per product sold. */
  salesorderdetailid: Int,
  /** Shipment tracking number supplied by the shipper. */
  carriertrackingnumber: Option[/* max 25 chars */ String],
  /** Quantity ordered per product. */
  orderqty: Int,
  /** Product sold to customer. Foreign key to Product.ProductID.
      Points to [[specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Promotional code. Foreign key to SpecialOffer.SpecialOfferID.
      Points to [[specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Selling price of a single product. */
  unitprice: BigDecimal,
  /** Discount amount. */
  unitpricediscount: BigDecimal,
  rowguid: UUID,
  modifieddate: LocalDateTime
){
   val compositeId: SalesorderdetailId = SalesorderdetailId(salesorderid, salesorderdetailid)
 }

object SalesorderdetailRow {
  val rowParser: RowParser[SalesorderdetailRow] =
    RowParser[SalesorderdetailRow] { row =>
      Success(
        SalesorderdetailRow(
          salesorderid = row[SalesorderheaderId]("salesorderid"),
          salesorderdetailid = row[Int]("salesorderdetailid"),
          carriertrackingnumber = row[Option[/* max 25 chars */ String]]("carriertrackingnumber"),
          orderqty = row[Int]("orderqty"),
          productid = row[ProductId]("productid"),
          specialofferid = row[SpecialofferId]("specialofferid"),
          unitprice = row[BigDecimal]("unitprice"),
          unitpricediscount = row[BigDecimal]("unitpricediscount"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[SalesorderdetailRow] = new OFormat[SalesorderdetailRow]{
    override def writes(o: SalesorderdetailRow): JsObject =
      Json.obj(
        "salesorderid" -> o.salesorderid,
        "salesorderdetailid" -> o.salesorderdetailid,
        "carriertrackingnumber" -> o.carriertrackingnumber,
        "orderqty" -> o.orderqty,
        "productid" -> o.productid,
        "specialofferid" -> o.specialofferid,
        "unitprice" -> o.unitprice,
        "unitpricediscount" -> o.unitpricediscount,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalesorderdetailRow] = {
      JsResult.fromTry(
        Try(
          SalesorderdetailRow(
            salesorderid = json.\("salesorderid").as[SalesorderheaderId],
            salesorderdetailid = json.\("salesorderdetailid").as[Int],
            carriertrackingnumber = json.\("carriertrackingnumber").toOption.map(_.as[/* max 25 chars */ String]),
            orderqty = json.\("orderqty").as[Int],
            productid = json.\("productid").as[ProductId],
            specialofferid = json.\("specialofferid").as[SpecialofferId],
            unitprice = json.\("unitprice").as[BigDecimal],
            unitpricediscount = json.\("unitpricediscount").as[BigDecimal],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
