/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_backend_memory_contexts

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgBackendMemoryContextsViewRepoImpl extends PgBackendMemoryContextsViewRepo {
  override def select: SelectBuilder[PgBackendMemoryContextsViewFields, PgBackendMemoryContextsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_backend_memory_contexts", PgBackendMemoryContextsViewFields, PgBackendMemoryContextsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgBackendMemoryContextsViewRow] = {
    sql"""select "name", "ident", "parent", "level", "total_bytes", "total_nblocks", "free_bytes", "free_chunks", "used_bytes" from pg_catalog.pg_backend_memory_contexts""".query(PgBackendMemoryContextsViewRow.jdbcDecoder).selectStream
  }
}