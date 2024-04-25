/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ShoppingcartitemRepo {
  def delete: DeleteBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def deleteById(shoppingcartitemid: ShoppingcartitemId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(shoppingcartitemids: Array[ShoppingcartitemId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ShoppingcartitemRow): ZIO[ZConnection, Throwable, ShoppingcartitemRow]
  def insert(unsaved: ShoppingcartitemRowUnsaved): ZIO[ZConnection, Throwable, ShoppingcartitemRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ShoppingcartitemRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ShoppingcartitemRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def selectAll: ZStream[ZConnection, Throwable, ShoppingcartitemRow]
  def selectById(shoppingcartitemid: ShoppingcartitemId): ZIO[ZConnection, Throwable, Option[ShoppingcartitemRow]]
  def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId]): ZStream[ZConnection, Throwable, ShoppingcartitemRow]
  def update: UpdateBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def update(row: ShoppingcartitemRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ShoppingcartitemRow): ZIO[ZConnection, Throwable, UpdateResult[ShoppingcartitemRow]]
}
