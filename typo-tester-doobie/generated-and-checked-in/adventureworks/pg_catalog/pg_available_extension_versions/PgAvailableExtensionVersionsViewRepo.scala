/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_available_extension_versions

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgAvailableExtensionVersionsViewRepo {
  def select: SelectBuilder[PgAvailableExtensionVersionsViewFields, PgAvailableExtensionVersionsViewRow]
  def selectAll: Stream[ConnectionIO, PgAvailableExtensionVersionsViewRow]
}