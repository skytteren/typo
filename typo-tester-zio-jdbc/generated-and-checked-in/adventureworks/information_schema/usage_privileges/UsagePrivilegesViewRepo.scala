/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package usage_privileges

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait UsagePrivilegesViewRepo {
  def select: SelectBuilder[UsagePrivilegesViewFields, UsagePrivilegesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, UsagePrivilegesViewRow]
}