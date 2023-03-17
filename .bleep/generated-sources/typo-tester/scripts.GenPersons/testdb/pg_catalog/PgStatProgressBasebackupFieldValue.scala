package testdb.pg_catalog



sealed abstract class PgStatProgressBasebackupFieldValue[T](val name: String, val value: T)

object PgStatProgressBasebackupFieldValue {
  case class pid(override val value: /* unknown nullability */ Option[Int]) extends PgStatProgressBasebackupFieldValue("pid", value)
  case class phase(override val value: /* unknown nullability */ Option[String]) extends PgStatProgressBasebackupFieldValue("phase", value)
  case class backupTotal(override val value: /* unknown nullability */ Option[Long]) extends PgStatProgressBasebackupFieldValue("backup_total", value)
  case class backupStreamed(override val value: /* unknown nullability */ Option[Long]) extends PgStatProgressBasebackupFieldValue("backup_streamed", value)
  case class tablespacesTotal(override val value: /* unknown nullability */ Option[Long]) extends PgStatProgressBasebackupFieldValue("tablespaces_total", value)
  case class tablespacesStreamed(override val value: /* unknown nullability */ Option[Long]) extends PgStatProgressBasebackupFieldValue("tablespaces_streamed", value)
}