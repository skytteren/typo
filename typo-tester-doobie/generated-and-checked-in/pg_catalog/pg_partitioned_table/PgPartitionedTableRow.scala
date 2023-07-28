/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_partitioned_table

import adventureworks.TypoInt2Vector
import adventureworks.TypoOidVector
import adventureworks.TypoPgNodeTree
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgPartitionedTableRow(
  partrelid: PgPartitionedTableId,
  partstrat: String,
  partnatts: Int,
  partdefid: /* oid */ Long,
  partattrs: TypoInt2Vector,
  partclass: TypoOidVector,
  partcollation: TypoOidVector,
  partexprs: Option[TypoPgNodeTree]
)

object PgPartitionedTableRow {
  implicit val decoder: Decoder[PgPartitionedTableRow] = Decoder.forProduct8[PgPartitionedTableRow, PgPartitionedTableId, String, Int, /* oid */ Long, TypoInt2Vector, TypoOidVector, TypoOidVector, Option[TypoPgNodeTree]]("partrelid", "partstrat", "partnatts", "partdefid", "partattrs", "partclass", "partcollation", "partexprs")(PgPartitionedTableRow.apply)
  implicit val encoder: Encoder[PgPartitionedTableRow] = Encoder.forProduct8[PgPartitionedTableRow, PgPartitionedTableId, String, Int, /* oid */ Long, TypoInt2Vector, TypoOidVector, TypoOidVector, Option[TypoPgNodeTree]]("partrelid", "partstrat", "partnatts", "partdefid", "partattrs", "partclass", "partcollation", "partexprs")(x => (x.partrelid, x.partstrat, x.partnatts, x.partdefid, x.partattrs, x.partclass, x.partcollation, x.partexprs))
  implicit val read: Read[PgPartitionedTableRow] = new Read[PgPartitionedTableRow](
    gets = List(
      (Get[PgPartitionedTableId], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[TypoInt2Vector], Nullability.NoNulls),
      (Get[TypoOidVector], Nullability.NoNulls),
      (Get[TypoOidVector], Nullability.NoNulls),
      (Get[TypoPgNodeTree], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgPartitionedTableRow(
      partrelid = Get[PgPartitionedTableId].unsafeGetNonNullable(rs, i + 0),
      partstrat = Get[String].unsafeGetNonNullable(rs, i + 1),
      partnatts = Get[Int].unsafeGetNonNullable(rs, i + 2),
      partdefid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 3),
      partattrs = Get[TypoInt2Vector].unsafeGetNonNullable(rs, i + 4),
      partclass = Get[TypoOidVector].unsafeGetNonNullable(rs, i + 5),
      partcollation = Get[TypoOidVector].unsafeGetNonNullable(rs, i + 6),
      partexprs = Get[TypoPgNodeTree].unsafeGetNullable(rs, i + 7)
    )
  )
}
