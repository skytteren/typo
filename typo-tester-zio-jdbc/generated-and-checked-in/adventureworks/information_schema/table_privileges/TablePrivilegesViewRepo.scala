/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_privileges

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait TablePrivilegesViewRepo {
  def select: SelectBuilder[TablePrivilegesViewFields, TablePrivilegesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, TablePrivilegesViewRow]
}