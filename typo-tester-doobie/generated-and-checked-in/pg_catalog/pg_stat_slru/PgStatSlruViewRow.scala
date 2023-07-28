/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_slru

import adventureworks.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatSlruViewRow(
  name: Option[String],
  blksZeroed: Option[Long],
  blksHit: Option[Long],
  blksRead: Option[Long],
  blksWritten: Option[Long],
  blksExists: Option[Long],
  flushes: Option[Long],
  truncates: Option[Long],
  statsReset: Option[TypoOffsetDateTime]
)

object PgStatSlruViewRow {
  implicit val decoder: Decoder[PgStatSlruViewRow] = Decoder.forProduct9[PgStatSlruViewRow, Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[TypoOffsetDateTime]]("name", "blks_zeroed", "blks_hit", "blks_read", "blks_written", "blks_exists", "flushes", "truncates", "stats_reset")(PgStatSlruViewRow.apply)
  implicit val encoder: Encoder[PgStatSlruViewRow] = Encoder.forProduct9[PgStatSlruViewRow, Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[TypoOffsetDateTime]]("name", "blks_zeroed", "blks_hit", "blks_read", "blks_written", "blks_exists", "flushes", "truncates", "stats_reset")(x => (x.name, x.blksZeroed, x.blksHit, x.blksRead, x.blksWritten, x.blksExists, x.flushes, x.truncates, x.statsReset))
  implicit val read: Read[PgStatSlruViewRow] = new Read[PgStatSlruViewRow](
    gets = List(
      (Get[String], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[TypoOffsetDateTime], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatSlruViewRow(
      name = Get[String].unsafeGetNullable(rs, i + 0),
      blksZeroed = Get[Long].unsafeGetNullable(rs, i + 1),
      blksHit = Get[Long].unsafeGetNullable(rs, i + 2),
      blksRead = Get[Long].unsafeGetNullable(rs, i + 3),
      blksWritten = Get[Long].unsafeGetNullable(rs, i + 4),
      blksExists = Get[Long].unsafeGetNullable(rs, i + 5),
      flushes = Get[Long].unsafeGetNullable(rs, i + 6),
      truncates = Get[Long].unsafeGetNullable(rs, i + 7),
      statsReset = Get[TypoOffsetDateTime].unsafeGetNullable(rs, i + 8)
    )
  )
}
