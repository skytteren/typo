/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package sr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class SrViewRow(
  id: Option[Int],
  /** Points to [[production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  scrapreasonid: Option[ScrapreasonId],
  /** Points to [[production.scrapreason.ScrapreasonRow.name]] */
  name: Option[Name],
  /** Points to [[production.scrapreason.ScrapreasonRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SrViewRow {
  implicit lazy val decoder: Decoder[SrViewRow] = Decoder.forProduct4[SrViewRow, Option[Int], Option[ScrapreasonId], Option[Name], Option[TypoLocalDateTime]]("id", "scrapreasonid", "name", "modifieddate")(SrViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ScrapreasonId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[SrViewRow] = Encoder.forProduct4[SrViewRow, Option[Int], Option[ScrapreasonId], Option[Name], Option[TypoLocalDateTime]]("id", "scrapreasonid", "name", "modifieddate")(x => (x.id, x.scrapreasonid, x.name, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ScrapreasonId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[SrViewRow] = new Read[SrViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ScrapreasonId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SrViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      scrapreasonid = ScrapreasonId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 3)
    )
  )
}