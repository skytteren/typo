/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_xacts

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PgPreparedXactsViewRepo {
  def selectAll: Stream[ConnectionIO, PgPreparedXactsViewRow]
}