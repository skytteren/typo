/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait StateprovinceRepo {
  def delete: DeleteBuilder[StateprovinceFields, StateprovinceRow]
  def deleteById(stateprovinceid: StateprovinceId)(implicit c: Connection): Boolean
  def deleteByIds(stateprovinceids: Array[StateprovinceId])(implicit c: Connection): Int
  def insert(unsaved: StateprovinceRow)(implicit c: Connection): StateprovinceRow
  def insert(unsaved: StateprovinceRowUnsaved)(implicit c: Connection): StateprovinceRow
  def insertStreaming(unsaved: Iterator[StateprovinceRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[StateprovinceRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[StateprovinceFields, StateprovinceRow]
  def selectAll(implicit c: Connection): List[StateprovinceRow]
  def selectById(stateprovinceid: StateprovinceId)(implicit c: Connection): Option[StateprovinceRow]
  def selectByIds(stateprovinceids: Array[StateprovinceId])(implicit c: Connection): List[StateprovinceRow]
  def selectByIdsTracked(stateprovinceids: Array[StateprovinceId])(implicit c: Connection): Map[StateprovinceId, Option[StateprovinceRow]]
  def update: UpdateBuilder[StateprovinceFields, StateprovinceRow]
  def update(row: StateprovinceRow)(implicit c: Connection): Boolean
  def upsert(unsaved: StateprovinceRow)(implicit c: Connection): StateprovinceRow
}
