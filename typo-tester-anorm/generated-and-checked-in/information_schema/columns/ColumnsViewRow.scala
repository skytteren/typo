/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package columns

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ColumnsViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  ordinalPosition: Option[CardinalNumber],
  columnDefault: Option[CharacterData],
  isNullable: Option[YesOrNo],
  dataType: Option[CharacterData],
  characterMaximumLength: Option[CardinalNumber],
  characterOctetLength: Option[CardinalNumber],
  numericPrecision: Option[CardinalNumber],
  numericPrecisionRadix: Option[CardinalNumber],
  numericScale: Option[CardinalNumber],
  datetimePrecision: Option[CardinalNumber],
  intervalType: Option[CharacterData],
  intervalPrecision: Option[CardinalNumber],
  characterSetCatalog: Option[SqlIdentifier],
  characterSetSchema: Option[SqlIdentifier],
  characterSetName: Option[SqlIdentifier],
  collationCatalog: Option[SqlIdentifier],
  collationSchema: Option[SqlIdentifier],
  collationName: Option[SqlIdentifier],
  domainCatalog: Option[SqlIdentifier],
  domainSchema: Option[SqlIdentifier],
  domainName: Option[SqlIdentifier],
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  scopeCatalog: Option[SqlIdentifier],
  scopeSchema: Option[SqlIdentifier],
  scopeName: Option[SqlIdentifier],
  maximumCardinality: Option[CardinalNumber],
  dtdIdentifier: Option[SqlIdentifier],
  isSelfReferencing: Option[YesOrNo],
  isIdentity: Option[YesOrNo],
  identityGeneration: Option[CharacterData],
  identityStart: Option[CharacterData],
  identityIncrement: Option[CharacterData],
  identityMaximum: Option[CharacterData],
  identityMinimum: Option[CharacterData],
  identityCycle: Option[YesOrNo],
  isGenerated: Option[CharacterData],
  generationExpression: Option[CharacterData],
  isUpdatable: Option[YesOrNo]
)

object ColumnsViewRow {
  def rowParser(idx: Int): RowParser[ColumnsViewRow] =
    RowParser[ColumnsViewRow] { row =>
      Success(
        ColumnsViewRow(
          tableCatalog = row[Option[SqlIdentifier]](idx + 0),
          tableSchema = row[Option[SqlIdentifier]](idx + 1),
          tableName = row[Option[SqlIdentifier]](idx + 2),
          columnName = row[Option[SqlIdentifier]](idx + 3),
          ordinalPosition = row[Option[CardinalNumber]](idx + 4),
          columnDefault = row[Option[CharacterData]](idx + 5),
          isNullable = row[Option[YesOrNo]](idx + 6),
          dataType = row[Option[CharacterData]](idx + 7),
          characterMaximumLength = row[Option[CardinalNumber]](idx + 8),
          characterOctetLength = row[Option[CardinalNumber]](idx + 9),
          numericPrecision = row[Option[CardinalNumber]](idx + 10),
          numericPrecisionRadix = row[Option[CardinalNumber]](idx + 11),
          numericScale = row[Option[CardinalNumber]](idx + 12),
          datetimePrecision = row[Option[CardinalNumber]](idx + 13),
          intervalType = row[Option[CharacterData]](idx + 14),
          intervalPrecision = row[Option[CardinalNumber]](idx + 15),
          characterSetCatalog = row[Option[SqlIdentifier]](idx + 16),
          characterSetSchema = row[Option[SqlIdentifier]](idx + 17),
          characterSetName = row[Option[SqlIdentifier]](idx + 18),
          collationCatalog = row[Option[SqlIdentifier]](idx + 19),
          collationSchema = row[Option[SqlIdentifier]](idx + 20),
          collationName = row[Option[SqlIdentifier]](idx + 21),
          domainCatalog = row[Option[SqlIdentifier]](idx + 22),
          domainSchema = row[Option[SqlIdentifier]](idx + 23),
          domainName = row[Option[SqlIdentifier]](idx + 24),
          udtCatalog = row[Option[SqlIdentifier]](idx + 25),
          udtSchema = row[Option[SqlIdentifier]](idx + 26),
          udtName = row[Option[SqlIdentifier]](idx + 27),
          scopeCatalog = row[Option[SqlIdentifier]](idx + 28),
          scopeSchema = row[Option[SqlIdentifier]](idx + 29),
          scopeName = row[Option[SqlIdentifier]](idx + 30),
          maximumCardinality = row[Option[CardinalNumber]](idx + 31),
          dtdIdentifier = row[Option[SqlIdentifier]](idx + 32),
          isSelfReferencing = row[Option[YesOrNo]](idx + 33),
          isIdentity = row[Option[YesOrNo]](idx + 34),
          identityGeneration = row[Option[CharacterData]](idx + 35),
          identityStart = row[Option[CharacterData]](idx + 36),
          identityIncrement = row[Option[CharacterData]](idx + 37),
          identityMaximum = row[Option[CharacterData]](idx + 38),
          identityMinimum = row[Option[CharacterData]](idx + 39),
          identityCycle = row[Option[YesOrNo]](idx + 40),
          isGenerated = row[Option[CharacterData]](idx + 41),
          generationExpression = row[Option[CharacterData]](idx + 42),
          isUpdatable = row[Option[YesOrNo]](idx + 43)
        )
      )
    }
  implicit val oFormat: OFormat[ColumnsViewRow] = new OFormat[ColumnsViewRow]{
    override def writes(o: ColumnsViewRow): JsObject =
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
  
    override def reads(json: JsValue): JsResult[ColumnsViewRow] = {
      JsResult.fromTry(
        Try(
          ColumnsViewRow(
            tableCatalog = json.\("table_catalog").toOption.map(_.as[SqlIdentifier]),
            tableSchema = json.\("table_schema").toOption.map(_.as[SqlIdentifier]),
            tableName = json.\("table_name").toOption.map(_.as[SqlIdentifier]),
            columnName = json.\("column_name").toOption.map(_.as[SqlIdentifier]),
            ordinalPosition = json.\("ordinal_position").toOption.map(_.as[CardinalNumber]),
            columnDefault = json.\("column_default").toOption.map(_.as[CharacterData]),
            isNullable = json.\("is_nullable").toOption.map(_.as[YesOrNo]),
            dataType = json.\("data_type").toOption.map(_.as[CharacterData]),
            characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[CardinalNumber]),
            characterOctetLength = json.\("character_octet_length").toOption.map(_.as[CardinalNumber]),
            numericPrecision = json.\("numeric_precision").toOption.map(_.as[CardinalNumber]),
            numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[CardinalNumber]),
            numericScale = json.\("numeric_scale").toOption.map(_.as[CardinalNumber]),
            datetimePrecision = json.\("datetime_precision").toOption.map(_.as[CardinalNumber]),
            intervalType = json.\("interval_type").toOption.map(_.as[CharacterData]),
            intervalPrecision = json.\("interval_precision").toOption.map(_.as[CardinalNumber]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[SqlIdentifier]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[SqlIdentifier]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[SqlIdentifier]),
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[SqlIdentifier]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[SqlIdentifier]),
            collationName = json.\("collation_name").toOption.map(_.as[SqlIdentifier]),
            domainCatalog = json.\("domain_catalog").toOption.map(_.as[SqlIdentifier]),
            domainSchema = json.\("domain_schema").toOption.map(_.as[SqlIdentifier]),
            domainName = json.\("domain_name").toOption.map(_.as[SqlIdentifier]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[SqlIdentifier]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[SqlIdentifier]),
            udtName = json.\("udt_name").toOption.map(_.as[SqlIdentifier]),
            scopeCatalog = json.\("scope_catalog").toOption.map(_.as[SqlIdentifier]),
            scopeSchema = json.\("scope_schema").toOption.map(_.as[SqlIdentifier]),
            scopeName = json.\("scope_name").toOption.map(_.as[SqlIdentifier]),
            maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[CardinalNumber]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[SqlIdentifier]),
            isSelfReferencing = json.\("is_self_referencing").toOption.map(_.as[YesOrNo]),
            isIdentity = json.\("is_identity").toOption.map(_.as[YesOrNo]),
            identityGeneration = json.\("identity_generation").toOption.map(_.as[CharacterData]),
            identityStart = json.\("identity_start").toOption.map(_.as[CharacterData]),
            identityIncrement = json.\("identity_increment").toOption.map(_.as[CharacterData]),
            identityMaximum = json.\("identity_maximum").toOption.map(_.as[CharacterData]),
            identityMinimum = json.\("identity_minimum").toOption.map(_.as[CharacterData]),
            identityCycle = json.\("identity_cycle").toOption.map(_.as[YesOrNo]),
            isGenerated = json.\("is_generated").toOption.map(_.as[CharacterData]),
            generationExpression = json.\("generation_expression").toOption.map(_.as[CharacterData]),
            isUpdatable = json.\("is_updatable").toOption.map(_.as[YesOrNo])
          )
        )
      )
    }
  }
}