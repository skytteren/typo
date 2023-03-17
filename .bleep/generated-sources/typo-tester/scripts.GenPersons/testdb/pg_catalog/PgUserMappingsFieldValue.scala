package testdb.pg_catalog



sealed abstract class PgUserMappingsFieldValue[T](val name: String, val value: T)

object PgUserMappingsFieldValue {
  case class umid(override val value: Long) extends PgUserMappingsFieldValue("umid", value)
  case class srvid(override val value: Long) extends PgUserMappingsFieldValue("srvid", value)
  case class srvname(override val value: String) extends PgUserMappingsFieldValue("srvname", value)
  case class umuser(override val value: Long) extends PgUserMappingsFieldValue("umuser", value)
  case class usename(override val value: /* unknown nullability */ Option[String]) extends PgUserMappingsFieldValue("usename", value)
  case class umoptions(override val value: /* unknown nullability */ Option[Array[String]]) extends PgUserMappingsFieldValue("umoptions", value)
}