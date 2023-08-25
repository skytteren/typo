/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_matviews

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgMatviewsViewRepoImpl extends PgMatviewsViewRepo {
  override def select: SelectBuilder[PgMatviewsViewFields, PgMatviewsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_matviews", PgMatviewsViewFields, PgMatviewsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgMatviewsViewRow] = {
    sql"""select schemaname, matviewname, matviewowner, "tablespace", hasindexes, ispopulated, definition from pg_catalog.pg_matviews""".query(PgMatviewsViewRow.read).stream
  }
}