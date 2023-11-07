/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package transforms

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class TransformsViewRow(
  udtCatalog: /* nullability unknown */ Option[String],
  udtSchema: /* nullability unknown */ Option[String],
  udtName: /* nullability unknown */ Option[String],
  specificCatalog: /* nullability unknown */ Option[String],
  specificSchema: /* nullability unknown */ Option[String],
  specificName: /* nullability unknown */ Option[String],
  groupName: /* nullability unknown */ Option[String],
  transformType: /* nullability unknown */ Option[String]
)

object TransformsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[TransformsViewRow] = new JdbcDecoder[TransformsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, TransformsViewRow) =
      columIndex + 7 ->
        TransformsViewRow(
          udtCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          udtSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          udtName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          specificCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          specificSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          specificName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          groupName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          transformType = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[TransformsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val udtCatalog = jsonObj.get("udt_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtSchema = jsonObj.get("udt_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtName = jsonObj.get("udt_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificCatalog = jsonObj.get("specific_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificSchema = jsonObj.get("specific_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificName = jsonObj.get("specific_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val groupName = jsonObj.get("group_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val transformType = jsonObj.get("transform_type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (udtCatalog.isRight && udtSchema.isRight && udtName.isRight && specificCatalog.isRight && specificSchema.isRight && specificName.isRight && groupName.isRight && transformType.isRight)
      Right(TransformsViewRow(udtCatalog = udtCatalog.toOption.get, udtSchema = udtSchema.toOption.get, udtName = udtName.toOption.get, specificCatalog = specificCatalog.toOption.get, specificSchema = specificSchema.toOption.get, specificName = specificName.toOption.get, groupName = groupName.toOption.get, transformType = transformType.toOption.get))
    else Left(List[Either[String, Any]](udtCatalog, udtSchema, udtName, specificCatalog, specificSchema, specificName, groupName, transformType).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[TransformsViewRow] = new JsonEncoder[TransformsViewRow] {
    override def unsafeEncode(a: TransformsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""udt_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtCatalog, indent, out)
      out.write(",")
      out.write(""""udt_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtSchema, indent, out)
      out.write(",")
      out.write(""""udt_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtName, indent, out)
      out.write(",")
      out.write(""""specific_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificCatalog, indent, out)
      out.write(",")
      out.write(""""specific_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificSchema, indent, out)
      out.write(",")
      out.write(""""specific_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificName, indent, out)
      out.write(",")
      out.write(""""group_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.groupName, indent, out)
      out.write(",")
      out.write(""""transform_type":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.transformType, indent, out)
      out.write("}")
    }
  }
}