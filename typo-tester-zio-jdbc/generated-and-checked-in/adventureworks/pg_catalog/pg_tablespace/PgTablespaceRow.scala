/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tablespace

import adventureworks.customtypes.TypoAclItem
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgTablespaceRow(
  oid: PgTablespaceId,
  spcname: String,
  spcowner: /* oid */ Long,
  spcacl: Option[Array[TypoAclItem]],
  spcoptions: Option[Array[String]]
)

object PgTablespaceRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgTablespaceRow] = new JdbcDecoder[PgTablespaceRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgTablespaceRow) =
      columIndex + 4 ->
        PgTablespaceRow(
          oid = PgTablespaceId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          spcname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          spcowner = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 2, rs)._2,
          spcacl = JdbcDecoder.optionDecoder(JdbcDecoder[Array[TypoAclItem]]).unsafeDecode(columIndex + 3, rs)._2,
          spcoptions = JdbcDecoder.optionDecoder(adventureworks.StringArrayDecoder).unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgTablespaceRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val oid = jsonObj.get("oid").toRight("Missing field 'oid'").flatMap(_.as(PgTablespaceId.jsonDecoder))
    val spcname = jsonObj.get("spcname").toRight("Missing field 'spcname'").flatMap(_.as(JsonDecoder.string))
    val spcowner = jsonObj.get("spcowner").toRight("Missing field 'spcowner'").flatMap(_.as(JsonDecoder.long))
    val spcacl = jsonObj.get("spcacl").fold[Either[String, Option[Array[TypoAclItem]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[TypoAclItem](TypoAclItem.jsonDecoder, implicitly))))
    val spcoptions = jsonObj.get("spcoptions").fold[Either[String, Option[Array[String]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[String](JsonDecoder.string, implicitly))))
    if (oid.isRight && spcname.isRight && spcowner.isRight && spcacl.isRight && spcoptions.isRight)
      Right(PgTablespaceRow(oid = oid.toOption.get, spcname = spcname.toOption.get, spcowner = spcowner.toOption.get, spcacl = spcacl.toOption.get, spcoptions = spcoptions.toOption.get))
    else Left(List[Either[String, Any]](oid, spcname, spcowner, spcacl, spcoptions).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgTablespaceRow] = new JsonEncoder[PgTablespaceRow] {
    override def unsafeEncode(a: PgTablespaceRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""oid":""")
      PgTablespaceId.jsonEncoder.unsafeEncode(a.oid, indent, out)
      out.write(",")
      out.write(""""spcname":""")
      JsonEncoder.string.unsafeEncode(a.spcname, indent, out)
      out.write(",")
      out.write(""""spcowner":""")
      JsonEncoder.long.unsafeEncode(a.spcowner, indent, out)
      out.write(",")
      out.write(""""spcacl":""")
      JsonEncoder.option(JsonEncoder.array[TypoAclItem](TypoAclItem.jsonEncoder, implicitly)).unsafeEncode(a.spcacl, indent, out)
      out.write(",")
      out.write(""""spcoptions":""")
      JsonEncoder.option(JsonEncoder.array[String](JsonEncoder.string, implicitly)).unsafeEncode(a.spcoptions, indent, out)
      out.write("}")
    }
  }
}