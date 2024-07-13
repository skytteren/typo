/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait JobcandidateRepo {
  def delete: DeleteBuilder[JobcandidateFields, JobcandidateRow]
  def deleteById(jobcandidateid: JobcandidateId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(jobcandidateids: Array[JobcandidateId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: JobcandidateRow): ZIO[ZConnection, Throwable, JobcandidateRow]
  def insert(unsaved: JobcandidateRowUnsaved): ZIO[ZConnection, Throwable, JobcandidateRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, JobcandidateRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, JobcandidateRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[JobcandidateFields, JobcandidateRow]
  def selectAll: ZStream[ZConnection, Throwable, JobcandidateRow]
  def selectById(jobcandidateid: JobcandidateId): ZIO[ZConnection, Throwable, Option[JobcandidateRow]]
  def selectByIds(jobcandidateids: Array[JobcandidateId]): ZStream[ZConnection, Throwable, JobcandidateRow]
  def selectByIdsTracked(jobcandidateids: Array[JobcandidateId]): ZIO[ZConnection, Throwable, Map[JobcandidateId, JobcandidateRow]]
  def update: UpdateBuilder[JobcandidateFields, JobcandidateRow]
  def update(row: JobcandidateRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: JobcandidateRow): ZIO[ZConnection, Throwable, UpdateResult[JobcandidateRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, JobcandidateRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
