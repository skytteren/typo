/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PersonRepo {
  def delete: DeleteBuilder[PersonFields, PersonRow]
  def deleteById(compositeId: PersonId): ConnectionIO[Boolean]
  def insert(unsaved: PersonRow): ConnectionIO[PersonRow]
  def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, PersonRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersonRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[PersonFields, PersonRow]
  def selectAll: Stream[ConnectionIO, PersonRow]
  def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]]): Stream[ConnectionIO, PersonRow]
  def selectById(compositeId: PersonId): ConnectionIO[Option[PersonRow]]
  def update: UpdateBuilder[PersonFields, PersonRow]
  def update(row: PersonRow): ConnectionIO[Boolean]
  def updateFieldValues(compositeId: PersonId, fieldValues: List[PersonFieldValue[?]]): ConnectionIO[Boolean]
  def upsert(unsaved: PersonRow): ConnectionIO[PersonRow]
}
