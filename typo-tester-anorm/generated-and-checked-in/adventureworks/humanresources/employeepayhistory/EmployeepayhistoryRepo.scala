/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait EmployeepayhistoryRepo {
  def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow]
  def deleteById(compositeId: EmployeepayhistoryId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[EmployeepayhistoryId])(implicit c: Connection): Int
  def insert(unsaved: EmployeepayhistoryRow)(implicit c: Connection): EmployeepayhistoryRow
  def insert(unsaved: EmployeepayhistoryRowUnsaved)(implicit c: Connection): EmployeepayhistoryRow
  def insertStreaming(unsaved: Iterator[EmployeepayhistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[EmployeepayhistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow]
  def selectAll(implicit c: Connection): List[EmployeepayhistoryRow]
  def selectById(compositeId: EmployeepayhistoryId)(implicit c: Connection): Option[EmployeepayhistoryRow]
  def selectByIds(compositeIds: Array[EmployeepayhistoryId])(implicit c: Connection): List[EmployeepayhistoryRow]
  def selectByIdsTracked(compositeIds: Array[EmployeepayhistoryId])(implicit c: Connection): Map[EmployeepayhistoryId, EmployeepayhistoryRow]
  def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow]
  def update(row: EmployeepayhistoryRow)(implicit c: Connection): Boolean
  def upsert(unsaved: EmployeepayhistoryRow)(implicit c: Connection): EmployeepayhistoryRow
  def upsertBatch(unsaved: Iterable[EmployeepayhistoryRow])(implicit c: Connection): List[EmployeepayhistoryRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[EmployeepayhistoryRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
