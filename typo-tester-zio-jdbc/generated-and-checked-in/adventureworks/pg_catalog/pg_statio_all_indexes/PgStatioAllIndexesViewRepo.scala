/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_indexes

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgStatioAllIndexesViewRepo {
  def select: SelectBuilder[PgStatioAllIndexesViewFields, PgStatioAllIndexesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgStatioAllIndexesViewRow]
}