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

case class PgMatviewsRow(
  schemaname: Option[String],
  matviewname: Option[String],
  matviewowner: Option[String],
  tablespace: Option[String],
  hasindexes: Option[Boolean],
  ispopulated: Option[Boolean],
  definition: Option[String]
)

object PgMatviewsRow {
  def rowParser(prefix: String): RowParser[PgMatviewsRow] = { row =>
    Success(
      PgMatviewsRow(
        schemaname = row[Option[String]](prefix + "schemaname"),
        matviewname = row[Option[String]](prefix + "matviewname"),
        matviewowner = row[Option[String]](prefix + "matviewowner"),
        tablespace = row[Option[String]](prefix + "tablespace"),
        hasindexes = row[Option[Boolean]](prefix + "hasindexes"),
        ispopulated = row[Option[Boolean]](prefix + "ispopulated"),
        definition = row[Option[String]](prefix + "definition")
      )
    )
  }

  implicit val oFormat: OFormat[PgMatviewsRow] = new OFormat[PgMatviewsRow]{
    override def writes(o: PgMatviewsRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "matviewname" -> o.matviewname,
      "matviewowner" -> o.matviewowner,
      "tablespace" -> o.tablespace,
      "hasindexes" -> o.hasindexes,
      "ispopulated" -> o.ispopulated,
      "definition" -> o.definition
      )

    override def reads(json: JsValue): JsResult[PgMatviewsRow] = {
      JsResult.fromTry(
        Try(
          PgMatviewsRow(
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            matviewname = json.\("matviewname").toOption.map(_.as[String]),
            matviewowner = json.\("matviewowner").toOption.map(_.as[String]),
            tablespace = json.\("tablespace").toOption.map(_.as[String]),
            hasindexes = json.\("hasindexes").toOption.map(_.as[Boolean]),
            ispopulated = json.\("ispopulated").toOption.map(_.as[Boolean]),
            definition = json.\("definition").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}