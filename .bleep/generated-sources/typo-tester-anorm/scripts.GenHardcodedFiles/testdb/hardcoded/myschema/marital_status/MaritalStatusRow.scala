/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class MaritalStatusRow(
  id: MaritalStatusId
)

object MaritalStatusRow {
  val rowParser: RowParser[MaritalStatusRow] =
    RowParser[MaritalStatusRow] { row =>
      Success(
        MaritalStatusRow(
          id = row[MaritalStatusId]("id")
        )
      )
    }
  implicit val oFormat: OFormat[MaritalStatusRow] = new OFormat[MaritalStatusRow]{
    override def writes(o: MaritalStatusRow): JsObject =
      Json.obj(
        "id" -> o.id
      )
  
    override def reads(json: JsValue): JsResult[MaritalStatusRow] = {
      JsResult.fromTry(
        Try(
          MaritalStatusRow(
            id = json.\("id").as[MaritalStatusId]
          )
        )
      )
    }
  }
}
