/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mappings

import adventureworks.pg_catalog.pg_foreign_server.PgForeignServerId
import adventureworks.pg_catalog.pg_user_mapping.PgUserMappingId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgUserMappingsViewRow(
  /** Points to [[pg_user_mapping.PgUserMappingRow.oid]] */
  umid: PgUserMappingId,
  /** Points to [[pg_foreign_server.PgForeignServerRow.oid]] */
  srvid: PgForeignServerId,
  /** Points to [[pg_foreign_server.PgForeignServerRow.srvname]] */
  srvname: String,
  /** Points to [[pg_user_mapping.PgUserMappingRow.umuser]] */
  umuser: /* oid */ Long,
  usename: /* nullability unknown */ Option[String],
  umoptions: /* nullability unknown */ Option[Array[String]]
)

object PgUserMappingsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgUserMappingsViewRow] = new JdbcDecoder[PgUserMappingsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgUserMappingsViewRow) =
      columIndex + 5 ->
        PgUserMappingsViewRow(
          umid = PgUserMappingId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          srvid = PgForeignServerId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          srvname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          umuser = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 3, rs)._2,
          usename = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          umoptions = JdbcDecoder.optionDecoder(adventureworks.StringArrayDecoder).unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgUserMappingsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val umid = jsonObj.get("umid").toRight("Missing field 'umid'").flatMap(_.as(PgUserMappingId.jsonDecoder))
    val srvid = jsonObj.get("srvid").toRight("Missing field 'srvid'").flatMap(_.as(PgForeignServerId.jsonDecoder))
    val srvname = jsonObj.get("srvname").toRight("Missing field 'srvname'").flatMap(_.as(JsonDecoder.string))
    val umuser = jsonObj.get("umuser").toRight("Missing field 'umuser'").flatMap(_.as(JsonDecoder.long))
    val usename = jsonObj.get("usename").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val umoptions = jsonObj.get("umoptions").fold[Either[String, Option[Array[String]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[String](JsonDecoder.string, implicitly))))
    if (umid.isRight && srvid.isRight && srvname.isRight && umuser.isRight && usename.isRight && umoptions.isRight)
      Right(PgUserMappingsViewRow(umid = umid.toOption.get, srvid = srvid.toOption.get, srvname = srvname.toOption.get, umuser = umuser.toOption.get, usename = usename.toOption.get, umoptions = umoptions.toOption.get))
    else Left(List[Either[String, Any]](umid, srvid, srvname, umuser, usename, umoptions).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgUserMappingsViewRow] = new JsonEncoder[PgUserMappingsViewRow] {
    override def unsafeEncode(a: PgUserMappingsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""umid":""")
      PgUserMappingId.jsonEncoder.unsafeEncode(a.umid, indent, out)
      out.write(",")
      out.write(""""srvid":""")
      PgForeignServerId.jsonEncoder.unsafeEncode(a.srvid, indent, out)
      out.write(",")
      out.write(""""srvname":""")
      JsonEncoder.string.unsafeEncode(a.srvname, indent, out)
      out.write(",")
      out.write(""""umuser":""")
      JsonEncoder.long.unsafeEncode(a.umuser, indent, out)
      out.write(",")
      out.write(""""usename":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.usename, indent, out)
      out.write(",")
      out.write(""""umoptions":""")
      JsonEncoder.option(JsonEncoder.array[String](JsonEncoder.string, implicitly)).unsafeEncode(a.umoptions, indent, out)
      out.write("}")
    }
  }
}