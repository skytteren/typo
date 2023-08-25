/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package domains

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class DomainsViewRow(
  domainCatalog: Option[SqlIdentifier],
  domainSchema: Option[SqlIdentifier],
  domainName: Option[SqlIdentifier],
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
  domainDefault: Option[CharacterData],
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  scopeCatalog: Option[SqlIdentifier],
  scopeSchema: Option[SqlIdentifier],
  scopeName: Option[SqlIdentifier],
  maximumCardinality: Option[CardinalNumber],
  dtdIdentifier: Option[SqlIdentifier]
)

object DomainsViewRow {
  implicit lazy val reads: Reads[DomainsViewRow] = Reads[DomainsViewRow](json => JsResult.fromTry(
      Try(
        DomainsViewRow(
          domainCatalog = json.\("domain_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          domainSchema = json.\("domain_schema").toOption.map(_.as(SqlIdentifier.reads)),
          domainName = json.\("domain_name").toOption.map(_.as(SqlIdentifier.reads)),
          dataType = json.\("data_type").toOption.map(_.as(CharacterData.reads)),
          characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as(CardinalNumber.reads)),
          characterOctetLength = json.\("character_octet_length").toOption.map(_.as(CardinalNumber.reads)),
          characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetSchema = json.\("character_set_schema").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetName = json.\("character_set_name").toOption.map(_.as(SqlIdentifier.reads)),
          collationCatalog = json.\("collation_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          collationSchema = json.\("collation_schema").toOption.map(_.as(SqlIdentifier.reads)),
          collationName = json.\("collation_name").toOption.map(_.as(SqlIdentifier.reads)),
          numericPrecision = json.\("numeric_precision").toOption.map(_.as(CardinalNumber.reads)),
          numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as(CardinalNumber.reads)),
          numericScale = json.\("numeric_scale").toOption.map(_.as(CardinalNumber.reads)),
          datetimePrecision = json.\("datetime_precision").toOption.map(_.as(CardinalNumber.reads)),
          intervalType = json.\("interval_type").toOption.map(_.as(CharacterData.reads)),
          intervalPrecision = json.\("interval_precision").toOption.map(_.as(CardinalNumber.reads)),
          domainDefault = json.\("domain_default").toOption.map(_.as(CharacterData.reads)),
          udtCatalog = json.\("udt_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          udtSchema = json.\("udt_schema").toOption.map(_.as(SqlIdentifier.reads)),
          udtName = json.\("udt_name").toOption.map(_.as(SqlIdentifier.reads)),
          scopeCatalog = json.\("scope_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          scopeSchema = json.\("scope_schema").toOption.map(_.as(SqlIdentifier.reads)),
          scopeName = json.\("scope_name").toOption.map(_.as(SqlIdentifier.reads)),
          maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as(CardinalNumber.reads)),
          dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[DomainsViewRow] = RowParser[DomainsViewRow] { row =>
    Success(
      DomainsViewRow(
        domainCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        domainSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        domainName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        dataType = row(idx + 3)(Column.columnToOption(CharacterData.column)),
        characterMaximumLength = row(idx + 4)(Column.columnToOption(CardinalNumber.column)),
        characterOctetLength = row(idx + 5)(Column.columnToOption(CardinalNumber.column)),
        characterSetCatalog = row(idx + 6)(Column.columnToOption(SqlIdentifier.column)),
        characterSetSchema = row(idx + 7)(Column.columnToOption(SqlIdentifier.column)),
        characterSetName = row(idx + 8)(Column.columnToOption(SqlIdentifier.column)),
        collationCatalog = row(idx + 9)(Column.columnToOption(SqlIdentifier.column)),
        collationSchema = row(idx + 10)(Column.columnToOption(SqlIdentifier.column)),
        collationName = row(idx + 11)(Column.columnToOption(SqlIdentifier.column)),
        numericPrecision = row(idx + 12)(Column.columnToOption(CardinalNumber.column)),
        numericPrecisionRadix = row(idx + 13)(Column.columnToOption(CardinalNumber.column)),
        numericScale = row(idx + 14)(Column.columnToOption(CardinalNumber.column)),
        datetimePrecision = row(idx + 15)(Column.columnToOption(CardinalNumber.column)),
        intervalType = row(idx + 16)(Column.columnToOption(CharacterData.column)),
        intervalPrecision = row(idx + 17)(Column.columnToOption(CardinalNumber.column)),
        domainDefault = row(idx + 18)(Column.columnToOption(CharacterData.column)),
        udtCatalog = row(idx + 19)(Column.columnToOption(SqlIdentifier.column)),
        udtSchema = row(idx + 20)(Column.columnToOption(SqlIdentifier.column)),
        udtName = row(idx + 21)(Column.columnToOption(SqlIdentifier.column)),
        scopeCatalog = row(idx + 22)(Column.columnToOption(SqlIdentifier.column)),
        scopeSchema = row(idx + 23)(Column.columnToOption(SqlIdentifier.column)),
        scopeName = row(idx + 24)(Column.columnToOption(SqlIdentifier.column)),
        maximumCardinality = row(idx + 25)(Column.columnToOption(CardinalNumber.column)),
        dtdIdentifier = row(idx + 26)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit lazy val writes: OWrites[DomainsViewRow] = OWrites[DomainsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "domain_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainCatalog),
      "domain_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainSchema),
      "domain_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainName),
      "data_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.dataType),
      "character_maximum_length" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.characterMaximumLength),
      "character_octet_length" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.characterOctetLength),
      "character_set_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetCatalog),
      "character_set_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetSchema),
      "character_set_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetName),
      "collation_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationCatalog),
      "collation_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationSchema),
      "collation_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationName),
      "numeric_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericPrecision),
      "numeric_precision_radix" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericPrecisionRadix),
      "numeric_scale" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericScale),
      "datetime_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.datetimePrecision),
      "interval_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.intervalType),
      "interval_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.intervalPrecision),
      "domain_default" -> Writes.OptionWrites(CharacterData.writes).writes(o.domainDefault),
      "udt_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtCatalog),
      "udt_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtSchema),
      "udt_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtName),
      "scope_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeCatalog),
      "scope_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeSchema),
      "scope_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeName),
      "maximum_cardinality" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.maximumCardinality),
      "dtd_identifier" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.dtdIdentifier)
    ))
  )
}