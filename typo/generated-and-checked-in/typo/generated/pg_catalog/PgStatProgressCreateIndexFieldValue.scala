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



sealed abstract class PgStatProgressCreateIndexFieldValue[T](val name: String, val value: T)

object PgStatProgressCreateIndexFieldValue {
  case class pid(override val value: Option[Int]) extends PgStatProgressCreateIndexFieldValue("pid", value)
  case class datid(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("datid", value)
  case class datname(override val value: Option[String]) extends PgStatProgressCreateIndexFieldValue("datname", value)
  case class relid(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("relid", value)
  case class indexRelid(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("index_relid", value)
  case class command(override val value: Option[String]) extends PgStatProgressCreateIndexFieldValue("command", value)
  case class phase(override val value: Option[String]) extends PgStatProgressCreateIndexFieldValue("phase", value)
  case class lockersTotal(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("lockers_total", value)
  case class lockersDone(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("lockers_done", value)
  case class currentLockerPid(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("current_locker_pid", value)
  case class blocksTotal(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("blocks_total", value)
  case class blocksDone(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("blocks_done", value)
  case class tuplesTotal(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("tuples_total", value)
  case class tuplesDone(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("tuples_done", value)
  case class partitionsTotal(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("partitions_total", value)
  case class partitionsDone(override val value: Option[Long]) extends PgStatProgressCreateIndexFieldValue("partitions_done", value)
}