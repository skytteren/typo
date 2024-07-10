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
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/**
 *View: pr.sr */
case class SrViewRow(
  /** Points to [[production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  id: ScrapreasonId,
  /** Points to [[production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  scrapreasonid: ScrapreasonId,
  /** Points to [[production.scrapreason.ScrapreasonRow.name]] */
  name: Name,
  /** Points to [[production.scrapreason.ScrapreasonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SrViewRow {
  implicit lazy val decoder: Decoder[SrViewRow] = Decoder.forProduct4[SrViewRow, ScrapreasonId, ScrapreasonId, Name, TypoLocalDateTime]("id", "scrapreasonid", "name", "modifieddate")(SrViewRow.apply)(ScrapreasonId.decoder, ScrapreasonId.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SrViewRow] = Encoder.forProduct4[SrViewRow, ScrapreasonId, ScrapreasonId, Name, TypoLocalDateTime]("id", "scrapreasonid", "name", "modifieddate")(x => (x.id, x.scrapreasonid, x.name, x.modifieddate))(ScrapreasonId.encoder, ScrapreasonId.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SrViewRow] = new Read[SrViewRow](
    gets = List(
      (ScrapreasonId.get, Nullability.NoNulls),
      (ScrapreasonId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SrViewRow(
      id = ScrapreasonId.get.unsafeGetNonNullable(rs, i + 0),
      scrapreasonid = ScrapreasonId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
