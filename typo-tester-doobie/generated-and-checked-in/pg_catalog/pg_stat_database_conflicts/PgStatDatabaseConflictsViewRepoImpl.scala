/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database_conflicts

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgStatDatabaseConflictsViewRepoImpl extends PgStatDatabaseConflictsViewRepo {
  override def selectAll: Stream[ConnectionIO, PgStatDatabaseConflictsViewRow] = {
    sql"select datid, datname, confl_tablespace, confl_lock, confl_snapshot, confl_bufferpin, confl_deadlock from pg_catalog.pg_stat_database_conflicts".query(PgStatDatabaseConflictsViewRow.read).stream
  }
}
