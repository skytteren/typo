/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cast

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgCastRepo {
  def delete(oid: PgCastId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgCastFields, PgCastRow]
  def insert(unsaved: PgCastRow): ZIO[ZConnection, Throwable, PgCastRow]
  def select: SelectBuilder[PgCastFields, PgCastRow]
  def selectAll: ZStream[ZConnection, Throwable, PgCastRow]
  def selectById(oid: PgCastId): ZIO[ZConnection, Throwable, Option[PgCastRow]]
  def selectByIds(oids: Array[PgCastId]): ZStream[ZConnection, Throwable, PgCastRow]
  def selectByUnique(castsource: /* oid */ Long, casttarget: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgCastRow]]
  def update(row: PgCastRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgCastFields, PgCastRow]
  def upsert(unsaved: PgCastRow): ZIO[ZConnection, Throwable, UpdateResult[PgCastRow]]
}