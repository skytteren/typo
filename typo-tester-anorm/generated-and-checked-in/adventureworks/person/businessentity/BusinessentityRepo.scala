/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait BusinessentityRepo {
  def delete: DeleteBuilder[BusinessentityFields, BusinessentityRow]
  def deleteById(businessentityid: BusinessentityId)(implicit c: Connection): Boolean
  def deleteByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): Int
  def insert(unsaved: BusinessentityRow)(implicit c: Connection): BusinessentityRow
  def insert(unsaved: BusinessentityRowUnsaved)(implicit c: Connection): BusinessentityRow
  def insertStreaming(unsaved: Iterator[BusinessentityRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[BusinessentityRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[BusinessentityFields, BusinessentityRow]
  def selectAll(implicit c: Connection): List[BusinessentityRow]
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[BusinessentityRow]
  def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[BusinessentityRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId])(implicit c: Connection): Map[BusinessentityId, Option[BusinessentityRow]]
  def update: UpdateBuilder[BusinessentityFields, BusinessentityRow]
  def update(row: BusinessentityRow)(implicit c: Connection): Boolean
  def upsert(unsaved: BusinessentityRow)(implicit c: Connection): BusinessentityRow
}
