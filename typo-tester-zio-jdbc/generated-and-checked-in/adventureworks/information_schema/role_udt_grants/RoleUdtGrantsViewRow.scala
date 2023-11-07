/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_udt_grants

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class RoleUdtGrantsViewRow(
  /** Points to [[udt_privileges.UdtPrivilegesViewRow.grantor]] */
  grantor: Option[/* nullability unknown */ String],
  /** Points to [[udt_privileges.UdtPrivilegesViewRow.grantee]] */
  grantee: Option[/* nullability unknown */ String],
  /** Points to [[udt_privileges.UdtPrivilegesViewRow.udtCatalog]] */
  udtCatalog: Option[/* nullability unknown */ String],
  /** Points to [[udt_privileges.UdtPrivilegesViewRow.udtSchema]] */
  udtSchema: Option[/* nullability unknown */ String],
  /** Points to [[udt_privileges.UdtPrivilegesViewRow.udtName]] */
  udtName: Option[/* nullability unknown */ String],
  /** Points to [[udt_privileges.UdtPrivilegesViewRow.privilegeType]] */
  privilegeType: Option[/* nullability unknown */ String],
  /** Points to [[udt_privileges.UdtPrivilegesViewRow.isGrantable]] */
  isGrantable: Option[/* nullability unknown */ /* max 3 chars */ String]
)

object RoleUdtGrantsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[RoleUdtGrantsViewRow] = new JdbcDecoder[RoleUdtGrantsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, RoleUdtGrantsViewRow) =
      columIndex + 6 ->
        RoleUdtGrantsViewRow(
          grantor = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          grantee = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          udtCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          udtSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          udtName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          privilegeType = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          isGrantable = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[RoleUdtGrantsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val grantor = jsonObj.get("grantor").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val grantee = jsonObj.get("grantee").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtCatalog = jsonObj.get("udt_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtSchema = jsonObj.get("udt_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val udtName = jsonObj.get("udt_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val privilegeType = jsonObj.get("privilege_type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val isGrantable = jsonObj.get("is_grantable").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (grantor.isRight && grantee.isRight && udtCatalog.isRight && udtSchema.isRight && udtName.isRight && privilegeType.isRight && isGrantable.isRight)
      Right(RoleUdtGrantsViewRow(grantor = grantor.toOption.get, grantee = grantee.toOption.get, udtCatalog = udtCatalog.toOption.get, udtSchema = udtSchema.toOption.get, udtName = udtName.toOption.get, privilegeType = privilegeType.toOption.get, isGrantable = isGrantable.toOption.get))
    else Left(List[Either[String, Any]](grantor, grantee, udtCatalog, udtSchema, udtName, privilegeType, isGrantable).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[RoleUdtGrantsViewRow] = new JsonEncoder[RoleUdtGrantsViewRow] {
    override def unsafeEncode(a: RoleUdtGrantsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""grantor":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.grantor, indent, out)
      out.write(",")
      out.write(""""grantee":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.grantee, indent, out)
      out.write(",")
      out.write(""""udt_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtCatalog, indent, out)
      out.write(",")
      out.write(""""udt_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtSchema, indent, out)
      out.write(",")
      out.write(""""udt_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.udtName, indent, out)
      out.write(",")
      out.write(""""privilege_type":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.privilegeType, indent, out)
      out.write(",")
      out.write(""""is_grantable":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.isGrantable, indent, out)
      out.write("}")
    }
  }
}