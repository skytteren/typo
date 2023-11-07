/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package key_column_usage

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait KeyColumnUsageViewRepo {
  def select: SelectBuilder[KeyColumnUsageViewFields, KeyColumnUsageViewRow]
  def selectAll: ZStream[ZConnection, Throwable, KeyColumnUsageViewRow]
}