/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema



sealed abstract class CheckConstraintsFieldValue[T](val name: String, val value: T)

object CheckConstraintsFieldValue {
  case class constraintCatalog(override val value: /* unknown nullability */ Option[String]) extends CheckConstraintsFieldValue("constraint_catalog", value)
  case class constraintSchema(override val value: /* unknown nullability */ Option[String]) extends CheckConstraintsFieldValue("constraint_schema", value)
  case class constraintName(override val value: /* unknown nullability */ Option[String]) extends CheckConstraintsFieldValue("constraint_name", value)
  case class checkClause(override val value: /* unknown nullability */ Option[String]) extends CheckConstraintsFieldValue("check_clause", value)
}
