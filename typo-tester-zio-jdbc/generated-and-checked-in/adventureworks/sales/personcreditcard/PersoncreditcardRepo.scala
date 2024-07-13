/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.userdefined.CustomCreditcardId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.JdbcEncoder
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PersoncreditcardRepo {
  def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def deleteById(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, PersoncreditcardRow]
  def insert(unsaved: PersoncreditcardRowUnsaved): ZIO[ZConnection, Throwable, PersoncreditcardRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def selectAll: ZStream[ZConnection, Throwable, PersoncreditcardRow]
  def selectById(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Option[PersoncreditcardRow]]
  def selectByIds(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZStream[ZConnection, Throwable, PersoncreditcardRow]
  def selectByIdsTracked(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Map[PersoncreditcardId, PersoncreditcardRow]]
  def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def update(row: PersoncreditcardRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, UpdateResult[PersoncreditcardRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
