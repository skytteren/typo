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

case class PgTransformRow(
  oid: PgTransformId,
  trftype: Long,
  trflang: Long,
  trffromsql: PGobject,
  trftosql: PGobject
)

object PgTransformRow {
  def rowParser(prefix: String): RowParser[PgTransformRow] = { row =>
    Success(
      PgTransformRow(
        oid = row[PgTransformId](prefix + "oid"),
        trftype = row[Long](prefix + "trftype"),
        trflang = row[Long](prefix + "trflang"),
        trffromsql = row[PGobject](prefix + "trffromsql"),
        trftosql = row[PGobject](prefix + "trftosql")
      )
    )
  }

  implicit val oFormat: OFormat[PgTransformRow] = new OFormat[PgTransformRow]{
    override def writes(o: PgTransformRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "trftype" -> o.trftype,
      "trflang" -> o.trflang,
      "trffromsql" -> o.trffromsql,
      "trftosql" -> o.trftosql
      )

    override def reads(json: JsValue): JsResult[PgTransformRow] = {
      JsResult.fromTry(
        Try(
          PgTransformRow(
            oid = json.\("oid").as[PgTransformId],
            trftype = json.\("trftype").as[Long],
            trflang = json.\("trflang").as[Long],
            trffromsql = json.\("trffromsql").as[PGobject],
            trftosql = json.\("trftosql").as[PGobject]
          )
        )
      )
    }
  }
}