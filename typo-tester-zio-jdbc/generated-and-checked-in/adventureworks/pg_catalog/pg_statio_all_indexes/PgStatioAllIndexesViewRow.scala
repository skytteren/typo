/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_indexes

import adventureworks.pg_catalog.pg_class.PgClassId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgStatioAllIndexesViewRow(
  /** Points to [[pg_class.PgClassRow.oid]] */
  relid: PgClassId,
  /** Points to [[pg_class.PgClassRow.oid]] */
  indexrelid: PgClassId,
  /** Points to [[pg_namespace.PgNamespaceRow.nspname]] */
  schemaname: Option[String],
  /** Points to [[pg_class.PgClassRow.relname]] */
  relname: String,
  /** Points to [[pg_class.PgClassRow.relname]] */
  indexrelname: String,
  idxBlksRead: /* nullability unknown */ Option[Long],
  idxBlksHit: /* nullability unknown */ Option[Long]
)

object PgStatioAllIndexesViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgStatioAllIndexesViewRow] = new JdbcDecoder[PgStatioAllIndexesViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgStatioAllIndexesViewRow) =
      columIndex + 6 ->
        PgStatioAllIndexesViewRow(
          relid = PgClassId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          indexrelid = PgClassId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          schemaname = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          relname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 3, rs)._2,
          indexrelname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 4, rs)._2,
          idxBlksRead = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 5, rs)._2,
          idxBlksHit = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgStatioAllIndexesViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val relid = jsonObj.get("relid").toRight("Missing field 'relid'").flatMap(_.as(PgClassId.jsonDecoder))
    val indexrelid = jsonObj.get("indexrelid").toRight("Missing field 'indexrelid'").flatMap(_.as(PgClassId.jsonDecoder))
    val schemaname = jsonObj.get("schemaname").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val relname = jsonObj.get("relname").toRight("Missing field 'relname'").flatMap(_.as(JsonDecoder.string))
    val indexrelname = jsonObj.get("indexrelname").toRight("Missing field 'indexrelname'").flatMap(_.as(JsonDecoder.string))
    val idxBlksRead = jsonObj.get("idx_blks_read").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val idxBlksHit = jsonObj.get("idx_blks_hit").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    if (relid.isRight && indexrelid.isRight && schemaname.isRight && relname.isRight && indexrelname.isRight && idxBlksRead.isRight && idxBlksHit.isRight)
      Right(PgStatioAllIndexesViewRow(relid = relid.toOption.get, indexrelid = indexrelid.toOption.get, schemaname = schemaname.toOption.get, relname = relname.toOption.get, indexrelname = indexrelname.toOption.get, idxBlksRead = idxBlksRead.toOption.get, idxBlksHit = idxBlksHit.toOption.get))
    else Left(List[Either[String, Any]](relid, indexrelid, schemaname, relname, indexrelname, idxBlksRead, idxBlksHit).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgStatioAllIndexesViewRow] = new JsonEncoder[PgStatioAllIndexesViewRow] {
    override def unsafeEncode(a: PgStatioAllIndexesViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""relid":""")
      PgClassId.jsonEncoder.unsafeEncode(a.relid, indent, out)
      out.write(",")
      out.write(""""indexrelid":""")
      PgClassId.jsonEncoder.unsafeEncode(a.indexrelid, indent, out)
      out.write(",")
      out.write(""""schemaname":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.schemaname, indent, out)
      out.write(",")
      out.write(""""relname":""")
      JsonEncoder.string.unsafeEncode(a.relname, indent, out)
      out.write(",")
      out.write(""""indexrelname":""")
      JsonEncoder.string.unsafeEncode(a.indexrelname, indent, out)
      out.write(",")
      out.write(""""idx_blks_read":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.idxBlksRead, indent, out)
      out.write(",")
      out.write(""""idx_blks_hit":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.idxBlksHit, indent, out)
      out.write("}")
    }
  }
}