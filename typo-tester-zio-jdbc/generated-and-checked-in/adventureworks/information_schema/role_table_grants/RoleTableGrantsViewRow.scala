/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_table_grants

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class RoleTableGrantsViewRow(
  /** Points to [[table_privileges.TablePrivilegesViewRow.grantor]] */
  grantor: Option[/* nullability unknown */ String],
  /** Points to [[table_privileges.TablePrivilegesViewRow.grantee]] */
  grantee: Option[/* nullability unknown */ String],
  /** Points to [[table_privileges.TablePrivilegesViewRow.tableCatalog]] */
  tableCatalog: Option[/* nullability unknown */ String],
  /** Points to [[table_privileges.TablePrivilegesViewRow.tableSchema]] */
  tableSchema: Option[/* nullability unknown */ String],
  /** Points to [[table_privileges.TablePrivilegesViewRow.tableName]] */
  tableName: Option[/* nullability unknown */ String],
  /** Points to [[table_privileges.TablePrivilegesViewRow.privilegeType]] */
  privilegeType: Option[/* nullability unknown */ String],
  /** Points to [[table_privileges.TablePrivilegesViewRow.isGrantable]] */
  isGrantable: Option[/* nullability unknown */ /* max 3 chars */ String],
  /** Points to [[table_privileges.TablePrivilegesViewRow.withHierarchy]] */
  withHierarchy: Option[/* nullability unknown */ /* max 3 chars */ String]
)

object RoleTableGrantsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[RoleTableGrantsViewRow] = new JdbcDecoder[RoleTableGrantsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, RoleTableGrantsViewRow) =
      columIndex + 7 ->
        RoleTableGrantsViewRow(
          grantor = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          grantee = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          tableCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          tableSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          tableName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          privilegeType = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          isGrantable = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          withHierarchy = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[RoleTableGrantsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val grantor = jsonObj.get("grantor").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val grantee = jsonObj.get("grantee").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val tableCatalog = jsonObj.get("table_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val tableSchema = jsonObj.get("table_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val tableName = jsonObj.get("table_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val privilegeType = jsonObj.get("privilege_type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val isGrantable = jsonObj.get("is_grantable").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val withHierarchy = jsonObj.get("with_hierarchy").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (grantor.isRight && grantee.isRight && tableCatalog.isRight && tableSchema.isRight && tableName.isRight && privilegeType.isRight && isGrantable.isRight && withHierarchy.isRight)
      Right(RoleTableGrantsViewRow(grantor = grantor.toOption.get, grantee = grantee.toOption.get, tableCatalog = tableCatalog.toOption.get, tableSchema = tableSchema.toOption.get, tableName = tableName.toOption.get, privilegeType = privilegeType.toOption.get, isGrantable = isGrantable.toOption.get, withHierarchy = withHierarchy.toOption.get))
    else Left(List[Either[String, Any]](grantor, grantee, tableCatalog, tableSchema, tableName, privilegeType, isGrantable, withHierarchy).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[RoleTableGrantsViewRow] = new JsonEncoder[RoleTableGrantsViewRow] {
    override def unsafeEncode(a: RoleTableGrantsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""grantor":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.grantor, indent, out)
      out.write(",")
      out.write(""""grantee":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.grantee, indent, out)
      out.write(",")
      out.write(""""table_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableCatalog, indent, out)
      out.write(",")
      out.write(""""table_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableSchema, indent, out)
      out.write(",")
      out.write(""""table_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableName, indent, out)
      out.write(",")
      out.write(""""privilege_type":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.privilegeType, indent, out)
      out.write(",")
      out.write(""""is_grantable":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.isGrantable, indent, out)
      out.write(",")
      out.write(""""with_hierarchy":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.withHierarchy, indent, out)
      out.write("}")
    }
  }
}