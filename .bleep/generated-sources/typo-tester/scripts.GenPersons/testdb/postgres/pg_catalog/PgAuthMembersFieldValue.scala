/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog



sealed abstract class PgAuthMembersFieldValue[T](val name: String, val value: T)

object PgAuthMembersFieldValue {
  case class roleid(override val value: Long) extends PgAuthMembersFieldValue("roleid", value)
  case class member(override val value: Long) extends PgAuthMembersFieldValue("member", value)
  case class grantor(override val value: Long) extends PgAuthMembersFieldValue("grantor", value)
  case class adminOption(override val value: Boolean) extends PgAuthMembersFieldValue("admin_option", value)
}
