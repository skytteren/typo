/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_auth_members

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgAuthMembersRow(
  roleid: /* oid */ Long,
  member: /* oid */ Long,
  grantor: /* oid */ Long,
  adminOption: Boolean
){
   val compositeId: PgAuthMembersId = PgAuthMembersId(roleid, member)
 }

object PgAuthMembersRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgAuthMembersRow] = new JdbcDecoder[PgAuthMembersRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgAuthMembersRow) =
      columIndex + 3 ->
        PgAuthMembersRow(
          roleid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 0, rs)._2,
          member = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 1, rs)._2,
          grantor = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 2, rs)._2,
          adminOption = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgAuthMembersRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val roleid = jsonObj.get("roleid").toRight("Missing field 'roleid'").flatMap(_.as(JsonDecoder.long))
    val member = jsonObj.get("member").toRight("Missing field 'member'").flatMap(_.as(JsonDecoder.long))
    val grantor = jsonObj.get("grantor").toRight("Missing field 'grantor'").flatMap(_.as(JsonDecoder.long))
    val adminOption = jsonObj.get("admin_option").toRight("Missing field 'admin_option'").flatMap(_.as(JsonDecoder.boolean))
    if (roleid.isRight && member.isRight && grantor.isRight && adminOption.isRight)
      Right(PgAuthMembersRow(roleid = roleid.toOption.get, member = member.toOption.get, grantor = grantor.toOption.get, adminOption = adminOption.toOption.get))
    else Left(List[Either[String, Any]](roleid, member, grantor, adminOption).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgAuthMembersRow] = new JsonEncoder[PgAuthMembersRow] {
    override def unsafeEncode(a: PgAuthMembersRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""roleid":""")
      JsonEncoder.long.unsafeEncode(a.roleid, indent, out)
      out.write(",")
      out.write(""""member":""")
      JsonEncoder.long.unsafeEncode(a.member, indent, out)
      out.write(",")
      out.write(""""grantor":""")
      JsonEncoder.long.unsafeEncode(a.grantor, indent, out)
      out.write(",")
      out.write(""""admin_option":""")
      JsonEncoder.boolean.unsafeEncode(a.adminOption, indent, out)
      out.write("}")
    }
  }
}