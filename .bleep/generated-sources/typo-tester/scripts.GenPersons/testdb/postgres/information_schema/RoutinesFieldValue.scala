/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import java.time.LocalDateTime

sealed abstract class RoutinesFieldValue[T](val name: String, val value: T)

object RoutinesFieldValue {
  case class specificCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("specific_catalog", value)
  case class specificSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("specific_schema", value)
  case class specificName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("specific_name", value)
  case class routineCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("routine_catalog", value)
  case class routineSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("routine_schema", value)
  case class routineName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("routine_name", value)
  case class routineType(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("routine_type", value)
  case class moduleCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("module_catalog", value)
  case class moduleSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("module_schema", value)
  case class moduleName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("module_name", value)
  case class udtCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("udt_catalog", value)
  case class udtSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("udt_schema", value)
  case class udtName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("udt_name", value)
  case class dataType(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("data_type", value)
  case class characterMaximumLength(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("character_maximum_length", value)
  case class characterOctetLength(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("character_octet_length", value)
  case class characterSetCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("character_set_catalog", value)
  case class characterSetSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("character_set_schema", value)
  case class characterSetName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("character_set_name", value)
  case class collationCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("collation_catalog", value)
  case class collationSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("collation_schema", value)
  case class collationName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("collation_name", value)
  case class numericPrecision(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("numeric_precision", value)
  case class numericPrecisionRadix(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("numeric_precision_radix", value)
  case class numericScale(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("numeric_scale", value)
  case class datetimePrecision(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("datetime_precision", value)
  case class intervalType(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("interval_type", value)
  case class intervalPrecision(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("interval_precision", value)
  case class typeUdtCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("type_udt_catalog", value)
  case class typeUdtSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("type_udt_schema", value)
  case class typeUdtName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("type_udt_name", value)
  case class scopeCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("scope_catalog", value)
  case class scopeSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("scope_schema", value)
  case class scopeName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("scope_name", value)
  case class maximumCardinality(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("maximum_cardinality", value)
  case class dtdIdentifier(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("dtd_identifier", value)
  case class routineBody(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("routine_body", value)
  case class routineDefinition(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("routine_definition", value)
  case class externalName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("external_name", value)
  case class externalLanguage(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("external_language", value)
  case class parameterStyle(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("parameter_style", value)
  case class isDeterministic(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("is_deterministic", value)
  case class sqlDataAccess(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("sql_data_access", value)
  case class isNullCall(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("is_null_call", value)
  case class sqlPath(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("sql_path", value)
  case class schemaLevelRoutine(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("schema_level_routine", value)
  case class maxDynamicResultSets(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("max_dynamic_result_sets", value)
  case class isUserDefinedCast(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("is_user_defined_cast", value)
  case class isImplicitlyInvocable(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("is_implicitly_invocable", value)
  case class securityType(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("security_type", value)
  case class toSqlSpecificCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("to_sql_specific_catalog", value)
  case class toSqlSpecificSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("to_sql_specific_schema", value)
  case class toSqlSpecificName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("to_sql_specific_name", value)
  case class asLocator(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("as_locator", value)
  case class created(override val value: /* unknown nullability */ Option[LocalDateTime]) extends RoutinesFieldValue("created", value)
  case class lastAltered(override val value: /* unknown nullability */ Option[LocalDateTime]) extends RoutinesFieldValue("last_altered", value)
  case class newSavepointLevel(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("new_savepoint_level", value)
  case class isUdtDependent(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("is_udt_dependent", value)
  case class resultCastFromDataType(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_from_data_type", value)
  case class resultCastAsLocator(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_as_locator", value)
  case class resultCastCharMaxLength(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("result_cast_char_max_length", value)
  case class resultCastCharOctetLength(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("result_cast_char_octet_length", value)
  case class resultCastCharSetCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_char_set_catalog", value)
  case class resultCastCharSetSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_char_set_schema", value)
  case class resultCastCharSetName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_char_set_name", value)
  case class resultCastCollationCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_collation_catalog", value)
  case class resultCastCollationSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_collation_schema", value)
  case class resultCastCollationName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_collation_name", value)
  case class resultCastNumericPrecision(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("result_cast_numeric_precision", value)
  case class resultCastNumericPrecisionRadix(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("result_cast_numeric_precision_radix", value)
  case class resultCastNumericScale(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("result_cast_numeric_scale", value)
  case class resultCastDatetimePrecision(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("result_cast_datetime_precision", value)
  case class resultCastIntervalType(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_interval_type", value)
  case class resultCastIntervalPrecision(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("result_cast_interval_precision", value)
  case class resultCastTypeUdtCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_type_udt_catalog", value)
  case class resultCastTypeUdtSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_type_udt_schema", value)
  case class resultCastTypeUdtName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_type_udt_name", value)
  case class resultCastScopeCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_scope_catalog", value)
  case class resultCastScopeSchema(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_scope_schema", value)
  case class resultCastScopeName(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_scope_name", value)
  case class resultCastMaximumCardinality(override val value: /* unknown nullability */ Option[Int]) extends RoutinesFieldValue("result_cast_maximum_cardinality", value)
  case class resultCastDtdIdentifier(override val value: /* unknown nullability */ Option[String]) extends RoutinesFieldValue("result_cast_dtd_identifier", value)
}
