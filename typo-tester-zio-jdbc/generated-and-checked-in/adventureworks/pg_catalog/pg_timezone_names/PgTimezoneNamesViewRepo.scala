/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_timezone_names

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgTimezoneNamesViewRepo {
  def select: SelectBuilder[PgTimezoneNamesViewFields, PgTimezoneNamesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgTimezoneNamesViewRow]
}