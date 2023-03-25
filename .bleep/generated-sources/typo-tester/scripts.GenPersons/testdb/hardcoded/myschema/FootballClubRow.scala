/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class FootballClubRow(
  id: FootballClubId,
  name: String
)

object FootballClubRow {
  def rowParser(prefix: String): RowParser[FootballClubRow] = { row =>
    Success(
      FootballClubRow(
        id = row[FootballClubId](prefix + "id"),
        name = row[String](prefix + "name")
      )
    )
  }

  implicit val oFormat: OFormat[FootballClubRow] = new OFormat[FootballClubRow]{
    override def writes(o: FootballClubRow): JsObject =
      Json.obj(
        "id" -> o.id,
      "name" -> o.name
      )

    override def reads(json: JsValue): JsResult[FootballClubRow] = {
      JsResult.fromTry(
        Try(
          FootballClubRow(
            id = json.\("id").as[FootballClubId],
            name = json.\("name").as[String]
          )
        )
      )
    }
  }
}