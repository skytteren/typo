/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrapper_options

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ForeignDataWrapperOptionsViewRow(
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperCatalog]] */
  foreignDataWrapperCatalog: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperName]] */
  foreignDataWrapperName: Option[/* nullability unknown */ String],
  optionName: /* nullability unknown */ Option[String],
  optionValue: /* nullability unknown */ Option[String]
)

object ForeignDataWrapperOptionsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ForeignDataWrapperOptionsViewRow] = new JdbcDecoder[ForeignDataWrapperOptionsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ForeignDataWrapperOptionsViewRow) =
      columIndex + 3 ->
        ForeignDataWrapperOptionsViewRow(
          foreignDataWrapperCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          foreignDataWrapperName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          optionName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          optionValue = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ForeignDataWrapperOptionsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val foreignDataWrapperCatalog = jsonObj.get("foreign_data_wrapper_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val foreignDataWrapperName = jsonObj.get("foreign_data_wrapper_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val optionName = jsonObj.get("option_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val optionValue = jsonObj.get("option_value").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (foreignDataWrapperCatalog.isRight && foreignDataWrapperName.isRight && optionName.isRight && optionValue.isRight)
      Right(ForeignDataWrapperOptionsViewRow(foreignDataWrapperCatalog = foreignDataWrapperCatalog.toOption.get, foreignDataWrapperName = foreignDataWrapperName.toOption.get, optionName = optionName.toOption.get, optionValue = optionValue.toOption.get))
    else Left(List[Either[String, Any]](foreignDataWrapperCatalog, foreignDataWrapperName, optionName, optionValue).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ForeignDataWrapperOptionsViewRow] = new JsonEncoder[ForeignDataWrapperOptionsViewRow] {
    override def unsafeEncode(a: ForeignDataWrapperOptionsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""foreign_data_wrapper_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignDataWrapperCatalog, indent, out)
      out.write(",")
      out.write(""""foreign_data_wrapper_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignDataWrapperName, indent, out)
      out.write(",")
      out.write(""""option_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.optionName, indent, out)
      out.write(",")
      out.write(""""option_value":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.optionValue, indent, out)
      out.write("}")
    }
  }
}