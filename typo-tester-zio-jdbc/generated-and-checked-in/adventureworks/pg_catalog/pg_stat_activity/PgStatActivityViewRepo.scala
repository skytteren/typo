/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_activity

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgStatActivityViewRepo {
  def select: SelectBuilder[PgStatActivityViewFields, PgStatActivityViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgStatActivityViewRow]
}