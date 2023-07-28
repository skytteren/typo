/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cursors

import adventureworks.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgCursorsViewRow(
  name: Option[String],
  statement: Option[String],
  isHoldable: Option[Boolean],
  isBinary: Option[Boolean],
  isScrollable: Option[Boolean],
  creationTime: Option[TypoOffsetDateTime]
)

object PgCursorsViewRow {
  implicit val decoder: Decoder[PgCursorsViewRow] = Decoder.forProduct6[PgCursorsViewRow, Option[String], Option[String], Option[Boolean], Option[Boolean], Option[Boolean], Option[TypoOffsetDateTime]]("name", "statement", "is_holdable", "is_binary", "is_scrollable", "creation_time")(PgCursorsViewRow.apply)
  implicit val encoder: Encoder[PgCursorsViewRow] = Encoder.forProduct6[PgCursorsViewRow, Option[String], Option[String], Option[Boolean], Option[Boolean], Option[Boolean], Option[TypoOffsetDateTime]]("name", "statement", "is_holdable", "is_binary", "is_scrollable", "creation_time")(x => (x.name, x.statement, x.isHoldable, x.isBinary, x.isScrollable, x.creationTime))
  implicit val read: Read[PgCursorsViewRow] = new Read[PgCursorsViewRow](
    gets = List(
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[Boolean], Nullability.Nullable),
      (Get[Boolean], Nullability.Nullable),
      (Get[Boolean], Nullability.Nullable),
      (Get[TypoOffsetDateTime], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgCursorsViewRow(
      name = Get[String].unsafeGetNullable(rs, i + 0),
      statement = Get[String].unsafeGetNullable(rs, i + 1),
      isHoldable = Get[Boolean].unsafeGetNullable(rs, i + 2),
      isBinary = Get[Boolean].unsafeGetNullable(rs, i + 3),
      isScrollable = Get[Boolean].unsafeGetNullable(rs, i + 4),
      creationTime = Get[TypoOffsetDateTime].unsafeGetNullable(rs, i + 5)
    )
  )
}
