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

case class ColumnsRow(
  tableCatalog: Option[String],
  tableSchema: Option[String],
  tableName: Option[String],
  columnName: Option[String],
  ordinalPosition: Option[Int],
  columnDefault: Option[String],
  isNullable: Option[String],
  dataType: Option[String],
  characterMaximumLength: Option[Int],
  characterOctetLength: Option[Int],
  numericPrecision: Option[Int],
  numericPrecisionRadix: Option[Int],
  numericScale: Option[Int],
  datetimePrecision: Option[Int],
  intervalType: Option[String],
  intervalPrecision: Option[Int],
  characterSetCatalog: Option[String],
  characterSetSchema: Option[String],
  characterSetName: Option[String],
  collationCatalog: Option[String],
  collationSchema: Option[String],
  collationName: Option[String],
  domainCatalog: Option[String],
  domainSchema: Option[String],
  domainName: Option[String],
  udtCatalog: Option[String],
  udtSchema: Option[String],
  udtName: Option[String],
  scopeCatalog: Option[String],
  scopeSchema: Option[String],
  scopeName: Option[String],
  maximumCardinality: Option[Int],
  dtdIdentifier: Option[String],
  isSelfReferencing: Option[String],
  isIdentity: Option[String],
  identityGeneration: Option[String],
  identityStart: Option[String],
  identityIncrement: Option[String],
  identityMaximum: Option[String],
  identityMinimum: Option[String],
  identityCycle: Option[String],
  isGenerated: Option[String],
  generationExpression: Option[String],
  isUpdatable: Option[String]
)

object ColumnsRow {
  def rowParser(prefix: String): RowParser[ColumnsRow] = { row =>
    Success(
      ColumnsRow(
        tableCatalog = row[Option[String]](prefix + "table_catalog"),
        tableSchema = row[Option[String]](prefix + "table_schema"),
        tableName = row[Option[String]](prefix + "table_name"),
        columnName = row[Option[String]](prefix + "column_name"),
        ordinalPosition = row[Option[Int]](prefix + "ordinal_position"),
        columnDefault = row[Option[String]](prefix + "column_default"),
        isNullable = row[Option[String]](prefix + "is_nullable"),
        dataType = row[Option[String]](prefix + "data_type"),
        characterMaximumLength = row[Option[Int]](prefix + "character_maximum_length"),
        characterOctetLength = row[Option[Int]](prefix + "character_octet_length"),
        numericPrecision = row[Option[Int]](prefix + "numeric_precision"),
        numericPrecisionRadix = row[Option[Int]](prefix + "numeric_precision_radix"),
        numericScale = row[Option[Int]](prefix + "numeric_scale"),
        datetimePrecision = row[Option[Int]](prefix + "datetime_precision"),
        intervalType = row[Option[String]](prefix + "interval_type"),
        intervalPrecision = row[Option[Int]](prefix + "interval_precision"),
        characterSetCatalog = row[Option[String]](prefix + "character_set_catalog"),
        characterSetSchema = row[Option[String]](prefix + "character_set_schema"),
        characterSetName = row[Option[String]](prefix + "character_set_name"),
        collationCatalog = row[Option[String]](prefix + "collation_catalog"),
        collationSchema = row[Option[String]](prefix + "collation_schema"),
        collationName = row[Option[String]](prefix + "collation_name"),
        domainCatalog = row[Option[String]](prefix + "domain_catalog"),
        domainSchema = row[Option[String]](prefix + "domain_schema"),
        domainName = row[Option[String]](prefix + "domain_name"),
        udtCatalog = row[Option[String]](prefix + "udt_catalog"),
        udtSchema = row[Option[String]](prefix + "udt_schema"),
        udtName = row[Option[String]](prefix + "udt_name"),
        scopeCatalog = row[Option[String]](prefix + "scope_catalog"),
        scopeSchema = row[Option[String]](prefix + "scope_schema"),
        scopeName = row[Option[String]](prefix + "scope_name"),
        maximumCardinality = row[Option[Int]](prefix + "maximum_cardinality"),
        dtdIdentifier = row[Option[String]](prefix + "dtd_identifier"),
        isSelfReferencing = row[Option[String]](prefix + "is_self_referencing"),
        isIdentity = row[Option[String]](prefix + "is_identity"),
        identityGeneration = row[Option[String]](prefix + "identity_generation"),
        identityStart = row[Option[String]](prefix + "identity_start"),
        identityIncrement = row[Option[String]](prefix + "identity_increment"),
        identityMaximum = row[Option[String]](prefix + "identity_maximum"),
        identityMinimum = row[Option[String]](prefix + "identity_minimum"),
        identityCycle = row[Option[String]](prefix + "identity_cycle"),
        isGenerated = row[Option[String]](prefix + "is_generated"),
        generationExpression = row[Option[String]](prefix + "generation_expression"),
        isUpdatable = row[Option[String]](prefix + "is_updatable")
      )
    )
  }

  implicit val oFormat: OFormat[ColumnsRow] = new OFormat[ColumnsRow]{
    override def writes(o: ColumnsRow): JsObject =
      Json.obj(
        "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "column_name" -> o.columnName,
      "ordinal_position" -> o.ordinalPosition,
      "column_default" -> o.columnDefault,
      "is_nullable" -> o.isNullable,
      "data_type" -> o.dataType,
      "character_maximum_length" -> o.characterMaximumLength,
      "character_octet_length" -> o.characterOctetLength,
      "numeric_precision" -> o.numericPrecision,
      "numeric_precision_radix" -> o.numericPrecisionRadix,
      "numeric_scale" -> o.numericScale,
      "datetime_precision" -> o.datetimePrecision,
      "interval_type" -> o.intervalType,
      "interval_precision" -> o.intervalPrecision,
      "character_set_catalog" -> o.characterSetCatalog,
      "character_set_schema" -> o.characterSetSchema,
      "character_set_name" -> o.characterSetName,
      "collation_catalog" -> o.collationCatalog,
      "collation_schema" -> o.collationSchema,
      "collation_name" -> o.collationName,
      "domain_catalog" -> o.domainCatalog,
      "domain_schema" -> o.domainSchema,
      "domain_name" -> o.domainName,
      "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "scope_catalog" -> o.scopeCatalog,
      "scope_schema" -> o.scopeSchema,
      "scope_name" -> o.scopeName,
      "maximum_cardinality" -> o.maximumCardinality,
      "dtd_identifier" -> o.dtdIdentifier,
      "is_self_referencing" -> o.isSelfReferencing,
      "is_identity" -> o.isIdentity,
      "identity_generation" -> o.identityGeneration,
      "identity_start" -> o.identityStart,
      "identity_increment" -> o.identityIncrement,
      "identity_maximum" -> o.identityMaximum,
      "identity_minimum" -> o.identityMinimum,
      "identity_cycle" -> o.identityCycle,
      "is_generated" -> o.isGenerated,
      "generation_expression" -> o.generationExpression,
      "is_updatable" -> o.isUpdatable
      )

    override def reads(json: JsValue): JsResult[ColumnsRow] = {
      JsResult.fromTry(
        Try(
          ColumnsRow(
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            columnName = json.\("column_name").toOption.map(_.as[String]),
            ordinalPosition = json.\("ordinal_position").toOption.map(_.as[Int]),
            columnDefault = json.\("column_default").toOption.map(_.as[String]),
            isNullable = json.\("is_nullable").toOption.map(_.as[String]),
            dataType = json.\("data_type").toOption.map(_.as[String]),
            characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[Int]),
            characterOctetLength = json.\("character_octet_length").toOption.map(_.as[Int]),
            numericPrecision = json.\("numeric_precision").toOption.map(_.as[Int]),
            numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[Int]),
            numericScale = json.\("numeric_scale").toOption.map(_.as[Int]),
            datetimePrecision = json.\("datetime_precision").toOption.map(_.as[Int]),
            intervalType = json.\("interval_type").toOption.map(_.as[String]),
            intervalPrecision = json.\("interval_precision").toOption.map(_.as[Int]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[String]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[String]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[String]),
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[String]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[String]),
            collationName = json.\("collation_name").toOption.map(_.as[String]),
            domainCatalog = json.\("domain_catalog").toOption.map(_.as[String]),
            domainSchema = json.\("domain_schema").toOption.map(_.as[String]),
            domainName = json.\("domain_name").toOption.map(_.as[String]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            scopeCatalog = json.\("scope_catalog").toOption.map(_.as[String]),
            scopeSchema = json.\("scope_schema").toOption.map(_.as[String]),
            scopeName = json.\("scope_name").toOption.map(_.as[String]),
            maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[Int]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[String]),
            isSelfReferencing = json.\("is_self_referencing").toOption.map(_.as[String]),
            isIdentity = json.\("is_identity").toOption.map(_.as[String]),
            identityGeneration = json.\("identity_generation").toOption.map(_.as[String]),
            identityStart = json.\("identity_start").toOption.map(_.as[String]),
            identityIncrement = json.\("identity_increment").toOption.map(_.as[String]),
            identityMaximum = json.\("identity_maximum").toOption.map(_.as[String]),
            identityMinimum = json.\("identity_minimum").toOption.map(_.as[String]),
            identityCycle = json.\("identity_cycle").toOption.map(_.as[String]),
            isGenerated = json.\("is_generated").toOption.map(_.as[String]),
            generationExpression = json.\("generation_expression").toOption.map(_.as[String]),
            isUpdatable = json.\("is_updatable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}