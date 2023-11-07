/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_indexes

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatioUserIndexesViewRepoImpl extends PgStatioUserIndexesViewRepo {
  override def select: SelectBuilder[PgStatioUserIndexesViewFields, PgStatioUserIndexesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_statio_user_indexes", PgStatioUserIndexesViewFields, PgStatioUserIndexesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatioUserIndexesViewRow] = {
    sql"""select "relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_blks_read", "idx_blks_hit" from pg_catalog.pg_statio_user_indexes""".query(PgStatioUserIndexesViewRow.jdbcDecoder).selectStream
  }
}