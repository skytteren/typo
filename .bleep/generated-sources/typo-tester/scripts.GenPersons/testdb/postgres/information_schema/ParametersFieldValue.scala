/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema



sealed abstract class ParametersFieldValue[T](val name: String, val value: T)

object ParametersFieldValue {
  case class specificCatalog(override val value: Option[String]) extends ParametersFieldValue("specific_catalog", value)
  case class specificSchema(override val value: Option[String]) extends ParametersFieldValue("specific_schema", value)
  case class specificName(override val value: Option[String]) extends ParametersFieldValue("specific_name", value)
  case class ordinalPosition(override val value: Option[Int]) extends ParametersFieldValue("ordinal_position", value)
  case class parameterMode(override val value: Option[String]) extends ParametersFieldValue("parameter_mode", value)
  case class isResult(override val value: Option[String]) extends ParametersFieldValue("is_result", value)
  case class asLocator(override val value: Option[String]) extends ParametersFieldValue("as_locator", value)
  case class parameterName(override val value: Option[String]) extends ParametersFieldValue("parameter_name", value)
  case class dataType(override val value: Option[String]) extends ParametersFieldValue("data_type", value)
  case class characterMaximumLength(override val value: Option[Int]) extends ParametersFieldValue("character_maximum_length", value)
  case class characterOctetLength(override val value: Option[Int]) extends ParametersFieldValue("character_octet_length", value)
  case class characterSetCatalog(override val value: Option[String]) extends ParametersFieldValue("character_set_catalog", value)
  case class characterSetSchema(override val value: Option[String]) extends ParametersFieldValue("character_set_schema", value)
  case class characterSetName(override val value: Option[String]) extends ParametersFieldValue("character_set_name", value)
  case class collationCatalog(override val value: Option[String]) extends ParametersFieldValue("collation_catalog", value)
  case class collationSchema(override val value: Option[String]) extends ParametersFieldValue("collation_schema", value)
  case class collationName(override val value: Option[String]) extends ParametersFieldValue("collation_name", value)
  case class numericPrecision(override val value: Option[Int]) extends ParametersFieldValue("numeric_precision", value)
  case class numericPrecisionRadix(override val value: Option[Int]) extends ParametersFieldValue("numeric_precision_radix", value)
  case class numericScale(override val value: Option[Int]) extends ParametersFieldValue("numeric_scale", value)
  case class datetimePrecision(override val value: Option[Int]) extends ParametersFieldValue("datetime_precision", value)
  case class intervalType(override val value: Option[String]) extends ParametersFieldValue("interval_type", value)
  case class intervalPrecision(override val value: Option[Int]) extends ParametersFieldValue("interval_precision", value)
  case class udtCatalog(override val value: Option[String]) extends ParametersFieldValue("udt_catalog", value)
  case class udtSchema(override val value: Option[String]) extends ParametersFieldValue("udt_schema", value)
  case class udtName(override val value: Option[String]) extends ParametersFieldValue("udt_name", value)
  case class scopeCatalog(override val value: Option[String]) extends ParametersFieldValue("scope_catalog", value)
  case class scopeSchema(override val value: Option[String]) extends ParametersFieldValue("scope_schema", value)
  case class scopeName(override val value: Option[String]) extends ParametersFieldValue("scope_name", value)
  case class maximumCardinality(override val value: Option[Int]) extends ParametersFieldValue("maximum_cardinality", value)
  case class dtdIdentifier(override val value: Option[String]) extends ParametersFieldValue("dtd_identifier", value)
  case class parameterDefault(override val value: Option[String]) extends ParametersFieldValue("parameter_default", value)
}