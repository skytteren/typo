/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductsubcategoryRepo {
  def delete: DeleteBuilder[ProductsubcategoryFields, ProductsubcategoryRow]
  def deleteById(productsubcategoryid: ProductsubcategoryId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(productsubcategoryids: Array[ProductsubcategoryId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ProductsubcategoryRow): ZIO[ZConnection, Throwable, ProductsubcategoryRow]
  def insert(unsaved: ProductsubcategoryRowUnsaved): ZIO[ZConnection, Throwable, ProductsubcategoryRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductsubcategoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductsubcategoryRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ProductsubcategoryFields, ProductsubcategoryRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductsubcategoryRow]
  def selectById(productsubcategoryid: ProductsubcategoryId): ZIO[ZConnection, Throwable, Option[ProductsubcategoryRow]]
  def selectByIds(productsubcategoryids: Array[ProductsubcategoryId]): ZStream[ZConnection, Throwable, ProductsubcategoryRow]
  def selectByIdsTracked(productsubcategoryids: Array[ProductsubcategoryId]): ZIO[ZConnection, Throwable, Map[ProductsubcategoryId, ProductsubcategoryRow]]
  def update: UpdateBuilder[ProductsubcategoryFields, ProductsubcategoryRow]
  def update(row: ProductsubcategoryRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ProductsubcategoryRow): ZIO[ZConnection, Throwable, UpdateResult[ProductsubcategoryRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductsubcategoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
