/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication_slots

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgStatReplicationSlotsViewRepoImpl extends PgStatReplicationSlotsViewRepo {
  override def selectAll: Stream[ConnectionIO, PgStatReplicationSlotsViewRow] = {
    sql"select slot_name, spill_txns, spill_count, spill_bytes, stream_txns, stream_count, stream_bytes, total_txns, total_bytes, stats_reset::text from pg_catalog.pg_stat_replication_slots".query[PgStatReplicationSlotsViewRow].stream
  }
}
