/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_settings

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgSettingsViewRepo {
  def select: SelectBuilder[PgSettingsViewFields, PgSettingsViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgSettingsViewRow]
}