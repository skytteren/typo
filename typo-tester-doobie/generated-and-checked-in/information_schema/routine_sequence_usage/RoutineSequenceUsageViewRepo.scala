/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_sequence_usage

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait RoutineSequenceUsageViewRepo {
  def selectAll: Stream[ConnectionIO, RoutineSequenceUsageViewRow]
}