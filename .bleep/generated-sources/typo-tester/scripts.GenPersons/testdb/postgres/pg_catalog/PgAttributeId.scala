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

case class PgAttributeId(attrelid: Long, attnum: Short)
object PgAttributeId {
  implicit val ordering: Ordering[PgAttributeId] = Ordering.by(x => (x.attrelid, x.attnum))
  implicit val oFormat: OFormat[PgAttributeId] = new OFormat[PgAttributeId]{
    override def writes(o: PgAttributeId): JsObject =
      Json.obj(
        "attrelid" -> o.attrelid,
      "attnum" -> o.attnum
      )

    override def reads(json: JsValue): JsResult[PgAttributeId] = {
      JsResult.fromTry(
        Try(
          PgAttributeId(
            attrelid = json.\("attrelid").as[Long],
            attnum = json.\("attnum").as[Short]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgAttributeId] = { row =>
    Success(
      PgAttributeId(
        attrelid = row[Long]("attrelid"),
        attnum = row[Short]("attnum")
      )
    )
  }

}
