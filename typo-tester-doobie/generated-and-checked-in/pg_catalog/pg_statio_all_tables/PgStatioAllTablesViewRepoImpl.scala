/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_tables

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgStatioAllTablesViewRepoImpl extends PgStatioAllTablesViewRepo {
  override def selectAll: Stream[ConnectionIO, PgStatioAllTablesViewRow] = {
    sql"select relid, schemaname, relname, heap_blks_read, heap_blks_hit, idx_blks_read, idx_blks_hit, toast_blks_read, toast_blks_hit, tidx_blks_read, tidx_blks_hit from pg_catalog.pg_statio_all_tables".query(PgStatioAllTablesViewRow.read).stream
  }
}
