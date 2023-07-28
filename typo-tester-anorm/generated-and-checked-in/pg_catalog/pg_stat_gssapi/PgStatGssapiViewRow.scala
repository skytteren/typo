/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_gssapi

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatGssapiViewRow(
  pid: Option[Int],
  gssAuthenticated: Option[Boolean],
  principal: Option[String],
  encrypted: Option[Boolean]
)

object PgStatGssapiViewRow {
  def rowParser(idx: Int): RowParser[PgStatGssapiViewRow] =
    RowParser[PgStatGssapiViewRow] { row =>
      Success(
        PgStatGssapiViewRow(
          pid = row[Option[Int]](idx + 0),
          gssAuthenticated = row[Option[Boolean]](idx + 1),
          principal = row[Option[String]](idx + 2),
          encrypted = row[Option[Boolean]](idx + 3)
        )
      )
    }
  implicit val oFormat: OFormat[PgStatGssapiViewRow] = new OFormat[PgStatGssapiViewRow]{
    override def writes(o: PgStatGssapiViewRow): JsObject =
      Json.obj(
        "pid" -> o.pid,
        "gss_authenticated" -> o.gssAuthenticated,
        "principal" -> o.principal,
        "encrypted" -> o.encrypted
      )
  
    override def reads(json: JsValue): JsResult[PgStatGssapiViewRow] = {
      JsResult.fromTry(
        Try(
          PgStatGssapiViewRow(
            pid = json.\("pid").toOption.map(_.as[Int]),
            gssAuthenticated = json.\("gss_authenticated").toOption.map(_.as[Boolean]),
            principal = json.\("principal").toOption.map(_.as[String]),
            encrypted = json.\("encrypted").toOption.map(_.as[Boolean])
          )
        )
      )
    }
  }
}