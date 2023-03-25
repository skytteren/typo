/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.time.ZonedDateTime
import scala.math.BigDecimal

sealed abstract class PgStatWalFieldValue[T](val name: String, val value: T)

object PgStatWalFieldValue {
  case class walRecords(override val value: Option[Long]) extends PgStatWalFieldValue("wal_records", value)
  case class walFpi(override val value: Option[Long]) extends PgStatWalFieldValue("wal_fpi", value)
  case class walBytes(override val value: Option[BigDecimal]) extends PgStatWalFieldValue("wal_bytes", value)
  case class walBuffersFull(override val value: Option[Long]) extends PgStatWalFieldValue("wal_buffers_full", value)
  case class walWrite(override val value: Option[Long]) extends PgStatWalFieldValue("wal_write", value)
  case class walSync(override val value: Option[Long]) extends PgStatWalFieldValue("wal_sync", value)
  case class walWriteTime(override val value: Option[Double]) extends PgStatWalFieldValue("wal_write_time", value)
  case class walSyncTime(override val value: Option[Double]) extends PgStatWalFieldValue("wal_sync_time", value)
  case class statsReset(override val value: Option[ZonedDateTime]) extends PgStatWalFieldValue("stats_reset", value)
}