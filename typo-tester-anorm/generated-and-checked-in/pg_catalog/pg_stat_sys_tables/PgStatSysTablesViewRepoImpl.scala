/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_sys_tables

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgStatSysTablesViewRepoImpl extends PgStatSysTablesViewRepo {
  override def selectAll(implicit c: Connection): List[PgStatSysTablesViewRow] = {
    SQL"""select relid, schemaname, relname, seq_scan, seq_tup_read, idx_scan, idx_tup_fetch, n_tup_ins, n_tup_upd, n_tup_del, n_tup_hot_upd, n_live_tup, n_dead_tup, n_mod_since_analyze, n_ins_since_vacuum, last_vacuum::text, last_autovacuum::text, last_analyze::text, last_autoanalyze::text, vacuum_count, autovacuum_count, analyze_count, autoanalyze_count
          from pg_catalog.pg_stat_sys_tables
       """.as(PgStatSysTablesViewRow.rowParser(1).*)
  }
}
