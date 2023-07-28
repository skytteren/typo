/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmi

import adventureworks.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PmiViewRow(
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.illustrationid]] */
  illustrationid: Option[IllustrationId],
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PmiViewRow {
  implicit val decoder: Decoder[PmiViewRow] = Decoder.forProduct3[PmiViewRow, Option[ProductmodelId], Option[IllustrationId], Option[TypoLocalDateTime]]("productmodelid", "illustrationid", "modifieddate")(PmiViewRow.apply)
  implicit val encoder: Encoder[PmiViewRow] = Encoder.forProduct3[PmiViewRow, Option[ProductmodelId], Option[IllustrationId], Option[TypoLocalDateTime]]("productmodelid", "illustrationid", "modifieddate")(x => (x.productmodelid, x.illustrationid, x.modifieddate))
  implicit val read: Read[PmiViewRow] = new Read[PmiViewRow](
    gets = List(
      (Get[ProductmodelId], Nullability.Nullable),
      (Get[IllustrationId], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PmiViewRow(
      productmodelid = Get[ProductmodelId].unsafeGetNullable(rs, i + 0),
      illustrationid = Get[IllustrationId].unsafeGetNullable(rs, i + 1),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 2)
    )
  )
}
