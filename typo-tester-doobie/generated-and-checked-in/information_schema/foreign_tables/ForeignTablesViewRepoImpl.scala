/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_tables

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object ForeignTablesViewRepoImpl extends ForeignTablesViewRepo {
  override def selectAll: Stream[ConnectionIO, ForeignTablesViewRow] = {
    sql"select foreign_table_catalog, foreign_table_schema, foreign_table_name, foreign_server_catalog, foreign_server_name from information_schema.foreign_tables".query(ForeignTablesViewRow.read).stream
  }
}
