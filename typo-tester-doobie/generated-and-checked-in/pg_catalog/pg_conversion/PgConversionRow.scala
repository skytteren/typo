/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_conversion

import adventureworks.TypoRegproc
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgConversionRow(
  oid: PgConversionId,
  conname: String,
  connamespace: /* oid */ Long,
  conowner: /* oid */ Long,
  conforencoding: Int,
  contoencoding: Int,
  conproc: TypoRegproc,
  condefault: Boolean
)

object PgConversionRow {
  implicit val decoder: Decoder[PgConversionRow] = Decoder.forProduct8[PgConversionRow, PgConversionId, String, /* oid */ Long, /* oid */ Long, Int, Int, TypoRegproc, Boolean]("oid", "conname", "connamespace", "conowner", "conforencoding", "contoencoding", "conproc", "condefault")(PgConversionRow.apply)
  implicit val encoder: Encoder[PgConversionRow] = Encoder.forProduct8[PgConversionRow, PgConversionId, String, /* oid */ Long, /* oid */ Long, Int, Int, TypoRegproc, Boolean]("oid", "conname", "connamespace", "conowner", "conforencoding", "contoencoding", "conproc", "condefault")(x => (x.oid, x.conname, x.connamespace, x.conowner, x.conforencoding, x.contoencoding, x.conproc, x.condefault))
  implicit val read: Read[PgConversionRow] = new Read[PgConversionRow](
    gets = List(
      (Get[PgConversionId], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[TypoRegproc], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgConversionRow(
      oid = Get[PgConversionId].unsafeGetNonNullable(rs, i + 0),
      conname = Get[String].unsafeGetNonNullable(rs, i + 1),
      connamespace = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 2),
      conowner = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 3),
      conforencoding = Get[Int].unsafeGetNonNullable(rs, i + 4),
      contoencoding = Get[Int].unsafeGetNonNullable(rs, i + 5),
      conproc = Get[TypoRegproc].unsafeGetNonNullable(rs, i + 6),
      condefault = Get[Boolean].unsafeGetNonNullable(rs, i + 7)
    )
  )
}
