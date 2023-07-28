/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.transactionhistory` which has not been persisted yet */
case class TransactionhistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** W = WorkOrder, S = SalesOrder, P = PurchaseOrder */
  transactiontype: /* bpchar */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  /** Default: nextval('production.transactionhistory_transactionid_seq'::regclass)
      Primary key for TransactionHistory records. */
  transactionid: Defaulted[TransactionhistoryId] = Defaulted.UseDefault,
  /** Default: 0
      Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date and time of the transaction. */
  transactiondate: Defaulted[LocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(transactionidDefault: => TransactionhistoryId, referenceorderlineidDefault: => Int, transactiondateDefault: => LocalDateTime, modifieddateDefault: => LocalDateTime): TransactionhistoryRow =
    TransactionhistoryRow(
      productid = productid,
      referenceorderid = referenceorderid,
      transactiontype = transactiontype,
      quantity = quantity,
      actualcost = actualcost,
      transactionid = transactionid match {
                        case Defaulted.UseDefault => transactionidDefault
                        case Defaulted.Provided(value) => value
                      },
      referenceorderlineid = referenceorderlineid match {
                               case Defaulted.UseDefault => referenceorderlineidDefault
                               case Defaulted.Provided(value) => value
                             },
      transactiondate = transactiondate match {
                          case Defaulted.UseDefault => transactiondateDefault
                          case Defaulted.Provided(value) => value
                        },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object TransactionhistoryRowUnsaved {
  implicit val oFormat: OFormat[TransactionhistoryRowUnsaved] = new OFormat[TransactionhistoryRowUnsaved]{
    override def writes(o: TransactionhistoryRowUnsaved): JsObject =
      Json.obj(
        "productid" -> o.productid,
        "referenceorderid" -> o.referenceorderid,
        "transactiontype" -> o.transactiontype,
        "quantity" -> o.quantity,
        "actualcost" -> o.actualcost,
        "transactionid" -> o.transactionid,
        "referenceorderlineid" -> o.referenceorderlineid,
        "transactiondate" -> o.transactiondate,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[TransactionhistoryRowUnsaved] = {
      JsResult.fromTry(
        Try(
          TransactionhistoryRowUnsaved(
            productid = json.\("productid").as[ProductId],
            referenceorderid = json.\("referenceorderid").as[Int],
            transactiontype = json.\("transactiontype").as[/* bpchar */ String],
            quantity = json.\("quantity").as[Int],
            actualcost = json.\("actualcost").as[BigDecimal],
            transactionid = json.\("transactionid").as[Defaulted[TransactionhistoryId]],
            referenceorderlineid = json.\("referenceorderlineid").as[Defaulted[Int]],
            transactiondate = json.\("transactiondate").as[Defaulted[LocalDateTime]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}