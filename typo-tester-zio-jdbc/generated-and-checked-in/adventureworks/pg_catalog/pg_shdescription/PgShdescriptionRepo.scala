/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdescription

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgShdescriptionRepo {
  def delete(compositeId: PgShdescriptionId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgShdescriptionFields, PgShdescriptionRow]
  def insert(unsaved: PgShdescriptionRow): ZIO[ZConnection, Throwable, PgShdescriptionRow]
  def select: SelectBuilder[PgShdescriptionFields, PgShdescriptionRow]
  def selectAll: ZStream[ZConnection, Throwable, PgShdescriptionRow]
  def selectById(compositeId: PgShdescriptionId): ZIO[ZConnection, Throwable, Option[PgShdescriptionRow]]
  def update(row: PgShdescriptionRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgShdescriptionFields, PgShdescriptionRow]
  def upsert(unsaved: PgShdescriptionRow): ZIO[ZConnection, Throwable, UpdateResult[PgShdescriptionRow]]
}