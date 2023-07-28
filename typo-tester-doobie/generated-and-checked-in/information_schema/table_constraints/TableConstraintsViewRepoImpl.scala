/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_constraints

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object TableConstraintsViewRepoImpl extends TableConstraintsViewRepo {
  override def selectAll: Stream[ConnectionIO, TableConstraintsViewRow] = {
    sql"""select "constraint_catalog", "constraint_schema", "constraint_name", table_catalog, table_schema, "table_name", constraint_type, is_deferrable, initially_deferred, "enforced" from information_schema.table_constraints""".query(TableConstraintsViewRow.read).stream
  }
}
