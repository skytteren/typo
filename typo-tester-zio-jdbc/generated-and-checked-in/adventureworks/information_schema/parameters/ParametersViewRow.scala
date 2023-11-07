/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package parameters

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ParametersViewRow(
  specificCatalog: /* nullability unknown */ Option[String],
  specificSchema: /* nullability unknown */ Option[String],
  specificName: /* nullability unknown */ Option[String],
  ordinalPosition: /* nullability unknown */ Option[Int],
  parameterMode: /* nullability unknown */ Option[String],
  isResult: /* nullability unknown */ Option[/* max 3 chars */ String],
  asLocator: /* nullability unknown */ Option[/* max 3 chars */ String],
  parameterName: /* nullability unknown */ Option[String],
  dataType: /* nullability unknown */ Option[String],
  characterMaximumLength: /* nullability unknown */ Option[Int],
  characterOctetLength: /* nullability unknown */ Option[Int],
  characterSetCatalog: /* nullability unknown */ Option[String],
  characterSetSchema: /* nullability unknown */ Option[String],
  characterSetName: /* nullability unknown */ Option[String],
  collationCatalog: /* nullability unknown */ Option[String],
  collationSchema: /* nullability unknown */ Option[String],
  collationName: /* nullability unknown */ Option[String],
  numericPrecision: /* nullability unknown */ Option[Int],
  numericPrecisionRadix: /* nullability unknown */ Option[Int],
  numericScale: /* nullability unknown */ Option[Int],
  datetimePrecision: /* nullability unknown */ Option[Int],
  intervalType: /* nullability unknown */ Option[String],
  intervalPrecision: /* nullability unknown */ Option[Int],
  udtCatalog: /* nullability unknown */ Option[String],
  udtSchema: /* nullability unknown */ Option[String],
  udtName: /* nullability unknown */ Option[String],
  scopeCatalog: /* nullability unknown */ Option[String],
  scopeSchema: /* nullability unknown */ Option[String],
  scopeName: /* nullability unknown */ Option[String],
  maximumCardinality: /* nullability unknown */ Option[Int],
  dtdIdentifier: /* nullability unknown */ Option[String],
  parameterDefault: /* nullability unknown */ Option[String]
)

object ParametersViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ParametersViewRow] = new JdbcDecoder[ParametersViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ParametersViewRow) =
      columIndex + 31 ->
        ParametersViewRow(
          specificCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          specificSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          specificName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          ordinalPosition = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 3, rs)._2,
          parameterMode = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          isResult = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          asLocator = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          parameterName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          dataType = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2,
          characterMaximumLength = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 9, rs)._2,
          characterOctetLength = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 10, rs)._2,
          characterSetCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 11, rs)._2,
          characterSetSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 12, rs)._2,
          characterSetName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 13, rs)._2,
          collationCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 14, rs)._2,
          collationSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 15, rs)._2,
          collationName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 16, rs)._2,
          numericPrecision = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 17, rs)._2,
          numericPrecisionRadix = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 18, rs)._2,
          numericScale = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 19, rs)._2,
          datetimePrecision = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 20, rs)._2,
          intervalType = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 21, rs)._2,
          intervalPrecision = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 22, rs)._2,
          udtCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 23, rs)._2,
          udtSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 24, rs)._2,
          udtName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 25, rs)._2,
          scopeCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 26, rs)._2,
          scopeSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 27, rs)._2,
          scopeName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 28, rs)._2,
          maximumCardinality = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 29, rs)._2,
          dtdIdentifier = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 30, rs)._2,
          parameterDefault = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 31, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ParametersViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val specificCatalog = jsonObj.get("specific_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificSchema = jsonObj.get("specific_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificName = jsonObj.get("specific_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val ordinalPosition = jsonObj.get("ordinal_position").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val parameterMode = jsonObj.get("parameter_mode").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val isResult = jsonObj.get("is_result").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val asLocator = jsonObj.get("as_locator").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val parameterName = jsonObj.get("parameter_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val dataType = jsonObj.get("data_type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val characterMaximumLength = jsonObj.get("character_maximum_length").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val characterOctetLength = jsonObj.get("character_octet_length").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val characterSetCatalog = jsonObj.get("character_set_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val characterSetSchema = jsonObj.get("character_set_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val characterSetName = jsonObj.get("character_set_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val collationCatalog = jsonObj.get("collation_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val collationSchema = jsonObj.get("collation_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val collationName = jsonObj.get("collation_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val numericPrecision = jsonObj.get("numeric_precision").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val numericPrecisionRadix = jsonObj.get("numeric_precision_radix").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val numericScale = jsonObj.get("numeric_scale").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val datetimePrecision = jsonObj.get("datetime_precision").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val intervalType = jsonObj.get("interval_type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val intervalPrecision = jsonObj.get("interval_precision").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val udtCatalog = jsonObj.get("udt_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtSchema = jsonObj.get("udt_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtName = jsonObj.get("udt_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val scopeCatalog = jsonObj.get("scope_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val scopeSchema = jsonObj.get("scope_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val scopeName = jsonObj.get("scope_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val maximumCardinality = jsonObj.get("maximum_cardinality").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val dtdIdentifier = jsonObj.get("dtd_identifier").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val parameterDefault = jsonObj.get("parameter_default").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (specificCatalog.isRight && specificSchema.isRight && specificName.isRight && ordinalPosition.isRight && parameterMode.isRight && isResult.isRight && asLocator.isRight && parameterName.isRight && dataType.isRight && characterMaximumLength.isRight && characterOctetLength.isRight && characterSetCatalog.isRight && characterSetSchema.isRight && characterSetName.isRight && collationCatalog.isRight && collationSchema.isRight && collationName.isRight && numericPrecision.isRight && numericPrecisionRadix.isRight && numericScale.isRight && datetimePrecision.isRight && intervalType.isRight && intervalPrecision.isRight && udtCatalog.isRight && udtSchema.isRight && udtName.isRight && scopeCatalog.isRight && scopeSchema.isRight && scopeName.isRight && maximumCardinality.isRight && dtdIdentifier.isRight && parameterDefault.isRight)
      Right(ParametersViewRow(specificCatalog = specificCatalog.toOption.get, specificSchema = specificSchema.toOption.get, specificName = specificName.toOption.get, ordinalPosition = ordinalPosition.toOption.get, parameterMode = parameterMode.toOption.get, isResult = isResult.toOption.get, asLocator = asLocator.toOption.get, parameterName = parameterName.toOption.get, dataType = dataType.toOption.get, characterMaximumLength = characterMaximumLength.toOption.get, characterOctetLength = characterOctetLength.toOption.get, characterSetCatalog = characterSetCatalog.toOption.get, characterSetSchema = characterSetSchema.toOption.get, characterSetName = characterSetName.toOption.get, collationCatalog = collationCatalog.toOption.get, collationSchema = collationSchema.toOption.get, collationName = collationName.toOption.get, numericPrecision = numericPrecision.toOption.get, numericPrecisionRadix = numericPrecisionRadix.toOption.get, numericScale = numericScale.toOption.get, datetimePrecision = datetimePrecision.toOption.get, intervalType = intervalType.toOption.get, intervalPrecision = intervalPrecision.toOption.get, udtCatalog = udtCatalog.toOption.get, udtSchema = udtSchema.toOption.get, udtName = udtName.toOption.get, scopeCatalog = scopeCatalog.toOption.get, scopeSchema = scopeSchema.toOption.get, scopeName = scopeName.toOption.get, maximumCardinality = maximumCardinality.toOption.get, dtdIdentifier = dtdIdentifier.toOption.get, parameterDefault = parameterDefault.toOption.get))
    else Left(List[Either[String, Any]](specificCatalog, specificSchema, specificName, ordinalPosition, parameterMode, isResult, asLocator, parameterName, dataType, characterMaximumLength, characterOctetLength, characterSetCatalog, characterSetSchema, characterSetName, collationCatalog, collationSchema, collationName, numericPrecision, numericPrecisionRadix, numericScale, datetimePrecision, intervalType, intervalPrecision, udtCatalog, udtSchema, udtName, scopeCatalog, scopeSchema, scopeName, maximumCardinality, dtdIdentifier, parameterDefault).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ParametersViewRow] = new JsonEncoder[ParametersViewRow] {
    override def unsafeEncode(a: ParametersViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""specific_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificCatalog, indent, out)
      out.write(",")
      out.write(""""specific_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificSchema, indent, out)
      out.write(",")
      out.write(""""specific_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificName, indent, out)
      out.write(",")
      out.write(""""ordinal_position":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.ordinalPosition, indent, out)
      out.write(",")
      out.write(""""parameter_mode":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.parameterMode, indent, out)
      out.write(",")
      out.write(""""is_result":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.isResult, indent, out)
      out.write(",")
      out.write(""""as_locator":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.asLocator, indent, out)
      out.write(",")
      out.write(""""parameter_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.parameterName, indent, out)
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
      out.write(""""parameter_default":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.parameterDefault, indent, out)
      out.write("}")
    }
  }
}