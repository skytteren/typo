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

case class PgViewsRow(
  /** Points to [[PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[PgClassRow.relname]] */
  viewname: String,
  viewowner: /* unknown nullability */ Option[String],
  definition: /* unknown nullability */ Option[String]
)

object PgViewsRow {
  implicit val rowParser: RowParser[PgViewsRow] = { row =>
    Success(
      PgViewsRow(
        schemaname = row[String]("schemaname"),
        viewname = row[String]("viewname"),
        viewowner = row[/* unknown nullability */ Option[String]]("viewowner"),
        definition = row[/* unknown nullability */ Option[String]]("definition")
      )
    )
  }

  implicit val oFormat: OFormat[PgViewsRow] = new OFormat[PgViewsRow]{
    override def writes(o: PgViewsRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "viewname" -> o.viewname,
      "viewowner" -> o.viewowner,
      "definition" -> o.definition
      )

    override def reads(json: JsValue): JsResult[PgViewsRow] = {
      JsResult.fromTry(
        Try(
          PgViewsRow(
            schemaname = json.\("schemaname").as[String],
            viewname = json.\("viewname").as[String],
            viewowner = json.\("viewowner").toOption.map(_.as[String]),
            definition = json.\("definition").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
