/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_namespace

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgNamespaceRepo {
  def delete(oid: PgNamespaceId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgNamespaceFields, PgNamespaceRow]
  def insert(unsaved: PgNamespaceRow): ConnectionIO[PgNamespaceRow]
  def select: SelectBuilder[PgNamespaceFields, PgNamespaceRow]
  def selectAll: Stream[ConnectionIO, PgNamespaceRow]
  def selectById(oid: PgNamespaceId): ConnectionIO[Option[PgNamespaceRow]]
  def selectByIds(oids: Array[PgNamespaceId]): Stream[ConnectionIO, PgNamespaceRow]
  def selectByUnique(nspname: String): ConnectionIO[Option[PgNamespaceRow]]
  def update(row: PgNamespaceRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgNamespaceFields, PgNamespaceRow]
  def upsert(unsaved: PgNamespaceRow): ConnectionIO[PgNamespaceRow]
}