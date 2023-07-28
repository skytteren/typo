/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_config

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgConfigViewRow(
  name: Option[String],
  setting: Option[String]
)

object PgConfigViewRow {
  def rowParser(idx: Int): RowParser[PgConfigViewRow] =
    RowParser[PgConfigViewRow] { row =>
      Success(
        PgConfigViewRow(
          name = row[Option[String]](idx + 0),
          setting = row[Option[String]](idx + 1)
        )
      )
    }
  implicit val oFormat: OFormat[PgConfigViewRow] = new OFormat[PgConfigViewRow]{
    override def writes(o: PgConfigViewRow): JsObject =
      Json.obj(
        "name" -> o.name,
        "setting" -> o.setting
      )
  
    override def reads(json: JsValue): JsResult[PgConfigViewRow] = {
      JsResult.fromTry(
        Try(
          PgConfigViewRow(
            name = json.\("name").toOption.map(_.as[String]),
            setting = json.\("setting").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}