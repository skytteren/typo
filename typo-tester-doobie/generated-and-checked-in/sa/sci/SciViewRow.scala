/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sci

import adventureworks.production.product.ProductId
import adventureworks.sales.shoppingcartitem.ShoppingcartitemId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class SciViewRow(
  id: Option[Int],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.shoppingcartitemid]] */
  shoppingcartitemid: Option[ShoppingcartitemId],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.shoppingcartid]] */
  shoppingcartid: Option[/* max 50 chars */ String],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.datecreated]] */
  datecreated: Option[LocalDateTime],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object SciViewRow {
  implicit val decoder: Decoder[SciViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        shoppingcartitemid <- c.downField("shoppingcartitemid").as[Option[ShoppingcartitemId]]
        shoppingcartid <- c.downField("shoppingcartid").as[Option[/* max 50 chars */ String]]
        quantity <- c.downField("quantity").as[Option[Int]]
        productid <- c.downField("productid").as[Option[ProductId]]
        datecreated <- c.downField("datecreated").as[Option[LocalDateTime]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield SciViewRow(id, shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate)
  implicit val encoder: Encoder[SciViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "shoppingcartitemid" := row.shoppingcartitemid,
        "shoppingcartid" := row.shoppingcartid,
        "quantity" := row.quantity,
        "productid" := row.productid,
        "datecreated" := row.datecreated,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[SciViewRow] =
    new Read[SciViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[ShoppingcartitemId], Nullability.Nullable),
        (Get[/* max 50 chars */ String], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[ProductId], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => SciViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        shoppingcartitemid = Get[ShoppingcartitemId].unsafeGetNullable(rs, i + 1),
        shoppingcartid = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 2),
        quantity = Get[Int].unsafeGetNullable(rs, i + 3),
        productid = Get[ProductId].unsafeGetNullable(rs, i + 4),
        datecreated = Get[LocalDateTime].unsafeGetNullable(rs, i + 5),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 6)
      )
    )
  

}