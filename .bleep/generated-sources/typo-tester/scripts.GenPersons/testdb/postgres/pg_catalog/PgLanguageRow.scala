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
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgLanguageRow(
  oid: PgLanguageId,
  lanname: String,
  lanowner: Long,
  lanispl: Boolean,
  lanpltrusted: Boolean,
  lanplcallfoid: Long,
  laninline: Long,
  lanvalidator: Long,
  lanacl: Option[Array[PGobject]]
)

object PgLanguageRow {
  def rowParser(prefix: String): RowParser[PgLanguageRow] = { row =>
    Success(
      PgLanguageRow(
        oid = row[PgLanguageId](prefix + "oid"),
        lanname = row[String](prefix + "lanname"),
        lanowner = row[Long](prefix + "lanowner"),
        lanispl = row[Boolean](prefix + "lanispl"),
        lanpltrusted = row[Boolean](prefix + "lanpltrusted"),
        lanplcallfoid = row[Long](prefix + "lanplcallfoid"),
        laninline = row[Long](prefix + "laninline"),
        lanvalidator = row[Long](prefix + "lanvalidator"),
        lanacl = row[Option[Array[PGobject]]](prefix + "lanacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgLanguageRow] = new OFormat[PgLanguageRow]{
    override def writes(o: PgLanguageRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "lanname" -> o.lanname,
      "lanowner" -> o.lanowner,
      "lanispl" -> o.lanispl,
      "lanpltrusted" -> o.lanpltrusted,
      "lanplcallfoid" -> o.lanplcallfoid,
      "laninline" -> o.laninline,
      "lanvalidator" -> o.lanvalidator,
      "lanacl" -> o.lanacl
      )

    override def reads(json: JsValue): JsResult[PgLanguageRow] = {
      JsResult.fromTry(
        Try(
          PgLanguageRow(
            oid = json.\("oid").as[PgLanguageId],
            lanname = json.\("lanname").as[String],
            lanowner = json.\("lanowner").as[Long],
            lanispl = json.\("lanispl").as[Boolean],
            lanpltrusted = json.\("lanpltrusted").as[Boolean],
            lanplcallfoid = json.\("lanplcallfoid").as[Long],
            laninline = json.\("laninline").as[Long],
            lanvalidator = json.\("lanvalidator").as[Long],
            lanacl = json.\("lanacl").toOption.map(_.as[Array[PGobject]])
          )
        )
      )
    }
  }
}