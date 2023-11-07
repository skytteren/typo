/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_language

import adventureworks.customtypes.TypoAclItem
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgLanguageRow(
  oid: PgLanguageId,
  lanname: String,
  lanowner: /* oid */ Long,
  lanispl: Boolean,
  lanpltrusted: Boolean,
  lanplcallfoid: /* oid */ Long,
  laninline: /* oid */ Long,
  lanvalidator: /* oid */ Long,
  lanacl: Option[Array[TypoAclItem]]
)

object PgLanguageRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgLanguageRow] = new JdbcDecoder[PgLanguageRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgLanguageRow) =
      columIndex + 8 ->
        PgLanguageRow(
          oid = PgLanguageId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          lanname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          lanowner = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 2, rs)._2,
          lanispl = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 3, rs)._2,
          lanpltrusted = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 4, rs)._2,
          lanplcallfoid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 5, rs)._2,
          laninline = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 6, rs)._2,
          lanvalidator = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 7, rs)._2,
          lanacl = JdbcDecoder.optionDecoder(JdbcDecoder[Array[TypoAclItem]]).unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgLanguageRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val oid = jsonObj.get("oid").toRight("Missing field 'oid'").flatMap(_.as(PgLanguageId.jsonDecoder))
    val lanname = jsonObj.get("lanname").toRight("Missing field 'lanname'").flatMap(_.as(JsonDecoder.string))
    val lanowner = jsonObj.get("lanowner").toRight("Missing field 'lanowner'").flatMap(_.as(JsonDecoder.long))
    val lanispl = jsonObj.get("lanispl").toRight("Missing field 'lanispl'").flatMap(_.as(JsonDecoder.boolean))
    val lanpltrusted = jsonObj.get("lanpltrusted").toRight("Missing field 'lanpltrusted'").flatMap(_.as(JsonDecoder.boolean))
    val lanplcallfoid = jsonObj.get("lanplcallfoid").toRight("Missing field 'lanplcallfoid'").flatMap(_.as(JsonDecoder.long))
    val laninline = jsonObj.get("laninline").toRight("Missing field 'laninline'").flatMap(_.as(JsonDecoder.long))
    val lanvalidator = jsonObj.get("lanvalidator").toRight("Missing field 'lanvalidator'").flatMap(_.as(JsonDecoder.long))
    val lanacl = jsonObj.get("lanacl").fold[Either[String, Option[Array[TypoAclItem]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[TypoAclItem](TypoAclItem.jsonDecoder, implicitly))))
    if (oid.isRight && lanname.isRight && lanowner.isRight && lanispl.isRight && lanpltrusted.isRight && lanplcallfoid.isRight && laninline.isRight && lanvalidator.isRight && lanacl.isRight)
      Right(PgLanguageRow(oid = oid.toOption.get, lanname = lanname.toOption.get, lanowner = lanowner.toOption.get, lanispl = lanispl.toOption.get, lanpltrusted = lanpltrusted.toOption.get, lanplcallfoid = lanplcallfoid.toOption.get, laninline = laninline.toOption.get, lanvalidator = lanvalidator.toOption.get, lanacl = lanacl.toOption.get))
    else Left(List[Either[String, Any]](oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgLanguageRow] = new JsonEncoder[PgLanguageRow] {
    override def unsafeEncode(a: PgLanguageRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""oid":""")
      PgLanguageId.jsonEncoder.unsafeEncode(a.oid, indent, out)
      out.write(",")
      out.write(""""lanname":""")
      JsonEncoder.string.unsafeEncode(a.lanname, indent, out)
      out.write(",")
      out.write(""""lanowner":""")
      JsonEncoder.long.unsafeEncode(a.lanowner, indent, out)
      out.write(",")
      out.write(""""lanispl":""")
      JsonEncoder.boolean.unsafeEncode(a.lanispl, indent, out)
      out.write(",")
      out.write(""""lanpltrusted":""")
      JsonEncoder.boolean.unsafeEncode(a.lanpltrusted, indent, out)
      out.write(",")
      out.write(""""lanplcallfoid":""")
      JsonEncoder.long.unsafeEncode(a.lanplcallfoid, indent, out)
      out.write(",")
      out.write(""""laninline":""")
      JsonEncoder.long.unsafeEncode(a.laninline, indent, out)
      out.write(",")
      out.write(""""lanvalidator":""")
      JsonEncoder.long.unsafeEncode(a.lanvalidator, indent, out)
      out.write(",")
      out.write(""""lanacl":""")
      JsonEncoder.option(JsonEncoder.array[TypoAclItem](TypoAclItem.jsonEncoder, implicitly)).unsafeEncode(a.lanacl, indent, out)
      out.write("}")
    }
  }
}