/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_tables

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ForeignTablesViewRow(
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableCatalog]] */
  foreignTableCatalog: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableSchema]] */
  foreignTableSchema: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableName]] */
  foreignTableName: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignServerName]] */
  foreignServerName: Option[/* nullability unknown */ String]
)

object ForeignTablesViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ForeignTablesViewRow] = new JdbcDecoder[ForeignTablesViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ForeignTablesViewRow) =
      columIndex + 4 ->
        ForeignTablesViewRow(
          foreignTableCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          foreignTableSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          foreignTableName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          foreignServerCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          foreignServerName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ForeignTablesViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val foreignTableCatalog = jsonObj.get("foreign_table_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val foreignTableSchema = jsonObj.get("foreign_table_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val foreignTableName = jsonObj.get("foreign_table_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val foreignServerCatalog = jsonObj.get("foreign_server_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val foreignServerName = jsonObj.get("foreign_server_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (foreignTableCatalog.isRight && foreignTableSchema.isRight && foreignTableName.isRight && foreignServerCatalog.isRight && foreignServerName.isRight)
      Right(ForeignTablesViewRow(foreignTableCatalog = foreignTableCatalog.toOption.get, foreignTableSchema = foreignTableSchema.toOption.get, foreignTableName = foreignTableName.toOption.get, foreignServerCatalog = foreignServerCatalog.toOption.get, foreignServerName = foreignServerName.toOption.get))
    else Left(List[Either[String, Any]](foreignTableCatalog, foreignTableSchema, foreignTableName, foreignServerCatalog, foreignServerName).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ForeignTablesViewRow] = new JsonEncoder[ForeignTablesViewRow] {
    override def unsafeEncode(a: ForeignTablesViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""foreign_table_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignTableCatalog, indent, out)
      out.write(",")
      out.write(""""foreign_table_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignTableSchema, indent, out)
      out.write(",")
      out.write(""""foreign_table_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignTableName, indent, out)
      out.write(",")
      out.write(""""foreign_server_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignServerCatalog, indent, out)
      out.write(",")
      out.write(""""foreign_server_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignServerName, indent, out)
      out.write("}")
    }
  }
}