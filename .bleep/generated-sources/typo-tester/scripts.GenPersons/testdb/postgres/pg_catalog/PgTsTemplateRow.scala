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

case class PgTsTemplateRow(
  oid: PgTsTemplateId,
  tmplname: String,
  tmplnamespace: Long,
  tmplinit: PGobject,
  tmpllexize: PGobject
)

object PgTsTemplateRow {
  def rowParser(prefix: String): RowParser[PgTsTemplateRow] = { row =>
    Success(
      PgTsTemplateRow(
        oid = row[PgTsTemplateId](prefix + "oid"),
        tmplname = row[String](prefix + "tmplname"),
        tmplnamespace = row[Long](prefix + "tmplnamespace"),
        tmplinit = row[PGobject](prefix + "tmplinit"),
        tmpllexize = row[PGobject](prefix + "tmpllexize")
      )
    )
  }

  implicit val oFormat: OFormat[PgTsTemplateRow] = new OFormat[PgTsTemplateRow]{
    override def writes(o: PgTsTemplateRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "tmplname" -> o.tmplname,
      "tmplnamespace" -> o.tmplnamespace,
      "tmplinit" -> o.tmplinit,
      "tmpllexize" -> o.tmpllexize
      )

    override def reads(json: JsValue): JsResult[PgTsTemplateRow] = {
      JsResult.fromTry(
        Try(
          PgTsTemplateRow(
            oid = json.\("oid").as[PgTsTemplateId],
            tmplname = json.\("tmplname").as[String],
            tmplnamespace = json.\("tmplnamespace").as[Long],
            tmplinit = json.\("tmplinit").as[PGobject],
            tmpllexize = json.\("tmpllexize").as[PGobject]
          )
        )
      )
    }
  }
}