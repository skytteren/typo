/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_views

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgViewsViewRepoImpl extends PgViewsViewRepo {
  override def select: SelectBuilder[PgViewsViewFields, PgViewsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_views", PgViewsViewFields, PgViewsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgViewsViewRow] = {
    sql"select schemaname, viewname, viewowner, definition from pg_catalog.pg_views".query(PgViewsViewRow.read).stream
  }
}