/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_table_columns`

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgForeignTableColumnsViewRepo {
  def select: SelectBuilder[PgForeignTableColumnsViewFields, PgForeignTableColumnsViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgForeignTableColumnsViewRow]
}