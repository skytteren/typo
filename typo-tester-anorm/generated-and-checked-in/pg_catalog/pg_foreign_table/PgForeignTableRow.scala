/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_table

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

case class PgForeignTableRow(
  ftrelid: PgForeignTableId,
  ftserver: /* oid */ Long,
  ftoptions: Option[Array[String]]
)

object PgForeignTableRow {
  implicit val reads: Reads[PgForeignTableRow] = Reads[PgForeignTableRow](json => JsResult.fromTry(
      Try(
        PgForeignTableRow(
          ftrelid = json.\("ftrelid").as[PgForeignTableId],
          ftserver = json.\("ftserver").as[/* oid */ Long],
          ftoptions = json.\("ftoptions").toOption.map(_.as[Array[String]])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgForeignTableRow] = RowParser[PgForeignTableRow] { row =>
    Success(
      PgForeignTableRow(
        ftrelid = row[PgForeignTableId](idx + 0),
        ftserver = row[/* oid */ Long](idx + 1),
        ftoptions = row[Option[Array[String]]](idx + 2)
      )
    )
  }
  implicit val writes: OWrites[PgForeignTableRow] = OWrites[PgForeignTableRow](o =>
    new JsObject(ListMap[String, JsValue](
      "ftrelid" -> Json.toJson(o.ftrelid),
      "ftserver" -> Json.toJson(o.ftserver),
      "ftoptions" -> Json.toJson(o.ftoptions)
    ))
  )
}
