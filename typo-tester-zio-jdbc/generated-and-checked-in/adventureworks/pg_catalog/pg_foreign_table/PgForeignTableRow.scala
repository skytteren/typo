/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_table

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgForeignTableRow(
  ftrelid: PgForeignTableId,
  ftserver: /* oid */ Long,
  ftoptions: Option[Array[String]]
)

object PgForeignTableRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgForeignTableRow] = new JdbcDecoder[PgForeignTableRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgForeignTableRow) =
      columIndex + 2 ->
        PgForeignTableRow(
          ftrelid = PgForeignTableId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          ftserver = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 1, rs)._2,
          ftoptions = JdbcDecoder.optionDecoder(adventureworks.StringArrayDecoder).unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgForeignTableRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val ftrelid = jsonObj.get("ftrelid").toRight("Missing field 'ftrelid'").flatMap(_.as(PgForeignTableId.jsonDecoder))
    val ftserver = jsonObj.get("ftserver").toRight("Missing field 'ftserver'").flatMap(_.as(JsonDecoder.long))
    val ftoptions = jsonObj.get("ftoptions").fold[Either[String, Option[Array[String]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[String](JsonDecoder.string, implicitly))))
    if (ftrelid.isRight && ftserver.isRight && ftoptions.isRight)
      Right(PgForeignTableRow(ftrelid = ftrelid.toOption.get, ftserver = ftserver.toOption.get, ftoptions = ftoptions.toOption.get))
    else Left(List[Either[String, Any]](ftrelid, ftserver, ftoptions).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgForeignTableRow] = new JsonEncoder[PgForeignTableRow] {
    override def unsafeEncode(a: PgForeignTableRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""ftrelid":""")
      PgForeignTableId.jsonEncoder.unsafeEncode(a.ftrelid, indent, out)
      out.write(",")
      out.write(""""ftserver":""")
      JsonEncoder.long.unsafeEncode(a.ftserver, indent, out)
      out.write(",")
      out.write(""""ftoptions":""")
      JsonEncoder.option(JsonEncoder.array[String](JsonEncoder.string, implicitly)).unsafeEncode(a.ftoptions, indent, out)
      out.write("}")
    }
  }
}