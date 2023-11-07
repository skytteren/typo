/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_tables

import adventureworks.pg_catalog.pg_class.PgClassId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgStatioSysTablesViewRow(
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.relid]] */
  relid: Option[PgClassId],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.heapBlksRead]] */
  heapBlksRead: Option[/* nullability unknown */ Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.heapBlksHit]] */
  heapBlksHit: Option[/* nullability unknown */ Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.idxBlksRead]] */
  idxBlksRead: Option[/* nullability unknown */ Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.idxBlksHit]] */
  idxBlksHit: Option[/* nullability unknown */ Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.toastBlksRead]] */
  toastBlksRead: Option[/* nullability unknown */ Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.toastBlksHit]] */
  toastBlksHit: Option[/* nullability unknown */ Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.tidxBlksRead]] */
  tidxBlksRead: Option[/* nullability unknown */ Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.tidxBlksHit]] */
  tidxBlksHit: Option[/* nullability unknown */ Long]
)

object PgStatioSysTablesViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgStatioSysTablesViewRow] = new JdbcDecoder[PgStatioSysTablesViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgStatioSysTablesViewRow) =
      columIndex + 10 ->
        PgStatioSysTablesViewRow(
          relid = JdbcDecoder.optionDecoder(PgClassId.jdbcDecoder).unsafeDecode(columIndex + 0, rs)._2,
          schemaname = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          relname = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          heapBlksRead = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 3, rs)._2,
          heapBlksHit = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 4, rs)._2,
          idxBlksRead = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 5, rs)._2,
          idxBlksHit = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 6, rs)._2,
          toastBlksRead = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 7, rs)._2,
          toastBlksHit = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 8, rs)._2,
          tidxBlksRead = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 9, rs)._2,
          tidxBlksHit = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 10, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgStatioSysTablesViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val relid = jsonObj.get("relid").fold[Either[String, Option[PgClassId]]](Right(None))(_.as(JsonDecoder.option(PgClassId.jsonDecoder)))
    val schemaname = jsonObj.get("schemaname").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val relname = jsonObj.get("relname").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val heapBlksRead = jsonObj.get("heap_blks_read").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val heapBlksHit = jsonObj.get("heap_blks_hit").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val idxBlksRead = jsonObj.get("idx_blks_read").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val idxBlksHit = jsonObj.get("idx_blks_hit").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val toastBlksRead = jsonObj.get("toast_blks_read").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val toastBlksHit = jsonObj.get("toast_blks_hit").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val tidxBlksRead = jsonObj.get("tidx_blks_read").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val tidxBlksHit = jsonObj.get("tidx_blks_hit").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    if (relid.isRight && schemaname.isRight && relname.isRight && heapBlksRead.isRight && heapBlksHit.isRight && idxBlksRead.isRight && idxBlksHit.isRight && toastBlksRead.isRight && toastBlksHit.isRight && tidxBlksRead.isRight && tidxBlksHit.isRight)
      Right(PgStatioSysTablesViewRow(relid = relid.toOption.get, schemaname = schemaname.toOption.get, relname = relname.toOption.get, heapBlksRead = heapBlksRead.toOption.get, heapBlksHit = heapBlksHit.toOption.get, idxBlksRead = idxBlksRead.toOption.get, idxBlksHit = idxBlksHit.toOption.get, toastBlksRead = toastBlksRead.toOption.get, toastBlksHit = toastBlksHit.toOption.get, tidxBlksRead = tidxBlksRead.toOption.get, tidxBlksHit = tidxBlksHit.toOption.get))
    else Left(List[Either[String, Any]](relid, schemaname, relname, heapBlksRead, heapBlksHit, idxBlksRead, idxBlksHit, toastBlksRead, toastBlksHit, tidxBlksRead, tidxBlksHit).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgStatioSysTablesViewRow] = new JsonEncoder[PgStatioSysTablesViewRow] {
    override def unsafeEncode(a: PgStatioSysTablesViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""relid":""")
      JsonEncoder.option(PgClassId.jsonEncoder).unsafeEncode(a.relid, indent, out)
      out.write(",")
      out.write(""""schemaname":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.schemaname, indent, out)
      out.write(",")
      out.write(""""relname":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.relname, indent, out)
      out.write(",")
      out.write(""""heap_blks_read":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.heapBlksRead, indent, out)
      out.write(",")
      out.write(""""heap_blks_hit":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.heapBlksHit, indent, out)
      out.write(",")
      out.write(""""idx_blks_read":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.idxBlksRead, indent, out)
      out.write(",")
      out.write(""""idx_blks_hit":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.idxBlksHit, indent, out)
      out.write(",")
      out.write(""""toast_blks_read":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.toastBlksRead, indent, out)
      out.write(",")
      out.write(""""toast_blks_hit":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.toastBlksHit, indent, out)
      out.write(",")
      out.write(""""tidx_blks_read":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.tidxBlksRead, indent, out)
      out.write(",")
      out.write(""""tidx_blks_hit":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.tidxBlksHit, indent, out)
      out.write("}")
    }
  }
}