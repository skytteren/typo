/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pod

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PodViewRow(
  id: Option[Int],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.purchaseorderid]] */
  purchaseorderid: Option[PurchaseorderheaderId],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.purchaseorderdetailid]] */
  purchaseorderdetailid: Option[Int],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.duedate]] */
  duedate: Option[TypoLocalDateTime],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.orderqty]] */
  orderqty: Option[Int],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.unitprice]] */
  unitprice: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.receivedqty]] */
  receivedqty: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.rejectedqty]] */
  rejectedqty: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PodViewRow {
  implicit val decoder: Decoder[PodViewRow] = Decoder.forProduct10[PodViewRow, Option[Int], Option[PurchaseorderheaderId], Option[Int], Option[TypoLocalDateTime], Option[Int], Option[ProductId], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(PodViewRow.apply)
  implicit val encoder: Encoder[PodViewRow] = Encoder.forProduct10[PodViewRow, Option[Int], Option[PurchaseorderheaderId], Option[Int], Option[TypoLocalDateTime], Option[Int], Option[ProductId], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(x => (x.id, x.purchaseorderid, x.purchaseorderdetailid, x.duedate, x.orderqty, x.productid, x.unitprice, x.receivedqty, x.rejectedqty, x.modifieddate))
  implicit val read: Read[PodViewRow] = new Read[PodViewRow](
    gets = List(
      (Get[Int], Nullability.Nullable),
      (Get[PurchaseorderheaderId], Nullability.Nullable),
      (Get[Int], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.Nullable),
      (Get[Int], Nullability.Nullable),
      (Get[ProductId], Nullability.Nullable),
      (Get[BigDecimal], Nullability.Nullable),
      (Get[BigDecimal], Nullability.Nullable),
      (Get[BigDecimal], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PodViewRow(
      id = Get[Int].unsafeGetNullable(rs, i + 0),
      purchaseorderid = Get[PurchaseorderheaderId].unsafeGetNullable(rs, i + 1),
      purchaseorderdetailid = Get[Int].unsafeGetNullable(rs, i + 2),
      duedate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 3),
      orderqty = Get[Int].unsafeGetNullable(rs, i + 4),
      productid = Get[ProductId].unsafeGetNullable(rs, i + 5),
      unitprice = Get[BigDecimal].unsafeGetNullable(rs, i + 6),
      receivedqty = Get[BigDecimal].unsafeGetNullable(rs, i + 7),
      rejectedqty = Get[BigDecimal].unsafeGetNullable(rs, i + 8),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 9)
    )
  )
}
