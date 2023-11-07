/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_indexes

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatUserIndexesViewRepoImpl extends PgStatUserIndexesViewRepo {
  override def select: SelectBuilder[PgStatUserIndexesViewFields, PgStatUserIndexesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_user_indexes", PgStatUserIndexesViewFields, PgStatUserIndexesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatUserIndexesViewRow] = {
    sql"""select "relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_scan", "idx_tup_read", "idx_tup_fetch" from pg_catalog.pg_stat_user_indexes""".query(PgStatUserIndexesViewRow.jdbcDecoder).selectStream
  }
}