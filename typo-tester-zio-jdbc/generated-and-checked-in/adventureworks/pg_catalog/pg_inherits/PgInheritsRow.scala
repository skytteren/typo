/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgInheritsRow(
  inhrelid: /* oid */ Long,
  inhparent: /* oid */ Long,
  inhseqno: Int,
  inhdetachpending: Boolean
){
   val compositeId: PgInheritsId = PgInheritsId(inhrelid, inhseqno)
 }

object PgInheritsRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgInheritsRow] = new JdbcDecoder[PgInheritsRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgInheritsRow) =
      columIndex + 3 ->
        PgInheritsRow(
          inhrelid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 0, rs)._2,
          inhparent = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 1, rs)._2,
          inhseqno = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 2, rs)._2,
          inhdetachpending = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgInheritsRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val inhrelid = jsonObj.get("inhrelid").toRight("Missing field 'inhrelid'").flatMap(_.as(JsonDecoder.long))
    val inhparent = jsonObj.get("inhparent").toRight("Missing field 'inhparent'").flatMap(_.as(JsonDecoder.long))
    val inhseqno = jsonObj.get("inhseqno").toRight("Missing field 'inhseqno'").flatMap(_.as(JsonDecoder.int))
    val inhdetachpending = jsonObj.get("inhdetachpending").toRight("Missing field 'inhdetachpending'").flatMap(_.as(JsonDecoder.boolean))
    if (inhrelid.isRight && inhparent.isRight && inhseqno.isRight && inhdetachpending.isRight)
      Right(PgInheritsRow(inhrelid = inhrelid.toOption.get, inhparent = inhparent.toOption.get, inhseqno = inhseqno.toOption.get, inhdetachpending = inhdetachpending.toOption.get))
    else Left(List[Either[String, Any]](inhrelid, inhparent, inhseqno, inhdetachpending).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgInheritsRow] = new JsonEncoder[PgInheritsRow] {
    override def unsafeEncode(a: PgInheritsRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""inhrelid":""")
      JsonEncoder.long.unsafeEncode(a.inhrelid, indent, out)
      out.write(",")
      out.write(""""inhparent":""")
      JsonEncoder.long.unsafeEncode(a.inhparent, indent, out)
      out.write(",")
      out.write(""""inhseqno":""")
      JsonEncoder.int.unsafeEncode(a.inhseqno, indent, out)
      out.write(",")
      out.write(""""inhdetachpending":""")
      JsonEncoder.boolean.unsafeEncode(a.inhdetachpending, indent, out)
      out.write("}")
    }
  }
}