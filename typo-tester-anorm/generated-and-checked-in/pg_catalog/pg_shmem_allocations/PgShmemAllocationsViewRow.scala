/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shmem_allocations

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

case class PgShmemAllocationsViewRow(
  name: Option[String],
  off: Option[Long],
  size: Option[Long],
  allocatedSize: Option[Long]
)

object PgShmemAllocationsViewRow {
  implicit val reads: Reads[PgShmemAllocationsViewRow] = Reads[PgShmemAllocationsViewRow](json => JsResult.fromTry(
      Try(
        PgShmemAllocationsViewRow(
          name = json.\("name").toOption.map(_.as[String]),
          off = json.\("off").toOption.map(_.as[Long]),
          size = json.\("size").toOption.map(_.as[Long]),
          allocatedSize = json.\("allocated_size").toOption.map(_.as[Long])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgShmemAllocationsViewRow] = RowParser[PgShmemAllocationsViewRow] { row =>
    Success(
      PgShmemAllocationsViewRow(
        name = row[Option[String]](idx + 0),
        off = row[Option[Long]](idx + 1),
        size = row[Option[Long]](idx + 2),
        allocatedSize = row[Option[Long]](idx + 3)
      )
    )
  }
  implicit val writes: OWrites[PgShmemAllocationsViewRow] = OWrites[PgShmemAllocationsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Json.toJson(o.name),
      "off" -> Json.toJson(o.off),
      "size" -> Json.toJson(o.size),
      "allocated_size" -> Json.toJson(o.allocatedSize)
    ))
  )
}
