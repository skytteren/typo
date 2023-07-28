/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_conversion

import adventureworks.TypoRegproc
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

case class PgConversionRow(
  oid: PgConversionId,
  conname: String,
  connamespace: /* oid */ Long,
  conowner: /* oid */ Long,
  conforencoding: Int,
  contoencoding: Int,
  conproc: TypoRegproc,
  condefault: Boolean
)

object PgConversionRow {
  implicit val reads: Reads[PgConversionRow] = Reads[PgConversionRow](json => JsResult.fromTry(
      Try(
        PgConversionRow(
          oid = json.\("oid").as[PgConversionId],
          conname = json.\("conname").as[String],
          connamespace = json.\("connamespace").as[/* oid */ Long],
          conowner = json.\("conowner").as[/* oid */ Long],
          conforencoding = json.\("conforencoding").as[Int],
          contoencoding = json.\("contoencoding").as[Int],
          conproc = json.\("conproc").as[TypoRegproc],
          condefault = json.\("condefault").as[Boolean]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgConversionRow] = RowParser[PgConversionRow] { row =>
    Success(
      PgConversionRow(
        oid = row[PgConversionId](idx + 0),
        conname = row[String](idx + 1),
        connamespace = row[/* oid */ Long](idx + 2),
        conowner = row[/* oid */ Long](idx + 3),
        conforencoding = row[Int](idx + 4),
        contoencoding = row[Int](idx + 5),
        conproc = row[TypoRegproc](idx + 6),
        condefault = row[Boolean](idx + 7)
      )
    )
  }
  implicit val writes: OWrites[PgConversionRow] = OWrites[PgConversionRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> Json.toJson(o.oid),
      "conname" -> Json.toJson(o.conname),
      "connamespace" -> Json.toJson(o.connamespace),
      "conowner" -> Json.toJson(o.conowner),
      "conforencoding" -> Json.toJson(o.conforencoding),
      "contoencoding" -> Json.toJson(o.contoencoding),
      "conproc" -> Json.toJson(o.conproc),
      "condefault" -> Json.toJson(o.condefault)
    ))
  )
}
