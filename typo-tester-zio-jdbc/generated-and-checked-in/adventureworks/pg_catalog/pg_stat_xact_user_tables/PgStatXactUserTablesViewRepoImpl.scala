/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_user_tables

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatXactUserTablesViewRepoImpl extends PgStatXactUserTablesViewRepo {
  override def select: SelectBuilder[PgStatXactUserTablesViewFields, PgStatXactUserTablesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_xact_user_tables", PgStatXactUserTablesViewFields, PgStatXactUserTablesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatXactUserTablesViewRow] = {
    sql"""select "relid", "schemaname", "relname", "seq_scan", "seq_tup_read", "idx_scan", "idx_tup_fetch", "n_tup_ins", "n_tup_upd", "n_tup_del", "n_tup_hot_upd" from pg_catalog.pg_stat_xact_user_tables""".query(PgStatXactUserTablesViewRow.jdbcDecoder).selectStream
  }
}