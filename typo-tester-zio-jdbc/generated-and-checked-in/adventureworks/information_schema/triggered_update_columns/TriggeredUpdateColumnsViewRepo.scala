/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggered_update_columns

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait TriggeredUpdateColumnsViewRepo {
  def select: SelectBuilder[TriggeredUpdateColumnsViewFields, TriggeredUpdateColumnsViewRow]
  def selectAll: ZStream[ZConnection, Throwable, TriggeredUpdateColumnsViewRow]
}