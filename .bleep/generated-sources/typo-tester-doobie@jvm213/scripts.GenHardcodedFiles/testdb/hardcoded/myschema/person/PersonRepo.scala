/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PersonRepo {
  def delete: DeleteBuilder[PersonFields, PersonRow]
  def deleteById(id: PersonId): ConnectionIO[Boolean]
  def deleteByIds(ids: Array[PersonId]): ConnectionIO[Int]
  def insert(unsaved: PersonRow): ConnectionIO[PersonRow]
  def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, PersonRow], batchSize: Int): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersonRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[PersonFields, PersonRow]
  def selectAll: Stream[ConnectionIO, PersonRow]
  def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]]): Stream[ConnectionIO, PersonRow]
  def selectById(id: PersonId): ConnectionIO[Option[PersonRow]]
  def selectByIds(ids: Array[PersonId]): Stream[ConnectionIO, PersonRow]
  def update: UpdateBuilder[PersonFields, PersonRow]
  def update(row: PersonRow): ConnectionIO[Boolean]
  def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[?]]): ConnectionIO[Boolean]
  def upsert(unsaved: PersonRow): ConnectionIO[PersonRow]
}
