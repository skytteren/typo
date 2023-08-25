/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication

import adventureworks.customtypes.TypoInet
import adventureworks.customtypes.TypoInterval
import adventureworks.customtypes.TypoOffsetDateTime
import adventureworks.customtypes.TypoXid
import typo.dsl.SqlExpr.OptField

trait PgStatReplicationViewFields[Row] {
  val pid: OptField[Int, Row]
  val usesysid: OptField[/* oid */ Long, Row]
  val usename: OptField[String, Row]
  val applicationName: OptField[String, Row]
  val clientAddr: OptField[TypoInet, Row]
  val clientHostname: OptField[String, Row]
  val clientPort: OptField[Int, Row]
  val backendStart: OptField[TypoOffsetDateTime, Row]
  val backendXmin: OptField[TypoXid, Row]
  val state: OptField[String, Row]
  val sentLsn: OptField[/* pg_lsn */ Long, Row]
  val writeLsn: OptField[/* pg_lsn */ Long, Row]
  val flushLsn: OptField[/* pg_lsn */ Long, Row]
  val replayLsn: OptField[/* pg_lsn */ Long, Row]
  val writeLag: OptField[TypoInterval, Row]
  val flushLag: OptField[TypoInterval, Row]
  val replayLag: OptField[TypoInterval, Row]
  val syncPriority: OptField[Int, Row]
  val syncState: OptField[String, Row]
  val replyTime: OptField[TypoOffsetDateTime, Row]
}
object PgStatReplicationViewFields extends PgStatReplicationViewStructure[PgStatReplicationViewRow](None, identity, (_, x) => x)
