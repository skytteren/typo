/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_sequences

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

case class PgStatioSysSequencesViewRow(
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.relid]] */
  relid: Option[/* oid */ Long],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.blksRead]] */
  blksRead: Option[Long],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.blksHit]] */
  blksHit: Option[Long]
)

object PgStatioSysSequencesViewRow {
  implicit val reads: Reads[PgStatioSysSequencesViewRow] = Reads[PgStatioSysSequencesViewRow](json => JsResult.fromTry(
      Try(
        PgStatioSysSequencesViewRow(
          relid = json.\("relid").toOption.map(_.as[/* oid */ Long]),
          schemaname = json.\("schemaname").toOption.map(_.as[String]),
          relname = json.\("relname").toOption.map(_.as[String]),
          blksRead = json.\("blks_read").toOption.map(_.as[Long]),
          blksHit = json.\("blks_hit").toOption.map(_.as[Long])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatioSysSequencesViewRow] = RowParser[PgStatioSysSequencesViewRow] { row =>
    Success(
      PgStatioSysSequencesViewRow(
        relid = row[Option[/* oid */ Long]](idx + 0),
        schemaname = row[Option[String]](idx + 1),
        relname = row[Option[String]](idx + 2),
        blksRead = row[Option[Long]](idx + 3),
        blksHit = row[Option[Long]](idx + 4)
      )
    )
  }
  implicit val writes: OWrites[PgStatioSysSequencesViewRow] = OWrites[PgStatioSysSequencesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "relid" -> Json.toJson(o.relid),
      "schemaname" -> Json.toJson(o.schemaname),
      "relname" -> Json.toJson(o.relname),
      "blks_read" -> Json.toJson(o.blksRead),
      "blks_hit" -> Json.toJson(o.blksHit)
    ))
  )
}
