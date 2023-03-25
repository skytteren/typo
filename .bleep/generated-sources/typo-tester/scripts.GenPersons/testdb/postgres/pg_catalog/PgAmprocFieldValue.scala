/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import org.postgresql.util.PGobject

sealed abstract class PgAmprocFieldValue[T](val name: String, val value: T)

object PgAmprocFieldValue {
  case class oid(override val value: PgAmprocId) extends PgAmprocFieldValue("oid", value)
  case class amprocfamily(override val value: Long) extends PgAmprocFieldValue("amprocfamily", value)
  case class amproclefttype(override val value: Long) extends PgAmprocFieldValue("amproclefttype", value)
  case class amprocrighttype(override val value: Long) extends PgAmprocFieldValue("amprocrighttype", value)
  case class amprocnum(override val value: Int) extends PgAmprocFieldValue("amprocnum", value)
  case class amproc(override val value: PGobject) extends PgAmprocFieldValue("amproc", value)
}