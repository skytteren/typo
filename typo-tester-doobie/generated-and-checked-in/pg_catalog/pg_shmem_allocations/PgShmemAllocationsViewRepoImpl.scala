/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shmem_allocations

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgShmemAllocationsViewRepoImpl extends PgShmemAllocationsViewRepo {
  override def selectAll: Stream[ConnectionIO, PgShmemAllocationsViewRow] = {
    sql"""select "name", "off", "size", allocated_size from pg_catalog.pg_shmem_allocations""".query(PgShmemAllocationsViewRow.read).stream
  }
}
