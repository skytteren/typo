/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductphotoRepo {
  def delete: DeleteBuilder[ProductphotoFields, ProductphotoRow]
  def deleteById(productphotoid: ProductphotoId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(productphotoids: Array[ProductphotoId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ProductphotoRow): ZIO[ZConnection, Throwable, ProductphotoRow]
  def insert(unsaved: ProductphotoRowUnsaved): ZIO[ZConnection, Throwable, ProductphotoRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductphotoRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductphotoRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ProductphotoFields, ProductphotoRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductphotoRow]
  def selectById(productphotoid: ProductphotoId): ZIO[ZConnection, Throwable, Option[ProductphotoRow]]
  def selectByIds(productphotoids: Array[ProductphotoId]): ZStream[ZConnection, Throwable, ProductphotoRow]
  def update: UpdateBuilder[ProductphotoFields, ProductphotoRow]
  def update(row: ProductphotoRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ProductphotoRow): ZIO[ZConnection, Throwable, UpdateResult[ProductphotoRow]]
}
