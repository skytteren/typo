/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_extension

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

case class PgExtensionRow(
  oid: PgExtensionId,
  extname: String,
  extowner: /* oid */ Long,
  extnamespace: /* oid */ Long,
  extrelocatable: Boolean,
  extversion: String,
  extconfig: Option[Array[/* oid */ Long]],
  extcondition: Option[Array[String]]
)

object PgExtensionRow {
  implicit val reads: Reads[PgExtensionRow] = Reads[PgExtensionRow](json => JsResult.fromTry(
      Try(
        PgExtensionRow(
          oid = json.\("oid").as[PgExtensionId],
          extname = json.\("extname").as[String],
          extowner = json.\("extowner").as[/* oid */ Long],
          extnamespace = json.\("extnamespace").as[/* oid */ Long],
          extrelocatable = json.\("extrelocatable").as[Boolean],
          extversion = json.\("extversion").as[String],
          extconfig = json.\("extconfig").toOption.map(_.as[Array[/* oid */ Long]]),
          extcondition = json.\("extcondition").toOption.map(_.as[Array[String]])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgExtensionRow] = RowParser[PgExtensionRow] { row =>
    Success(
      PgExtensionRow(
        oid = row[PgExtensionId](idx + 0),
        extname = row[String](idx + 1),
        extowner = row[/* oid */ Long](idx + 2),
        extnamespace = row[/* oid */ Long](idx + 3),
        extrelocatable = row[Boolean](idx + 4),
        extversion = row[String](idx + 5),
        extconfig = row[Option[Array[/* oid */ Long]]](idx + 6),
        extcondition = row[Option[Array[String]]](idx + 7)
      )
    )
  }
  implicit val writes: OWrites[PgExtensionRow] = OWrites[PgExtensionRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> Json.toJson(o.oid),
      "extname" -> Json.toJson(o.extname),
      "extowner" -> Json.toJson(o.extowner),
      "extnamespace" -> Json.toJson(o.extnamespace),
      "extrelocatable" -> Json.toJson(o.extrelocatable),
      "extversion" -> Json.toJson(o.extversion),
      "extconfig" -> Json.toJson(o.extconfig),
      "extcondition" -> Json.toJson(o.extcondition)
    ))
  )
}
