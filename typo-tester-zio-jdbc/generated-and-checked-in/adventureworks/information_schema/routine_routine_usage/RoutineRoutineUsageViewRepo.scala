/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_routine_usage

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait RoutineRoutineUsageViewRepo {
  def select: SelectBuilder[RoutineRoutineUsageViewFields, RoutineRoutineUsageViewRow]
  def selectAll: ZStream[ZConnection, Throwable, RoutineRoutineUsageViewRow]
}