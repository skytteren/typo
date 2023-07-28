/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_available_extensions

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgAvailableExtensionsViewRow(
  name: Option[String],
  defaultVersion: Option[String],
  installedVersion: Option[String],
  comment: Option[String]
)

object PgAvailableExtensionsViewRow {
  def rowParser(idx: Int): RowParser[PgAvailableExtensionsViewRow] =
    RowParser[PgAvailableExtensionsViewRow] { row =>
      Success(
        PgAvailableExtensionsViewRow(
          name = row[Option[String]](idx + 0),
          defaultVersion = row[Option[String]](idx + 1),
          installedVersion = row[Option[String]](idx + 2),
          comment = row[Option[String]](idx + 3)
        )
      )
    }
  implicit val oFormat: OFormat[PgAvailableExtensionsViewRow] = new OFormat[PgAvailableExtensionsViewRow]{
    override def writes(o: PgAvailableExtensionsViewRow): JsObject =
      Json.obj(
        "name" -> o.name,
        "default_version" -> o.defaultVersion,
        "installed_version" -> o.installedVersion,
        "comment" -> o.comment
      )
  
    override def reads(json: JsValue): JsResult[PgAvailableExtensionsViewRow] = {
      JsResult.fromTry(
        Try(
          PgAvailableExtensionsViewRow(
            name = json.\("name").toOption.map(_.as[String]),
            defaultVersion = json.\("default_version").toOption.map(_.as[String]),
            installedVersion = json.\("installed_version").toOption.map(_.as[String]),
            comment = json.\("comment").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}