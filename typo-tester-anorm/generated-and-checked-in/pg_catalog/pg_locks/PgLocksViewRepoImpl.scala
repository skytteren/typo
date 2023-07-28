/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_locks

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgLocksViewRepoImpl extends PgLocksViewRepo {
  override def selectAll(implicit c: Connection): List[PgLocksViewRow] = {
    SQL"""select locktype, "database", relation, page, tuple, virtualxid, transactionid, classid, objid, objsubid, virtualtransaction, pid, "mode", "granted", fastpath, waitstart
          from pg_catalog.pg_locks
       """.as(PgLocksViewRow.rowParser(1).*)
  }
}