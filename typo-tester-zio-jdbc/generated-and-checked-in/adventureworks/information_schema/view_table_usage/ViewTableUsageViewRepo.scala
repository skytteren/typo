/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_table_usage

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ViewTableUsageViewRepo {
  def select: SelectBuilder[ViewTableUsageViewFields, ViewTableUsageViewRow]
  def selectAll: ZStream[ZConnection, Throwable, ViewTableUsageViewRow]
}