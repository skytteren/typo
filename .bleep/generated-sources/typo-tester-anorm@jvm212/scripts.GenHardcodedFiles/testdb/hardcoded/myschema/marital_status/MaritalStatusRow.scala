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
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class MaritalStatusRow(
  id: MaritalStatusId
)

object MaritalStatusRow {
  implicit val reads: Reads[MaritalStatusRow] = Reads[MaritalStatusRow](json => JsResult.fromTry(
      Try(
        MaritalStatusRow(
          id = json.\("id").as[MaritalStatusId]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[MaritalStatusRow] = RowParser[MaritalStatusRow] { row =>
    Success(
      MaritalStatusRow(
        id = row[MaritalStatusId](idx + 0)
      )
    )
  }
  implicit val writes: OWrites[MaritalStatusRow] = OWrites[MaritalStatusRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Json.toJson(o.id)
    ))
  )
}
