/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait UnitmeasureRepo {
  def delete(unitmeasurecode: UnitmeasureId): ConnectionIO[Boolean]
  def deleteByIds(unitmeasurecodes: Array[UnitmeasureId]): ConnectionIO[Int]
  def delete: DeleteBuilder[UnitmeasureFields, UnitmeasureRow]
  def insert(unsaved: UnitmeasureRow): ConnectionIO[UnitmeasureRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, UnitmeasureRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: UnitmeasureRowUnsaved): ConnectionIO[UnitmeasureRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, UnitmeasureRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[UnitmeasureFields, UnitmeasureRow]
  def selectAll: Stream[ConnectionIO, UnitmeasureRow]
  def selectById(unitmeasurecode: UnitmeasureId): ConnectionIO[Option[UnitmeasureRow]]
  def selectByIds(unitmeasurecodes: Array[UnitmeasureId]): Stream[ConnectionIO, UnitmeasureRow]
  def update(row: UnitmeasureRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[UnitmeasureFields, UnitmeasureRow]
  def upsert(unsaved: UnitmeasureRow): ConnectionIO[UnitmeasureRow]
}
