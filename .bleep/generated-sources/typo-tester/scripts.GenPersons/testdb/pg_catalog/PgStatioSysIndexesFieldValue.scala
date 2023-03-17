package testdb.pg_catalog



sealed abstract class PgStatioSysIndexesFieldValue[T](val name: String, val value: T)

object PgStatioSysIndexesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatioSysIndexesFieldValue("relid", value)
  case class indexrelid(override val value: Option[Long]) extends PgStatioSysIndexesFieldValue("indexrelid", value)
  case class schemaname(override val value: Option[String]) extends PgStatioSysIndexesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatioSysIndexesFieldValue("relname", value)
  case class indexrelname(override val value: Option[String]) extends PgStatioSysIndexesFieldValue("indexrelname", value)
  case class idxBlksRead(override val value: Option[Long]) extends PgStatioSysIndexesFieldValue("idx_blks_read", value)
  case class idxBlksHit(override val value: Option[Long]) extends PgStatioSysIndexesFieldValue("idx_blks_hit", value)
}