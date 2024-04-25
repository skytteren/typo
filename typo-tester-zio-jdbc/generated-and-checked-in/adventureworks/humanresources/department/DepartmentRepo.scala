/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait DepartmentRepo {
  def delete: DeleteBuilder[DepartmentFields, DepartmentRow]
  def deleteById(departmentid: DepartmentId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(departmentids: Array[DepartmentId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: DepartmentRow): ZIO[ZConnection, Throwable, DepartmentRow]
  def insert(unsaved: DepartmentRowUnsaved): ZIO[ZConnection, Throwable, DepartmentRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, DepartmentRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, DepartmentRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[DepartmentFields, DepartmentRow]
  def selectAll: ZStream[ZConnection, Throwable, DepartmentRow]
  def selectById(departmentid: DepartmentId): ZIO[ZConnection, Throwable, Option[DepartmentRow]]
  def selectByIds(departmentids: Array[DepartmentId]): ZStream[ZConnection, Throwable, DepartmentRow]
  def update: UpdateBuilder[DepartmentFields, DepartmentRow]
  def update(row: DepartmentRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: DepartmentRow): ZIO[ZConnection, Throwable, UpdateResult[DepartmentRow]]
}
