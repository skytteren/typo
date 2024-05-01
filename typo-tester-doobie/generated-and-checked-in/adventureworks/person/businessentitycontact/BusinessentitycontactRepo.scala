/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait BusinessentitycontactRepo {
  def delete: DeleteBuilder[BusinessentitycontactFields, BusinessentitycontactRow]
  def deleteById(compositeId: BusinessentitycontactId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[BusinessentitycontactId]): ConnectionIO[Int]
  def insert(unsaved: BusinessentitycontactRow): ConnectionIO[BusinessentitycontactRow]
  def insert(unsaved: BusinessentitycontactRowUnsaved): ConnectionIO[BusinessentitycontactRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, BusinessentitycontactRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BusinessentitycontactRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[BusinessentitycontactFields, BusinessentitycontactRow]
  def selectAll: Stream[ConnectionIO, BusinessentitycontactRow]
  def selectById(compositeId: BusinessentitycontactId): ConnectionIO[Option[BusinessentitycontactRow]]
  def selectByIds(compositeIds: Array[BusinessentitycontactId]): Stream[ConnectionIO, BusinessentitycontactRow]
  def selectByIdsTracked(compositeIds: Array[BusinessentitycontactId]): ConnectionIO[Map[BusinessentitycontactId, Option[BusinessentitycontactRow]]]
  def update: UpdateBuilder[BusinessentitycontactFields, BusinessentitycontactRow]
  def update(row: BusinessentitycontactRow): ConnectionIO[Boolean]
  def upsert(unsaved: BusinessentitycontactRow): ConnectionIO[BusinessentitycontactRow]
}
