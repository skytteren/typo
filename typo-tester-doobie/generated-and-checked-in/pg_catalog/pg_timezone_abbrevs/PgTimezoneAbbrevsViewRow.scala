/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_timezone_abbrevs

import adventureworks.TypoInterval
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class PgTimezoneAbbrevsViewRow(
  abbrev: Option[String],
  utcOffset: Option[TypoInterval],
  isDst: Option[Boolean]
)

object PgTimezoneAbbrevsViewRow {
  implicit val decoder: Decoder[PgTimezoneAbbrevsViewRow] =
    (c: HCursor) =>
      for {
        abbrev <- c.downField("abbrev").as[Option[String]]
        utcOffset <- c.downField("utc_offset").as[Option[TypoInterval]]
        isDst <- c.downField("is_dst").as[Option[Boolean]]
      } yield PgTimezoneAbbrevsViewRow(abbrev, utcOffset, isDst)
  implicit val encoder: Encoder[PgTimezoneAbbrevsViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "abbrev" := row.abbrev,
        "utc_offset" := row.utcOffset,
        "is_dst" := row.isDst
      )}
  implicit val read: Read[PgTimezoneAbbrevsViewRow] =
    new Read[PgTimezoneAbbrevsViewRow](
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