package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgStatioSysSequencesRow(
  /** Points to [[testdb.pg_catalog.PgStatioAllSequencesRow.relid]] */
  relid: Option[Long],
  /** Points to [[testdb.pg_catalog.PgStatioAllSequencesRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[testdb.pg_catalog.PgStatioAllSequencesRow.relname]] */
  relname: Option[String],
  /** Points to [[testdb.pg_catalog.PgStatioAllSequencesRow.blksRead]] */
  blksRead: Option[Long],
  /** Points to [[testdb.pg_catalog.PgStatioAllSequencesRow.blksHit]] */
  blksHit: Option[Long]
)

object PgStatioSysSequencesRow {
  implicit val rowParser: RowParser[PgStatioSysSequencesRow] = { row =>
    Success(
      PgStatioSysSequencesRow(
        relid = row[Option[Long]]("relid"),
        schemaname = row[Option[String]]("schemaname"),
        relname = row[Option[String]]("relname"),
        blksRead = row[Option[Long]]("blks_read"),
        blksHit = row[Option[Long]]("blks_hit")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatioSysSequencesRow] = Json.format
}