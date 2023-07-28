/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_activity

import adventureworks.TypoInet
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

case class PgStatActivityViewRow(
  datid: Option[/* oid */ Long],
  datname: Option[String],
  pid: Option[Int],
  leaderPid: Option[Int],
  usesysid: Option[/* oid */ Long],
  usename: Option[String],
  applicationName: Option[String],
  clientAddr: Option[TypoInet],
  clientHostname: Option[String],
  clientPort: Option[Int],
  backendStart: Option[TypoOffsetDateTime],
  xactStart: Option[TypoOffsetDateTime],
  queryStart: Option[TypoOffsetDateTime],
  stateChange: Option[TypoOffsetDateTime],
  waitEventType: Option[String],
  waitEvent: Option[String],
  state: Option[String],
  backendXid: Option[TypoXid],
  backendXmin: Option[TypoXid],
  queryId: Option[Long],
  query: Option[String],
  backendType: Option[String]
)

object PgStatActivityViewRow {
  implicit val reads: Reads[PgStatActivityViewRow] = Reads[PgStatActivityViewRow](json => JsResult.fromTry(
      Try(
        PgStatActivityViewRow(
          datid = json.\("datid").toOption.map(_.as[/* oid */ Long]),
          datname = json.\("datname").toOption.map(_.as[String]),
          pid = json.\("pid").toOption.map(_.as[Int]),
          leaderPid = json.\("leader_pid").toOption.map(_.as[Int]),
          usesysid = json.\("usesysid").toOption.map(_.as[/* oid */ Long]),
          usename = json.\("usename").toOption.map(_.as[String]),
          applicationName = json.\("application_name").toOption.map(_.as[String]),
          clientAddr = json.\("client_addr").toOption.map(_.as[TypoInet]),
          clientHostname = json.\("client_hostname").toOption.map(_.as[String]),
          clientPort = json.\("client_port").toOption.map(_.as[Int]),
          backendStart = json.\("backend_start").toOption.map(_.as[TypoOffsetDateTime]),
          xactStart = json.\("xact_start").toOption.map(_.as[TypoOffsetDateTime]),
          queryStart = json.\("query_start").toOption.map(_.as[TypoOffsetDateTime]),
          stateChange = json.\("state_change").toOption.map(_.as[TypoOffsetDateTime]),
          waitEventType = json.\("wait_event_type").toOption.map(_.as[String]),
          waitEvent = json.\("wait_event").toOption.map(_.as[String]),
          state = json.\("state").toOption.map(_.as[String]),
          backendXid = json.\("backend_xid").toOption.map(_.as[TypoXid]),
          backendXmin = json.\("backend_xmin").toOption.map(_.as[TypoXid]),
          queryId = json.\("query_id").toOption.map(_.as[Long]),
          query = json.\("query").toOption.map(_.as[String]),
          backendType = json.\("backend_type").toOption.map(_.as[String])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatActivityViewRow] = RowParser[PgStatActivityViewRow] { row =>
    Success(
      PgStatActivityViewRow(
        datid = row[Option[/* oid */ Long]](idx + 0),
        datname = row[Option[String]](idx + 1),
        pid = row[Option[Int]](idx + 2),
        leaderPid = row[Option[Int]](idx + 3),
        usesysid = row[Option[/* oid */ Long]](idx + 4),
        usename = row[Option[String]](idx + 5),
        applicationName = row[Option[String]](idx + 6),
        clientAddr = row[Option[TypoInet]](idx + 7),
        clientHostname = row[Option[String]](idx + 8),
        clientPort = row[Option[Int]](idx + 9),
        backendStart = row[Option[TypoOffsetDateTime]](idx + 10),
        xactStart = row[Option[TypoOffsetDateTime]](idx + 11),
        queryStart = row[Option[TypoOffsetDateTime]](idx + 12),
        stateChange = row[Option[TypoOffsetDateTime]](idx + 13),
        waitEventType = row[Option[String]](idx + 14),
        waitEvent = row[Option[String]](idx + 15),
        state = row[Option[String]](idx + 16),
        backendXid = row[Option[TypoXid]](idx + 17),
        backendXmin = row[Option[TypoXid]](idx + 18),
        queryId = row[Option[Long]](idx + 19),
        query = row[Option[String]](idx + 20),
        backendType = row[Option[String]](idx + 21)
      )
    )
  }
  implicit val writes: OWrites[PgStatActivityViewRow] = OWrites[PgStatActivityViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "datid" -> Json.toJson(o.datid),
      "datname" -> Json.toJson(o.datname),
      "pid" -> Json.toJson(o.pid),
      "leader_pid" -> Json.toJson(o.leaderPid),
      "usesysid" -> Json.toJson(o.usesysid),
      "usename" -> Json.toJson(o.usename),
      "application_name" -> Json.toJson(o.applicationName),
      "client_addr" -> Json.toJson(o.clientAddr),
      "client_hostname" -> Json.toJson(o.clientHostname),
      "client_port" -> Json.toJson(o.clientPort),
      "backend_start" -> Json.toJson(o.backendStart),
      "xact_start" -> Json.toJson(o.xactStart),
      "query_start" -> Json.toJson(o.queryStart),
      "state_change" -> Json.toJson(o.stateChange),
      "wait_event_type" -> Json.toJson(o.waitEventType),
      "wait_event" -> Json.toJson(o.waitEvent),
      "state" -> Json.toJson(o.state),
      "backend_xid" -> Json.toJson(o.backendXid),
      "backend_xmin" -> Json.toJson(o.backendXmin),
      "query_id" -> Json.toJson(o.queryId),
      "query" -> Json.toJson(o.query),
      "backend_type" -> Json.toJson(o.backendType)
    ))
  )
}
