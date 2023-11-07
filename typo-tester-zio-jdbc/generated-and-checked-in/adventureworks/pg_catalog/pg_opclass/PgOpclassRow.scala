/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opclass

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgOpclassRow(
  oid: PgOpclassId,
  opcmethod: /* oid */ Long,
  opcname: String,
  opcnamespace: /* oid */ Long,
  opcowner: /* oid */ Long,
  opcfamily: /* oid */ Long,
  opcintype: /* oid */ Long,
  opcdefault: Boolean,
  opckeytype: /* oid */ Long
)

object PgOpclassRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgOpclassRow] = new JdbcDecoder[PgOpclassRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgOpclassRow) =
      columIndex + 8 ->
        PgOpclassRow(
          oid = PgOpclassId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          opcmethod = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 1, rs)._2,
          opcname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          opcnamespace = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 3, rs)._2,
          opcowner = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 4, rs)._2,
          opcfamily = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 5, rs)._2,
          opcintype = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 6, rs)._2,
          opcdefault = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 7, rs)._2,
          opckeytype = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgOpclassRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val oid = jsonObj.get("oid").toRight("Missing field 'oid'").flatMap(_.as(PgOpclassId.jsonDecoder))
    val opcmethod = jsonObj.get("opcmethod").toRight("Missing field 'opcmethod'").flatMap(_.as(JsonDecoder.long))
    val opcname = jsonObj.get("opcname").toRight("Missing field 'opcname'").flatMap(_.as(JsonDecoder.string))
    val opcnamespace = jsonObj.get("opcnamespace").toRight("Missing field 'opcnamespace'").flatMap(_.as(JsonDecoder.long))
    val opcowner = jsonObj.get("opcowner").toRight("Missing field 'opcowner'").flatMap(_.as(JsonDecoder.long))
    val opcfamily = jsonObj.get("opcfamily").toRight("Missing field 'opcfamily'").flatMap(_.as(JsonDecoder.long))
    val opcintype = jsonObj.get("opcintype").toRight("Missing field 'opcintype'").flatMap(_.as(JsonDecoder.long))
    val opcdefault = jsonObj.get("opcdefault").toRight("Missing field 'opcdefault'").flatMap(_.as(JsonDecoder.boolean))
    val opckeytype = jsonObj.get("opckeytype").toRight("Missing field 'opckeytype'").flatMap(_.as(JsonDecoder.long))
    if (oid.isRight && opcmethod.isRight && opcname.isRight && opcnamespace.isRight && opcowner.isRight && opcfamily.isRight && opcintype.isRight && opcdefault.isRight && opckeytype.isRight)
      Right(PgOpclassRow(oid = oid.toOption.get, opcmethod = opcmethod.toOption.get, opcname = opcname.toOption.get, opcnamespace = opcnamespace.toOption.get, opcowner = opcowner.toOption.get, opcfamily = opcfamily.toOption.get, opcintype = opcintype.toOption.get, opcdefault = opcdefault.toOption.get, opckeytype = opckeytype.toOption.get))
    else Left(List[Either[String, Any]](oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgOpclassRow] = new JsonEncoder[PgOpclassRow] {
    override def unsafeEncode(a: PgOpclassRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""oid":""")
      PgOpclassId.jsonEncoder.unsafeEncode(a.oid, indent, out)
      out.write(",")
      out.write(""""opcmethod":""")
      JsonEncoder.long.unsafeEncode(a.opcmethod, indent, out)
      out.write(",")
      out.write(""""opcname":""")
      JsonEncoder.string.unsafeEncode(a.opcname, indent, out)
      out.write(",")
      out.write(""""opcnamespace":""")
      JsonEncoder.long.unsafeEncode(a.opcnamespace, indent, out)
      out.write(",")
      out.write(""""opcowner":""")
      JsonEncoder.long.unsafeEncode(a.opcowner, indent, out)
      out.write(",")
      out.write(""""opcfamily":""")
      JsonEncoder.long.unsafeEncode(a.opcfamily, indent, out)
      out.write(",")
      out.write(""""opcintype":""")
      JsonEncoder.long.unsafeEncode(a.opcintype, indent, out)
      out.write(",")
      out.write(""""opcdefault":""")
      JsonEncoder.boolean.unsafeEncode(a.opcdefault, indent, out)
      out.write(",")
      out.write(""""opckeytype":""")
      JsonEncoder.long.unsafeEncode(a.opckeytype, indent, out)
      out.write("}")
    }
  }
}