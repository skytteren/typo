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
import scala.util.Try

case class PgStatDatabaseRow(
  datid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"datid","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  datname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"datname","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  numbackends: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"numbackends","ordinal_position":3,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  xactCommit: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"xact_commit","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  xactRollback: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"xact_rollback","ordinal_position":5,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  blksRead: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"blks_read","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  blksHit: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"blks_hit","ordinal_position":7,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tupReturned: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"tup_returned","ordinal_position":8,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tupFetched: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"tup_fetched","ordinal_position":9,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tupInserted: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"tup_inserted","ordinal_position":10,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tupUpdated: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"tup_updated","ordinal_position":11,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tupDeleted: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"tup_deleted","ordinal_position":12,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  conflicts: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"conflicts","ordinal_position":13,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tempFiles: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"temp_files","ordinal_position":14,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tempBytes: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"temp_bytes","ordinal_position":15,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  deadlocks: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"deadlocks","ordinal_position":16,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  checksumFailures: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"checksum_failures","ordinal_position":17,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  checksumLastFailure: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"checksum_last_failure","ordinal_position":18,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  blkReadTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"blk_read_time","ordinal_position":19,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  blkWriteTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"blk_write_time","ordinal_position":20,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  sessionTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"session_time","ordinal_position":21,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  activeTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"active_time","ordinal_position":22,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  idleInTransactionTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"idle_in_transaction_time","ordinal_position":23,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"23","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  sessions: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"sessions","ordinal_position":24,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"24","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  sessionsAbandoned: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"sessions_abandoned","ordinal_position":25,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"25","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  sessionsFatal: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"sessions_fatal","ordinal_position":26,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"26","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  sessionsKilled: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"sessions_killed","ordinal_position":27,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"27","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  statsReset: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database","column_name":"stats_reset","ordinal_position":28,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"28","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatDatabaseRow {
  implicit val rowParser: RowParser[PgStatDatabaseRow] = { row =>
    Success(
      PgStatDatabaseRow(
        datid = row[Option[Long]]("datid"),
        datname = row[Option[String]]("datname"),
        numbackends = row[Option[Int]]("numbackends"),
        xactCommit = row[Option[Long]]("xact_commit"),
        xactRollback = row[Option[Long]]("xact_rollback"),
        blksRead = row[Option[Long]]("blks_read"),
        blksHit = row[Option[Long]]("blks_hit"),
        tupReturned = row[Option[Long]]("tup_returned"),
        tupFetched = row[Option[Long]]("tup_fetched"),
        tupInserted = row[Option[Long]]("tup_inserted"),
        tupUpdated = row[Option[Long]]("tup_updated"),
        tupDeleted = row[Option[Long]]("tup_deleted"),
        conflicts = row[Option[Long]]("conflicts"),
        tempFiles = row[Option[Long]]("temp_files"),
        tempBytes = row[Option[Long]]("temp_bytes"),
        deadlocks = row[Option[Long]]("deadlocks"),
        checksumFailures = row[Option[Long]]("checksum_failures"),
        checksumLastFailure = row[Option[ZonedDateTime]]("checksum_last_failure"),
        blkReadTime = row[Option[Double]]("blk_read_time"),
        blkWriteTime = row[Option[Double]]("blk_write_time"),
        sessionTime = row[Option[Double]]("session_time"),
        activeTime = row[Option[Double]]("active_time"),
        idleInTransactionTime = row[Option[Double]]("idle_in_transaction_time"),
        sessions = row[Option[Long]]("sessions"),
        sessionsAbandoned = row[Option[Long]]("sessions_abandoned"),
        sessionsFatal = row[Option[Long]]("sessions_fatal"),
        sessionsKilled = row[Option[Long]]("sessions_killed"),
        statsReset = row[Option[ZonedDateTime]]("stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatDatabaseRow] = new OFormat[PgStatDatabaseRow]{
    override def writes(o: PgStatDatabaseRow): JsObject =
      Json.obj(
        "datid" -> o.datid,
      "datname" -> o.datname,
      "numbackends" -> o.numbackends,
      "xact_commit" -> o.xactCommit,
      "xact_rollback" -> o.xactRollback,
      "blks_read" -> o.blksRead,
      "blks_hit" -> o.blksHit,
      "tup_returned" -> o.tupReturned,
      "tup_fetched" -> o.tupFetched,
      "tup_inserted" -> o.tupInserted,
      "tup_updated" -> o.tupUpdated,
      "tup_deleted" -> o.tupDeleted,
      "conflicts" -> o.conflicts,
      "temp_files" -> o.tempFiles,
      "temp_bytes" -> o.tempBytes,
      "deadlocks" -> o.deadlocks,
      "checksum_failures" -> o.checksumFailures,
      "checksum_last_failure" -> o.checksumLastFailure,
      "blk_read_time" -> o.blkReadTime,
      "blk_write_time" -> o.blkWriteTime,
      "session_time" -> o.sessionTime,
      "active_time" -> o.activeTime,
      "idle_in_transaction_time" -> o.idleInTransactionTime,
      "sessions" -> o.sessions,
      "sessions_abandoned" -> o.sessionsAbandoned,
      "sessions_fatal" -> o.sessionsFatal,
      "sessions_killed" -> o.sessionsKilled,
      "stats_reset" -> o.statsReset
      )

    override def reads(json: JsValue): JsResult[PgStatDatabaseRow] = {
      JsResult.fromTry(
        Try(
          PgStatDatabaseRow(
            datid = json.\("datid").toOption.map(_.as[Long]),
            datname = json.\("datname").toOption.map(_.as[String]),
            numbackends = json.\("numbackends").toOption.map(_.as[Int]),
            xactCommit = json.\("xact_commit").toOption.map(_.as[Long]),
            xactRollback = json.\("xact_rollback").toOption.map(_.as[Long]),
            blksRead = json.\("blks_read").toOption.map(_.as[Long]),
            blksHit = json.\("blks_hit").toOption.map(_.as[Long]),
            tupReturned = json.\("tup_returned").toOption.map(_.as[Long]),
            tupFetched = json.\("tup_fetched").toOption.map(_.as[Long]),
            tupInserted = json.\("tup_inserted").toOption.map(_.as[Long]),
            tupUpdated = json.\("tup_updated").toOption.map(_.as[Long]),
            tupDeleted = json.\("tup_deleted").toOption.map(_.as[Long]),
            conflicts = json.\("conflicts").toOption.map(_.as[Long]),
            tempFiles = json.\("temp_files").toOption.map(_.as[Long]),
            tempBytes = json.\("temp_bytes").toOption.map(_.as[Long]),
            deadlocks = json.\("deadlocks").toOption.map(_.as[Long]),
            checksumFailures = json.\("checksum_failures").toOption.map(_.as[Long]),
            checksumLastFailure = json.\("checksum_last_failure").toOption.map(_.as[ZonedDateTime]),
            blkReadTime = json.\("blk_read_time").toOption.map(_.as[Double]),
            blkWriteTime = json.\("blk_write_time").toOption.map(_.as[Double]),
            sessionTime = json.\("session_time").toOption.map(_.as[Double]),
            activeTime = json.\("active_time").toOption.map(_.as[Double]),
            idleInTransactionTime = json.\("idle_in_transaction_time").toOption.map(_.as[Double]),
            sessions = json.\("sessions").toOption.map(_.as[Long]),
            sessionsAbandoned = json.\("sessions_abandoned").toOption.map(_.as[Long]),
            sessionsFatal = json.\("sessions_fatal").toOption.map(_.as[Long]),
            sessionsKilled = json.\("sessions_killed").toOption.map(_.as[Long]),
            statsReset = json.\("stats_reset").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}