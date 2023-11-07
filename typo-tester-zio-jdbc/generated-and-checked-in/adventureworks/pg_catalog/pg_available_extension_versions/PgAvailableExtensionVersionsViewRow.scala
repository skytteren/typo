/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_available_extension_versions

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgAvailableExtensionVersionsViewRow(
  name: /* nullability unknown */ Option[String],
  version: /* nullability unknown */ Option[String],
  installed: /* nullability unknown */ Option[Boolean],
  superuser: /* nullability unknown */ Option[Boolean],
  trusted: /* nullability unknown */ Option[Boolean],
  relocatable: /* nullability unknown */ Option[Boolean],
  schema: /* nullability unknown */ Option[String],
  requires: /* nullability unknown */ Option[Array[String]],
  comment: /* nullability unknown */ Option[String]
)

object PgAvailableExtensionVersionsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgAvailableExtensionVersionsViewRow] = new JdbcDecoder[PgAvailableExtensionVersionsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgAvailableExtensionVersionsViewRow) =
      columIndex + 8 ->
        PgAvailableExtensionVersionsViewRow(
          name = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          version = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          installed = JdbcDecoder.optionDecoder(JdbcDecoder.booleanDecoder).unsafeDecode(columIndex + 2, rs)._2,
          superuser = JdbcDecoder.optionDecoder(JdbcDecoder.booleanDecoder).unsafeDecode(columIndex + 3, rs)._2,
          trusted = JdbcDecoder.optionDecoder(JdbcDecoder.booleanDecoder).unsafeDecode(columIndex + 4, rs)._2,
          relocatable = JdbcDecoder.optionDecoder(JdbcDecoder.booleanDecoder).unsafeDecode(columIndex + 5, rs)._2,
          schema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          requires = JdbcDecoder.optionDecoder(adventureworks.StringArrayDecoder).unsafeDecode(columIndex + 7, rs)._2,
          comment = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgAvailableExtensionVersionsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val version = jsonObj.get("version").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val installed = jsonObj.get("installed").fold[Either[String, Option[Boolean]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.boolean)))
    val superuser = jsonObj.get("superuser").fold[Either[String, Option[Boolean]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.boolean)))
    val trusted = jsonObj.get("trusted").fold[Either[String, Option[Boolean]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.boolean)))
    val relocatable = jsonObj.get("relocatable").fold[Either[String, Option[Boolean]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.boolean)))
    val schema = jsonObj.get("schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val requires = jsonObj.get("requires").fold[Either[String, Option[Array[String]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[String](JsonDecoder.string, implicitly))))
    val comment = jsonObj.get("comment").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (name.isRight && version.isRight && installed.isRight && superuser.isRight && trusted.isRight && relocatable.isRight && schema.isRight && requires.isRight && comment.isRight)
      Right(PgAvailableExtensionVersionsViewRow(name = name.toOption.get, version = version.toOption.get, installed = installed.toOption.get, superuser = superuser.toOption.get, trusted = trusted.toOption.get, relocatable = relocatable.toOption.get, schema = schema.toOption.get, requires = requires.toOption.get, comment = comment.toOption.get))
    else Left(List[Either[String, Any]](name, version, installed, superuser, trusted, relocatable, schema, requires, comment).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgAvailableExtensionVersionsViewRow] = new JsonEncoder[PgAvailableExtensionVersionsViewRow] {
    override def unsafeEncode(a: PgAvailableExtensionVersionsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""version":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.version, indent, out)
      out.write(",")
      out.write(""""installed":""")
      JsonEncoder.option(JsonEncoder.boolean).unsafeEncode(a.installed, indent, out)
      out.write(",")
      out.write(""""superuser":""")
      JsonEncoder.option(JsonEncoder.boolean).unsafeEncode(a.superuser, indent, out)
      out.write(",")
      out.write(""""trusted":""")
      JsonEncoder.option(JsonEncoder.boolean).unsafeEncode(a.trusted, indent, out)
      out.write(",")
      out.write(""""relocatable":""")
      JsonEncoder.option(JsonEncoder.boolean).unsafeEncode(a.relocatable, indent, out)
      out.write(",")
      out.write(""""schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.schema, indent, out)
      out.write(",")
      out.write(""""requires":""")
      JsonEncoder.option(JsonEncoder.array[String](JsonEncoder.string, implicitly)).unsafeEncode(a.requires, indent, out)
      out.write(",")
      out.write(""""comment":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.comment, indent, out)
      out.write("}")
    }
  }
}