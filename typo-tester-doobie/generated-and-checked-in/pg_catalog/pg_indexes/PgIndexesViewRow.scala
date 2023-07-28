/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_indexes

import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgIndexesViewRow(
  schemaname: Option[String],
  tablename: Option[String],
  indexname: Option[String],
  tablespace: Option[String],
  indexdef: Option[String]
)

object PgIndexesViewRow {
  implicit val decoder: Decoder[PgIndexesViewRow] = Decoder.forProduct5[PgIndexesViewRow, Option[String], Option[String], Option[String], Option[String], Option[String]]("schemaname", "tablename", "indexname", "tablespace", "indexdef")(PgIndexesViewRow.apply)
  implicit val encoder: Encoder[PgIndexesViewRow] = Encoder.forProduct5[PgIndexesViewRow, Option[String], Option[String], Option[String], Option[String], Option[String]]("schemaname", "tablename", "indexname", "tablespace", "indexdef")(x => (x.schemaname, x.tablename, x.indexname, x.tablespace, x.indexdef))
  implicit val read: Read[PgIndexesViewRow] = new Read[PgIndexesViewRow](
    gets = List(
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgIndexesViewRow(
      schemaname = Get[String].unsafeGetNullable(rs, i + 0),
      tablename = Get[String].unsafeGetNullable(rs, i + 1),
      indexname = Get[String].unsafeGetNullable(rs, i + 2),
      tablespace = Get[String].unsafeGetNullable(rs, i + 3),
      indexdef = Get[String].unsafeGetNullable(rs, i + 4)
    )
  )
}
