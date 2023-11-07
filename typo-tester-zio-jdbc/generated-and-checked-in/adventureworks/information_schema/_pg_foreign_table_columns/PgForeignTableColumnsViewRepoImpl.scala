/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_table_columns`

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgForeignTableColumnsViewRepoImpl extends PgForeignTableColumnsViewRepo {
  override def select: SelectBuilder[PgForeignTableColumnsViewFields, PgForeignTableColumnsViewRow] = {
    SelectBuilderSql("information_schema._pg_foreign_table_columns", PgForeignTableColumnsViewFields, PgForeignTableColumnsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgForeignTableColumnsViewRow] = {
    sql"""select "nspname", "relname", "attname", "attfdwoptions" from information_schema._pg_foreign_table_columns""".query(PgForeignTableColumnsViewRow.jdbcDecoder).selectStream
  }
}