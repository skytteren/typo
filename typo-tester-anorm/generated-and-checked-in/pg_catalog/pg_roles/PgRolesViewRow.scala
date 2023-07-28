/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_roles

import anorm.RowParser
import anorm.Success
import java.time.OffsetDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgRolesViewRow(
  rolname: Option[String],
  rolsuper: Option[Boolean],
  rolinherit: Option[Boolean],
  rolcreaterole: Option[Boolean],
  rolcreatedb: Option[Boolean],
  rolcanlogin: Option[Boolean],
  rolreplication: Option[Boolean],
  rolconnlimit: Option[Int],
  rolpassword: Option[String],
  rolvaliduntil: Option[OffsetDateTime],
  rolbypassrls: Option[Boolean],
  rolconfig: Option[Array[String]],
  oid: Option[/* oid */ Long]
)

object PgRolesViewRow {
  def rowParser(idx: Int): RowParser[PgRolesViewRow] =
    RowParser[PgRolesViewRow] { row =>
      Success(
        PgRolesViewRow(
          rolname = row[Option[String]](idx + 0),
          rolsuper = row[Option[Boolean]](idx + 1),
          rolinherit = row[Option[Boolean]](idx + 2),
          rolcreaterole = row[Option[Boolean]](idx + 3),
          rolcreatedb = row[Option[Boolean]](idx + 4),
          rolcanlogin = row[Option[Boolean]](idx + 5),
          rolreplication = row[Option[Boolean]](idx + 6),
          rolconnlimit = row[Option[Int]](idx + 7),
          rolpassword = row[Option[String]](idx + 8),
          rolvaliduntil = row[Option[OffsetDateTime]](idx + 9),
          rolbypassrls = row[Option[Boolean]](idx + 10),
          rolconfig = row[Option[Array[String]]](idx + 11),
          oid = row[Option[/* oid */ Long]](idx + 12)
        )
      )
    }
  implicit val oFormat: OFormat[PgRolesViewRow] = new OFormat[PgRolesViewRow]{
    override def writes(o: PgRolesViewRow): JsObject =
      Json.obj(
        "rolname" -> o.rolname,
        "rolsuper" -> o.rolsuper,
        "rolinherit" -> o.rolinherit,
        "rolcreaterole" -> o.rolcreaterole,
        "rolcreatedb" -> o.rolcreatedb,
        "rolcanlogin" -> o.rolcanlogin,
        "rolreplication" -> o.rolreplication,
        "rolconnlimit" -> o.rolconnlimit,
        "rolpassword" -> o.rolpassword,
        "rolvaliduntil" -> o.rolvaliduntil,
        "rolbypassrls" -> o.rolbypassrls,
        "rolconfig" -> o.rolconfig,
        "oid" -> o.oid
      )
  
    override def reads(json: JsValue): JsResult[PgRolesViewRow] = {
      JsResult.fromTry(
        Try(
          PgRolesViewRow(
            rolname = json.\("rolname").toOption.map(_.as[String]),
            rolsuper = json.\("rolsuper").toOption.map(_.as[Boolean]),
            rolinherit = json.\("rolinherit").toOption.map(_.as[Boolean]),
            rolcreaterole = json.\("rolcreaterole").toOption.map(_.as[Boolean]),
            rolcreatedb = json.\("rolcreatedb").toOption.map(_.as[Boolean]),
            rolcanlogin = json.\("rolcanlogin").toOption.map(_.as[Boolean]),
            rolreplication = json.\("rolreplication").toOption.map(_.as[Boolean]),
            rolconnlimit = json.\("rolconnlimit").toOption.map(_.as[Int]),
            rolpassword = json.\("rolpassword").toOption.map(_.as[String]),
            rolvaliduntil = json.\("rolvaliduntil").toOption.map(_.as[OffsetDateTime]),
            rolbypassrls = json.\("rolbypassrls").toOption.map(_.as[Boolean]),
            rolconfig = json.\("rolconfig").toOption.map(_.as[Array[String]]),
            oid = json.\("oid").toOption.map(_.as[/* oid */ Long])
          )
        )
      )
    }
  }
}