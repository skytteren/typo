/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_copy

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatProgressCopyViewRow(
  pid: Option[Int],
  datid: Option[/* oid */ Long],
  datname: Option[String],
  relid: Option[/* oid */ Long],
  command: Option[String],
  `type`: Option[String],
  bytesProcessed: Option[Long],
  bytesTotal: Option[Long],
  tuplesProcessed: Option[Long],
  tuplesExcluded: Option[Long]
)

object PgStatProgressCopyViewRow {
  def rowParser(idx: Int): RowParser[PgStatProgressCopyViewRow] =
    RowParser[PgStatProgressCopyViewRow] { row =>
      Success(
        PgStatProgressCopyViewRow(
          pid = row[Option[Int]](idx + 0),
          datid = row[Option[/* oid */ Long]](idx + 1),
          datname = row[Option[String]](idx + 2),
          relid = row[Option[/* oid */ Long]](idx + 3),
          command = row[Option[String]](idx + 4),
          `type` = row[Option[String]](idx + 5),
          bytesProcessed = row[Option[Long]](idx + 6),
          bytesTotal = row[Option[Long]](idx + 7),
          tuplesProcessed = row[Option[Long]](idx + 8),
          tuplesExcluded = row[Option[Long]](idx + 9)
        )
      )
    }
  implicit val oFormat: OFormat[PgStatProgressCopyViewRow] = new OFormat[PgStatProgressCopyViewRow]{
    override def writes(o: PgStatProgressCopyViewRow): JsObject =
      Json.obj(
        "pid" -> o.pid,
        "datid" -> o.datid,
        "datname" -> o.datname,
        "relid" -> o.relid,
        "command" -> o.command,
        "type" -> o.`type`,
        "bytes_processed" -> o.bytesProcessed,
        "bytes_total" -> o.bytesTotal,
        "tuples_processed" -> o.tuplesProcessed,
        "tuples_excluded" -> o.tuplesExcluded
      )
  
    override def reads(json: JsValue): JsResult[PgStatProgressCopyViewRow] = {
      JsResult.fromTry(
        Try(
          PgStatProgressCopyViewRow(
            pid = json.\("pid").toOption.map(_.as[Int]),
            datid = json.\("datid").toOption.map(_.as[/* oid */ Long]),
            datname = json.\("datname").toOption.map(_.as[String]),
            relid = json.\("relid").toOption.map(_.as[/* oid */ Long]),
            command = json.\("command").toOption.map(_.as[String]),
            `type` = json.\("type").toOption.map(_.as[String]),
            bytesProcessed = json.\("bytes_processed").toOption.map(_.as[Long]),
            bytesTotal = json.\("bytes_total").toOption.map(_.as[Long]),
            tuplesProcessed = json.\("tuples_processed").toOption.map(_.as[Long]),
            tuplesExcluded = json.\("tuples_excluded").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}