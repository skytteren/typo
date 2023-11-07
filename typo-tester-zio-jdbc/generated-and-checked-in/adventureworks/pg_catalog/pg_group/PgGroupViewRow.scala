/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_group

import adventureworks.pg_catalog.pg_authid.PgAuthidId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgGroupViewRow(
  /** Points to [[pg_authid.PgAuthidRow.rolname]] */
  groname: String,
  /** Points to [[pg_authid.PgAuthidRow.oid]] */
  grosysid: PgAuthidId,
  grolist: /* nullability unknown */ Option[Array[/* oid */ Long]]
)

object PgGroupViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgGroupViewRow] = new JdbcDecoder[PgGroupViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgGroupViewRow) =
      columIndex + 2 ->
        PgGroupViewRow(
          groname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 0, rs)._2,
          grosysid = PgAuthidId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          grolist = JdbcDecoder.optionDecoder(adventureworks.LongArrayDecoder).unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgGroupViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val groname = jsonObj.get("groname").toRight("Missing field 'groname'").flatMap(_.as(JsonDecoder.string))
    val grosysid = jsonObj.get("grosysid").toRight("Missing field 'grosysid'").flatMap(_.as(PgAuthidId.jsonDecoder))
    val grolist = jsonObj.get("grolist").fold[Either[String, Option[Array[Long]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[Long](JsonDecoder.long, implicitly))))
    if (groname.isRight && grosysid.isRight && grolist.isRight)
      Right(PgGroupViewRow(groname = groname.toOption.get, grosysid = grosysid.toOption.get, grolist = grolist.toOption.get))
    else Left(List[Either[String, Any]](groname, grosysid, grolist).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgGroupViewRow] = new JsonEncoder[PgGroupViewRow] {
    override def unsafeEncode(a: PgGroupViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""groname":""")
      JsonEncoder.string.unsafeEncode(a.groname, indent, out)
      out.write(",")
      out.write(""""grosysid":""")
      PgAuthidId.jsonEncoder.unsafeEncode(a.grosysid, indent, out)
      out.write(",")
      out.write(""""grolist":""")
      JsonEncoder.option(JsonEncoder.array[Long](JsonEncoder.long, implicitly)).unsafeEncode(a.grolist, indent, out)
      out.write("}")
    }
  }
}