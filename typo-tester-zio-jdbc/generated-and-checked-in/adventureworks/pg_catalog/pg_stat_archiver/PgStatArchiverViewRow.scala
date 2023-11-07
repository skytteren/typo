/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_archiver

import adventureworks.customtypes.TypoInstant
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgStatArchiverViewRow(
  archivedCount: /* nullability unknown */ Option[Long],
  lastArchivedWal: /* nullability unknown */ Option[String],
  lastArchivedTime: /* nullability unknown */ Option[TypoInstant],
  failedCount: /* nullability unknown */ Option[Long],
  lastFailedWal: /* nullability unknown */ Option[String],
  lastFailedTime: /* nullability unknown */ Option[TypoInstant],
  statsReset: /* nullability unknown */ Option[TypoInstant]
)

object PgStatArchiverViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgStatArchiverViewRow] = new JdbcDecoder[PgStatArchiverViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgStatArchiverViewRow) =
      columIndex + 6 ->
        PgStatArchiverViewRow(
          archivedCount = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 0, rs)._2,
          lastArchivedWal = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          lastArchivedTime = JdbcDecoder.optionDecoder(TypoInstant.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          failedCount = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 3, rs)._2,
          lastFailedWal = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          lastFailedTime = JdbcDecoder.optionDecoder(TypoInstant.jdbcDecoder).unsafeDecode(columIndex + 5, rs)._2,
          statsReset = JdbcDecoder.optionDecoder(TypoInstant.jdbcDecoder).unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgStatArchiverViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val archivedCount = jsonObj.get("archived_count").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val lastArchivedWal = jsonObj.get("last_archived_wal").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val lastArchivedTime = jsonObj.get("last_archived_time").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(TypoInstant.jsonDecoder)))
    val failedCount = jsonObj.get("failed_count").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val lastFailedWal = jsonObj.get("last_failed_wal").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val lastFailedTime = jsonObj.get("last_failed_time").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(TypoInstant.jsonDecoder)))
    val statsReset = jsonObj.get("stats_reset").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(TypoInstant.jsonDecoder)))
    if (archivedCount.isRight && lastArchivedWal.isRight && lastArchivedTime.isRight && failedCount.isRight && lastFailedWal.isRight && lastFailedTime.isRight && statsReset.isRight)
      Right(PgStatArchiverViewRow(archivedCount = archivedCount.toOption.get, lastArchivedWal = lastArchivedWal.toOption.get, lastArchivedTime = lastArchivedTime.toOption.get, failedCount = failedCount.toOption.get, lastFailedWal = lastFailedWal.toOption.get, lastFailedTime = lastFailedTime.toOption.get, statsReset = statsReset.toOption.get))
    else Left(List[Either[String, Any]](archivedCount, lastArchivedWal, lastArchivedTime, failedCount, lastFailedWal, lastFailedTime, statsReset).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgStatArchiverViewRow] = new JsonEncoder[PgStatArchiverViewRow] {
    override def unsafeEncode(a: PgStatArchiverViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""archived_count":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.archivedCount, indent, out)
      out.write(",")
      out.write(""""last_archived_wal":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.lastArchivedWal, indent, out)
      out.write(",")
      out.write(""""last_archived_time":""")
      JsonEncoder.option(TypoInstant.jsonEncoder).unsafeEncode(a.lastArchivedTime, indent, out)
      out.write(",")
      out.write(""""failed_count":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.failedCount, indent, out)
      out.write(",")
      out.write(""""last_failed_wal":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.lastFailedWal, indent, out)
      out.write(",")
      out.write(""""last_failed_time":""")
      JsonEncoder.option(TypoInstant.jsonEncoder).unsafeEncode(a.lastFailedTime, indent, out)
      out.write(",")
      out.write(""""stats_reset":""")
      JsonEncoder.option(TypoInstant.jsonEncoder).unsafeEncode(a.statsReset, indent, out)
      out.write("}")
    }
  }
}