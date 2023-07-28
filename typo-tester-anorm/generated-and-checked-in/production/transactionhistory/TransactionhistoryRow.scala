/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
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

case class TransactionhistoryRow(
  /** Primary key for TransactionHistory records. */
  transactionid: TransactionhistoryId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Int,
  /** Date and time of the transaction. */
  transactiondate: TypoLocalDateTime,
  /** W = WorkOrder, S = SalesOrder, P = PurchaseOrder */
  transactiontype: /* bpchar */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object TransactionhistoryRow {
  implicit val reads: Reads[TransactionhistoryRow] = Reads[TransactionhistoryRow](json => JsResult.fromTry(
      Try(
        TransactionhistoryRow(
          transactionid = json.\("transactionid").as[TransactionhistoryId],
          productid = json.\("productid").as[ProductId],
          referenceorderid = json.\("referenceorderid").as[Int],
          referenceorderlineid = json.\("referenceorderlineid").as[Int],
          transactiondate = json.\("transactiondate").as[TypoLocalDateTime],
          transactiontype = json.\("transactiontype").as[/* bpchar */ String],
          quantity = json.\("quantity").as[Int],
          actualcost = json.\("actualcost").as[BigDecimal],
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TransactionhistoryRow] = RowParser[TransactionhistoryRow] { row =>
    Success(
      TransactionhistoryRow(
        transactionid = row[TransactionhistoryId](idx + 0),
        productid = row[ProductId](idx + 1),
        referenceorderid = row[Int](idx + 2),
        referenceorderlineid = row[Int](idx + 3),
        transactiondate = row[TypoLocalDateTime](idx + 4),
        transactiontype = row[/* bpchar */ String](idx + 5),
        quantity = row[Int](idx + 6),
        actualcost = row[BigDecimal](idx + 7),
        modifieddate = row[TypoLocalDateTime](idx + 8)
      )
    )
  }
  implicit val writes: OWrites[TransactionhistoryRow] = OWrites[TransactionhistoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "transactionid" -> Json.toJson(o.transactionid),
      "productid" -> Json.toJson(o.productid),
      "referenceorderid" -> Json.toJson(o.referenceorderid),
      "referenceorderlineid" -> Json.toJson(o.referenceorderlineid),
      "transactiondate" -> Json.toJson(o.transactiondate),
      "transactiontype" -> Json.toJson(o.transactiontype),
      "quantity" -> Json.toJson(o.quantity),
      "actualcost" -> Json.toJson(o.actualcost),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
