package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgReplicationOriginStatusRow(
  localId: /* unknown nullability */ Option[Long],
  externalId: /* unknown nullability */ Option[String],
  remoteLsn: /* unknown nullability */ Option[/* pg_lsn */ String],
  localLsn: /* unknown nullability */ Option[/* pg_lsn */ String]
)

object PgReplicationOriginStatusRow {
  implicit val rowParser: RowParser[PgReplicationOriginStatusRow] = { row =>
    Success(
      PgReplicationOriginStatusRow(
        localId = row[/* unknown nullability */ Option[Long]]("local_id"),
        externalId = row[/* unknown nullability */ Option[String]]("external_id"),
        remoteLsn = row[/* unknown nullability */ Option[/* pg_lsn */ String]]("remote_lsn"),
        localLsn = row[/* unknown nullability */ Option[/* pg_lsn */ String]]("local_lsn")
      )
    )
  }

  implicit val oFormat: OFormat[PgReplicationOriginStatusRow] = Json.format
}