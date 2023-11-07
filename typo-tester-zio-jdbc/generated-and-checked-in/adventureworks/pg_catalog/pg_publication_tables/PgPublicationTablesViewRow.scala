/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_tables

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgPublicationTablesViewRow(
  /** Points to [[pg_publication.PgPublicationRow.pubname]] */
  pubname: String,
  /** Points to [[pg_namespace.PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[pg_class.PgClassRow.relname]] */
  tablename: String
)

object PgPublicationTablesViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgPublicationTablesViewRow] = new JdbcDecoder[PgPublicationTablesViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgPublicationTablesViewRow) =
      columIndex + 2 ->
        PgPublicationTablesViewRow(
          pubname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 0, rs)._2,
          schemaname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          tablename = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgPublicationTablesViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val pubname = jsonObj.get("pubname").toRight("Missing field 'pubname'").flatMap(_.as(JsonDecoder.string))
    val schemaname = jsonObj.get("schemaname").toRight("Missing field 'schemaname'").flatMap(_.as(JsonDecoder.string))
    val tablename = jsonObj.get("tablename").toRight("Missing field 'tablename'").flatMap(_.as(JsonDecoder.string))
    if (pubname.isRight && schemaname.isRight && tablename.isRight)
      Right(PgPublicationTablesViewRow(pubname = pubname.toOption.get, schemaname = schemaname.toOption.get, tablename = tablename.toOption.get))
    else Left(List[Either[String, Any]](pubname, schemaname, tablename).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgPublicationTablesViewRow] = new JsonEncoder[PgPublicationTablesViewRow] {
    override def unsafeEncode(a: PgPublicationTablesViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""pubname":""")
      JsonEncoder.string.unsafeEncode(a.pubname, indent, out)
      out.write(",")
      out.write(""""schemaname":""")
      JsonEncoder.string.unsafeEncode(a.schemaname, indent, out)
      out.write(",")
      out.write(""""tablename":""")
      JsonEncoder.string.unsafeEncode(a.tablename, indent, out)
      out.write("}")
    }
  }
}