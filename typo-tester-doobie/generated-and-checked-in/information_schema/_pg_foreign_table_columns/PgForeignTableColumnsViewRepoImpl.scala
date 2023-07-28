/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_table_columns`

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgForeignTableColumnsViewRepoImpl extends PgForeignTableColumnsViewRepo {
  override def selectAll: Stream[ConnectionIO, PgForeignTableColumnsViewRow] = {
    sql"select nspname, relname, attname, attfdwoptions from information_schema._pg_foreign_table_columns".query(PgForeignTableColumnsViewRow.read).stream
  }
}
