/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PhonenumbertypeRepo {
  def delete: DeleteBuilder[PhonenumbertypeFields, PhonenumbertypeRow]
  def deleteById(phonenumbertypeid: PhonenumbertypeId): ConnectionIO[Boolean]
  def deleteByIds(phonenumbertypeids: Array[PhonenumbertypeId]): ConnectionIO[Int]
  def insert(unsaved: PhonenumbertypeRow): ConnectionIO[PhonenumbertypeRow]
  def insert(unsaved: PhonenumbertypeRowUnsaved): ConnectionIO[PhonenumbertypeRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, PhonenumbertypeRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PhonenumbertypeRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[PhonenumbertypeFields, PhonenumbertypeRow]
  def selectAll: Stream[ConnectionIO, PhonenumbertypeRow]
  def selectById(phonenumbertypeid: PhonenumbertypeId): ConnectionIO[Option[PhonenumbertypeRow]]
  def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId]): Stream[ConnectionIO, PhonenumbertypeRow]
  def selectByIdsTracked(phonenumbertypeids: Array[PhonenumbertypeId]): ConnectionIO[Map[PhonenumbertypeId, Option[PhonenumbertypeRow]]]
  def update: UpdateBuilder[PhonenumbertypeFields, PhonenumbertypeRow]
  def update(row: PhonenumbertypeRow): ConnectionIO[Boolean]
  def upsert(unsaved: PhonenumbertypeRow): ConnectionIO[PhonenumbertypeRow]
}
