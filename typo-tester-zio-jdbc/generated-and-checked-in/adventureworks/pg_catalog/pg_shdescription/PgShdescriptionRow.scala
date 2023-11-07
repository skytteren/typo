/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdescription

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgShdescriptionRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  description: String
){
   val compositeId: PgShdescriptionId = PgShdescriptionId(objoid, classoid)
 }

object PgShdescriptionRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgShdescriptionRow] = new JdbcDecoder[PgShdescriptionRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgShdescriptionRow) =
      columIndex + 2 ->
        PgShdescriptionRow(
          objoid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 0, rs)._2,
          classoid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 1, rs)._2,
          description = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgShdescriptionRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val objoid = jsonObj.get("objoid").toRight("Missing field 'objoid'").flatMap(_.as(JsonDecoder.long))
    val classoid = jsonObj.get("classoid").toRight("Missing field 'classoid'").flatMap(_.as(JsonDecoder.long))
    val description = jsonObj.get("description").toRight("Missing field 'description'").flatMap(_.as(JsonDecoder.string))
    if (objoid.isRight && classoid.isRight && description.isRight)
      Right(PgShdescriptionRow(objoid = objoid.toOption.get, classoid = classoid.toOption.get, description = description.toOption.get))
    else Left(List[Either[String, Any]](objoid, classoid, description).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgShdescriptionRow] = new JsonEncoder[PgShdescriptionRow] {
    override def unsafeEncode(a: PgShdescriptionRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""objoid":""")
      JsonEncoder.long.unsafeEncode(a.objoid, indent, out)
      out.write(",")
      out.write(""""classoid":""")
      JsonEncoder.long.unsafeEncode(a.classoid, indent, out)
      out.write(",")
      out.write(""""description":""")
      JsonEncoder.string.unsafeEncode(a.description, indent, out)
      out.write("}")
    }
  }
}