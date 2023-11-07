/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package check_constraint_routine_usage

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class CheckConstraintRoutineUsageViewRow(
  constraintCatalog: /* nullability unknown */ Option[String],
  constraintSchema: /* nullability unknown */ Option[String],
  constraintName: /* nullability unknown */ Option[String],
  specificCatalog: /* nullability unknown */ Option[String],
  specificSchema: /* nullability unknown */ Option[String],
  specificName: /* nullability unknown */ Option[String]
)

object CheckConstraintRoutineUsageViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[CheckConstraintRoutineUsageViewRow] = new JdbcDecoder[CheckConstraintRoutineUsageViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, CheckConstraintRoutineUsageViewRow) =
      columIndex + 5 ->
        CheckConstraintRoutineUsageViewRow(
          constraintCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          constraintSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          constraintName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          specificCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          specificSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          specificName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[CheckConstraintRoutineUsageViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val constraintCatalog = jsonObj.get("constraint_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val constraintSchema = jsonObj.get("constraint_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val constraintName = jsonObj.get("constraint_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificCatalog = jsonObj.get("specific_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificSchema = jsonObj.get("specific_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificName = jsonObj.get("specific_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (constraintCatalog.isRight && constraintSchema.isRight && constraintName.isRight && specificCatalog.isRight && specificSchema.isRight && specificName.isRight)
      Right(CheckConstraintRoutineUsageViewRow(constraintCatalog = constraintCatalog.toOption.get, constraintSchema = constraintSchema.toOption.get, constraintName = constraintName.toOption.get, specificCatalog = specificCatalog.toOption.get, specificSchema = specificSchema.toOption.get, specificName = specificName.toOption.get))
    else Left(List[Either[String, Any]](constraintCatalog, constraintSchema, constraintName, specificCatalog, specificSchema, specificName).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CheckConstraintRoutineUsageViewRow] = new JsonEncoder[CheckConstraintRoutineUsageViewRow] {
    override def unsafeEncode(a: CheckConstraintRoutineUsageViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""constraint_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.constraintCatalog, indent, out)
      out.write(",")
      out.write(""""constraint_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.constraintSchema, indent, out)
      out.write(",")
      out.write(""""constraint_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.constraintName, indent, out)
      out.write(",")
      out.write(""""specific_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificCatalog, indent, out)
      out.write(",")
      out.write(""""specific_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificSchema, indent, out)
      out.write(",")
      out.write(""""specific_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificName, indent, out)
      out.write("}")
    }
  }
}