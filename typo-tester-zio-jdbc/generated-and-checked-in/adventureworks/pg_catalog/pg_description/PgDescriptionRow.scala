/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_description

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgDescriptionRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  objsubid: Int,
  description: String
){
   val compositeId: PgDescriptionId = PgDescriptionId(objoid, classoid, objsubid)
 }

object PgDescriptionRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgDescriptionRow] = new JdbcDecoder[PgDescriptionRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgDescriptionRow) =
      columIndex + 3 ->
        PgDescriptionRow(
          objoid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 0, rs)._2,
          classoid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 1, rs)._2,
          objsubid = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 2, rs)._2,
          description = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgDescriptionRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val objoid = jsonObj.get("objoid").toRight("Missing field 'objoid'").flatMap(_.as(JsonDecoder.long))
    val classoid = jsonObj.get("classoid").toRight("Missing field 'classoid'").flatMap(_.as(JsonDecoder.long))
    val objsubid = jsonObj.get("objsubid").toRight("Missing field 'objsubid'").flatMap(_.as(JsonDecoder.int))
    val description = jsonObj.get("description").toRight("Missing field 'description'").flatMap(_.as(JsonDecoder.string))
    if (objoid.isRight && classoid.isRight && objsubid.isRight && description.isRight)
      Right(PgDescriptionRow(objoid = objoid.toOption.get, classoid = classoid.toOption.get, objsubid = objsubid.toOption.get, description = description.toOption.get))
    else Left(List[Either[String, Any]](objoid, classoid, objsubid, description).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgDescriptionRow] = new JsonEncoder[PgDescriptionRow] {
    override def unsafeEncode(a: PgDescriptionRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""objoid":""")
      JsonEncoder.long.unsafeEncode(a.objoid, indent, out)
      out.write(",")
      out.write(""""classoid":""")
      JsonEncoder.long.unsafeEncode(a.classoid, indent, out)
      out.write(",")
      out.write(""""objsubid":""")
      JsonEncoder.int.unsafeEncode(a.objsubid, indent, out)
      out.write(",")
      out.write(""""description":""")
      JsonEncoder.string.unsafeEncode(a.description, indent, out)
      out.write("}")
    }
  }
}