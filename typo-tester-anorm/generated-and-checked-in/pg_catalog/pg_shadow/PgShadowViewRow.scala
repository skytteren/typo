/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shadow

import adventureworks.TypoOffsetDateTime
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

case class PgShadowViewRow(
  usename: Option[String],
  usesysid: Option[/* oid */ Long],
  usecreatedb: Option[Boolean],
  usesuper: Option[Boolean],
  userepl: Option[Boolean],
  usebypassrls: Option[Boolean],
  passwd: Option[String],
  valuntil: Option[TypoOffsetDateTime],
  useconfig: Option[Array[String]]
)

object PgShadowViewRow {
  implicit val reads: Reads[PgShadowViewRow] = Reads[PgShadowViewRow](json => JsResult.fromTry(
      Try(
        PgShadowViewRow(
          usename = json.\("usename").toOption.map(_.as[String]),
          usesysid = json.\("usesysid").toOption.map(_.as[/* oid */ Long]),
          usecreatedb = json.\("usecreatedb").toOption.map(_.as[Boolean]),
          usesuper = json.\("usesuper").toOption.map(_.as[Boolean]),
          userepl = json.\("userepl").toOption.map(_.as[Boolean]),
          usebypassrls = json.\("usebypassrls").toOption.map(_.as[Boolean]),
          passwd = json.\("passwd").toOption.map(_.as[String]),
          valuntil = json.\("valuntil").toOption.map(_.as[TypoOffsetDateTime]),
          useconfig = json.\("useconfig").toOption.map(_.as[Array[String]])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgShadowViewRow] = RowParser[PgShadowViewRow] { row =>
    Success(
      PgShadowViewRow(
        usename = row[Option[String]](idx + 0),
        usesysid = row[Option[/* oid */ Long]](idx + 1),
        usecreatedb = row[Option[Boolean]](idx + 2),
        usesuper = row[Option[Boolean]](idx + 3),
        userepl = row[Option[Boolean]](idx + 4),
        usebypassrls = row[Option[Boolean]](idx + 5),
        passwd = row[Option[String]](idx + 6),
        valuntil = row[Option[TypoOffsetDateTime]](idx + 7),
        useconfig = row[Option[Array[String]]](idx + 8)
      )
    )
  }
  implicit val writes: OWrites[PgShadowViewRow] = OWrites[PgShadowViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "usename" -> Json.toJson(o.usename),
      "usesysid" -> Json.toJson(o.usesysid),
      "usecreatedb" -> Json.toJson(o.usecreatedb),
      "usesuper" -> Json.toJson(o.usesuper),
      "userepl" -> Json.toJson(o.userepl),
      "usebypassrls" -> Json.toJson(o.usebypassrls),
      "passwd" -> Json.toJson(o.passwd),
      "valuntil" -> Json.toJson(o.valuntil),
      "useconfig" -> Json.toJson(o.useconfig)
    ))
  )
}
