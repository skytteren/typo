/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgUserMappingsRow(
  oid: Option[Long],
  umoptions: Option[Array[String]],
  umuser: Option[Long],
  authorizationIdentifier: Option[String],
  foreignServerCatalog: Option[String],
  foreignServerName: Option[String],
  srvowner: Option[String]
)

object PgUserMappingsRow {
  def rowParser(prefix: String): RowParser[PgUserMappingsRow] = { row =>
    Success(
      PgUserMappingsRow(
        oid = row[Option[Long]](prefix + "oid"),
        umoptions = row[Option[Array[String]]](prefix + "umoptions"),
        umuser = row[Option[Long]](prefix + "umuser"),
        authorizationIdentifier = row[Option[String]](prefix + "authorization_identifier"),
        foreignServerCatalog = row[Option[String]](prefix + "foreign_server_catalog"),
        foreignServerName = row[Option[String]](prefix + "foreign_server_name"),
        srvowner = row[Option[String]](prefix + "srvowner")
      )
    )
  }

  implicit val oFormat: OFormat[PgUserMappingsRow] = new OFormat[PgUserMappingsRow]{
    override def writes(o: PgUserMappingsRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "umoptions" -> o.umoptions,
      "umuser" -> o.umuser,
      "authorization_identifier" -> o.authorizationIdentifier,
      "foreign_server_catalog" -> o.foreignServerCatalog,
      "foreign_server_name" -> o.foreignServerName,
      "srvowner" -> o.srvowner
      )

    override def reads(json: JsValue): JsResult[PgUserMappingsRow] = {
      JsResult.fromTry(
        Try(
          PgUserMappingsRow(
            oid = json.\("oid").toOption.map(_.as[Long]),
            umoptions = json.\("umoptions").toOption.map(_.as[Array[String]]),
            umuser = json.\("umuser").toOption.map(_.as[Long]),
            authorizationIdentifier = json.\("authorization_identifier").toOption.map(_.as[String]),
            foreignServerCatalog = json.\("foreign_server_catalog").toOption.map(_.as[String]),
            foreignServerName = json.\("foreign_server_name").toOption.map(_.as[String]),
            srvowner = json.\("srvowner").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}