/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_table_usage

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object ConstraintTableUsageViewRepoImpl extends ConstraintTableUsageViewRepo {
  override def selectAll: Stream[ConnectionIO, ConstraintTableUsageViewRow] = {
    sql"""select table_catalog, table_schema, "table_name", "constraint_catalog", "constraint_schema", "constraint_name" from information_schema.constraint_table_usage""".query(ConstraintTableUsageViewRow.read).stream
  }
}
