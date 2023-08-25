/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_archiver

import adventureworks.customtypes.TypoOffsetDateTime
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

case class PgStatArchiverViewRow(
  archivedCount: Option[Long],
  lastArchivedWal: Option[String],
  lastArchivedTime: Option[TypoOffsetDateTime],
  failedCount: Option[Long],
  lastFailedWal: Option[String],
  lastFailedTime: Option[TypoOffsetDateTime],
  statsReset: Option[TypoOffsetDateTime]
)

object PgStatArchiverViewRow {
  implicit lazy val reads: Reads[PgStatArchiverViewRow] = Reads[PgStatArchiverViewRow](json => JsResult.fromTry(
      Try(
        PgStatArchiverViewRow(
          archivedCount = json.\("archived_count").toOption.map(_.as(Reads.LongReads)),
          lastArchivedWal = json.\("last_archived_wal").toOption.map(_.as(Reads.StringReads)),
          lastArchivedTime = json.\("last_archived_time").toOption.map(_.as(TypoOffsetDateTime.reads)),
          failedCount = json.\("failed_count").toOption.map(_.as(Reads.LongReads)),
          lastFailedWal = json.\("last_failed_wal").toOption.map(_.as(Reads.StringReads)),
          lastFailedTime = json.\("last_failed_time").toOption.map(_.as(TypoOffsetDateTime.reads)),
          statsReset = json.\("stats_reset").toOption.map(_.as(TypoOffsetDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatArchiverViewRow] = RowParser[PgStatArchiverViewRow] { row =>
    Success(
      PgStatArchiverViewRow(
        archivedCount = row(idx + 0)(Column.columnToOption(Column.columnToLong)),
        lastArchivedWal = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        lastArchivedTime = row(idx + 2)(Column.columnToOption(TypoOffsetDateTime.column)),
        failedCount = row(idx + 3)(Column.columnToOption(Column.columnToLong)),
        lastFailedWal = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        lastFailedTime = row(idx + 5)(Column.columnToOption(TypoOffsetDateTime.column)),
        statsReset = row(idx + 6)(Column.columnToOption(TypoOffsetDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatArchiverViewRow] = OWrites[PgStatArchiverViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "archived_count" -> Writes.OptionWrites(Writes.LongWrites).writes(o.archivedCount),
      "last_archived_wal" -> Writes.OptionWrites(Writes.StringWrites).writes(o.lastArchivedWal),
      "last_archived_time" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.lastArchivedTime),
      "failed_count" -> Writes.OptionWrites(Writes.LongWrites).writes(o.failedCount),
      "last_failed_wal" -> Writes.OptionWrites(Writes.StringWrites).writes(o.lastFailedWal),
      "last_failed_time" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.lastFailedTime),
      "stats_reset" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.statsReset)
    ))
  )
}