/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_table_usage

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ConstraintTableUsageViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  constraintCatalog: Option[SqlIdentifier],
  constraintSchema: Option[SqlIdentifier],
  constraintName: Option[SqlIdentifier]
)

object ConstraintTableUsageViewRow {
  implicit val decoder: Decoder[ConstraintTableUsageViewRow] = Decoder.forProduct6[ConstraintTableUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("table_catalog", "table_schema", "table_name", "constraint_catalog", "constraint_schema", "constraint_name")(ConstraintTableUsageViewRow.apply)
  implicit val encoder: Encoder[ConstraintTableUsageViewRow] = Encoder.forProduct6[ConstraintTableUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("table_catalog", "table_schema", "table_name", "constraint_catalog", "constraint_schema", "constraint_name")(x => (x.tableCatalog, x.tableSchema, x.tableName, x.constraintCatalog, x.constraintSchema, x.constraintName))
  implicit val read: Read[ConstraintTableUsageViewRow] = new Read[ConstraintTableUsageViewRow](
    gets = List(
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ConstraintTableUsageViewRow(
      tableCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 0),
      tableSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 1),
      tableName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 2),
      constraintCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 3),
      constraintSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 4),
      constraintName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 5)
    )
  )
}
