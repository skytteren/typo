/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ScrapreasonRepo {
  def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow]
  def deleteById(scrapreasonid: ScrapreasonId): ConnectionIO[Boolean]
  def deleteByIds(scrapreasonids: Array[ScrapreasonId]): ConnectionIO[Int]
  def insert(unsaved: ScrapreasonRow): ConnectionIO[ScrapreasonRow]
  def insert(unsaved: ScrapreasonRowUnsaved): ConnectionIO[ScrapreasonRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ScrapreasonRow], batchSize: Int): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ScrapreasonRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow]
  def selectAll: Stream[ConnectionIO, ScrapreasonRow]
  def selectById(scrapreasonid: ScrapreasonId): ConnectionIO[Option[ScrapreasonRow]]
  def selectByIds(scrapreasonids: Array[ScrapreasonId]): Stream[ConnectionIO, ScrapreasonRow]
  def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow]
  def update(row: ScrapreasonRow): ConnectionIO[Boolean]
  def upsert(unsaved: ScrapreasonRow): ConnectionIO[ScrapreasonRow]
}
