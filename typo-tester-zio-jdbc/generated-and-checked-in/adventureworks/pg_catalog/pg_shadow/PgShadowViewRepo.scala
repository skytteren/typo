/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shadow

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgShadowViewRepo {
  def select: SelectBuilder[PgShadowViewFields, PgShadowViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgShadowViewRow]
}