/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_column_usage

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait ColumnColumnUsageViewRepo {
  def selectAll: Stream[ConnectionIO, ColumnColumnUsageViewRow]
}