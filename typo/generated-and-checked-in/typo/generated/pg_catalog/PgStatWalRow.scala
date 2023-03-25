/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.ZonedDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.math.BigDecimal
import scala.util.Try

case class PgStatWalRow(
  walRecords: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"wal_records","ordinal_position":1,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  walFpi: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"wal_fpi","ordinal_position":2,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  walBytes: Option[BigDecimal] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"wal_bytes","ordinal_position":3,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  walBuffersFull: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"wal_buffers_full","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  walWrite: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"wal_write","ordinal_position":5,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  walSync: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"wal_sync","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  walWriteTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"wal_write_time","ordinal_position":7,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  walSyncTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"wal_sync_time","ordinal_position":8,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  statsReset: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_wal","column_name":"stats_reset","ordinal_position":9,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatWalRow {
  implicit val rowParser: RowParser[PgStatWalRow] = { row =>
    Success(
      PgStatWalRow(
        walRecords = row[Option[Long]]("wal_records"),
        walFpi = row[Option[Long]]("wal_fpi"),
        walBytes = row[Option[BigDecimal]]("wal_bytes"),
        walBuffersFull = row[Option[Long]]("wal_buffers_full"),
        walWrite = row[Option[Long]]("wal_write"),
        walSync = row[Option[Long]]("wal_sync"),
        walWriteTime = row[Option[Double]]("wal_write_time"),
        walSyncTime = row[Option[Double]]("wal_sync_time"),
        statsReset = row[Option[ZonedDateTime]]("stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatWalRow] = new OFormat[PgStatWalRow]{
    override def writes(o: PgStatWalRow): JsObject =
      Json.obj(
        "wal_records" -> o.walRecords,
      "wal_fpi" -> o.walFpi,
      "wal_bytes" -> o.walBytes,
      "wal_buffers_full" -> o.walBuffersFull,
      "wal_write" -> o.walWrite,
      "wal_sync" -> o.walSync,
      "wal_write_time" -> o.walWriteTime,
      "wal_sync_time" -> o.walSyncTime,
      "stats_reset" -> o.statsReset
      )

    override def reads(json: JsValue): JsResult[PgStatWalRow] = {
      JsResult.fromTry(
        Try(
          PgStatWalRow(
            walRecords = json.\("wal_records").toOption.map(_.as[Long]),
            walFpi = json.\("wal_fpi").toOption.map(_.as[Long]),
            walBytes = json.\("wal_bytes").toOption.map(_.as[BigDecimal]),
            walBuffersFull = json.\("wal_buffers_full").toOption.map(_.as[Long]),
            walWrite = json.\("wal_write").toOption.map(_.as[Long]),
            walSync = json.\("wal_sync").toOption.map(_.as[Long]),
            walWriteTime = json.\("wal_write_time").toOption.map(_.as[Double]),
            walSyncTime = json.\("wal_sync_time").toOption.map(_.as[Double]),
            statsReset = json.\("stats_reset").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}