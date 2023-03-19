/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.time.ZonedDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgAuthidRowUnsaved(
  rolname: String,
  rolsuper: Boolean,
  rolinherit: Boolean,
  rolcreaterole: Boolean,
  rolcreatedb: Boolean,
  rolcanlogin: Boolean,
  rolreplication: Boolean,
  rolbypassrls: Boolean,
  rolconnlimit: Int,
  rolpassword: Option[String],
  rolvaliduntil: Option[ZonedDateTime]
)
object PgAuthidRowUnsaved {
  implicit val oFormat: OFormat[PgAuthidRowUnsaved] = new OFormat[PgAuthidRowUnsaved]{
    override def writes(o: PgAuthidRowUnsaved): JsObject =
      Json.obj(
        "rolname" -> o.rolname,
      "rolsuper" -> o.rolsuper,
      "rolinherit" -> o.rolinherit,
      "rolcreaterole" -> o.rolcreaterole,
      "rolcreatedb" -> o.rolcreatedb,
      "rolcanlogin" -> o.rolcanlogin,
      "rolreplication" -> o.rolreplication,
      "rolbypassrls" -> o.rolbypassrls,
      "rolconnlimit" -> o.rolconnlimit,
      "rolpassword" -> o.rolpassword,
      "rolvaliduntil" -> o.rolvaliduntil
      )

    override def reads(json: JsValue): JsResult[PgAuthidRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgAuthidRowUnsaved(
            rolname = json.\("rolname").as[String],
            rolsuper = json.\("rolsuper").as[Boolean],
            rolinherit = json.\("rolinherit").as[Boolean],
            rolcreaterole = json.\("rolcreaterole").as[Boolean],
            rolcreatedb = json.\("rolcreatedb").as[Boolean],
            rolcanlogin = json.\("rolcanlogin").as[Boolean],
            rolreplication = json.\("rolreplication").as[Boolean],
            rolbypassrls = json.\("rolbypassrls").as[Boolean],
            rolconnlimit = json.\("rolconnlimit").as[Int],
            rolpassword = json.\("rolpassword").toOption.map(_.as[String]),
            rolvaliduntil = json.\("rolvaliduntil").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
