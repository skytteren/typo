/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collations

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class CollationsViewRow(
  collationCatalog: /* nullability unknown */ Option[String],
  collationSchema: /* nullability unknown */ Option[String],
  collationName: /* nullability unknown */ Option[String],
  padAttribute: /* nullability unknown */ Option[String]
)

object CollationsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[CollationsViewRow] = new JdbcDecoder[CollationsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, CollationsViewRow) =
      columIndex + 3 ->
        CollationsViewRow(
          collationCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          collationSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          collationName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          padAttribute = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[CollationsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val collationCatalog = jsonObj.get("collation_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val collationSchema = jsonObj.get("collation_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val collationName = jsonObj.get("collation_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val padAttribute = jsonObj.get("pad_attribute").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (collationCatalog.isRight && collationSchema.isRight && collationName.isRight && padAttribute.isRight)
      Right(CollationsViewRow(collationCatalog = collationCatalog.toOption.get, collationSchema = collationSchema.toOption.get, collationName = collationName.toOption.get, padAttribute = padAttribute.toOption.get))
    else Left(List[Either[String, Any]](collationCatalog, collationSchema, collationName, padAttribute).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CollationsViewRow] = new JsonEncoder[CollationsViewRow] {
    override def unsafeEncode(a: CollationsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""collation_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.collationCatalog, indent, out)
      out.write(",")
      out.write(""""collation_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.collationSchema, indent, out)
      out.write(",")
      out.write(""""collation_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.collationName, indent, out)
      out.write(",")
      out.write(""""pad_attribute":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.padAttribute, indent, out)
      out.write("}")
    }
  }
}