/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import adventureworks.TypoInt2Vector
import adventureworks.TypoPgNodeTree
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class PgStatisticExtRow(
  oid: PgStatisticExtId,
  stxrelid: /* oid */ Long,
  stxname: String,
  stxnamespace: /* oid */ Long,
  stxowner: /* oid */ Long,
  stxstattarget: Int,
  stxkeys: TypoInt2Vector,
  stxkind: Array[String],
  stxexprs: Option[TypoPgNodeTree]
)

object PgStatisticExtRow {
  implicit val decoder: Decoder[PgStatisticExtRow] =
    (c: HCursor) =>
      for {
        oid <- c.downField("oid").as[PgStatisticExtId]
        stxrelid <- c.downField("stxrelid").as[/* oid */ Long]
        stxname <- c.downField("stxname").as[String]
        stxnamespace <- c.downField("stxnamespace").as[/* oid */ Long]
        stxowner <- c.downField("stxowner").as[/* oid */ Long]
        stxstattarget <- c.downField("stxstattarget").as[Int]
        stxkeys <- c.downField("stxkeys").as[TypoInt2Vector]
        stxkind <- c.downField("stxkind").as[Array[String]]
        stxexprs <- c.downField("stxexprs").as[Option[TypoPgNodeTree]]
      } yield PgStatisticExtRow(oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs)
  implicit val encoder: Encoder[PgStatisticExtRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "oid" := row.oid,
        "stxrelid" := row.stxrelid,
        "stxname" := row.stxname,
        "stxnamespace" := row.stxnamespace,
        "stxowner" := row.stxowner,
        "stxstattarget" := row.stxstattarget,
        "stxkeys" := row.stxkeys,
        "stxkind" := row.stxkind,
        "stxexprs" := row.stxexprs
      )}
  implicit val read: Read[PgStatisticExtRow] =
    new Read[PgStatisticExtRow](
      gets = List(
        (Get[PgStatisticExtId], Nullability.NoNulls),
        (Get[/* oid */ Long], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[/* oid */ Long], Nullability.NoNulls),
        (Get[/* oid */ Long], Nullability.NoNulls),
        (Get[Int], Nullability.NoNulls),
        (Get[TypoInt2Vector], Nullability.NoNulls),
        (Get[Array[String]], Nullability.NoNulls),
        (Get[TypoPgNodeTree], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PgStatisticExtRow(
        oid = Get[PgStatisticExtId].unsafeGetNonNullable(rs, i + 0),
        stxrelid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 1),
        stxname = Get[String].unsafeGetNonNullable(rs, i + 2),
        stxnamespace = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 3),
        stxowner = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 4),
        stxstattarget = Get[Int].unsafeGetNonNullable(rs, i + 5),
        stxkeys = Get[TypoInt2Vector].unsafeGetNonNullable(rs, i + 6),
        stxkind = Get[Array[String]].unsafeGetNonNullable(rs, i + 7),
        stxexprs = Get[TypoPgNodeTree].unsafeGetNullable(rs, i + 8)
      )
    )
  

}