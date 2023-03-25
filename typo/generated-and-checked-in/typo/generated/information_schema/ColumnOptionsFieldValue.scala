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



sealed abstract class ColumnOptionsFieldValue[T](val name: String, val value: T)

object ColumnOptionsFieldValue {
  case class tableCatalog(override val value: Option[String]) extends ColumnOptionsFieldValue("table_catalog", value)
  case class tableSchema(override val value: Option[String]) extends ColumnOptionsFieldValue("table_schema", value)
  case class tableName(override val value: Option[String]) extends ColumnOptionsFieldValue("table_name", value)
  case class columnName(override val value: Option[String]) extends ColumnOptionsFieldValue("column_name", value)
  case class optionName(override val value: Option[String]) extends ColumnOptionsFieldValue("option_name", value)
  case class optionValue(override val value: Option[String]) extends ColumnOptionsFieldValue("option_value", value)
}