/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalesorderheadersalesreasonRepo {
  def delete: DeleteBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def deleteById(compositeId: SalesorderheadersalesreasonId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[SalesorderheadersalesreasonId]): ConnectionIO[Int]
  def insert(unsaved: SalesorderheadersalesreasonRow): ConnectionIO[SalesorderheadersalesreasonRow]
  def insert(unsaved: SalesorderheadersalesreasonRowUnsaved): ConnectionIO[SalesorderheadersalesreasonRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, SalesorderheadersalesreasonRow], batchSize: Int): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesorderheadersalesreasonRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def selectAll: Stream[ConnectionIO, SalesorderheadersalesreasonRow]
  def selectById(compositeId: SalesorderheadersalesreasonId): ConnectionIO[Option[SalesorderheadersalesreasonRow]]
  def selectByIds(compositeIds: Array[SalesorderheadersalesreasonId]): Stream[ConnectionIO, SalesorderheadersalesreasonRow]
  def update: UpdateBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def update(row: SalesorderheadersalesreasonRow): ConnectionIO[Boolean]
  def upsert(unsaved: SalesorderheadersalesreasonRow): ConnectionIO[SalesorderheadersalesreasonRow]
}
