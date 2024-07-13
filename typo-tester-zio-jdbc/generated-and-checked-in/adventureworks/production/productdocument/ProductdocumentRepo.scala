/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductdocumentRepo {
  def delete: DeleteBuilder[ProductdocumentFields, ProductdocumentRow]
  def deleteById(compositeId: ProductdocumentId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[ProductdocumentId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ProductdocumentRow): ZIO[ZConnection, Throwable, ProductdocumentRow]
  def insert(unsaved: ProductdocumentRowUnsaved): ZIO[ZConnection, Throwable, ProductdocumentRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdocumentRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdocumentRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ProductdocumentFields, ProductdocumentRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductdocumentRow]
  def selectById(compositeId: ProductdocumentId): ZIO[ZConnection, Throwable, Option[ProductdocumentRow]]
  def selectByIds(compositeIds: Array[ProductdocumentId]): ZStream[ZConnection, Throwable, ProductdocumentRow]
  def selectByIdsTracked(compositeIds: Array[ProductdocumentId]): ZIO[ZConnection, Throwable, Map[ProductdocumentId, ProductdocumentRow]]
  def update: UpdateBuilder[ProductdocumentFields, ProductdocumentRow]
  def update(row: ProductdocumentRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ProductdocumentRow): ZIO[ZConnection, Throwable, UpdateResult[ProductdocumentRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdocumentRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
