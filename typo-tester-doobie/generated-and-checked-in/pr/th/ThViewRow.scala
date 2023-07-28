/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package th

import adventureworks.production.product.ProductId
import adventureworks.production.transactionhistory.TransactionhistoryId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class ThViewRow(
  id: Option[Int],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactionid]] */
  transactionid: Option[TransactionhistoryId],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.referenceorderid]] */
  referenceorderid: Option[Int],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.referenceorderlineid]] */
  referenceorderlineid: Option[Int],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactiondate]] */
  transactiondate: Option[LocalDateTime],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactiontype]] */
  transactiontype: Option[/* bpchar */ String],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.actualcost]] */
  actualcost: Option[BigDecimal],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object ThViewRow {
  implicit val decoder: Decoder[ThViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        transactionid <- c.downField("transactionid").as[Option[TransactionhistoryId]]
        productid <- c.downField("productid").as[Option[ProductId]]
        referenceorderid <- c.downField("referenceorderid").as[Option[Int]]
        referenceorderlineid <- c.downField("referenceorderlineid").as[Option[Int]]
        transactiondate <- c.downField("transactiondate").as[Option[LocalDateTime]]
        transactiontype <- c.downField("transactiontype").as[Option[/* bpchar */ String]]
        quantity <- c.downField("quantity").as[Option[Int]]
        actualcost <- c.downField("actualcost").as[Option[BigDecimal]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield ThViewRow(id, transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)
  implicit val encoder: Encoder[ThViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "transactionid" := row.transactionid,
        "productid" := row.productid,
        "referenceorderid" := row.referenceorderid,
        "referenceorderlineid" := row.referenceorderlineid,
        "transactiondate" := row.transactiondate,
        "transactiontype" := row.transactiontype,
        "quantity" := row.quantity,
        "actualcost" := row.actualcost,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[ThViewRow] =
    new Read[ThViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[TransactionhistoryId], Nullability.Nullable),
        (Get[ProductId], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[/* bpchar */ String], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => ThViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        transactionid = Get[TransactionhistoryId].unsafeGetNullable(rs, i + 1),
        productid = Get[ProductId].unsafeGetNullable(rs, i + 2),
        referenceorderid = Get[Int].unsafeGetNullable(rs, i + 3),
        referenceorderlineid = Get[Int].unsafeGetNullable(rs, i + 4),
        transactiondate = Get[LocalDateTime].unsafeGetNullable(rs, i + 5),
        transactiontype = Get[/* bpchar */ String].unsafeGetNullable(rs, i + 6),
        quantity = Get[Int].unsafeGetNullable(rs, i + 7),
        actualcost = Get[BigDecimal].unsafeGetNullable(rs, i + 8),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 9)
      )
    )
  

}