/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package flaff

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait FlaffRepo {
  def delete: DeleteBuilder[FlaffFields, FlaffRow]
  def deleteById(compositeId: FlaffId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[FlaffId])(implicit c: Connection): Int
  def insert(unsaved: FlaffRow)(implicit c: Connection): FlaffRow
  def insertStreaming(unsaved: Iterator[FlaffRow], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[FlaffFields, FlaffRow]
  def selectAll(implicit c: Connection): List[FlaffRow]
  def selectById(compositeId: FlaffId)(implicit c: Connection): Option[FlaffRow]
  def selectByIds(compositeIds: Array[FlaffId])(implicit c: Connection): List[FlaffRow]
  def update: UpdateBuilder[FlaffFields, FlaffRow]
  def update(row: FlaffRow)(implicit c: Connection): Boolean
  def upsert(unsaved: FlaffRow)(implicit c: Connection): FlaffRow
}
