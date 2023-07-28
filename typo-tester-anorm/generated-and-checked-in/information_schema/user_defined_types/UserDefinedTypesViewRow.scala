/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_defined_types

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

case class UserDefinedTypesViewRow(
  userDefinedTypeCatalog: Option[SqlIdentifier],
  userDefinedTypeSchema: Option[SqlIdentifier],
  userDefinedTypeName: Option[SqlIdentifier],
  userDefinedTypeCategory: Option[CharacterData],
  isInstantiable: Option[YesOrNo],
  isFinal: Option[YesOrNo],
  orderingForm: Option[CharacterData],
  orderingCategory: Option[CharacterData],
  orderingRoutineCatalog: Option[SqlIdentifier],
  orderingRoutineSchema: Option[SqlIdentifier],
  orderingRoutineName: Option[SqlIdentifier],
  referenceType: Option[CharacterData],
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
  sourceDtdIdentifier: Option[SqlIdentifier],
  refDtdIdentifier: Option[SqlIdentifier]
)

object UserDefinedTypesViewRow {
  implicit val reads: Reads[UserDefinedTypesViewRow] = Reads[UserDefinedTypesViewRow](json => JsResult.fromTry(
      Try(
        UserDefinedTypesViewRow(
          userDefinedTypeCatalog = json.\("user_defined_type_catalog").toOption.map(_.as[SqlIdentifier]),
          userDefinedTypeSchema = json.\("user_defined_type_schema").toOption.map(_.as[SqlIdentifier]),
          userDefinedTypeName = json.\("user_defined_type_name").toOption.map(_.as[SqlIdentifier]),
          userDefinedTypeCategory = json.\("user_defined_type_category").toOption.map(_.as[CharacterData]),
          isInstantiable = json.\("is_instantiable").toOption.map(_.as[YesOrNo]),
          isFinal = json.\("is_final").toOption.map(_.as[YesOrNo]),
          orderingForm = json.\("ordering_form").toOption.map(_.as[CharacterData]),
          orderingCategory = json.\("ordering_category").toOption.map(_.as[CharacterData]),
          orderingRoutineCatalog = json.\("ordering_routine_catalog").toOption.map(_.as[SqlIdentifier]),
          orderingRoutineSchema = json.\("ordering_routine_schema").toOption.map(_.as[SqlIdentifier]),
          orderingRoutineName = json.\("ordering_routine_name").toOption.map(_.as[SqlIdentifier]),
          referenceType = json.\("reference_type").toOption.map(_.as[CharacterData]),
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
          sourceDtdIdentifier = json.\("source_dtd_identifier").toOption.map(_.as[SqlIdentifier]),
          refDtdIdentifier = json.\("ref_dtd_identifier").toOption.map(_.as[SqlIdentifier])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[UserDefinedTypesViewRow] = RowParser[UserDefinedTypesViewRow] { row =>
    Success(
      UserDefinedTypesViewRow(
        userDefinedTypeCatalog = row[Option[SqlIdentifier]](idx + 0),
        userDefinedTypeSchema = row[Option[SqlIdentifier]](idx + 1),
        userDefinedTypeName = row[Option[SqlIdentifier]](idx + 2),
        userDefinedTypeCategory = row[Option[CharacterData]](idx + 3),
        isInstantiable = row[Option[YesOrNo]](idx + 4),
        isFinal = row[Option[YesOrNo]](idx + 5),
        orderingForm = row[Option[CharacterData]](idx + 6),
        orderingCategory = row[Option[CharacterData]](idx + 7),
        orderingRoutineCatalog = row[Option[SqlIdentifier]](idx + 8),
        orderingRoutineSchema = row[Option[SqlIdentifier]](idx + 9),
        orderingRoutineName = row[Option[SqlIdentifier]](idx + 10),
        referenceType = row[Option[CharacterData]](idx + 11),
        dataType = row[Option[CharacterData]](idx + 12),
        characterMaximumLength = row[Option[CardinalNumber]](idx + 13),
        characterOctetLength = row[Option[CardinalNumber]](idx + 14),
        characterSetCatalog = row[Option[SqlIdentifier]](idx + 15),
        characterSetSchema = row[Option[SqlIdentifier]](idx + 16),
        characterSetName = row[Option[SqlIdentifier]](idx + 17),
        collationCatalog = row[Option[SqlIdentifier]](idx + 18),
        collationSchema = row[Option[SqlIdentifier]](idx + 19),
        collationName = row[Option[SqlIdentifier]](idx + 20),
        numericPrecision = row[Option[CardinalNumber]](idx + 21),
        numericPrecisionRadix = row[Option[CardinalNumber]](idx + 22),
        numericScale = row[Option[CardinalNumber]](idx + 23),
        datetimePrecision = row[Option[CardinalNumber]](idx + 24),
        intervalType = row[Option[CharacterData]](idx + 25),
        intervalPrecision = row[Option[CardinalNumber]](idx + 26),
        sourceDtdIdentifier = row[Option[SqlIdentifier]](idx + 27),
        refDtdIdentifier = row[Option[SqlIdentifier]](idx + 28)
      )
    )
  }
  implicit val writes: OWrites[UserDefinedTypesViewRow] = OWrites[UserDefinedTypesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "user_defined_type_catalog" -> Json.toJson(o.userDefinedTypeCatalog),
      "user_defined_type_schema" -> Json.toJson(o.userDefinedTypeSchema),
      "user_defined_type_name" -> Json.toJson(o.userDefinedTypeName),
      "user_defined_type_category" -> Json.toJson(o.userDefinedTypeCategory),
      "is_instantiable" -> Json.toJson(o.isInstantiable),
      "is_final" -> Json.toJson(o.isFinal),
      "ordering_form" -> Json.toJson(o.orderingForm),
      "ordering_category" -> Json.toJson(o.orderingCategory),
      "ordering_routine_catalog" -> Json.toJson(o.orderingRoutineCatalog),
      "ordering_routine_schema" -> Json.toJson(o.orderingRoutineSchema),
      "ordering_routine_name" -> Json.toJson(o.orderingRoutineName),
      "reference_type" -> Json.toJson(o.referenceType),
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
      "source_dtd_identifier" -> Json.toJson(o.sourceDtdIdentifier),
      "ref_dtd_identifier" -> Json.toJson(o.refDtdIdentifier)
    ))
  )
}
