/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ParametersRow(
  specificCatalog: Option[String],
  specificSchema: Option[String],
  specificName: Option[String],
  ordinalPosition: Option[Int],
  parameterMode: Option[String],
  isResult: Option[String],
  asLocator: Option[String],
  parameterName: Option[String],
  dataType: Option[String],
  characterMaximumLength: Option[Int],
  characterOctetLength: Option[Int],
  characterSetCatalog: Option[String],
  characterSetSchema: Option[String],
  characterSetName: Option[String],
  collationCatalog: Option[String],
  collationSchema: Option[String],
  collationName: Option[String],
  numericPrecision: Option[Int],
  numericPrecisionRadix: Option[Int],
  numericScale: Option[Int],
  datetimePrecision: Option[Int],
  intervalType: Option[String],
  intervalPrecision: Option[Int],
  udtCatalog: Option[String],
  udtSchema: Option[String],
  udtName: Option[String],
  scopeCatalog: Option[String],
  scopeSchema: Option[String],
  scopeName: Option[String],
  maximumCardinality: Option[Int],
  dtdIdentifier: Option[String],
  parameterDefault: Option[String]
)

object ParametersRow {
  def rowParser(prefix: String): RowParser[ParametersRow] = { row =>
    Success(
      ParametersRow(
        specificCatalog = row[Option[String]](prefix + "specific_catalog"),
        specificSchema = row[Option[String]](prefix + "specific_schema"),
        specificName = row[Option[String]](prefix + "specific_name"),
        ordinalPosition = row[Option[Int]](prefix + "ordinal_position"),
        parameterMode = row[Option[String]](prefix + "parameter_mode"),
        isResult = row[Option[String]](prefix + "is_result"),
        asLocator = row[Option[String]](prefix + "as_locator"),
        parameterName = row[Option[String]](prefix + "parameter_name"),
        dataType = row[Option[String]](prefix + "data_type"),
        characterMaximumLength = row[Option[Int]](prefix + "character_maximum_length"),
        characterOctetLength = row[Option[Int]](prefix + "character_octet_length"),
        characterSetCatalog = row[Option[String]](prefix + "character_set_catalog"),
        characterSetSchema = row[Option[String]](prefix + "character_set_schema"),
        characterSetName = row[Option[String]](prefix + "character_set_name"),
        collationCatalog = row[Option[String]](prefix + "collation_catalog"),
        collationSchema = row[Option[String]](prefix + "collation_schema"),
        collationName = row[Option[String]](prefix + "collation_name"),
        numericPrecision = row[Option[Int]](prefix + "numeric_precision"),
        numericPrecisionRadix = row[Option[Int]](prefix + "numeric_precision_radix"),
        numericScale = row[Option[Int]](prefix + "numeric_scale"),
        datetimePrecision = row[Option[Int]](prefix + "datetime_precision"),
        intervalType = row[Option[String]](prefix + "interval_type"),
        intervalPrecision = row[Option[Int]](prefix + "interval_precision"),
        udtCatalog = row[Option[String]](prefix + "udt_catalog"),
        udtSchema = row[Option[String]](prefix + "udt_schema"),
        udtName = row[Option[String]](prefix + "udt_name"),
        scopeCatalog = row[Option[String]](prefix + "scope_catalog"),
        scopeSchema = row[Option[String]](prefix + "scope_schema"),
        scopeName = row[Option[String]](prefix + "scope_name"),
        maximumCardinality = row[Option[Int]](prefix + "maximum_cardinality"),
        dtdIdentifier = row[Option[String]](prefix + "dtd_identifier"),
        parameterDefault = row[Option[String]](prefix + "parameter_default")
      )
    )
  }

  implicit val oFormat: OFormat[ParametersRow] = new OFormat[ParametersRow]{
    override def writes(o: ParametersRow): JsObject =
      Json.obj(
        "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName,
      "ordinal_position" -> o.ordinalPosition,
      "parameter_mode" -> o.parameterMode,
      "is_result" -> o.isResult,
      "as_locator" -> o.asLocator,
      "parameter_name" -> o.parameterName,
      "data_type" -> o.dataType,
      "character_maximum_length" -> o.characterMaximumLength,
      "character_octet_length" -> o.characterOctetLength,
      "character_set_catalog" -> o.characterSetCatalog,
      "character_set_schema" -> o.characterSetSchema,
      "character_set_name" -> o.characterSetName,
      "collation_catalog" -> o.collationCatalog,
      "collation_schema" -> o.collationSchema,
      "collation_name" -> o.collationName,
      "numeric_precision" -> o.numericPrecision,
      "numeric_precision_radix" -> o.numericPrecisionRadix,
      "numeric_scale" -> o.numericScale,
      "datetime_precision" -> o.datetimePrecision,
      "interval_type" -> o.intervalType,
      "interval_precision" -> o.intervalPrecision,
      "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "scope_catalog" -> o.scopeCatalog,
      "scope_schema" -> o.scopeSchema,
      "scope_name" -> o.scopeName,
      "maximum_cardinality" -> o.maximumCardinality,
      "dtd_identifier" -> o.dtdIdentifier,
      "parameter_default" -> o.parameterDefault
      )

    override def reads(json: JsValue): JsResult[ParametersRow] = {
      JsResult.fromTry(
        Try(
          ParametersRow(
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String]),
            ordinalPosition = json.\("ordinal_position").toOption.map(_.as[Int]),
            parameterMode = json.\("parameter_mode").toOption.map(_.as[String]),
            isResult = json.\("is_result").toOption.map(_.as[String]),
            asLocator = json.\("as_locator").toOption.map(_.as[String]),
            parameterName = json.\("parameter_name").toOption.map(_.as[String]),
            dataType = json.\("data_type").toOption.map(_.as[String]),
            characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[Int]),
            characterOctetLength = json.\("character_octet_length").toOption.map(_.as[Int]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[String]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[String]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[String]),
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[String]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[String]),
            collationName = json.\("collation_name").toOption.map(_.as[String]),
            numericPrecision = json.\("numeric_precision").toOption.map(_.as[Int]),
            numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[Int]),
            numericScale = json.\("numeric_scale").toOption.map(_.as[Int]),
            datetimePrecision = json.\("datetime_precision").toOption.map(_.as[Int]),
            intervalType = json.\("interval_type").toOption.map(_.as[String]),
            intervalPrecision = json.\("interval_precision").toOption.map(_.as[Int]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            scopeCatalog = json.\("scope_catalog").toOption.map(_.as[String]),
            scopeSchema = json.\("scope_schema").toOption.map(_.as[String]),
            scopeName = json.\("scope_name").toOption.map(_.as[String]),
            maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[Int]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[String]),
            parameterDefault = json.\("parameter_default").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}