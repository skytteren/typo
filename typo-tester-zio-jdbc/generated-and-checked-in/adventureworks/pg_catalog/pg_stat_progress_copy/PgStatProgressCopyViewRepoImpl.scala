/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_copy

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatProgressCopyViewRepoImpl extends PgStatProgressCopyViewRepo {
  override def select: SelectBuilder[PgStatProgressCopyViewFields, PgStatProgressCopyViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_progress_copy", PgStatProgressCopyViewFields, PgStatProgressCopyViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatProgressCopyViewRow] = {
    sql"""select "pid", "datid", "datname", "relid", "command", "type", "bytes_processed", "bytes_total", "tuples_processed", "tuples_excluded" from pg_catalog.pg_stat_progress_copy""".query(PgStatProgressCopyViewRow.jdbcDecoder).selectStream
  }
}