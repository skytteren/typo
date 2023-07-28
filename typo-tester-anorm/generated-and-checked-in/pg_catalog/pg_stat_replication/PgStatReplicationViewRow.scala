/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication

import adventureworks.TypoInet
import adventureworks.TypoInterval
import adventureworks.TypoOffsetDateTime
import adventureworks.TypoXid
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgStatReplicationViewRow(
  pid: Option[Int],
  usesysid: Option[/* oid */ Long],
  usename: Option[String],
  applicationName: Option[String],
  clientAddr: Option[TypoInet],
  clientHostname: Option[String],
  clientPort: Option[Int],
  backendStart: Option[TypoOffsetDateTime],
  backendXmin: Option[TypoXid],
  state: Option[String],
  sentLsn: Option[/* pg_lsn */ Long],
  writeLsn: Option[/* pg_lsn */ Long],
  flushLsn: Option[/* pg_lsn */ Long],
  replayLsn: Option[/* pg_lsn */ Long],
  writeLag: Option[TypoInterval],
  flushLag: Option[TypoInterval],
  replayLag: Option[TypoInterval],
  syncPriority: Option[Int],
  syncState: Option[String],
  replyTime: Option[TypoOffsetDateTime]
)

object PgStatReplicationViewRow {
  implicit val reads: Reads[PgStatReplicationViewRow] = Reads[PgStatReplicationViewRow](json => JsResult.fromTry(
      Try(
        PgStatReplicationViewRow(
          pid = json.\("pid").toOption.map(_.as[Int]),
          usesysid = json.\("usesysid").toOption.map(_.as[/* oid */ Long]),
          usename = json.\("usename").toOption.map(_.as[String]),
          applicationName = json.\("application_name").toOption.map(_.as[String]),
          clientAddr = json.\("client_addr").toOption.map(_.as[TypoInet]),
          clientHostname = json.\("client_hostname").toOption.map(_.as[String]),
          clientPort = json.\("client_port").toOption.map(_.as[Int]),
          backendStart = json.\("backend_start").toOption.map(_.as[TypoOffsetDateTime]),
          backendXmin = json.\("backend_xmin").toOption.map(_.as[TypoXid]),
          state = json.\("state").toOption.map(_.as[String]),
          sentLsn = json.\("sent_lsn").toOption.map(_.as[/* pg_lsn */ Long]),
          writeLsn = json.\("write_lsn").toOption.map(_.as[/* pg_lsn */ Long]),
          flushLsn = json.\("flush_lsn").toOption.map(_.as[/* pg_lsn */ Long]),
          replayLsn = json.\("replay_lsn").toOption.map(_.as[/* pg_lsn */ Long]),
          writeLag = json.\("write_lag").toOption.map(_.as[TypoInterval]),
          flushLag = json.\("flush_lag").toOption.map(_.as[TypoInterval]),
          replayLag = json.\("replay_lag").toOption.map(_.as[TypoInterval]),
          syncPriority = json.\("sync_priority").toOption.map(_.as[Int]),
          syncState = json.\("sync_state").toOption.map(_.as[String]),
          replyTime = json.\("reply_time").toOption.map(_.as[TypoOffsetDateTime])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatReplicationViewRow] = RowParser[PgStatReplicationViewRow] { row =>
    Success(
      PgStatReplicationViewRow(
        pid = row[Option[Int]](idx + 0),
        usesysid = row[Option[/* oid */ Long]](idx + 1),
        usename = row[Option[String]](idx + 2),
        applicationName = row[Option[String]](idx + 3),
        clientAddr = row[Option[TypoInet]](idx + 4),
        clientHostname = row[Option[String]](idx + 5),
        clientPort = row[Option[Int]](idx + 6),
        backendStart = row[Option[TypoOffsetDateTime]](idx + 7),
        backendXmin = row[Option[TypoXid]](idx + 8),
        state = row[Option[String]](idx + 9),
        sentLsn = row[Option[/* pg_lsn */ Long]](idx + 10),
        writeLsn = row[Option[/* pg_lsn */ Long]](idx + 11),
        flushLsn = row[Option[/* pg_lsn */ Long]](idx + 12),
        replayLsn = row[Option[/* pg_lsn */ Long]](idx + 13),
        writeLag = row[Option[TypoInterval]](idx + 14),
        flushLag = row[Option[TypoInterval]](idx + 15),
        replayLag = row[Option[TypoInterval]](idx + 16),
        syncPriority = row[Option[Int]](idx + 17),
        syncState = row[Option[String]](idx + 18),
        replyTime = row[Option[TypoOffsetDateTime]](idx + 19)
      )
    )
  }
  implicit val writes: OWrites[PgStatReplicationViewRow] = OWrites[PgStatReplicationViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "pid" -> Json.toJson(o.pid),
      "usesysid" -> Json.toJson(o.usesysid),
      "usename" -> Json.toJson(o.usename),
      "application_name" -> Json.toJson(o.applicationName),
      "client_addr" -> Json.toJson(o.clientAddr),
      "client_hostname" -> Json.toJson(o.clientHostname),
      "client_port" -> Json.toJson(o.clientPort),
      "backend_start" -> Json.toJson(o.backendStart),
      "backend_xmin" -> Json.toJson(o.backendXmin),
      "state" -> Json.toJson(o.state),
      "sent_lsn" -> Json.toJson(o.sentLsn),
      "write_lsn" -> Json.toJson(o.writeLsn),
      "flush_lsn" -> Json.toJson(o.flushLsn),
      "replay_lsn" -> Json.toJson(o.replayLsn),
      "write_lag" -> Json.toJson(o.writeLag),
      "flush_lag" -> Json.toJson(o.flushLag),
      "replay_lag" -> Json.toJson(o.replayLag),
      "sync_priority" -> Json.toJson(o.syncPriority),
      "sync_state" -> Json.toJson(o.syncState),
      "reply_time" -> Json.toJson(o.replyTime)
    ))
  )
}
