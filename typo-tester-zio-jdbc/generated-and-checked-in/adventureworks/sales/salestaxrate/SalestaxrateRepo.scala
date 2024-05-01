/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SalestaxrateRepo {
  def delete: DeleteBuilder[SalestaxrateFields, SalestaxrateRow]
  def deleteById(salestaxrateid: SalestaxrateId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(salestaxrateids: Array[SalestaxrateId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: SalestaxrateRow): ZIO[ZConnection, Throwable, SalestaxrateRow]
  def insert(unsaved: SalestaxrateRowUnsaved): ZIO[ZConnection, Throwable, SalestaxrateRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalestaxrateRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalestaxrateRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[SalestaxrateFields, SalestaxrateRow]
  def selectAll: ZStream[ZConnection, Throwable, SalestaxrateRow]
  def selectById(salestaxrateid: SalestaxrateId): ZIO[ZConnection, Throwable, Option[SalestaxrateRow]]
  def selectByIds(salestaxrateids: Array[SalestaxrateId]): ZStream[ZConnection, Throwable, SalestaxrateRow]
  def selectByIdsTracked(salestaxrateids: Array[SalestaxrateId]): ZIO[ZConnection, Throwable, Map[SalestaxrateId, Option[SalestaxrateRow]]]
  def update: UpdateBuilder[SalestaxrateFields, SalestaxrateRow]
  def update(row: SalestaxrateRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: SalestaxrateRow): ZIO[ZConnection, Throwable, UpdateResult[SalestaxrateRow]]
}
