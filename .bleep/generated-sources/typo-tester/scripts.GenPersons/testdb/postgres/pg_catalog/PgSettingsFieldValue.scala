/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog



sealed abstract class PgSettingsFieldValue[T](val name: String, val value: T)

object PgSettingsFieldValue {
  case class name(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("name", value)
  case class setting(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("setting", value)
  case class unit(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("unit", value)
  case class category(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("category", value)
  case class shortDesc(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("short_desc", value)
  case class extraDesc(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("extra_desc", value)
  case class context(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("context", value)
  case class vartype(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("vartype", value)
  case class source(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("source", value)
  case class minVal(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("min_val", value)
  case class maxVal(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("max_val", value)
  case class enumvals(override val value: /* unknown nullability */ Option[Array[String]]) extends PgSettingsFieldValue("enumvals", value)
  case class bootVal(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("boot_val", value)
  case class resetVal(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("reset_val", value)
  case class sourcefile(override val value: /* unknown nullability */ Option[String]) extends PgSettingsFieldValue("sourcefile", value)
  case class sourceline(override val value: /* unknown nullability */ Option[Int]) extends PgSettingsFieldValue("sourceline", value)
  case class pendingRestart(override val value: /* unknown nullability */ Option[Boolean]) extends PgSettingsFieldValue("pending_restart", value)
}
