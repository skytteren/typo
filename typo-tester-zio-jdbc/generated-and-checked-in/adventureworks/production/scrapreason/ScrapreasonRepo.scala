/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ScrapreasonRepo {
  def delete(scrapreasonid: ScrapreasonId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(scrapreasonids: Array[ScrapreasonId]): ZIO[ZConnection, Throwable, Long]
  def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow]
  def insert(unsaved: ScrapreasonRow): ZIO[ZConnection, Throwable, ScrapreasonRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ScrapreasonRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ScrapreasonRowUnsaved): ZIO[ZConnection, Throwable, ScrapreasonRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ScrapreasonRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow]
  def selectAll: ZStream[ZConnection, Throwable, ScrapreasonRow]
  def selectById(scrapreasonid: ScrapreasonId): ZIO[ZConnection, Throwable, Option[ScrapreasonRow]]
  def selectByIds(scrapreasonids: Array[ScrapreasonId]): ZStream[ZConnection, Throwable, ScrapreasonRow]
  def update(row: ScrapreasonRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow]
  def upsert(unsaved: ScrapreasonRow): ZIO[ZConnection, Throwable, UpdateResult[ScrapreasonRow]]
}
