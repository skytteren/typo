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



sealed abstract class PgSeclabelFieldValue[T](val name: String, val value: T)

object PgSeclabelFieldValue {
  case class objoid(override val value: Long) extends PgSeclabelFieldValue("objoid", value)
  case class classoid(override val value: Long) extends PgSeclabelFieldValue("classoid", value)
  case class objsubid(override val value: Int) extends PgSeclabelFieldValue("objsubid", value)
  case class provider(override val value: String) extends PgSeclabelFieldValue("provider", value)
  case class label(override val value: String) extends PgSeclabelFieldValue("label", value)
}