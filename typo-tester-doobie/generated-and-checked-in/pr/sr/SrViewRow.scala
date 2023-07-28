/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package sr

import adventureworks.TypoLocalDateTime
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
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
  implicit val decoder: Decoder[SrViewRow] = Decoder.forProduct4[SrViewRow, Option[Int], Option[ScrapreasonId], Option[Name], Option[TypoLocalDateTime]]("id", "scrapreasonid", "name", "modifieddate")(SrViewRow.apply)
  implicit val encoder: Encoder[SrViewRow] = Encoder.forProduct4[SrViewRow, Option[Int], Option[ScrapreasonId], Option[Name], Option[TypoLocalDateTime]]("id", "scrapreasonid", "name", "modifieddate")(x => (x.id, x.scrapreasonid, x.name, x.modifieddate))
  implicit val read: Read[SrViewRow] = new Read[SrViewRow](
    gets = List(
      (Get[Int], Nullability.Nullable),
      (Get[ScrapreasonId], Nullability.Nullable),
      (Get[Name], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SrViewRow(
      id = Get[Int].unsafeGetNullable(rs, i + 0),
      scrapreasonid = Get[ScrapreasonId].unsafeGetNullable(rs, i + 1),
      name = Get[Name].unsafeGetNullable(rs, i + 2),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 3)
    )
  )
}
