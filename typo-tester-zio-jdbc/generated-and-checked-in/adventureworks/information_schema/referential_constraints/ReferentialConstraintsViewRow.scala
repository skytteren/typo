/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package referential_constraints

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ReferentialConstraintsViewRow(
  constraintCatalog: /* nullability unknown */ Option[String],
  constraintSchema: /* nullability unknown */ Option[String],
  constraintName: /* nullability unknown */ Option[String],
  uniqueConstraintCatalog: /* nullability unknown */ Option[String],
  uniqueConstraintSchema: /* nullability unknown */ Option[String],
  uniqueConstraintName: /* nullability unknown */ Option[String],
  matchOption: /* nullability unknown */ Option[String],
  updateRule: /* nullability unknown */ Option[String],
  deleteRule: /* nullability unknown */ Option[String]
)

object ReferentialConstraintsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ReferentialConstraintsViewRow] = new JdbcDecoder[ReferentialConstraintsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ReferentialConstraintsViewRow) =
      columIndex + 8 ->
        ReferentialConstraintsViewRow(
          constraintCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          constraintSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          constraintName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          uniqueConstraintCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          uniqueConstraintSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          uniqueConstraintName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          matchOption = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          updateRule = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          deleteRule = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ReferentialConstraintsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val constraintCatalog = jsonObj.get("constraint_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val constraintSchema = jsonObj.get("constraint_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val constraintName = jsonObj.get("constraint_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val uniqueConstraintCatalog = jsonObj.get("unique_constraint_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val uniqueConstraintSchema = jsonObj.get("unique_constraint_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val uniqueConstraintName = jsonObj.get("unique_constraint_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val matchOption = jsonObj.get("match_option").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val updateRule = jsonObj.get("update_rule").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val deleteRule = jsonObj.get("delete_rule").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (constraintCatalog.isRight && constraintSchema.isRight && constraintName.isRight && uniqueConstraintCatalog.isRight && uniqueConstraintSchema.isRight && uniqueConstraintName.isRight && matchOption.isRight && updateRule.isRight && deleteRule.isRight)
      Right(ReferentialConstraintsViewRow(constraintCatalog = constraintCatalog.toOption.get, constraintSchema = constraintSchema.toOption.get, constraintName = constraintName.toOption.get, uniqueConstraintCatalog = uniqueConstraintCatalog.toOption.get, uniqueConstraintSchema = uniqueConstraintSchema.toOption.get, uniqueConstraintName = uniqueConstraintName.toOption.get, matchOption = matchOption.toOption.get, updateRule = updateRule.toOption.get, deleteRule = deleteRule.toOption.get))
    else Left(List[Either[String, Any]](constraintCatalog, constraintSchema, constraintName, uniqueConstraintCatalog, uniqueConstraintSchema, uniqueConstraintName, matchOption, updateRule, deleteRule).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ReferentialConstraintsViewRow] = new JsonEncoder[ReferentialConstraintsViewRow] {
    override def unsafeEncode(a: ReferentialConstraintsViewRow, indent: Option[Int], out: Write): Unit = {
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
      out.write(""""unique_constraint_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.uniqueConstraintCatalog, indent, out)
      out.write(",")
      out.write(""""unique_constraint_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.uniqueConstraintSchema, indent, out)
      out.write(",")
      out.write(""""unique_constraint_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.uniqueConstraintName, indent, out)
      out.write(",")
      out.write(""""match_option":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.matchOption, indent, out)
      out.write(",")
      out.write(""""update_rule":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.updateRule, indent, out)
      out.write(",")
      out.write(""""delete_rule":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.deleteRule, indent, out)
      out.write("}")
    }
  }
}