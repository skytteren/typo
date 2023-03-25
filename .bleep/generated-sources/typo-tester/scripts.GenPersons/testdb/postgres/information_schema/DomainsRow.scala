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

case class DomainsRow(
  domainCatalog: Option[String],
  domainSchema: Option[String],
  domainName: Option[String],
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
  domainDefault: Option[String],
  udtCatalog: Option[String],
  udtSchema: Option[String],
  udtName: Option[String],
  scopeCatalog: Option[String],
  scopeSchema: Option[String],
  scopeName: Option[String],
  maximumCardinality: Option[Int],
  dtdIdentifier: Option[String]
)

object DomainsRow {
  def rowParser(prefix: String): RowParser[DomainsRow] = { row =>
    Success(
      DomainsRow(
        domainCatalog = row[Option[String]](prefix + "domain_catalog"),
        domainSchema = row[Option[String]](prefix + "domain_schema"),
        domainName = row[Option[String]](prefix + "domain_name"),
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
        domainDefault = row[Option[String]](prefix + "domain_default"),
        udtCatalog = row[Option[String]](prefix + "udt_catalog"),
        udtSchema = row[Option[String]](prefix + "udt_schema"),
        udtName = row[Option[String]](prefix + "udt_name"),
        scopeCatalog = row[Option[String]](prefix + "scope_catalog"),
        scopeSchema = row[Option[String]](prefix + "scope_schema"),
        scopeName = row[Option[String]](prefix + "scope_name"),
        maximumCardinality = row[Option[Int]](prefix + "maximum_cardinality"),
        dtdIdentifier = row[Option[String]](prefix + "dtd_identifier")
      )
    )
  }

  implicit val oFormat: OFormat[DomainsRow] = new OFormat[DomainsRow]{
    override def writes(o: DomainsRow): JsObject =
      Json.obj(
        "domain_catalog" -> o.domainCatalog,
      "domain_schema" -> o.domainSchema,
      "domain_name" -> o.domainName,
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
      "domain_default" -> o.domainDefault,
      "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "scope_catalog" -> o.scopeCatalog,
      "scope_schema" -> o.scopeSchema,
      "scope_name" -> o.scopeName,
      "maximum_cardinality" -> o.maximumCardinality,
      "dtd_identifier" -> o.dtdIdentifier
      )

    override def reads(json: JsValue): JsResult[DomainsRow] = {
      JsResult.fromTry(
        Try(
          DomainsRow(
            domainCatalog = json.\("domain_catalog").toOption.map(_.as[String]),
            domainSchema = json.\("domain_schema").toOption.map(_.as[String]),
            domainName = json.\("domain_name").toOption.map(_.as[String]),
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
            domainDefault = json.\("domain_default").toOption.map(_.as[String]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            scopeCatalog = json.\("scope_catalog").toOption.map(_.as[String]),
            scopeSchema = json.\("scope_schema").toOption.map(_.as[String]),
            scopeName = json.\("scope_name").toOption.map(_.as[String]),
            maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[Int]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}