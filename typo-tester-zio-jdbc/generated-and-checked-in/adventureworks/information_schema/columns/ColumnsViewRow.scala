/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package columns

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ColumnsViewRow(
  tableCatalog: /* nullability unknown */ Option[String],
  tableSchema: /* nullability unknown */ Option[String],
  tableName: /* nullability unknown */ Option[String],
  columnName: /* nullability unknown */ Option[String],
  ordinalPosition: /* nullability unknown */ Option[Int],
  columnDefault: /* nullability unknown */ Option[String],
  isNullable: /* nullability unknown */ Option[/* max 3 chars */ String],
  dataType: /* nullability unknown */ Option[String],
  characterMaximumLength: /* nullability unknown */ Option[Int],
  characterOctetLength: /* nullability unknown */ Option[Int],
  numericPrecision: /* nullability unknown */ Option[Int],
  numericPrecisionRadix: /* nullability unknown */ Option[Int],
  numericScale: /* nullability unknown */ Option[Int],
  datetimePrecision: /* nullability unknown */ Option[Int],
  intervalType: /* nullability unknown */ Option[String],
  intervalPrecision: /* nullability unknown */ Option[Int],
  characterSetCatalog: /* nullability unknown */ Option[String],
  characterSetSchema: /* nullability unknown */ Option[String],
  characterSetName: /* nullability unknown */ Option[String],
  collationCatalog: /* nullability unknown */ Option[String],
  collationSchema: /* nullability unknown */ Option[String],
  collationName: /* nullability unknown */ Option[String],
  domainCatalog: /* nullability unknown */ Option[String],
  domainSchema: /* nullability unknown */ Option[String],
  domainName: /* nullability unknown */ Option[String],
  udtCatalog: /* nullability unknown */ Option[String],
  udtSchema: /* nullability unknown */ Option[String],
  udtName: /* nullability unknown */ Option[String],
  scopeCatalog: /* nullability unknown */ Option[String],
  scopeSchema: /* nullability unknown */ Option[String],
  scopeName: /* nullability unknown */ Option[String],
  maximumCardinality: /* nullability unknown */ Option[Int],
  dtdIdentifier: /* nullability unknown */ Option[String],
  isSelfReferencing: /* nullability unknown */ Option[/* max 3 chars */ String],
  isIdentity: /* nullability unknown */ Option[/* max 3 chars */ String],
  identityGeneration: /* nullability unknown */ Option[String],
  identityStart: /* nullability unknown */ Option[String],
  identityIncrement: /* nullability unknown */ Option[String],
  identityMaximum: /* nullability unknown */ Option[String],
  identityMinimum: /* nullability unknown */ Option[String],
  identityCycle: /* nullability unknown */ Option[/* max 3 chars */ String],
  isGenerated: /* nullability unknown */ Option[String],
  generationExpression: /* nullability unknown */ Option[String],
  isUpdatable: /* nullability unknown */ Option[/* max 3 chars */ String]
)

object ColumnsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ColumnsViewRow] = new JdbcDecoder[ColumnsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ColumnsViewRow) =
      columIndex + 43 ->
        ColumnsViewRow(
          tableCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          tableSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          tableName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          columnName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          ordinalPosition = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 4, rs)._2,
          columnDefault = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          isNullable = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          dataType = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          characterMaximumLength = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 8, rs)._2,
          characterOctetLength = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 9, rs)._2,
          numericPrecision = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 10, rs)._2,
          numericPrecisionRadix = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 11, rs)._2,
          numericScale = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 12, rs)._2,
          datetimePrecision = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 13, rs)._2,
          intervalType = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 14, rs)._2,
          intervalPrecision = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 15, rs)._2,
          characterSetCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 16, rs)._2,
          characterSetSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 17, rs)._2,
          characterSetName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 18, rs)._2,
          collationCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 19, rs)._2,
          collationSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 20, rs)._2,
          collationName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 21, rs)._2,
          domainCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 22, rs)._2,
          domainSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 23, rs)._2,
          domainName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 24, rs)._2,
          udtCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 25, rs)._2,
          udtSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 26, rs)._2,
          udtName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 27, rs)._2,
          scopeCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 28, rs)._2,
          scopeSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 29, rs)._2,
          scopeName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 30, rs)._2,
          maximumCardinality = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 31, rs)._2,
          dtdIdentifier = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 32, rs)._2,
          isSelfReferencing = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 33, rs)._2,
          isIdentity = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 34, rs)._2,
          identityGeneration = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 35, rs)._2,
          identityStart = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 36, rs)._2,
          identityIncrement = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 37, rs)._2,
          identityMaximum = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 38, rs)._2,
          identityMinimum = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 39, rs)._2,
          identityCycle = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 40, rs)._2,
          isGenerated = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 41, rs)._2,
          generationExpression = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 42, rs)._2,
          isUpdatable = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 43, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ColumnsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val tableCatalog = jsonObj.get("table_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val tableSchema = jsonObj.get("table_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val tableName = jsonObj.get("table_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val columnName = jsonObj.get("column_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val ordinalPosition = jsonObj.get("ordinal_position").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val columnDefault = jsonObj.get("column_default").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val isNullable = jsonObj.get("is_nullable").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val dataType = jsonObj.get("data_type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val characterMaximumLength = jsonObj.get("character_maximum_length").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val characterOctetLength = jsonObj.get("character_octet_length").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val numericPrecision = jsonObj.get("numeric_precision").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val numericPrecisionRadix = jsonObj.get("numeric_precision_radix").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val numericScale = jsonObj.get("numeric_scale").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val datetimePrecision = jsonObj.get("datetime_precision").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val intervalType = jsonObj.get("interval_type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val intervalPrecision = jsonObj.get("interval_precision").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val characterSetCatalog = jsonObj.get("character_set_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val characterSetSchema = jsonObj.get("character_set_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val characterSetName = jsonObj.get("character_set_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val collationCatalog = jsonObj.get("collation_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val collationSchema = jsonObj.get("collation_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val collationName = jsonObj.get("collation_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val domainCatalog = jsonObj.get("domain_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val domainSchema = jsonObj.get("domain_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val domainName = jsonObj.get("domain_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtCatalog = jsonObj.get("udt_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtSchema = jsonObj.get("udt_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtName = jsonObj.get("udt_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val scopeCatalog = jsonObj.get("scope_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val scopeSchema = jsonObj.get("scope_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val scopeName = jsonObj.get("scope_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val maximumCardinality = jsonObj.get("maximum_cardinality").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val dtdIdentifier = jsonObj.get("dtd_identifier").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val isSelfReferencing = jsonObj.get("is_self_referencing").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val isIdentity = jsonObj.get("is_identity").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val identityGeneration = jsonObj.get("identity_generation").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val identityStart = jsonObj.get("identity_start").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val identityIncrement = jsonObj.get("identity_increment").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val identityMaximum = jsonObj.get("identity_maximum").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val identityMinimum = jsonObj.get("identity_minimum").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val identityCycle = jsonObj.get("identity_cycle").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val isGenerated = jsonObj.get("is_generated").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val generationExpression = jsonObj.get("generation_expression").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val isUpdatable = jsonObj.get("is_updatable").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (tableCatalog.isRight && tableSchema.isRight && tableName.isRight && columnName.isRight && ordinalPosition.isRight && columnDefault.isRight && isNullable.isRight && dataType.isRight && characterMaximumLength.isRight && characterOctetLength.isRight && numericPrecision.isRight && numericPrecisionRadix.isRight && numericScale.isRight && datetimePrecision.isRight && intervalType.isRight && intervalPrecision.isRight && characterSetCatalog.isRight && characterSetSchema.isRight && characterSetName.isRight && collationCatalog.isRight && collationSchema.isRight && collationName.isRight && domainCatalog.isRight && domainSchema.isRight && domainName.isRight && udtCatalog.isRight && udtSchema.isRight && udtName.isRight && scopeCatalog.isRight && scopeSchema.isRight && scopeName.isRight && maximumCardinality.isRight && dtdIdentifier.isRight && isSelfReferencing.isRight && isIdentity.isRight && identityGeneration.isRight && identityStart.isRight && identityIncrement.isRight && identityMaximum.isRight && identityMinimum.isRight && identityCycle.isRight && isGenerated.isRight && generationExpression.isRight && isUpdatable.isRight)
      Right(ColumnsViewRow(tableCatalog = tableCatalog.toOption.get, tableSchema = tableSchema.toOption.get, tableName = tableName.toOption.get, columnName = columnName.toOption.get, ordinalPosition = ordinalPosition.toOption.get, columnDefault = columnDefault.toOption.get, isNullable = isNullable.toOption.get, dataType = dataType.toOption.get, characterMaximumLength = characterMaximumLength.toOption.get, characterOctetLength = characterOctetLength.toOption.get, numericPrecision = numericPrecision.toOption.get, numericPrecisionRadix = numericPrecisionRadix.toOption.get, numericScale = numericScale.toOption.get, datetimePrecision = datetimePrecision.toOption.get, intervalType = intervalType.toOption.get, intervalPrecision = intervalPrecision.toOption.get, characterSetCatalog = characterSetCatalog.toOption.get, characterSetSchema = characterSetSchema.toOption.get, characterSetName = characterSetName.toOption.get, collationCatalog = collationCatalog.toOption.get, collationSchema = collationSchema.toOption.get, collationName = collationName.toOption.get, domainCatalog = domainCatalog.toOption.get, domainSchema = domainSchema.toOption.get, domainName = domainName.toOption.get, udtCatalog = udtCatalog.toOption.get, udtSchema = udtSchema.toOption.get, udtName = udtName.toOption.get, scopeCatalog = scopeCatalog.toOption.get, scopeSchema = scopeSchema.toOption.get, scopeName = scopeName.toOption.get, maximumCardinality = maximumCardinality.toOption.get, dtdIdentifier = dtdIdentifier.toOption.get, isSelfReferencing = isSelfReferencing.toOption.get, isIdentity = isIdentity.toOption.get, identityGeneration = identityGeneration.toOption.get, identityStart = identityStart.toOption.get, identityIncrement = identityIncrement.toOption.get, identityMaximum = identityMaximum.toOption.get, identityMinimum = identityMinimum.toOption.get, identityCycle = identityCycle.toOption.get, isGenerated = isGenerated.toOption.get, generationExpression = generationExpression.toOption.get, isUpdatable = isUpdatable.toOption.get))
    else Left(List[Either[String, Any]](tableCatalog, tableSchema, tableName, columnName, ordinalPosition, columnDefault, isNullable, dataType, characterMaximumLength, characterOctetLength, numericPrecision, numericPrecisionRadix, numericScale, datetimePrecision, intervalType, intervalPrecision, characterSetCatalog, characterSetSchema, characterSetName, collationCatalog, collationSchema, collationName, domainCatalog, domainSchema, domainName, udtCatalog, udtSchema, udtName, scopeCatalog, scopeSchema, scopeName, maximumCardinality, dtdIdentifier, isSelfReferencing, isIdentity, identityGeneration, identityStart, identityIncrement, identityMaximum, identityMinimum, identityCycle, isGenerated, generationExpression, isUpdatable).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ColumnsViewRow] = new JsonEncoder[ColumnsViewRow] {
    override def unsafeEncode(a: ColumnsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""table_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableCatalog, indent, out)
      out.write(",")
      out.write(""""table_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableSchema, indent, out)
      out.write(",")
      out.write(""""table_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableName, indent, out)
      out.write(",")
      out.write(""""column_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.columnName, indent, out)
      out.write(",")
      out.write(""""ordinal_position":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.ordinalPosition, indent, out)
      out.write(",")
      out.write(""""column_default":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.columnDefault, indent, out)
      out.write(",")
      out.write(""""is_nullable":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.isNullable, indent, out)
      out.write(",")
      out.write(""""data_type":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.dataType, indent, out)
      out.write(",")
      out.write(""""character_maximum_length":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.characterMaximumLength, indent, out)
      out.write(",")
      out.write(""""character_octet_length":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.characterOctetLength, indent, out)
      out.write(",")
      out.write(""""numeric_precision":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.numericPrecision, indent, out)
      out.write(",")
      out.write(""""numeric_precision_radix":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.numericPrecisionRadix, indent, out)
      out.write(",")
      out.write(""""numeric_scale":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.numericScale, indent, out)
      out.write(",")
      out.write(""""datetime_precision":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.datetimePrecision, indent, out)
      out.write(",")
      out.write(""""interval_type":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.intervalType, indent, out)
      out.write(",")
      out.write(""""interval_precision":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.intervalPrecision, indent, out)
      out.write(",")
      out.write(""""character_set_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.characterSetCatalog, indent, out)
      out.write(",")
      out.write(""""character_set_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.characterSetSchema, indent, out)
      out.write(",")
      out.write(""""character_set_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.characterSetName, indent, out)
      out.write(",")
      out.write(""""collation_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.collationCatalog, indent, out)
      out.write(",")
      out.write(""""collation_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.collationSchema, indent, out)
      out.write(",")
      out.write(""""collation_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.collationName, indent, out)
      out.write(",")
      out.write(""""domain_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.domainCatalog, indent, out)
      out.write(",")
      out.write(""""domain_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.domainSchema, indent, out)
      out.write(",")
      out.write(""""domain_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.domainName, indent, out)
      out.write(",")
      out.write(""""udt_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtCatalog, indent, out)
      out.write(",")
      out.write(""""udt_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtSchema, indent, out)
      out.write(",")
      out.write(""""udt_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtName, indent, out)
      out.write(",")
      out.write(""""scope_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.scopeCatalog, indent, out)
      out.write(",")
      out.write(""""scope_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.scopeSchema, indent, out)
      out.write(",")
      out.write(""""scope_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.scopeName, indent, out)
      out.write(",")
      out.write(""""maximum_cardinality":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.maximumCardinality, indent, out)
      out.write(",")
      out.write(""""dtd_identifier":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.dtdIdentifier, indent, out)
      out.write(",")
      out.write(""""is_self_referencing":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.isSelfReferencing, indent, out)
      out.write(",")
      out.write(""""is_identity":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.isIdentity, indent, out)
      out.write(",")
      out.write(""""identity_generation":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.identityGeneration, indent, out)
      out.write(",")
      out.write(""""identity_start":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.identityStart, indent, out)
      out.write(",")
      out.write(""""identity_increment":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.identityIncrement, indent, out)
      out.write(",")
      out.write(""""identity_maximum":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.identityMaximum, indent, out)
      out.write(",")
      out.write(""""identity_minimum":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.identityMinimum, indent, out)
      out.write(",")
      out.write(""""identity_cycle":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.identityCycle, indent, out)
      out.write(",")
      out.write(""""is_generated":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.isGenerated, indent, out)
      out.write(",")
      out.write(""""generation_expression":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.generationExpression, indent, out)
      out.write(",")
      out.write(""""is_updatable":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.isUpdatable, indent, out)
      out.write("}")
    }
  }
}