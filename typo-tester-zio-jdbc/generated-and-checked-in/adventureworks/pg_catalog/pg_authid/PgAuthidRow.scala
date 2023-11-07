/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_authid

import adventureworks.customtypes.TypoInstant
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgAuthidRow(
  oid: PgAuthidId,
  rolname: String,
  rolsuper: Boolean,
  rolinherit: Boolean,
  rolcreaterole: Boolean,
  rolcreatedb: Boolean,
  rolcanlogin: Boolean,
  rolreplication: Boolean,
  rolbypassrls: Boolean,
  rolconnlimit: Int,
  rolpassword: Option[String],
  rolvaliduntil: Option[TypoInstant]
)

object PgAuthidRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgAuthidRow] = new JdbcDecoder[PgAuthidRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgAuthidRow) =
      columIndex + 11 ->
        PgAuthidRow(
          oid = PgAuthidId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          rolname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          rolsuper = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 2, rs)._2,
          rolinherit = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 3, rs)._2,
          rolcreaterole = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 4, rs)._2,
          rolcreatedb = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 5, rs)._2,
          rolcanlogin = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 6, rs)._2,
          rolreplication = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 7, rs)._2,
          rolbypassrls = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 8, rs)._2,
          rolconnlimit = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 9, rs)._2,
          rolpassword = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 10, rs)._2,
          rolvaliduntil = JdbcDecoder.optionDecoder(TypoInstant.jdbcDecoder).unsafeDecode(columIndex + 11, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgAuthidRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val oid = jsonObj.get("oid").toRight("Missing field 'oid'").flatMap(_.as(PgAuthidId.jsonDecoder))
    val rolname = jsonObj.get("rolname").toRight("Missing field 'rolname'").flatMap(_.as(JsonDecoder.string))
    val rolsuper = jsonObj.get("rolsuper").toRight("Missing field 'rolsuper'").flatMap(_.as(JsonDecoder.boolean))
    val rolinherit = jsonObj.get("rolinherit").toRight("Missing field 'rolinherit'").flatMap(_.as(JsonDecoder.boolean))
    val rolcreaterole = jsonObj.get("rolcreaterole").toRight("Missing field 'rolcreaterole'").flatMap(_.as(JsonDecoder.boolean))
    val rolcreatedb = jsonObj.get("rolcreatedb").toRight("Missing field 'rolcreatedb'").flatMap(_.as(JsonDecoder.boolean))
    val rolcanlogin = jsonObj.get("rolcanlogin").toRight("Missing field 'rolcanlogin'").flatMap(_.as(JsonDecoder.boolean))
    val rolreplication = jsonObj.get("rolreplication").toRight("Missing field 'rolreplication'").flatMap(_.as(JsonDecoder.boolean))
    val rolbypassrls = jsonObj.get("rolbypassrls").toRight("Missing field 'rolbypassrls'").flatMap(_.as(JsonDecoder.boolean))
    val rolconnlimit = jsonObj.get("rolconnlimit").toRight("Missing field 'rolconnlimit'").flatMap(_.as(JsonDecoder.int))
    val rolpassword = jsonObj.get("rolpassword").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val rolvaliduntil = jsonObj.get("rolvaliduntil").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(TypoInstant.jsonDecoder)))
    if (oid.isRight && rolname.isRight && rolsuper.isRight && rolinherit.isRight && rolcreaterole.isRight && rolcreatedb.isRight && rolcanlogin.isRight && rolreplication.isRight && rolbypassrls.isRight && rolconnlimit.isRight && rolpassword.isRight && rolvaliduntil.isRight)
      Right(PgAuthidRow(oid = oid.toOption.get, rolname = rolname.toOption.get, rolsuper = rolsuper.toOption.get, rolinherit = rolinherit.toOption.get, rolcreaterole = rolcreaterole.toOption.get, rolcreatedb = rolcreatedb.toOption.get, rolcanlogin = rolcanlogin.toOption.get, rolreplication = rolreplication.toOption.get, rolbypassrls = rolbypassrls.toOption.get, rolconnlimit = rolconnlimit.toOption.get, rolpassword = rolpassword.toOption.get, rolvaliduntil = rolvaliduntil.toOption.get))
    else Left(List[Either[String, Any]](oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgAuthidRow] = new JsonEncoder[PgAuthidRow] {
    override def unsafeEncode(a: PgAuthidRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""oid":""")
      PgAuthidId.jsonEncoder.unsafeEncode(a.oid, indent, out)
      out.write(",")
      out.write(""""rolname":""")
      JsonEncoder.string.unsafeEncode(a.rolname, indent, out)
      out.write(",")
      out.write(""""rolsuper":""")
      JsonEncoder.boolean.unsafeEncode(a.rolsuper, indent, out)
      out.write(",")
      out.write(""""rolinherit":""")
      JsonEncoder.boolean.unsafeEncode(a.rolinherit, indent, out)
      out.write(",")
      out.write(""""rolcreaterole":""")
      JsonEncoder.boolean.unsafeEncode(a.rolcreaterole, indent, out)
      out.write(",")
      out.write(""""rolcreatedb":""")
      JsonEncoder.boolean.unsafeEncode(a.rolcreatedb, indent, out)
      out.write(",")
      out.write(""""rolcanlogin":""")
      JsonEncoder.boolean.unsafeEncode(a.rolcanlogin, indent, out)
      out.write(",")
      out.write(""""rolreplication":""")
      JsonEncoder.boolean.unsafeEncode(a.rolreplication, indent, out)
      out.write(",")
      out.write(""""rolbypassrls":""")
      JsonEncoder.boolean.unsafeEncode(a.rolbypassrls, indent, out)
      out.write(",")
      out.write(""""rolconnlimit":""")
      JsonEncoder.int.unsafeEncode(a.rolconnlimit, indent, out)
      out.write(",")
      out.write(""""rolpassword":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.rolpassword, indent, out)
      out.write(",")
      out.write(""""rolvaliduntil":""")
      JsonEncoder.option(TypoInstant.jsonEncoder).unsafeEncode(a.rolvaliduntil, indent, out)
      out.write("}")
    }
  }
}