/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_conversion

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgConversionRepo {
  def delete(oid: PgConversionId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgConversionFields, PgConversionRow]
  def insert(unsaved: PgConversionRow): ZIO[ZConnection, Throwable, PgConversionRow]
  def select: SelectBuilder[PgConversionFields, PgConversionRow]
  def selectAll: ZStream[ZConnection, Throwable, PgConversionRow]
  def selectById(oid: PgConversionId): ZIO[ZConnection, Throwable, Option[PgConversionRow]]
  def selectByIds(oids: Array[PgConversionId]): ZStream[ZConnection, Throwable, PgConversionRow]
  def selectByUnique(conname: String, connamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgConversionRow]]
  def selectByUnique(connamespace: /* oid */ Long, conforencoding: Int, contoencoding: Int, oid: PgConversionId): ZIO[ZConnection, Throwable, Option[PgConversionRow]]
  def update(row: PgConversionRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgConversionFields, PgConversionRow]
  def upsert(unsaved: PgConversionRow): ZIO[ZConnection, Throwable, UpdateResult[PgConversionRow]]
}