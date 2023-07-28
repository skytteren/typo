/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_backend_memory_contexts

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

case class PgBackendMemoryContextsViewRow(
  name: Option[String],
  ident: Option[String],
  parent: Option[String],
  level: Option[Int],
  totalBytes: Option[Long],
  totalNblocks: Option[Long],
  freeBytes: Option[Long],
  freeChunks: Option[Long],
  usedBytes: Option[Long]
)

object PgBackendMemoryContextsViewRow {
  implicit val reads: Reads[PgBackendMemoryContextsViewRow] = Reads[PgBackendMemoryContextsViewRow](json => JsResult.fromTry(
      Try(
        PgBackendMemoryContextsViewRow(
          name = json.\("name").toOption.map(_.as[String]),
          ident = json.\("ident").toOption.map(_.as[String]),
          parent = json.\("parent").toOption.map(_.as[String]),
          level = json.\("level").toOption.map(_.as[Int]),
          totalBytes = json.\("total_bytes").toOption.map(_.as[Long]),
          totalNblocks = json.\("total_nblocks").toOption.map(_.as[Long]),
          freeBytes = json.\("free_bytes").toOption.map(_.as[Long]),
          freeChunks = json.\("free_chunks").toOption.map(_.as[Long]),
          usedBytes = json.\("used_bytes").toOption.map(_.as[Long])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgBackendMemoryContextsViewRow] = RowParser[PgBackendMemoryContextsViewRow] { row =>
    Success(
      PgBackendMemoryContextsViewRow(
        name = row[Option[String]](idx + 0),
        ident = row[Option[String]](idx + 1),
        parent = row[Option[String]](idx + 2),
        level = row[Option[Int]](idx + 3),
        totalBytes = row[Option[Long]](idx + 4),
        totalNblocks = row[Option[Long]](idx + 5),
        freeBytes = row[Option[Long]](idx + 6),
        freeChunks = row[Option[Long]](idx + 7),
        usedBytes = row[Option[Long]](idx + 8)
      )
    )
  }
  implicit val writes: OWrites[PgBackendMemoryContextsViewRow] = OWrites[PgBackendMemoryContextsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Json.toJson(o.name),
      "ident" -> Json.toJson(o.ident),
      "parent" -> Json.toJson(o.parent),
      "level" -> Json.toJson(o.level),
      "total_bytes" -> Json.toJson(o.totalBytes),
      "total_nblocks" -> Json.toJson(o.totalNblocks),
      "free_bytes" -> Json.toJson(o.freeBytes),
      "free_chunks" -> Json.toJson(o.freeChunks),
      "used_bytes" -> Json.toJson(o.usedBytes)
    ))
  )
}
