/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_indexes

import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatioUserIndexesViewRow(
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.relid]] */
  relid: Option[/* oid */ Long],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.indexrelid]] */
  indexrelid: Option[/* oid */ Long],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.indexrelname]] */
  indexrelname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.idxBlksRead]] */
  idxBlksRead: Option[Long],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.idxBlksHit]] */
  idxBlksHit: Option[Long]
)

object PgStatioUserIndexesViewRow {
  implicit val decoder: Decoder[PgStatioUserIndexesViewRow] = Decoder.forProduct7[PgStatioUserIndexesViewRow, Option[/* oid */ Long], Option[/* oid */ Long], Option[String], Option[String], Option[String], Option[Long], Option[Long]]("relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_blks_read", "idx_blks_hit")(PgStatioUserIndexesViewRow.apply)
  implicit val encoder: Encoder[PgStatioUserIndexesViewRow] = Encoder.forProduct7[PgStatioUserIndexesViewRow, Option[/* oid */ Long], Option[/* oid */ Long], Option[String], Option[String], Option[String], Option[Long], Option[Long]]("relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_blks_read", "idx_blks_hit")(x => (x.relid, x.indexrelid, x.schemaname, x.relname, x.indexrelname, x.idxBlksRead, x.idxBlksHit))
  implicit val read: Read[PgStatioUserIndexesViewRow] = new Read[PgStatioUserIndexesViewRow](
    gets = List(
      (Get[/* oid */ Long], Nullability.Nullable),
      (Get[/* oid */ Long], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatioUserIndexesViewRow(
      relid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 0),
      indexrelid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 1),
      schemaname = Get[String].unsafeGetNullable(rs, i + 2),
      relname = Get[String].unsafeGetNullable(rs, i + 3),
      indexrelname = Get[String].unsafeGetNullable(rs, i + 4),
      idxBlksRead = Get[Long].unsafeGetNullable(rs, i + 5),
      idxBlksHit = Get[Long].unsafeGetNullable(rs, i + 6)
    )
  )
}
