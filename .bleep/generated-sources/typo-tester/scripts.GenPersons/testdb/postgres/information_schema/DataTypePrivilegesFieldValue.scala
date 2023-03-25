/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema



sealed abstract class DataTypePrivilegesFieldValue[T](val name: String, val value: T)

object DataTypePrivilegesFieldValue {
  case class objectCatalog(override val value: Option[String]) extends DataTypePrivilegesFieldValue("object_catalog", value)
  case class objectSchema(override val value: Option[String]) extends DataTypePrivilegesFieldValue("object_schema", value)
  case class objectName(override val value: Option[String]) extends DataTypePrivilegesFieldValue("object_name", value)
  case class objectType(override val value: Option[String]) extends DataTypePrivilegesFieldValue("object_type", value)
  case class dtdIdentifier(override val value: Option[String]) extends DataTypePrivilegesFieldValue("dtd_identifier", value)
}