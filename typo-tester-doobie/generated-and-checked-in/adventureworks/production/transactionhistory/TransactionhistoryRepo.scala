/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait TransactionhistoryRepo {
  def delete: DeleteBuilder[TransactionhistoryFields, TransactionhistoryRow]
  def deleteById(transactionid: TransactionhistoryId): ConnectionIO[Boolean]
  def deleteByIds(transactionids: Array[TransactionhistoryId]): ConnectionIO[Int]
  def insert(unsaved: TransactionhistoryRow): ConnectionIO[TransactionhistoryRow]
  def insert(unsaved: TransactionhistoryRowUnsaved): ConnectionIO[TransactionhistoryRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[TransactionhistoryFields, TransactionhistoryRow]
  def selectAll: Stream[ConnectionIO, TransactionhistoryRow]
  def selectById(transactionid: TransactionhistoryId): ConnectionIO[Option[TransactionhistoryRow]]
  def selectByIds(transactionids: Array[TransactionhistoryId]): Stream[ConnectionIO, TransactionhistoryRow]
  def selectByIdsTracked(transactionids: Array[TransactionhistoryId]): ConnectionIO[Map[TransactionhistoryId, Option[TransactionhistoryRow]]]
  def update: UpdateBuilder[TransactionhistoryFields, TransactionhistoryRow]
  def update(row: TransactionhistoryRow): ConnectionIO[Boolean]
  def upsert(unsaved: TransactionhistoryRow): ConnectionIO[TransactionhistoryRow]
}
