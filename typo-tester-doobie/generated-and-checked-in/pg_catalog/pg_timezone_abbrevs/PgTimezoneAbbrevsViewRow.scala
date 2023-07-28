/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_timezone_abbrevs

import adventureworks.TypoInterval
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgTimezoneAbbrevsViewRow(
  abbrev: Option[String],
  utcOffset: Option[TypoInterval],
  isDst: Option[Boolean]
)

object PgTimezoneAbbrevsViewRow {
  implicit val decoder: Decoder[PgTimezoneAbbrevsViewRow] = Decoder.forProduct3[PgTimezoneAbbrevsViewRow, Option[String], Option[TypoInterval], Option[Boolean]]("abbrev", "utc_offset", "is_dst")(PgTimezoneAbbrevsViewRow.apply)
  implicit val encoder: Encoder[PgTimezoneAbbrevsViewRow] = Encoder.forProduct3[PgTimezoneAbbrevsViewRow, Option[String], Option[TypoInterval], Option[Boolean]]("abbrev", "utc_offset", "is_dst")(x => (x.abbrev, x.utcOffset, x.isDst))
  implicit val read: Read[PgTimezoneAbbrevsViewRow] = new Read[PgTimezoneAbbrevsViewRow](
    gets = List(
      (Get[String], Nullability.Nullable),
      (Get[TypoInterval], Nullability.Nullable),
      (Get[Boolean], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgTimezoneAbbrevsViewRow(
      abbrev = Get[String].unsafeGetNullable(rs, i + 0),
      utcOffset = Get[TypoInterval].unsafeGetNullable(rs, i + 1),
      isDst = Get[Boolean].unsafeGetNullable(rs, i + 2)
    )
  )
}
