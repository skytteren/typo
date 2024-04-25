/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductinventoryRepo {
  def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow]
  def deleteById(compositeId: ProductinventoryId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[ProductinventoryId]): ConnectionIO[Int]
  def insert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow]
  def insert(unsaved: ProductinventoryRowUnsaved): ConnectionIO[ProductinventoryRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductinventoryRow], batchSize: Int): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductinventoryRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow]
  def selectAll: Stream[ConnectionIO, ProductinventoryRow]
  def selectById(compositeId: ProductinventoryId): ConnectionIO[Option[ProductinventoryRow]]
  def selectByIds(compositeIds: Array[ProductinventoryId]): Stream[ConnectionIO, ProductinventoryRow]
  def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow]
  def update(row: ProductinventoryRow): ConnectionIO[Boolean]
  def upsert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow]
}
