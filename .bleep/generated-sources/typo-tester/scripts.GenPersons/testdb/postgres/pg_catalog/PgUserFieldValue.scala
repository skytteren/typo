/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.time.ZonedDateTime

sealed abstract class PgUserFieldValue[T](val name: String, val value: T)

object PgUserFieldValue {
  case class usename(override val value: Option[String]) extends PgUserFieldValue("usename", value)
  case class usesysid(override val value: Option[Long]) extends PgUserFieldValue("usesysid", value)
  case class usecreatedb(override val value: Option[Boolean]) extends PgUserFieldValue("usecreatedb", value)
  case class usesuper(override val value: Option[Boolean]) extends PgUserFieldValue("usesuper", value)
  case class userepl(override val value: Option[Boolean]) extends PgUserFieldValue("userepl", value)
  case class usebypassrls(override val value: Option[Boolean]) extends PgUserFieldValue("usebypassrls", value)
  case class passwd(override val value: Option[String]) extends PgUserFieldValue("passwd", value)
  case class valuntil(override val value: Option[ZonedDateTime]) extends PgUserFieldValue("valuntil", value)
  case class useconfig(override val value: Option[Array[String]]) extends PgUserFieldValue("useconfig", value)
}