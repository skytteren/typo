/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductRepo {
  def delete: DeleteBuilder[ProductFields, ProductRow]
  def deleteById(productid: ProductId): ConnectionIO[Boolean]
  def deleteByIds(productids: Array[ProductId]): ConnectionIO[Int]
  def insert(unsaved: ProductRow): ConnectionIO[ProductRow]
  def insert(unsaved: ProductRowUnsaved): ConnectionIO[ProductRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductRow], batchSize: Int): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[ProductFields, ProductRow]
  def selectAll: Stream[ConnectionIO, ProductRow]
  def selectById(productid: ProductId): ConnectionIO[Option[ProductRow]]
  def selectByIds(productids: Array[ProductId]): Stream[ConnectionIO, ProductRow]
  def update: UpdateBuilder[ProductFields, ProductRow]
  def update(row: ProductRow): ConnectionIO[Boolean]
  def upsert(unsaved: ProductRow): ConnectionIO[ProductRow]
}
