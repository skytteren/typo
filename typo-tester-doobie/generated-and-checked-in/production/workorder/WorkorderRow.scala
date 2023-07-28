/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class WorkorderRow(
  /** Primary key for WorkOrder records. */
  workorderid: WorkorderId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product quantity to build. */
  orderqty: Int,
  /** Quantity that failed inspection. */
  scrappedqty: Int,
  /** Work order start date. */
  startdate: TypoLocalDateTime,
  /** Work order end date. */
  enddate: Option[TypoLocalDateTime],
  /** Work order due date. */
  duedate: TypoLocalDateTime,
  /** Reason for inspection failure.
      Points to [[scrapreason.ScrapreasonRow.scrapreasonid]] */
  scrapreasonid: Option[ScrapreasonId],
  modifieddate: TypoLocalDateTime
)

object WorkorderRow {
  implicit val decoder: Decoder[WorkorderRow] = Decoder.forProduct9[WorkorderRow, WorkorderId, ProductId, Int, Int, TypoLocalDateTime, Option[TypoLocalDateTime], TypoLocalDateTime, Option[ScrapreasonId], TypoLocalDateTime]("workorderid", "productid", "orderqty", "scrappedqty", "startdate", "enddate", "duedate", "scrapreasonid", "modifieddate")(WorkorderRow.apply)
  implicit val encoder: Encoder[WorkorderRow] = Encoder.forProduct9[WorkorderRow, WorkorderId, ProductId, Int, Int, TypoLocalDateTime, Option[TypoLocalDateTime], TypoLocalDateTime, Option[ScrapreasonId], TypoLocalDateTime]("workorderid", "productid", "orderqty", "scrappedqty", "startdate", "enddate", "duedate", "scrapreasonid", "modifieddate")(x => (x.workorderid, x.productid, x.orderqty, x.scrappedqty, x.startdate, x.enddate, x.duedate, x.scrapreasonid, x.modifieddate))
  implicit val read: Read[WorkorderRow] = new Read[WorkorderRow](
    gets = List(
      (Get[WorkorderId], Nullability.NoNulls),
      (Get[ProductId], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.NoNulls),
      (Get[ScrapreasonId], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => WorkorderRow(
      workorderid = Get[WorkorderId].unsafeGetNonNullable(rs, i + 0),
      productid = Get[ProductId].unsafeGetNonNullable(rs, i + 1),
      orderqty = Get[Int].unsafeGetNonNullable(rs, i + 2),
      scrappedqty = Get[Int].unsafeGetNonNullable(rs, i + 3),
      startdate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 4),
      enddate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 5),
      duedate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 6),
      scrapreasonid = Get[ScrapreasonId].unsafeGetNullable(rs, i + 7),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 8)
    )
  )
}
