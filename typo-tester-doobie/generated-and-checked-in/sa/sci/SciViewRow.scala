/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sci

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.shoppingcartitem.ShoppingcartitemId
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

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
  datecreated: Option[TypoLocalDateTime],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SciViewRow {
  implicit val decoder: Decoder[SciViewRow] = Decoder.forProduct7[SciViewRow, Option[Int], Option[ShoppingcartitemId], Option[/* max 50 chars */ String], Option[Int], Option[ProductId], Option[TypoLocalDateTime], Option[TypoLocalDateTime]]("id", "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")(SciViewRow.apply)
  implicit val encoder: Encoder[SciViewRow] = Encoder.forProduct7[SciViewRow, Option[Int], Option[ShoppingcartitemId], Option[/* max 50 chars */ String], Option[Int], Option[ProductId], Option[TypoLocalDateTime], Option[TypoLocalDateTime]]("id", "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")(x => (x.id, x.shoppingcartitemid, x.shoppingcartid, x.quantity, x.productid, x.datecreated, x.modifieddate))
  implicit val read: Read[SciViewRow] = new Read[SciViewRow](
    gets = List(
      (Get[Int], Nullability.Nullable),
      (Get[ShoppingcartitemId], Nullability.Nullable),
      (Get[/* max 50 chars */ String], Nullability.Nullable),
      (Get[Int], Nullability.Nullable),
      (Get[ProductId], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SciViewRow(
      id = Get[Int].unsafeGetNullable(rs, i + 0),
      shoppingcartitemid = Get[ShoppingcartitemId].unsafeGetNullable(rs, i + 1),
      shoppingcartid = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 2),
      quantity = Get[Int].unsafeGetNullable(rs, i + 3),
      productid = Get[ProductId].unsafeGetNullable(rs, i + 4),
      datecreated = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 5),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 6)
    )
  )
}
