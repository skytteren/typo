/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package attributes

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
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class AttributesViewRow(
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  attributeName: Option[SqlIdentifier],
  ordinalPosition: Option[CardinalNumber],
  attributeDefault: Option[CharacterData],
  isNullable: Option[YesOrNo],
  dataType: Option[CharacterData],
  characterMaximumLength: Option[CardinalNumber],
  characterOctetLength: Option[CardinalNumber],
  characterSetCatalog: Option[SqlIdentifier],
  characterSetSchema: Option[SqlIdentifier],
  characterSetName: Option[SqlIdentifier],
  collationCatalog: Option[SqlIdentifier],
  collationSchema: Option[SqlIdentifier],
  collationName: Option[SqlIdentifier],
  numericPrecision: Option[CardinalNumber],
  numericPrecisionRadix: Option[CardinalNumber],
  numericScale: Option[CardinalNumber],
  datetimePrecision: Option[CardinalNumber],
  intervalType: Option[CharacterData],
  intervalPrecision: Option[CardinalNumber],
  attributeUdtCatalog: Option[SqlIdentifier],
  attributeUdtSchema: Option[SqlIdentifier],
  attributeUdtName: Option[SqlIdentifier],
  scopeCatalog: Option[SqlIdentifier],
  scopeSchema: Option[SqlIdentifier],
  scopeName: Option[SqlIdentifier],
  maximumCardinality: Option[CardinalNumber],
  dtdIdentifier: Option[SqlIdentifier],
  isDerivedReferenceAttribute: Option[YesOrNo]
)

object AttributesViewRow {
  implicit val reads: Reads[AttributesViewRow] = Reads[AttributesViewRow](json => JsResult.fromTry(
      Try(
        AttributesViewRow(
          udtCatalog = json.\("udt_catalog").toOption.map(_.as[SqlIdentifier]),
          udtSchema = json.\("udt_schema").toOption.map(_.as[SqlIdentifier]),
          udtName = json.\("udt_name").toOption.map(_.as[SqlIdentifier]),
          attributeName = json.\("attribute_name").toOption.map(_.as[SqlIdentifier]),
          ordinalPosition = json.\("ordinal_position").toOption.map(_.as[CardinalNumber]),
          attributeDefault = json.\("attribute_default").toOption.map(_.as[CharacterData]),
          isNullable = json.\("is_nullable").toOption.map(_.as[YesOrNo]),
          dataType = json.\("data_type").toOption.map(_.as[CharacterData]),
          characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[CardinalNumber]),
          characterOctetLength = json.\("character_octet_length").toOption.map(_.as[CardinalNumber]),
          characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[SqlIdentifier]),
          characterSetSchema = json.\("character_set_schema").toOption.map(_.as[SqlIdentifier]),
          characterSetName = json.\("character_set_name").toOption.map(_.as[SqlIdentifier]),
          collationCatalog = json.\("collation_catalog").toOption.map(_.as[SqlIdentifier]),
          collationSchema = json.\("collation_schema").toOption.map(_.as[SqlIdentifier]),
          collationName = json.\("collation_name").toOption.map(_.as[SqlIdentifier]),
          numericPrecision = json.\("numeric_precision").toOption.map(_.as[CardinalNumber]),
          numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[CardinalNumber]),
          numericScale = json.\("numeric_scale").toOption.map(_.as[CardinalNumber]),
          datetimePrecision = json.\("datetime_precision").toOption.map(_.as[CardinalNumber]),
          intervalType = json.\("interval_type").toOption.map(_.as[CharacterData]),
          intervalPrecision = json.\("interval_precision").toOption.map(_.as[CardinalNumber]),
          attributeUdtCatalog = json.\("attribute_udt_catalog").toOption.map(_.as[SqlIdentifier]),
          attributeUdtSchema = json.\("attribute_udt_schema").toOption.map(_.as[SqlIdentifier]),
          attributeUdtName = json.\("attribute_udt_name").toOption.map(_.as[SqlIdentifier]),
          scopeCatalog = json.\("scope_catalog").toOption.map(_.as[SqlIdentifier]),
          scopeSchema = json.\("scope_schema").toOption.map(_.as[SqlIdentifier]),
          scopeName = json.\("scope_name").toOption.map(_.as[SqlIdentifier]),
          maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[CardinalNumber]),
          dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[SqlIdentifier]),
          isDerivedReferenceAttribute = json.\("is_derived_reference_attribute").toOption.map(_.as[YesOrNo])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[AttributesViewRow] = RowParser[AttributesViewRow] { row =>
    Success(
      AttributesViewRow(
        udtCatalog = row[Option[SqlIdentifier]](idx + 0),
        udtSchema = row[Option[SqlIdentifier]](idx + 1),
        udtName = row[Option[SqlIdentifier]](idx + 2),
        attributeName = row[Option[SqlIdentifier]](idx + 3),
        ordinalPosition = row[Option[CardinalNumber]](idx + 4),
        attributeDefault = row[Option[CharacterData]](idx + 5),
        isNullable = row[Option[YesOrNo]](idx + 6),
        dataType = row[Option[CharacterData]](idx + 7),
        characterMaximumLength = row[Option[CardinalNumber]](idx + 8),
        characterOctetLength = row[Option[CardinalNumber]](idx + 9),
        characterSetCatalog = row[Option[SqlIdentifier]](idx + 10),
        characterSetSchema = row[Option[SqlIdentifier]](idx + 11),
        characterSetName = row[Option[SqlIdentifier]](idx + 12),
        collationCatalog = row[Option[SqlIdentifier]](idx + 13),
        collationSchema = row[Option[SqlIdentifier]](idx + 14),
        collationName = row[Option[SqlIdentifier]](idx + 15),
        numericPrecision = row[Option[CardinalNumber]](idx + 16),
        numericPrecisionRadix = row[Option[CardinalNumber]](idx + 17),
        numericScale = row[Option[CardinalNumber]](idx + 18),
        datetimePrecision = row[Option[CardinalNumber]](idx + 19),
        intervalType = row[Option[CharacterData]](idx + 20),
        intervalPrecision = row[Option[CardinalNumber]](idx + 21),
        attributeUdtCatalog = row[Option[SqlIdentifier]](idx + 22),
        attributeUdtSchema = row[Option[SqlIdentifier]](idx + 23),
        attributeUdtName = row[Option[SqlIdentifier]](idx + 24),
        scopeCatalog = row[Option[SqlIdentifier]](idx + 25),
        scopeSchema = row[Option[SqlIdentifier]](idx + 26),
        scopeName = row[Option[SqlIdentifier]](idx + 27),
        maximumCardinality = row[Option[CardinalNumber]](idx + 28),
        dtdIdentifier = row[Option[SqlIdentifier]](idx + 29),
        isDerivedReferenceAttribute = row[Option[YesOrNo]](idx + 30)
      )
    )
  }
  implicit val writes: OWrites[AttributesViewRow] = OWrites[AttributesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "udt_catalog" -> Json.toJson(o.udtCatalog),
      "udt_schema" -> Json.toJson(o.udtSchema),
      "udt_name" -> Json.toJson(o.udtName),
      "attribute_name" -> Json.toJson(o.attributeName),
      "ordinal_position" -> Json.toJson(o.ordinalPosition),
      "attribute_default" -> Json.toJson(o.attributeDefault),
      "is_nullable" -> Json.toJson(o.isNullable),
      "data_type" -> Json.toJson(o.dataType),
      "character_maximum_length" -> Json.toJson(o.characterMaximumLength),
      "character_octet_length" -> Json.toJson(o.characterOctetLength),
      "character_set_catalog" -> Json.toJson(o.characterSetCatalog),
      "character_set_schema" -> Json.toJson(o.characterSetSchema),
      "character_set_name" -> Json.toJson(o.characterSetName),
      "collation_catalog" -> Json.toJson(o.collationCatalog),
      "collation_schema" -> Json.toJson(o.collationSchema),
      "collation_name" -> Json.toJson(o.collationName),
      "numeric_precision" -> Json.toJson(o.numericPrecision),
      "numeric_precision_radix" -> Json.toJson(o.numericPrecisionRadix),
      "numeric_scale" -> Json.toJson(o.numericScale),
      "datetime_precision" -> Json.toJson(o.datetimePrecision),
      "interval_type" -> Json.toJson(o.intervalType),
      "interval_precision" -> Json.toJson(o.intervalPrecision),
      "attribute_udt_catalog" -> Json.toJson(o.attributeUdtCatalog),
      "attribute_udt_schema" -> Json.toJson(o.attributeUdtSchema),
      "attribute_udt_name" -> Json.toJson(o.attributeUdtName),
      "scope_catalog" -> Json.toJson(o.scopeCatalog),
      "scope_schema" -> Json.toJson(o.scopeSchema),
      "scope_name" -> Json.toJson(o.scopeName),
      "maximum_cardinality" -> Json.toJson(o.maximumCardinality),
      "dtd_identifier" -> Json.toJson(o.dtdIdentifier),
      "is_derived_reference_attribute" -> Json.toJson(o.isDerivedReferenceAttribute)
    ))
  )
}
