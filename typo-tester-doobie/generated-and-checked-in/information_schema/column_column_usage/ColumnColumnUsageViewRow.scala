/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_column_usage

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ColumnColumnUsageViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  dependentColumn: Option[SqlIdentifier]
)

object ColumnColumnUsageViewRow {
  implicit val decoder: Decoder[ColumnColumnUsageViewRow] = Decoder.forProduct5[ColumnColumnUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("table_catalog", "table_schema", "table_name", "column_name", "dependent_column")(ColumnColumnUsageViewRow.apply)
  implicit val encoder: Encoder[ColumnColumnUsageViewRow] = Encoder.forProduct5[ColumnColumnUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("table_catalog", "table_schema", "table_name", "column_name", "dependent_column")(x => (x.tableCatalog, x.tableSchema, x.tableName, x.columnName, x.dependentColumn))
  implicit val read: Read[ColumnColumnUsageViewRow] = new Read[ColumnColumnUsageViewRow](
    gets = List(
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ColumnColumnUsageViewRow(
      tableCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 0),
      tableSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 1),
      tableName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 2),
      columnName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 3),
      dependentColumn = Get[SqlIdentifier].unsafeGetNullable(rs, i + 4)
    )
  )
}
