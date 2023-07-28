/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_slru

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgStatSlruViewRepoImpl extends PgStatSlruViewRepo {
  override def selectAll: Stream[ConnectionIO, PgStatSlruViewRow] = {
    sql"""select "name", blks_zeroed, blks_hit, blks_read, blks_written, blks_exists, flushes, truncates, stats_reset::text from pg_catalog.pg_stat_slru""".query(PgStatSlruViewRow.read).stream
  }
}
