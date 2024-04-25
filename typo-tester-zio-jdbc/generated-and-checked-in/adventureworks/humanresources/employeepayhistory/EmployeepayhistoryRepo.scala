/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait EmployeepayhistoryRepo {
  def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow]
  def deleteById(compositeId: EmployeepayhistoryId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[EmployeepayhistoryId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, EmployeepayhistoryRow]
  def insert(unsaved: EmployeepayhistoryRowUnsaved): ZIO[ZConnection, Throwable, EmployeepayhistoryRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeepayhistoryRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeepayhistoryRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow]
  def selectAll: ZStream[ZConnection, Throwable, EmployeepayhistoryRow]
  def selectById(compositeId: EmployeepayhistoryId): ZIO[ZConnection, Throwable, Option[EmployeepayhistoryRow]]
  def selectByIds(compositeIds: Array[EmployeepayhistoryId]): ZStream[ZConnection, Throwable, EmployeepayhistoryRow]
  def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow]
  def update(row: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeepayhistoryRow]]
}
