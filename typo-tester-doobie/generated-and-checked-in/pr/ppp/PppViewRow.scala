/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package ppp

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PppViewRow(
  /** Points to [[production.productproductphoto.ProductproductphotoRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productproductphoto.ProductproductphotoRow.productphotoid]] */
  productphotoid: Option[ProductphotoId],
  /** Points to [[production.productproductphoto.ProductproductphotoRow.primary]] */
  primary: Flag,
  /** Points to [[production.productproductphoto.ProductproductphotoRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PppViewRow {
  implicit val decoder: Decoder[PppViewRow] = Decoder.forProduct4[PppViewRow, Option[ProductId], Option[ProductphotoId], Flag, Option[TypoLocalDateTime]]("productid", "productphotoid", "primary", "modifieddate")(PppViewRow.apply)
  implicit val encoder: Encoder[PppViewRow] = Encoder.forProduct4[PppViewRow, Option[ProductId], Option[ProductphotoId], Flag, Option[TypoLocalDateTime]]("productid", "productphotoid", "primary", "modifieddate")(x => (x.productid, x.productphotoid, x.primary, x.modifieddate))
  implicit val read: Read[PppViewRow] = new Read[PppViewRow](
    gets = List(
      (Get[ProductId], Nullability.Nullable),
      (Get[ProductphotoId], Nullability.Nullable),
      (Get[Flag], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PppViewRow(
      productid = Get[ProductId].unsafeGetNullable(rs, i + 0),
      productphotoid = Get[ProductphotoId].unsafeGetNullable(rs, i + 1),
      primary = Get[Flag].unsafeGetNonNullable(rs, i + 2),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 3)
    )
  )
}
