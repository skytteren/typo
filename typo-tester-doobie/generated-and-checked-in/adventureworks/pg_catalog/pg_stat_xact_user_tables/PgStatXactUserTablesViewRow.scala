/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_user_tables

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatXactUserTablesViewRow(
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.relid]] */
  relid: Option[/* oid */ Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.seqScan]] */
  seqScan: Option[Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.seqTupRead]] */
  seqTupRead: Option[Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.idxScan]] */
  idxScan: Option[Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.idxTupFetch]] */
  idxTupFetch: Option[Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupIns]] */
  nTupIns: Option[Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupUpd]] */
  nTupUpd: Option[Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupDel]] */
  nTupDel: Option[Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupHotUpd]] */
  nTupHotUpd: Option[Long]
)

object PgStatXactUserTablesViewRow {
  implicit lazy val decoder: Decoder[PgStatXactUserTablesViewRow] = Decoder.forProduct11[PgStatXactUserTablesViewRow, Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long]]("relid", "schemaname", "relname", "seq_scan", "seq_tup_read", "idx_scan", "idx_tup_fetch", "n_tup_ins", "n_tup_upd", "n_tup_del", "n_tup_hot_upd")(PgStatXactUserTablesViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgStatXactUserTablesViewRow] = Encoder.forProduct11[PgStatXactUserTablesViewRow, Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long]]("relid", "schemaname", "relname", "seq_scan", "seq_tup_read", "idx_scan", "idx_tup_fetch", "n_tup_ins", "n_tup_upd", "n_tup_del", "n_tup_hot_upd")(x => (x.relid, x.schemaname, x.relname, x.seqScan, x.seqTupRead, x.idxScan, x.idxTupFetch, x.nTupIns, x.nTupUpd, x.nTupDel, x.nTupHotUpd))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgStatXactUserTablesViewRow] = new Read[PgStatXactUserTablesViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatXactUserTablesViewRow(
      relid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      relname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      seqScan = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      seqTupRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      idxScan = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      idxTupFetch = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      nTupIns = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      nTupUpd = Meta.LongMeta.get.unsafeGetNullable(rs, i + 8),
      nTupDel = Meta.LongMeta.get.unsafeGetNullable(rs, i + 9),
      nTupHotUpd = Meta.LongMeta.get.unsafeGetNullable(rs, i + 10)
    )
  )
}