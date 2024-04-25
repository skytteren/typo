/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalespersonRepo {
  def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int]
  def delete: DeleteBuilder[SalespersonFields, SalespersonRow]
  def insert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, SalespersonRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: SalespersonRowUnsaved): ConnectionIO[SalespersonRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalespersonRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[SalespersonFields, SalespersonRow]
  def selectAll: Stream[ConnectionIO, SalespersonRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[SalespersonRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, SalespersonRow]
  def update(row: SalespersonRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[SalespersonFields, SalespersonRow]
  def upsert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow]
}
