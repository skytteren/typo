/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog



sealed abstract class PgHbaFileRulesFieldValue[T](val name: String, val value: T)

object PgHbaFileRulesFieldValue {
  case class lineNumber(override val value: Option[Int]) extends PgHbaFileRulesFieldValue("line_number", value)
  case class `type`(override val value: Option[String]) extends PgHbaFileRulesFieldValue("type", value)
  case class database(override val value: Option[Array[String]]) extends PgHbaFileRulesFieldValue("database", value)
  case class userName(override val value: Option[Array[String]]) extends PgHbaFileRulesFieldValue("user_name", value)
  case class address(override val value: Option[String]) extends PgHbaFileRulesFieldValue("address", value)
  case class netmask(override val value: Option[String]) extends PgHbaFileRulesFieldValue("netmask", value)
  case class authMethod(override val value: Option[String]) extends PgHbaFileRulesFieldValue("auth_method", value)
  case class options(override val value: Option[Array[String]]) extends PgHbaFileRulesFieldValue("options", value)
  case class error(override val value: Option[String]) extends PgHbaFileRulesFieldValue("error", value)
}