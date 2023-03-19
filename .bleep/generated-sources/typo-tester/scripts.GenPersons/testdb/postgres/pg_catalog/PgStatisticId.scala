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

case class PgStatisticId(starelid: Long, staattnum: Short, stainherit: Boolean)
object PgStatisticId {
  implicit val ordering: Ordering[PgStatisticId] = Ordering.by(x => (x.starelid, x.staattnum, x.stainherit))
  implicit val oFormat: OFormat[PgStatisticId] = new OFormat[PgStatisticId]{
    override def writes(o: PgStatisticId): JsObject =
      Json.obj(
        "starelid" -> o.starelid,
      "staattnum" -> o.staattnum,
      "stainherit" -> o.stainherit
      )

    override def reads(json: JsValue): JsResult[PgStatisticId] = {
      JsResult.fromTry(
        Try(
          PgStatisticId(
            starelid = json.\("starelid").as[Long],
            staattnum = json.\("staattnum").as[Short],
            stainherit = json.\("stainherit").as[Boolean]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgStatisticId] = { row =>
    Success(
      PgStatisticId(
        starelid = row[Long]("starelid"),
        staattnum = row[Short]("staattnum"),
        stainherit = row[Boolean]("stainherit")
      )
    )
  }

}
