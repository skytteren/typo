/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_sequences

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgStatioSysSequencesViewRepoImpl extends PgStatioSysSequencesViewRepo {
  override def selectAll(implicit c: Connection): List[PgStatioSysSequencesViewRow] = {
    SQL"""select relid, schemaname, relname, blks_read, blks_hit
          from pg_catalog.pg_statio_sys_sequences
       """.as(PgStatioSysSequencesViewRow.rowParser(1).*)
  }
}