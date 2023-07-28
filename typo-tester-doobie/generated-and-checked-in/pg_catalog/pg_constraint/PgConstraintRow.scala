/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_constraint

import adventureworks.TypoPgNodeTree
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

case class PgConstraintRow(
  oid: PgConstraintId,
  conname: String,
  connamespace: /* oid */ Long,
  contype: String,
  condeferrable: Boolean,
  condeferred: Boolean,
  convalidated: Boolean,
  conrelid: /* oid */ Long,
  contypid: /* oid */ Long,
  conindid: /* oid */ Long,
  conparentid: /* oid */ Long,
  confrelid: /* oid */ Long,
  confupdtype: String,
  confdeltype: String,
  confmatchtype: String,
  conislocal: Boolean,
  coninhcount: Int,
  connoinherit: Boolean,
  conkey: Option[Array[Int]],
  confkey: Option[Array[Int]],
  conpfeqop: Option[Array[/* oid */ Long]],
  conppeqop: Option[Array[/* oid */ Long]],
  conffeqop: Option[Array[/* oid */ Long]],
  conexclop: Option[Array[/* oid */ Long]],
  conbin: Option[TypoPgNodeTree]
)

object PgConstraintRow {
  implicit val decoder: Decoder[PgConstraintRow] = Decoder.instanceTry[PgConstraintRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgConstraintRow(
        oid = orThrow(c.get("oid")(Decoder[PgConstraintId])),
        conname = orThrow(c.get("conname")(Decoder[String])),
        connamespace = orThrow(c.get("connamespace")(Decoder[/* oid */ Long])),
        contype = orThrow(c.get("contype")(Decoder[String])),
        condeferrable = orThrow(c.get("condeferrable")(Decoder[Boolean])),
        condeferred = orThrow(c.get("condeferred")(Decoder[Boolean])),
        convalidated = orThrow(c.get("convalidated")(Decoder[Boolean])),
        conrelid = orThrow(c.get("conrelid")(Decoder[/* oid */ Long])),
        contypid = orThrow(c.get("contypid")(Decoder[/* oid */ Long])),
        conindid = orThrow(c.get("conindid")(Decoder[/* oid */ Long])),
        conparentid = orThrow(c.get("conparentid")(Decoder[/* oid */ Long])),
        confrelid = orThrow(c.get("confrelid")(Decoder[/* oid */ Long])),
        confupdtype = orThrow(c.get("confupdtype")(Decoder[String])),
        confdeltype = orThrow(c.get("confdeltype")(Decoder[String])),
        confmatchtype = orThrow(c.get("confmatchtype")(Decoder[String])),
        conislocal = orThrow(c.get("conislocal")(Decoder[Boolean])),
        coninhcount = orThrow(c.get("coninhcount")(Decoder[Int])),
        connoinherit = orThrow(c.get("connoinherit")(Decoder[Boolean])),
        conkey = orThrow(c.get("conkey")(Decoder[Option[Array[Int]]])),
        confkey = orThrow(c.get("confkey")(Decoder[Option[Array[Int]]])),
        conpfeqop = orThrow(c.get("conpfeqop")(Decoder[Option[Array[/* oid */ Long]]])),
        conppeqop = orThrow(c.get("conppeqop")(Decoder[Option[Array[/* oid */ Long]]])),
        conffeqop = orThrow(c.get("conffeqop")(Decoder[Option[Array[/* oid */ Long]]])),
        conexclop = orThrow(c.get("conexclop")(Decoder[Option[Array[/* oid */ Long]]])),
        conbin = orThrow(c.get("conbin")(Decoder[Option[TypoPgNodeTree]]))
      )
    }
  )
  implicit val encoder: Encoder[PgConstraintRow] = Encoder[PgConstraintRow](row =>
    Json.obj(
      "oid" -> Encoder[PgConstraintId].apply(row.oid),
      "conname" -> Encoder[String].apply(row.conname),
      "connamespace" -> Encoder[/* oid */ Long].apply(row.connamespace),
      "contype" -> Encoder[String].apply(row.contype),
      "condeferrable" -> Encoder[Boolean].apply(row.condeferrable),
      "condeferred" -> Encoder[Boolean].apply(row.condeferred),
      "convalidated" -> Encoder[Boolean].apply(row.convalidated),
      "conrelid" -> Encoder[/* oid */ Long].apply(row.conrelid),
      "contypid" -> Encoder[/* oid */ Long].apply(row.contypid),
      "conindid" -> Encoder[/* oid */ Long].apply(row.conindid),
      "conparentid" -> Encoder[/* oid */ Long].apply(row.conparentid),
      "confrelid" -> Encoder[/* oid */ Long].apply(row.confrelid),
      "confupdtype" -> Encoder[String].apply(row.confupdtype),
      "confdeltype" -> Encoder[String].apply(row.confdeltype),
      "confmatchtype" -> Encoder[String].apply(row.confmatchtype),
      "conislocal" -> Encoder[Boolean].apply(row.conislocal),
      "coninhcount" -> Encoder[Int].apply(row.coninhcount),
      "connoinherit" -> Encoder[Boolean].apply(row.connoinherit),
      "conkey" -> Encoder[Option[Array[Int]]].apply(row.conkey),
      "confkey" -> Encoder[Option[Array[Int]]].apply(row.confkey),
      "conpfeqop" -> Encoder[Option[Array[/* oid */ Long]]].apply(row.conpfeqop),
      "conppeqop" -> Encoder[Option[Array[/* oid */ Long]]].apply(row.conppeqop),
      "conffeqop" -> Encoder[Option[Array[/* oid */ Long]]].apply(row.conffeqop),
      "conexclop" -> Encoder[Option[Array[/* oid */ Long]]].apply(row.conexclop),
      "conbin" -> Encoder[Option[TypoPgNodeTree]].apply(row.conbin)
    )
  )
  implicit val read: Read[PgConstraintRow] = new Read[PgConstraintRow](
    gets = List(
      (Get[PgConstraintId], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Array[Int]], Nullability.Nullable),
      (Get[Array[Int]], Nullability.Nullable),
      (Get[Array[/* oid */ Long]], Nullability.Nullable),
      (Get[Array[/* oid */ Long]], Nullability.Nullable),
      (Get[Array[/* oid */ Long]], Nullability.Nullable),
      (Get[Array[/* oid */ Long]], Nullability.Nullable),
      (Get[TypoPgNodeTree], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgConstraintRow(
      oid = Get[PgConstraintId].unsafeGetNonNullable(rs, i + 0),
      conname = Get[String].unsafeGetNonNullable(rs, i + 1),
      connamespace = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 2),
      contype = Get[String].unsafeGetNonNullable(rs, i + 3),
      condeferrable = Get[Boolean].unsafeGetNonNullable(rs, i + 4),
      condeferred = Get[Boolean].unsafeGetNonNullable(rs, i + 5),
      convalidated = Get[Boolean].unsafeGetNonNullable(rs, i + 6),
      conrelid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 7),
      contypid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 8),
      conindid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 9),
      conparentid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 10),
      confrelid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 11),
      confupdtype = Get[String].unsafeGetNonNullable(rs, i + 12),
      confdeltype = Get[String].unsafeGetNonNullable(rs, i + 13),
      confmatchtype = Get[String].unsafeGetNonNullable(rs, i + 14),
      conislocal = Get[Boolean].unsafeGetNonNullable(rs, i + 15),
      coninhcount = Get[Int].unsafeGetNonNullable(rs, i + 16),
      connoinherit = Get[Boolean].unsafeGetNonNullable(rs, i + 17),
      conkey = Get[Array[Int]].unsafeGetNullable(rs, i + 18),
      confkey = Get[Array[Int]].unsafeGetNullable(rs, i + 19),
      conpfeqop = Get[Array[/* oid */ Long]].unsafeGetNullable(rs, i + 20),
      conppeqop = Get[Array[/* oid */ Long]].unsafeGetNullable(rs, i + 21),
      conffeqop = Get[Array[/* oid */ Long]].unsafeGetNullable(rs, i + 22),
      conexclop = Get[Array[/* oid */ Long]].unsafeGetNullable(rs, i + 23),
      conbin = Get[TypoPgNodeTree].unsafeGetNullable(rs, i + 24)
    )
  )
}
