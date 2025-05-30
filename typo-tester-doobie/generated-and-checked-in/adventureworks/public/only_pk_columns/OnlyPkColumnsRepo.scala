/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package only_pk_columns

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait OnlyPkColumnsRepo {
  def delete: DeleteBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow]
  def deleteById(compositeId: OnlyPkColumnsId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[OnlyPkColumnsId]): ConnectionIO[Int]
  def insert(unsaved: OnlyPkColumnsRow): ConnectionIO[OnlyPkColumnsRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, OnlyPkColumnsRow], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow]
  def selectAll: Stream[ConnectionIO, OnlyPkColumnsRow]
  def selectById(compositeId: OnlyPkColumnsId): ConnectionIO[Option[OnlyPkColumnsRow]]
  def selectByIds(compositeIds: Array[OnlyPkColumnsId]): Stream[ConnectionIO, OnlyPkColumnsRow]
  def selectByIdsTracked(compositeIds: Array[OnlyPkColumnsId]): ConnectionIO[Map[OnlyPkColumnsId, OnlyPkColumnsRow]]
  def update: UpdateBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow]
  def upsert(unsaved: OnlyPkColumnsRow): ConnectionIO[OnlyPkColumnsRow]
  def upsertBatch(unsaved: List[OnlyPkColumnsRow]): Stream[ConnectionIO, OnlyPkColumnsRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, OnlyPkColumnsRow], batchSize: Int = 10000): ConnectionIO[Int]
}
