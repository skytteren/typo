/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait EmployeedepartmenthistoryRepo {
  def delete: DeleteBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow]
  def deleteById(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): Int
  def insert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow
  def insert(unsaved: EmployeedepartmenthistoryRowUnsaved)(implicit c: Connection): EmployeedepartmenthistoryRow
  def insertStreaming(unsaved: Iterator[EmployeedepartmenthistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[EmployeedepartmenthistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow]
  def selectAll(implicit c: Connection): List[EmployeedepartmenthistoryRow]
  def selectById(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Option[EmployeedepartmenthistoryRow]
  def selectByIds(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): List[EmployeedepartmenthistoryRow]
  def selectByIdsTracked(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): Map[EmployeedepartmenthistoryId, Option[EmployeedepartmenthistoryRow]]
  def update: UpdateBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow]
  def update(row: EmployeedepartmenthistoryRow)(implicit c: Connection): Boolean
  def upsert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow
}
