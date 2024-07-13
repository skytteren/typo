/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SalesterritoryRepo {
  def delete: DeleteBuilder[SalesterritoryFields, SalesterritoryRow]
  def deleteById(territoryid: SalesterritoryId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(territoryids: Array[SalesterritoryId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: SalesterritoryRow): ZIO[ZConnection, Throwable, SalesterritoryRow]
  def insert(unsaved: SalesterritoryRowUnsaved): ZIO[ZConnection, Throwable, SalesterritoryRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesterritoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesterritoryRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[SalesterritoryFields, SalesterritoryRow]
  def selectAll: ZStream[ZConnection, Throwable, SalesterritoryRow]
  def selectById(territoryid: SalesterritoryId): ZIO[ZConnection, Throwable, Option[SalesterritoryRow]]
  def selectByIds(territoryids: Array[SalesterritoryId]): ZStream[ZConnection, Throwable, SalesterritoryRow]
  def selectByIdsTracked(territoryids: Array[SalesterritoryId]): ZIO[ZConnection, Throwable, Map[SalesterritoryId, SalesterritoryRow]]
  def update: UpdateBuilder[SalesterritoryFields, SalesterritoryRow]
  def update(row: SalesterritoryRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: SalesterritoryRow): ZIO[ZConnection, Throwable, UpdateResult[SalesterritoryRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesterritoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
