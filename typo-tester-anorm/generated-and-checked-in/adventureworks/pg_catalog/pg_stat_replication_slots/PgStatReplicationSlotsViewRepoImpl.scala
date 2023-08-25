/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication_slots

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatReplicationSlotsViewRepoImpl extends PgStatReplicationSlotsViewRepo {
  override def select: SelectBuilder[PgStatReplicationSlotsViewFields, PgStatReplicationSlotsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_replication_slots", PgStatReplicationSlotsViewFields, PgStatReplicationSlotsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatReplicationSlotsViewRow] = {
    SQL"""select slot_name, spill_txns, spill_count, spill_bytes, stream_txns, stream_count, stream_bytes, total_txns, total_bytes, stats_reset::text
          from pg_catalog.pg_stat_replication_slots
       """.as(PgStatReplicationSlotsViewRow.rowParser(1).*)
  }
}