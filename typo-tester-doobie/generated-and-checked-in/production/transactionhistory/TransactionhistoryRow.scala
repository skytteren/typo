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
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

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
  implicit val decoder: Decoder[TransactionhistoryRow] = Decoder.forProduct9[TransactionhistoryRow, TransactionhistoryId, ProductId, Int, Int, TypoLocalDateTime, /* bpchar */ String, Int, BigDecimal, TypoLocalDateTime]("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(TransactionhistoryRow.apply)
  implicit val encoder: Encoder[TransactionhistoryRow] = Encoder.forProduct9[TransactionhistoryRow, TransactionhistoryId, ProductId, Int, Int, TypoLocalDateTime, /* bpchar */ String, Int, BigDecimal, TypoLocalDateTime]("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(x => (x.transactionid, x.productid, x.referenceorderid, x.referenceorderlineid, x.transactiondate, x.transactiontype, x.quantity, x.actualcost, x.modifieddate))
  implicit val read: Read[TransactionhistoryRow] = new Read[TransactionhistoryRow](
    gets = List(
      (Get[TransactionhistoryId], Nullability.NoNulls),
      (Get[ProductId], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls),
      (Get[/* bpchar */ String], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[BigDecimal], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => TransactionhistoryRow(
      transactionid = Get[TransactionhistoryId].unsafeGetNonNullable(rs, i + 0),
      productid = Get[ProductId].unsafeGetNonNullable(rs, i + 1),
      referenceorderid = Get[Int].unsafeGetNonNullable(rs, i + 2),
      referenceorderlineid = Get[Int].unsafeGetNonNullable(rs, i + 3),
      transactiondate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 4),
      transactiontype = Get[/* bpchar */ String].unsafeGetNonNullable(rs, i + 5),
      quantity = Get[Int].unsafeGetNonNullable(rs, i + 6),
      actualcost = Get[BigDecimal].unsafeGetNonNullable(rs, i + 7),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 8)
    )
  )
}
