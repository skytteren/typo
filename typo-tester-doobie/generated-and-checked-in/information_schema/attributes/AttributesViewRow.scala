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
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

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
  implicit val decoder: Decoder[AttributesViewRow] =
    (c: HCursor) =>
      for {
        udtCatalog <- c.downField("udt_catalog").as[Option[SqlIdentifier]]
        udtSchema <- c.downField("udt_schema").as[Option[SqlIdentifier]]
        udtName <- c.downField("udt_name").as[Option[SqlIdentifier]]
        attributeName <- c.downField("attribute_name").as[Option[SqlIdentifier]]
        ordinalPosition <- c.downField("ordinal_position").as[Option[CardinalNumber]]
        attributeDefault <- c.downField("attribute_default").as[Option[CharacterData]]
        isNullable <- c.downField("is_nullable").as[Option[YesOrNo]]
        dataType <- c.downField("data_type").as[Option[CharacterData]]
        characterMaximumLength <- c.downField("character_maximum_length").as[Option[CardinalNumber]]
        characterOctetLength <- c.downField("character_octet_length").as[Option[CardinalNumber]]
        characterSetCatalog <- c.downField("character_set_catalog").as[Option[SqlIdentifier]]
        characterSetSchema <- c.downField("character_set_schema").as[Option[SqlIdentifier]]
        characterSetName <- c.downField("character_set_name").as[Option[SqlIdentifier]]
        collationCatalog <- c.downField("collation_catalog").as[Option[SqlIdentifier]]
        collationSchema <- c.downField("collation_schema").as[Option[SqlIdentifier]]
        collationName <- c.downField("collation_name").as[Option[SqlIdentifier]]
        numericPrecision <- c.downField("numeric_precision").as[Option[CardinalNumber]]
        numericPrecisionRadix <- c.downField("numeric_precision_radix").as[Option[CardinalNumber]]
        numericScale <- c.downField("numeric_scale").as[Option[CardinalNumber]]
        datetimePrecision <- c.downField("datetime_precision").as[Option[CardinalNumber]]
        intervalType <- c.downField("interval_type").as[Option[CharacterData]]
        intervalPrecision <- c.downField("interval_precision").as[Option[CardinalNumber]]
        attributeUdtCatalog <- c.downField("attribute_udt_catalog").as[Option[SqlIdentifier]]
        attributeUdtSchema <- c.downField("attribute_udt_schema").as[Option[SqlIdentifier]]
        attributeUdtName <- c.downField("attribute_udt_name").as[Option[SqlIdentifier]]
        scopeCatalog <- c.downField("scope_catalog").as[Option[SqlIdentifier]]
        scopeSchema <- c.downField("scope_schema").as[Option[SqlIdentifier]]
        scopeName <- c.downField("scope_name").as[Option[SqlIdentifier]]
        maximumCardinality <- c.downField("maximum_cardinality").as[Option[CardinalNumber]]
        dtdIdentifier <- c.downField("dtd_identifier").as[Option[SqlIdentifier]]
        isDerivedReferenceAttribute <- c.downField("is_derived_reference_attribute").as[Option[YesOrNo]]
      } yield AttributesViewRow(udtCatalog, udtSchema, udtName, attributeName, ordinalPosition, attributeDefault, isNullable, dataType, characterMaximumLength, characterOctetLength, characterSetCatalog, characterSetSchema, characterSetName, collationCatalog, collationSchema, collationName, numericPrecision, numericPrecisionRadix, numericScale, datetimePrecision, intervalType, intervalPrecision, attributeUdtCatalog, attributeUdtSchema, attributeUdtName, scopeCatalog, scopeSchema, scopeName, maximumCardinality, dtdIdentifier, isDerivedReferenceAttribute)
  implicit val encoder: Encoder[AttributesViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "udt_catalog" := row.udtCatalog,
        "udt_schema" := row.udtSchema,
        "udt_name" := row.udtName,
        "attribute_name" := row.attributeName,
        "ordinal_position" := row.ordinalPosition,
        "attribute_default" := row.attributeDefault,
        "is_nullable" := row.isNullable,
        "data_type" := row.dataType,
        "character_maximum_length" := row.characterMaximumLength,
        "character_octet_length" := row.characterOctetLength,
        "character_set_catalog" := row.characterSetCatalog,
        "character_set_schema" := row.characterSetSchema,
        "character_set_name" := row.characterSetName,
        "collation_catalog" := row.collationCatalog,
        "collation_schema" := row.collationSchema,
        "collation_name" := row.collationName,
        "numeric_precision" := row.numericPrecision,
        "numeric_precision_radix" := row.numericPrecisionRadix,
        "numeric_scale" := row.numericScale,
        "datetime_precision" := row.datetimePrecision,
        "interval_type" := row.intervalType,
        "interval_precision" := row.intervalPrecision,
        "attribute_udt_catalog" := row.attributeUdtCatalog,
        "attribute_udt_schema" := row.attributeUdtSchema,
        "attribute_udt_name" := row.attributeUdtName,
        "scope_catalog" := row.scopeCatalog,
        "scope_schema" := row.scopeSchema,
        "scope_name" := row.scopeName,
        "maximum_cardinality" := row.maximumCardinality,
        "dtd_identifier" := row.dtdIdentifier,
        "is_derived_reference_attribute" := row.isDerivedReferenceAttribute
      )}
  implicit val read: Read[AttributesViewRow] =
    new Read[AttributesViewRow](
      gets = List(
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[CharacterData], Nullability.Nullable),
        (Get[YesOrNo], Nullability.Nullable),
        (Get[CharacterData], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[CharacterData], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[CardinalNumber], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[YesOrNo], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => AttributesViewRow(
        udtCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 0),
        udtSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 1),
        udtName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 2),
        attributeName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 3),
        ordinalPosition = Get[CardinalNumber].unsafeGetNullable(rs, i + 4),
        attributeDefault = Get[CharacterData].unsafeGetNullable(rs, i + 5),
        isNullable = Get[YesOrNo].unsafeGetNullable(rs, i + 6),
        dataType = Get[CharacterData].unsafeGetNullable(rs, i + 7),
        characterMaximumLength = Get[CardinalNumber].unsafeGetNullable(rs, i + 8),
        characterOctetLength = Get[CardinalNumber].unsafeGetNullable(rs, i + 9),
        characterSetCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 10),
        characterSetSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 11),
        characterSetName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 12),
        collationCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 13),
        collationSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 14),
        collationName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 15),
        numericPrecision = Get[CardinalNumber].unsafeGetNullable(rs, i + 16),
        numericPrecisionRadix = Get[CardinalNumber].unsafeGetNullable(rs, i + 17),
        numericScale = Get[CardinalNumber].unsafeGetNullable(rs, i + 18),
        datetimePrecision = Get[CardinalNumber].unsafeGetNullable(rs, i + 19),
        intervalType = Get[CharacterData].unsafeGetNullable(rs, i + 20),
        intervalPrecision = Get[CardinalNumber].unsafeGetNullable(rs, i + 21),
        attributeUdtCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 22),
        attributeUdtSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 23),
        attributeUdtName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 24),
        scopeCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 25),
        scopeSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 26),
        scopeName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 27),
        maximumCardinality = Get[CardinalNumber].unsafeGetNullable(rs, i + 28),
        dtdIdentifier = Get[SqlIdentifier].unsafeGetNullable(rs, i + 29),
        isDerivedReferenceAttribute = Get[YesOrNo].unsafeGetNullable(rs, i + 30)
      )
    )
  

}