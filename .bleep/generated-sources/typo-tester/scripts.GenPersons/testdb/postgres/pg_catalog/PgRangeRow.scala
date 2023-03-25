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

case class PgRangeRow(
  rngtypid: PgRangeId,
  rngsubtype: Long,
  rngmultitypid: Long,
  rngcollation: Long,
  rngsubopc: Long,
  rngcanonical: PGobject,
  rngsubdiff: PGobject
)

object PgRangeRow {
  def rowParser(prefix: String): RowParser[PgRangeRow] = { row =>
    Success(
      PgRangeRow(
        rngtypid = row[PgRangeId](prefix + "rngtypid"),
        rngsubtype = row[Long](prefix + "rngsubtype"),
        rngmultitypid = row[Long](prefix + "rngmultitypid"),
        rngcollation = row[Long](prefix + "rngcollation"),
        rngsubopc = row[Long](prefix + "rngsubopc"),
        rngcanonical = row[PGobject](prefix + "rngcanonical"),
        rngsubdiff = row[PGobject](prefix + "rngsubdiff")
      )
    )
  }

  implicit val oFormat: OFormat[PgRangeRow] = new OFormat[PgRangeRow]{
    override def writes(o: PgRangeRow): JsObject =
      Json.obj(
        "rngtypid" -> o.rngtypid,
      "rngsubtype" -> o.rngsubtype,
      "rngmultitypid" -> o.rngmultitypid,
      "rngcollation" -> o.rngcollation,
      "rngsubopc" -> o.rngsubopc,
      "rngcanonical" -> o.rngcanonical,
      "rngsubdiff" -> o.rngsubdiff
      )

    override def reads(json: JsValue): JsResult[PgRangeRow] = {
      JsResult.fromTry(
        Try(
          PgRangeRow(
            rngtypid = json.\("rngtypid").as[PgRangeId],
            rngsubtype = json.\("rngsubtype").as[Long],
            rngmultitypid = json.\("rngmultitypid").as[Long],
            rngcollation = json.\("rngcollation").as[Long],
            rngsubopc = json.\("rngsubopc").as[Long],
            rngcanonical = json.\("rngcanonical").as[PGobject],
            rngsubdiff = json.\("rngsubdiff").as[PGobject]
          )
        )
      )
    }
  }
}