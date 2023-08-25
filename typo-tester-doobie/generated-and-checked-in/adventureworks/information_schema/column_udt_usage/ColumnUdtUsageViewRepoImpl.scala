/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_udt_usage

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ColumnUdtUsageViewRepoImpl extends ColumnUdtUsageViewRepo {
  override def select: SelectBuilder[ColumnUdtUsageViewFields, ColumnUdtUsageViewRow] = {
    SelectBuilderSql("information_schema.column_udt_usage", ColumnUdtUsageViewFields, ColumnUdtUsageViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ColumnUdtUsageViewRow] = {
    sql"""select udt_catalog, udt_schema, udt_name, table_catalog, table_schema, "table_name", "column_name" from information_schema.column_udt_usage""".query(ColumnUdtUsageViewRow.read).stream
  }
}