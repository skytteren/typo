/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import adventureworks.TypoAnyArray
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import scala.util.Try

case class PgStatisticRow(
  starelid: /* oid */ Long,
  staattnum: Int,
  stainherit: Boolean,
  stanullfrac: Float,
  stawidth: Int,
  stadistinct: Float,
  stakind1: Int,
  stakind2: Int,
  stakind3: Int,
  stakind4: Int,
  stakind5: Int,
  staop1: /* oid */ Long,
  staop2: /* oid */ Long,
  staop3: /* oid */ Long,
  staop4: /* oid */ Long,
  staop5: /* oid */ Long,
  stacoll1: /* oid */ Long,
  stacoll2: /* oid */ Long,
  stacoll3: /* oid */ Long,
  stacoll4: /* oid */ Long,
  stacoll5: /* oid */ Long,
  stanumbers1: Option[Array[Float]],
  stanumbers2: Option[Array[Float]],
  stanumbers3: Option[Array[Float]],
  stanumbers4: Option[Array[Float]],
  stanumbers5: Option[Array[Float]],
  stavalues1: Option[TypoAnyArray],
  stavalues2: Option[TypoAnyArray],
  stavalues3: Option[TypoAnyArray],
  stavalues4: Option[TypoAnyArray],
  stavalues5: Option[TypoAnyArray]
){
   val compositeId: PgStatisticId = PgStatisticId(starelid, staattnum, stainherit)
 }

object PgStatisticRow {
  implicit val decoder: Decoder[PgStatisticRow] = Decoder.instanceTry[PgStatisticRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgStatisticRow(
        starelid = orThrow(c.get("starelid")(Decoder[/* oid */ Long])),
        staattnum = orThrow(c.get("staattnum")(Decoder[Int])),
        stainherit = orThrow(c.get("stainherit")(Decoder[Boolean])),
        stanullfrac = orThrow(c.get("stanullfrac")(Decoder[Float])),
        stawidth = orThrow(c.get("stawidth")(Decoder[Int])),
        stadistinct = orThrow(c.get("stadistinct")(Decoder[Float])),
        stakind1 = orThrow(c.get("stakind1")(Decoder[Int])),
        stakind2 = orThrow(c.get("stakind2")(Decoder[Int])),
        stakind3 = orThrow(c.get("stakind3")(Decoder[Int])),
        stakind4 = orThrow(c.get("stakind4")(Decoder[Int])),
        stakind5 = orThrow(c.get("stakind5")(Decoder[Int])),
        staop1 = orThrow(c.get("staop1")(Decoder[/* oid */ Long])),
        staop2 = orThrow(c.get("staop2")(Decoder[/* oid */ Long])),
        staop3 = orThrow(c.get("staop3")(Decoder[/* oid */ Long])),
        staop4 = orThrow(c.get("staop4")(Decoder[/* oid */ Long])),
        staop5 = orThrow(c.get("staop5")(Decoder[/* oid */ Long])),
        stacoll1 = orThrow(c.get("stacoll1")(Decoder[/* oid */ Long])),
        stacoll2 = orThrow(c.get("stacoll2")(Decoder[/* oid */ Long])),
        stacoll3 = orThrow(c.get("stacoll3")(Decoder[/* oid */ Long])),
        stacoll4 = orThrow(c.get("stacoll4")(Decoder[/* oid */ Long])),
        stacoll5 = orThrow(c.get("stacoll5")(Decoder[/* oid */ Long])),
        stanumbers1 = orThrow(c.get("stanumbers1")(Decoder[Option[Array[Float]]])),
        stanumbers2 = orThrow(c.get("stanumbers2")(Decoder[Option[Array[Float]]])),
        stanumbers3 = orThrow(c.get("stanumbers3")(Decoder[Option[Array[Float]]])),
        stanumbers4 = orThrow(c.get("stanumbers4")(Decoder[Option[Array[Float]]])),
        stanumbers5 = orThrow(c.get("stanumbers5")(Decoder[Option[Array[Float]]])),
        stavalues1 = orThrow(c.get("stavalues1")(Decoder[Option[TypoAnyArray]])),
        stavalues2 = orThrow(c.get("stavalues2")(Decoder[Option[TypoAnyArray]])),
        stavalues3 = orThrow(c.get("stavalues3")(Decoder[Option[TypoAnyArray]])),
        stavalues4 = orThrow(c.get("stavalues4")(Decoder[Option[TypoAnyArray]])),
        stavalues5 = orThrow(c.get("stavalues5")(Decoder[Option[TypoAnyArray]]))
      )
    }
  )
  implicit val encoder: Encoder[PgStatisticRow] = Encoder[PgStatisticRow](row =>
    Json.obj(
      "starelid" -> Encoder[/* oid */ Long].apply(row.starelid),
      "staattnum" -> Encoder[Int].apply(row.staattnum),
      "stainherit" -> Encoder[Boolean].apply(row.stainherit),
      "stanullfrac" -> Encoder[Float].apply(row.stanullfrac),
      "stawidth" -> Encoder[Int].apply(row.stawidth),
      "stadistinct" -> Encoder[Float].apply(row.stadistinct),
      "stakind1" -> Encoder[Int].apply(row.stakind1),
      "stakind2" -> Encoder[Int].apply(row.stakind2),
      "stakind3" -> Encoder[Int].apply(row.stakind3),
      "stakind4" -> Encoder[Int].apply(row.stakind4),
      "stakind5" -> Encoder[Int].apply(row.stakind5),
      "staop1" -> Encoder[/* oid */ Long].apply(row.staop1),
      "staop2" -> Encoder[/* oid */ Long].apply(row.staop2),
      "staop3" -> Encoder[/* oid */ Long].apply(row.staop3),
      "staop4" -> Encoder[/* oid */ Long].apply(row.staop4),
      "staop5" -> Encoder[/* oid */ Long].apply(row.staop5),
      "stacoll1" -> Encoder[/* oid */ Long].apply(row.stacoll1),
      "stacoll2" -> Encoder[/* oid */ Long].apply(row.stacoll2),
      "stacoll3" -> Encoder[/* oid */ Long].apply(row.stacoll3),
      "stacoll4" -> Encoder[/* oid */ Long].apply(row.stacoll4),
      "stacoll5" -> Encoder[/* oid */ Long].apply(row.stacoll5),
      "stanumbers1" -> Encoder[Option[Array[Float]]].apply(row.stanumbers1),
      "stanumbers2" -> Encoder[Option[Array[Float]]].apply(row.stanumbers2),
      "stanumbers3" -> Encoder[Option[Array[Float]]].apply(row.stanumbers3),
      "stanumbers4" -> Encoder[Option[Array[Float]]].apply(row.stanumbers4),
      "stanumbers5" -> Encoder[Option[Array[Float]]].apply(row.stanumbers5),
      "stavalues1" -> Encoder[Option[TypoAnyArray]].apply(row.stavalues1),
      "stavalues2" -> Encoder[Option[TypoAnyArray]].apply(row.stavalues2),
      "stavalues3" -> Encoder[Option[TypoAnyArray]].apply(row.stavalues3),
      "stavalues4" -> Encoder[Option[TypoAnyArray]].apply(row.stavalues4),
      "stavalues5" -> Encoder[Option[TypoAnyArray]].apply(row.stavalues5)
    )
  )
  implicit val read: Read[PgStatisticRow] = new Read[PgStatisticRow](
    gets = List(
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Float], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Float], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[Array[Float]], Nullability.Nullable),
      (Get[Array[Float]], Nullability.Nullable),
      (Get[Array[Float]], Nullability.Nullable),
      (Get[Array[Float]], Nullability.Nullable),
      (Get[Array[Float]], Nullability.Nullable),
      (Get[TypoAnyArray], Nullability.Nullable),
      (Get[TypoAnyArray], Nullability.Nullable),
      (Get[TypoAnyArray], Nullability.Nullable),
      (Get[TypoAnyArray], Nullability.Nullable),
      (Get[TypoAnyArray], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatisticRow(
      starelid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 0),
      staattnum = Get[Int].unsafeGetNonNullable(rs, i + 1),
      stainherit = Get[Boolean].unsafeGetNonNullable(rs, i + 2),
      stanullfrac = Get[Float].unsafeGetNonNullable(rs, i + 3),
      stawidth = Get[Int].unsafeGetNonNullable(rs, i + 4),
      stadistinct = Get[Float].unsafeGetNonNullable(rs, i + 5),
      stakind1 = Get[Int].unsafeGetNonNullable(rs, i + 6),
      stakind2 = Get[Int].unsafeGetNonNullable(rs, i + 7),
      stakind3 = Get[Int].unsafeGetNonNullable(rs, i + 8),
      stakind4 = Get[Int].unsafeGetNonNullable(rs, i + 9),
      stakind5 = Get[Int].unsafeGetNonNullable(rs, i + 10),
      staop1 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 11),
      staop2 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 12),
      staop3 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 13),
      staop4 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 14),
      staop5 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 15),
      stacoll1 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 16),
      stacoll2 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 17),
      stacoll3 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 18),
      stacoll4 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 19),
      stacoll5 = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 20),
      stanumbers1 = Get[Array[Float]].unsafeGetNullable(rs, i + 21),
      stanumbers2 = Get[Array[Float]].unsafeGetNullable(rs, i + 22),
      stanumbers3 = Get[Array[Float]].unsafeGetNullable(rs, i + 23),
      stanumbers4 = Get[Array[Float]].unsafeGetNullable(rs, i + 24),
      stanumbers5 = Get[Array[Float]].unsafeGetNullable(rs, i + 25),
      stavalues1 = Get[TypoAnyArray].unsafeGetNullable(rs, i + 26),
      stavalues2 = Get[TypoAnyArray].unsafeGetNullable(rs, i + 27),
      stavalues3 = Get[TypoAnyArray].unsafeGetNullable(rs, i + 28),
      stavalues4 = Get[TypoAnyArray].unsafeGetNullable(rs, i + 29),
      stavalues5 = Get[TypoAnyArray].unsafeGetNullable(rs, i + 30)
    )
  )
}
