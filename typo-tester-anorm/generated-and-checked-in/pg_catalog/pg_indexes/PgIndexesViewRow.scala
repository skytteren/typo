/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_indexes

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

case class PgIndexesViewRow(
  schemaname: Option[String],
  tablename: Option[String],
  indexname: Option[String],
  tablespace: Option[String],
  indexdef: Option[String]
)

object PgIndexesViewRow {
  implicit val reads: Reads[PgIndexesViewRow] = Reads[PgIndexesViewRow](json => JsResult.fromTry(
      Try(
        PgIndexesViewRow(
          schemaname = json.\("schemaname").toOption.map(_.as[String]),
          tablename = json.\("tablename").toOption.map(_.as[String]),
          indexname = json.\("indexname").toOption.map(_.as[String]),
          tablespace = json.\("tablespace").toOption.map(_.as[String]),
          indexdef = json.\("indexdef").toOption.map(_.as[String])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgIndexesViewRow] = RowParser[PgIndexesViewRow] { row =>
    Success(
      PgIndexesViewRow(
        schemaname = row[Option[String]](idx + 0),
        tablename = row[Option[String]](idx + 1),
        indexname = row[Option[String]](idx + 2),
        tablespace = row[Option[String]](idx + 3),
        indexdef = row[Option[String]](idx + 4)
      )
    )
  }
  implicit val writes: OWrites[PgIndexesViewRow] = OWrites[PgIndexesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schemaname" -> Json.toJson(o.schemaname),
      "tablename" -> Json.toJson(o.tablename),
      "indexname" -> Json.toJson(o.indexname),
      "tablespace" -> Json.toJson(o.tablespace),
      "indexdef" -> Json.toJson(o.indexdef)
    ))
  )
}
