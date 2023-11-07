/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_column_usage

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object ConstraintColumnUsageViewRepoImpl extends ConstraintColumnUsageViewRepo {
  override def select: SelectBuilder[ConstraintColumnUsageViewFields, ConstraintColumnUsageViewRow] = {
    SelectBuilderSql("information_schema.constraint_column_usage", ConstraintColumnUsageViewFields, ConstraintColumnUsageViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ConstraintColumnUsageViewRow] = {
    sql"""select "table_catalog", "table_schema", "table_name", "column_name", "constraint_catalog", "constraint_schema", "constraint_name" from information_schema.constraint_column_usage""".query(ConstraintColumnUsageViewRow.jdbcDecoder).selectStream
  }
}