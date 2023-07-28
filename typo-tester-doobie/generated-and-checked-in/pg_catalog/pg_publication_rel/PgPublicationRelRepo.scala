/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_rel

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PgPublicationRelRepo {
  def delete(oid: PgPublicationRelId): ConnectionIO[Boolean]
  def insert(unsaved: PgPublicationRelRow): ConnectionIO[PgPublicationRelRow]
  def selectAll: Stream[ConnectionIO, PgPublicationRelRow]
  def selectById(oid: PgPublicationRelId): ConnectionIO[Option[PgPublicationRelRow]]
  def selectByIds(oids: Array[PgPublicationRelId]): Stream[ConnectionIO, PgPublicationRelRow]
  def update(row: PgPublicationRelRow): ConnectionIO[Boolean]
  def upsert(unsaved: PgPublicationRelRow): ConnectionIO[PgPublicationRelRow]
}