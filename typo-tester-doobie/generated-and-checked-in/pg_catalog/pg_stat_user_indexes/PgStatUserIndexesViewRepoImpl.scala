/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_indexes

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgStatUserIndexesViewRepoImpl extends PgStatUserIndexesViewRepo {
  override def selectAll: Stream[ConnectionIO, PgStatUserIndexesViewRow] = {
    sql"select relid, indexrelid, schemaname, relname, indexrelname, idx_scan, idx_tup_read, idx_tup_fetch from pg_catalog.pg_stat_user_indexes".query(PgStatUserIndexesViewRow.read).stream
  }
}
