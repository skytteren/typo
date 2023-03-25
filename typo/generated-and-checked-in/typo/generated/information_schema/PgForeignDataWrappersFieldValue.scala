/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema



sealed abstract class PgForeignDataWrappersFieldValue[T](val name: String, val value: T)

object PgForeignDataWrappersFieldValue {
  case class oid(override val value: Option[Long]) extends PgForeignDataWrappersFieldValue("oid", value)
  case class fdwowner(override val value: Option[Long]) extends PgForeignDataWrappersFieldValue("fdwowner", value)
  case class fdwoptions(override val value: Option[Array[String]]) extends PgForeignDataWrappersFieldValue("fdwoptions", value)
  case class foreignDataWrapperCatalog(override val value: Option[String]) extends PgForeignDataWrappersFieldValue("foreign_data_wrapper_catalog", value)
  case class foreignDataWrapperName(override val value: Option[String]) extends PgForeignDataWrappersFieldValue("foreign_data_wrapper_name", value)
  case class authorizationIdentifier(override val value: Option[String]) extends PgForeignDataWrappersFieldValue("authorization_identifier", value)
  case class foreignDataWrapperLanguage(override val value: Option[String]) extends PgForeignDataWrappersFieldValue("foreign_data_wrapper_language", value)
}