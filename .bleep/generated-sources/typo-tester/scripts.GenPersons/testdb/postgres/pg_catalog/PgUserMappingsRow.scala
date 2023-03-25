/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgUserMappingsRow(
  umid: Option[Long],
  srvid: Option[Long],
  srvname: Option[String],
  umuser: Option[Long],
  usename: Option[String],
  umoptions: Option[Array[String]]
)

object PgUserMappingsRow {
  def rowParser(prefix: String): RowParser[PgUserMappingsRow] = { row =>
    Success(
      PgUserMappingsRow(
        umid = row[Option[Long]](prefix + "umid"),
        srvid = row[Option[Long]](prefix + "srvid"),
        srvname = row[Option[String]](prefix + "srvname"),
        umuser = row[Option[Long]](prefix + "umuser"),
        usename = row[Option[String]](prefix + "usename"),
        umoptions = row[Option[Array[String]]](prefix + "umoptions")
      )
    )
  }

  implicit val oFormat: OFormat[PgUserMappingsRow] = new OFormat[PgUserMappingsRow]{
    override def writes(o: PgUserMappingsRow): JsObject =
      Json.obj(
        "umid" -> o.umid,
      "srvid" -> o.srvid,
      "srvname" -> o.srvname,
      "umuser" -> o.umuser,
      "usename" -> o.usename,
      "umoptions" -> o.umoptions
      )

    override def reads(json: JsValue): JsResult[PgUserMappingsRow] = {
      JsResult.fromTry(
        Try(
          PgUserMappingsRow(
            umid = json.\("umid").toOption.map(_.as[Long]),
            srvid = json.\("srvid").toOption.map(_.as[Long]),
            srvname = json.\("srvname").toOption.map(_.as[String]),
            umuser = json.\("umuser").toOption.map(_.as[Long]),
            usename = json.\("usename").toOption.map(_.as[String]),
            umoptions = json.\("umoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}