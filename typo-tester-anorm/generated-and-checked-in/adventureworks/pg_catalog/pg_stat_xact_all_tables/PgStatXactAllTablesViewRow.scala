/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_all_tables

import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgStatXactAllTablesViewRow(
  relid: Option[/* oid */ Long],
  schemaname: Option[String],
  relname: Option[String],
  seqScan: Option[Long],
  seqTupRead: Option[Long],
  idxScan: Option[Long],
  idxTupFetch: Option[Long],
  nTupIns: Option[Long],
  nTupUpd: Option[Long],
  nTupDel: Option[Long],
  nTupHotUpd: Option[Long]
)

object PgStatXactAllTablesViewRow {
  implicit lazy val reads: Reads[PgStatXactAllTablesViewRow] = Reads[PgStatXactAllTablesViewRow](json => JsResult.fromTry(
      Try(
        PgStatXactAllTablesViewRow(
          relid = json.\("relid").toOption.map(_.as(Reads.LongReads)),
          schemaname = json.\("schemaname").toOption.map(_.as(Reads.StringReads)),
          relname = json.\("relname").toOption.map(_.as(Reads.StringReads)),
          seqScan = json.\("seq_scan").toOption.map(_.as(Reads.LongReads)),
          seqTupRead = json.\("seq_tup_read").toOption.map(_.as(Reads.LongReads)),
          idxScan = json.\("idx_scan").toOption.map(_.as(Reads.LongReads)),
          idxTupFetch = json.\("idx_tup_fetch").toOption.map(_.as(Reads.LongReads)),
          nTupIns = json.\("n_tup_ins").toOption.map(_.as(Reads.LongReads)),
          nTupUpd = json.\("n_tup_upd").toOption.map(_.as(Reads.LongReads)),
          nTupDel = json.\("n_tup_del").toOption.map(_.as(Reads.LongReads)),
          nTupHotUpd = json.\("n_tup_hot_upd").toOption.map(_.as(Reads.LongReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatXactAllTablesViewRow] = RowParser[PgStatXactAllTablesViewRow] { row =>
    Success(
      PgStatXactAllTablesViewRow(
        relid = row(idx + 0)(Column.columnToOption(Column.columnToLong)),
        schemaname = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        relname = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        seqScan = row(idx + 3)(Column.columnToOption(Column.columnToLong)),
        seqTupRead = row(idx + 4)(Column.columnToOption(Column.columnToLong)),
        idxScan = row(idx + 5)(Column.columnToOption(Column.columnToLong)),
        idxTupFetch = row(idx + 6)(Column.columnToOption(Column.columnToLong)),
        nTupIns = row(idx + 7)(Column.columnToOption(Column.columnToLong)),
        nTupUpd = row(idx + 8)(Column.columnToOption(Column.columnToLong)),
        nTupDel = row(idx + 9)(Column.columnToOption(Column.columnToLong)),
        nTupHotUpd = row(idx + 10)(Column.columnToOption(Column.columnToLong))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatXactAllTablesViewRow] = OWrites[PgStatXactAllTablesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "relid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.relid),
      "schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schemaname),
      "relname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.relname),
      "seq_scan" -> Writes.OptionWrites(Writes.LongWrites).writes(o.seqScan),
      "seq_tup_read" -> Writes.OptionWrites(Writes.LongWrites).writes(o.seqTupRead),
      "idx_scan" -> Writes.OptionWrites(Writes.LongWrites).writes(o.idxScan),
      "idx_tup_fetch" -> Writes.OptionWrites(Writes.LongWrites).writes(o.idxTupFetch),
      "n_tup_ins" -> Writes.OptionWrites(Writes.LongWrites).writes(o.nTupIns),
      "n_tup_upd" -> Writes.OptionWrites(Writes.LongWrites).writes(o.nTupUpd),
      "n_tup_del" -> Writes.OptionWrites(Writes.LongWrites).writes(o.nTupDel),
      "n_tup_hot_upd" -> Writes.OptionWrites(Writes.LongWrites).writes(o.nTupHotUpd)
    ))
  )
}