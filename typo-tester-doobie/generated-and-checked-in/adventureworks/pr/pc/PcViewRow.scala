/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/**
 *View: pr.pc */
case class PcViewRow(
  /** Points to [[production.productcategory.ProductcategoryRow.productcategoryid]] */
  id: ProductcategoryId,
  /** Points to [[production.productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: ProductcategoryId,
  /** Points to [[production.productcategory.ProductcategoryRow.name]] */
  name: Name,
  /** Points to [[production.productcategory.ProductcategoryRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[production.productcategory.ProductcategoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PcViewRow {
  implicit lazy val decoder: Decoder[PcViewRow] = Decoder.forProduct5[PcViewRow, ProductcategoryId, ProductcategoryId, Name, TypoUUID, TypoLocalDateTime]("id", "productcategoryid", "name", "rowguid", "modifieddate")(PcViewRow.apply)(ProductcategoryId.decoder, ProductcategoryId.decoder, Name.decoder, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PcViewRow] = Encoder.forProduct5[PcViewRow, ProductcategoryId, ProductcategoryId, Name, TypoUUID, TypoLocalDateTime]("id", "productcategoryid", "name", "rowguid", "modifieddate")(x => (x.id, x.productcategoryid, x.name, x.rowguid, x.modifieddate))(ProductcategoryId.encoder, ProductcategoryId.encoder, Name.encoder, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PcViewRow] = new Read[PcViewRow](
    gets = List(
      (ProductcategoryId.get, Nullability.NoNulls),
      (ProductcategoryId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PcViewRow(
      id = ProductcategoryId.get.unsafeGetNonNullable(rs, i + 0),
      productcategoryid = ProductcategoryId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
