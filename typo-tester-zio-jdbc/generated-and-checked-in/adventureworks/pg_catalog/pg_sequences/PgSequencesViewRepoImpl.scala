/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequences

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgSequencesViewRepoImpl extends PgSequencesViewRepo {
  override def select: SelectBuilder[PgSequencesViewFields, PgSequencesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_sequences", PgSequencesViewFields, PgSequencesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgSequencesViewRow] = {
    sql"""select "schemaname", "sequencename", "sequenceowner", "data_type", "start_value", "min_value", "max_value", "increment_by", "cycle", "cache_size", "last_value" from pg_catalog.pg_sequences""".query(PgSequencesViewRow.jdbcDecoder).selectStream
  }
}