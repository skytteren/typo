/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdepend

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PgShdependRepo {
  def insert(unsaved: PgShdependRow): ConnectionIO[PgShdependRow]
  def selectAll: Stream[ConnectionIO, PgShdependRow]
}