/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmpdc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/**
 *View: pr.pmpdc */
case class PmpdcViewRow(
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.productdescriptionid]] */
  productdescriptionid: ProductdescriptionId,
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.cultureid]] */
  cultureid: CultureId,
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PmpdcViewRow {
  implicit lazy val decoder: Decoder[PmpdcViewRow] = Decoder.forProduct4[PmpdcViewRow, ProductmodelId, ProductdescriptionId, CultureId, TypoLocalDateTime]("productmodelid", "productdescriptionid", "cultureid", "modifieddate")(PmpdcViewRow.apply)(ProductmodelId.decoder, ProductdescriptionId.decoder, CultureId.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PmpdcViewRow] = Encoder.forProduct4[PmpdcViewRow, ProductmodelId, ProductdescriptionId, CultureId, TypoLocalDateTime]("productmodelid", "productdescriptionid", "cultureid", "modifieddate")(x => (x.productmodelid, x.productdescriptionid, x.cultureid, x.modifieddate))(ProductmodelId.encoder, ProductdescriptionId.encoder, CultureId.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PmpdcViewRow] = new Read[PmpdcViewRow](
    gets = List(
      (ProductmodelId.get, Nullability.NoNulls),
      (ProductdescriptionId.get, Nullability.NoNulls),
      (CultureId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PmpdcViewRow(
      productmodelid = ProductmodelId.get.unsafeGetNonNullable(rs, i + 0),
      productdescriptionid = ProductdescriptionId.get.unsafeGetNonNullable(rs, i + 1),
      cultureid = CultureId.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
