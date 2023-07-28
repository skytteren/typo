/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_index

import adventureworks.TypoInt2Vector
import adventureworks.TypoOidVector
import adventureworks.TypoPgNodeTree
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgIndexRow(
  indexrelid: PgIndexId,
  indrelid: /* oid */ Long,
  indnatts: Int,
  indnkeyatts: Int,
  indisunique: Boolean,
  indisprimary: Boolean,
  indisexclusion: Boolean,
  indimmediate: Boolean,
  indisclustered: Boolean,
  indisvalid: Boolean,
  indcheckxmin: Boolean,
  indisready: Boolean,
  indislive: Boolean,
  indisreplident: Boolean,
  indkey: TypoInt2Vector,
  indcollation: TypoOidVector,
  indclass: TypoOidVector,
  indoption: TypoInt2Vector,
  indexprs: Option[TypoPgNodeTree],
  indpred: Option[TypoPgNodeTree]
)

object PgIndexRow {
  implicit val decoder: Decoder[PgIndexRow] = Decoder.forProduct20[PgIndexRow, PgIndexId, /* oid */ Long, Int, Int, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, TypoInt2Vector, TypoOidVector, TypoOidVector, TypoInt2Vector, Option[TypoPgNodeTree], Option[TypoPgNodeTree]]("indexrelid", "indrelid", "indnatts", "indnkeyatts", "indisunique", "indisprimary", "indisexclusion", "indimmediate", "indisclustered", "indisvalid", "indcheckxmin", "indisready", "indislive", "indisreplident", "indkey", "indcollation", "indclass", "indoption", "indexprs", "indpred")(PgIndexRow.apply)
  implicit val encoder: Encoder[PgIndexRow] = Encoder.forProduct20[PgIndexRow, PgIndexId, /* oid */ Long, Int, Int, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, TypoInt2Vector, TypoOidVector, TypoOidVector, TypoInt2Vector, Option[TypoPgNodeTree], Option[TypoPgNodeTree]]("indexrelid", "indrelid", "indnatts", "indnkeyatts", "indisunique", "indisprimary", "indisexclusion", "indimmediate", "indisclustered", "indisvalid", "indcheckxmin", "indisready", "indislive", "indisreplident", "indkey", "indcollation", "indclass", "indoption", "indexprs", "indpred")(x => (x.indexrelid, x.indrelid, x.indnatts, x.indnkeyatts, x.indisunique, x.indisprimary, x.indisexclusion, x.indimmediate, x.indisclustered, x.indisvalid, x.indcheckxmin, x.indisready, x.indislive, x.indisreplident, x.indkey, x.indcollation, x.indclass, x.indoption, x.indexprs, x.indpred))
  implicit val read: Read[PgIndexRow] = new Read[PgIndexRow](
    gets = List(
      (Get[PgIndexId], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[TypoInt2Vector], Nullability.NoNulls),
      (Get[TypoOidVector], Nullability.NoNulls),
      (Get[TypoOidVector], Nullability.NoNulls),
      (Get[TypoInt2Vector], Nullability.NoNulls),
      (Get[TypoPgNodeTree], Nullability.Nullable),
      (Get[TypoPgNodeTree], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgIndexRow(
      indexrelid = Get[PgIndexId].unsafeGetNonNullable(rs, i + 0),
      indrelid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 1),
      indnatts = Get[Int].unsafeGetNonNullable(rs, i + 2),
      indnkeyatts = Get[Int].unsafeGetNonNullable(rs, i + 3),
      indisunique = Get[Boolean].unsafeGetNonNullable(rs, i + 4),
      indisprimary = Get[Boolean].unsafeGetNonNullable(rs, i + 5),
      indisexclusion = Get[Boolean].unsafeGetNonNullable(rs, i + 6),
      indimmediate = Get[Boolean].unsafeGetNonNullable(rs, i + 7),
      indisclustered = Get[Boolean].unsafeGetNonNullable(rs, i + 8),
      indisvalid = Get[Boolean].unsafeGetNonNullable(rs, i + 9),
      indcheckxmin = Get[Boolean].unsafeGetNonNullable(rs, i + 10),
      indisready = Get[Boolean].unsafeGetNonNullable(rs, i + 11),
      indislive = Get[Boolean].unsafeGetNonNullable(rs, i + 12),
      indisreplident = Get[Boolean].unsafeGetNonNullable(rs, i + 13),
      indkey = Get[TypoInt2Vector].unsafeGetNonNullable(rs, i + 14),
      indcollation = Get[TypoOidVector].unsafeGetNonNullable(rs, i + 15),
      indclass = Get[TypoOidVector].unsafeGetNonNullable(rs, i + 16),
      indoption = Get[TypoInt2Vector].unsafeGetNonNullable(rs, i + 17),
      indexprs = Get[TypoPgNodeTree].unsafeGetNullable(rs, i + 18),
      indpred = Get[TypoPgNodeTree].unsafeGetNullable(rs, i + 19)
    )
  )
}
