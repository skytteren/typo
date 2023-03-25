/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog



sealed abstract class PgTablesFieldValue[T](val name: String, val value: T)

object PgTablesFieldValue {
  case class schemaname(override val value: Option[String]) extends PgTablesFieldValue("schemaname", value)
  case class tablename(override val value: Option[String]) extends PgTablesFieldValue("tablename", value)
  case class tableowner(override val value: Option[String]) extends PgTablesFieldValue("tableowner", value)
  case class tablespace(override val value: Option[String]) extends PgTablesFieldValue("tablespace", value)
  case class hasindexes(override val value: Option[Boolean]) extends PgTablesFieldValue("hasindexes", value)
  case class hasrules(override val value: Option[Boolean]) extends PgTablesFieldValue("hasrules", value)
  case class hastriggers(override val value: Option[Boolean]) extends PgTablesFieldValue("hastriggers", value)
  case class rowsecurity(override val value: Option[Boolean]) extends PgTablesFieldValue("rowsecurity", value)
}