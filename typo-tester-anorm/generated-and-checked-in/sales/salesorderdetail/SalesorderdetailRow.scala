/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
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
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderdetailId = SalesorderdetailId(salesorderid, salesorderdetailid)
 }

object SalesorderdetailRow {
  implicit val reads: Reads[SalesorderdetailRow] = Reads[SalesorderdetailRow](json => JsResult.fromTry(
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
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalesorderdetailRow] = RowParser[SalesorderdetailRow] { row =>
    Success(
      SalesorderdetailRow(
        salesorderid = row[SalesorderheaderId](idx + 0),
        salesorderdetailid = row[Int](idx + 1),
        carriertrackingnumber = row[Option[/* max 25 chars */ String]](idx + 2),
        orderqty = row[Int](idx + 3),
        productid = row[ProductId](idx + 4),
        specialofferid = row[SpecialofferId](idx + 5),
        unitprice = row[BigDecimal](idx + 6),
        unitpricediscount = row[BigDecimal](idx + 7),
        rowguid = row[UUID](idx + 8),
        modifieddate = row[TypoLocalDateTime](idx + 9)
      )
    )
  }
  implicit val writes: OWrites[SalesorderdetailRow] = OWrites[SalesorderdetailRow](o =>
    new JsObject(ListMap[String, JsValue](
      "salesorderid" -> Json.toJson(o.salesorderid),
      "salesorderdetailid" -> Json.toJson(o.salesorderdetailid),
      "carriertrackingnumber" -> Json.toJson(o.carriertrackingnumber),
      "orderqty" -> Json.toJson(o.orderqty),
      "productid" -> Json.toJson(o.productid),
      "specialofferid" -> Json.toJson(o.specialofferid),
      "unitprice" -> Json.toJson(o.unitprice),
      "unitpricediscount" -> Json.toJson(o.unitpricediscount),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
