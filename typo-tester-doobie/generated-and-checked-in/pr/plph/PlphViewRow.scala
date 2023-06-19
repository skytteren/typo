/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import adventureworks.production.product.ProductId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class PlphViewRow(
  id: Option[Int],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.startdate]] */
  startdate: Option[LocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.enddate]] */
  enddate: Option[LocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.listprice]] */
  listprice: Option[BigDecimal],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PlphViewRow {
  implicit val decoder: Decoder[PlphViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        productid <- c.downField("productid").as[Option[ProductId]]
        startdate <- c.downField("startdate").as[Option[LocalDateTime]]
        enddate <- c.downField("enddate").as[Option[LocalDateTime]]
        listprice <- c.downField("listprice").as[Option[BigDecimal]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield PlphViewRow(id, productid, startdate, enddate, listprice, modifieddate)
  implicit val encoder: Encoder[PlphViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "productid" := row.productid,
        "startdate" := row.startdate,
        "enddate" := row.enddate,
        "listprice" := row.listprice,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[PlphViewRow] =
    new Read[PlphViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[ProductId], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PlphViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        productid = Get[ProductId].unsafeGetNullable(rs, i + 1),
        startdate = Get[LocalDateTime].unsafeGetNullable(rs, i + 2),
        enddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 3),
        listprice = Get[BigDecimal].unsafeGetNullable(rs, i + 4),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 5)
      )
    )
  

}
