/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pch

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PchViewRow(
  id: Option[Int],
  /** Points to [[production.productcosthistory.ProductcosthistoryRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productcosthistory.ProductcosthistoryRow.startdate]] */
  startdate: Option[TypoLocalDateTime],
  /** Points to [[production.productcosthistory.ProductcosthistoryRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[production.productcosthistory.ProductcosthistoryRow.standardcost]] */
  standardcost: Option[BigDecimal],
  /** Points to [[production.productcosthistory.ProductcosthistoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PchViewRow {
  implicit lazy val decoder: Decoder[PchViewRow] = Decoder.forProduct6[PchViewRow, Option[Int], Option[ProductId], Option[TypoLocalDateTime], Option[TypoLocalDateTime], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "productid", "startdate", "enddate", "standardcost", "modifieddate")(PchViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ProductId.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PchViewRow] = Encoder.forProduct6[PchViewRow, Option[Int], Option[ProductId], Option[TypoLocalDateTime], Option[TypoLocalDateTime], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "productid", "startdate", "enddate", "standardcost", "modifieddate")(x => (x.id, x.productid, x.startdate, x.enddate, x.standardcost, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ProductId.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[PchViewRow] = new Read[PchViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductId.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PchViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNullable(rs, i + 1),
      startdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 2),
      enddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 3),
      standardcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5)
    )
  )
}