/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_rel

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgPublicationRelRepo {
  def delete(oid: PgPublicationRelId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgPublicationRelFields, PgPublicationRelRow]
  def insert(unsaved: PgPublicationRelRow): ZIO[ZConnection, Throwable, PgPublicationRelRow]
  def select: SelectBuilder[PgPublicationRelFields, PgPublicationRelRow]
  def selectAll: ZStream[ZConnection, Throwable, PgPublicationRelRow]
  def selectById(oid: PgPublicationRelId): ZIO[ZConnection, Throwable, Option[PgPublicationRelRow]]
  def selectByIds(oids: Array[PgPublicationRelId]): ZStream[ZConnection, Throwable, PgPublicationRelRow]
  def selectByUnique(prrelid: /* oid */ Long, prpubid: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgPublicationRelRow]]
  def update(row: PgPublicationRelRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgPublicationRelFields, PgPublicationRelRow]
  def upsert(unsaved: PgPublicationRelRow): ZIO[ZConnection, Throwable, UpdateResult[PgPublicationRelRow]]
}