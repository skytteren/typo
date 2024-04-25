/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductreviewRepo {
  def delete(productreviewid: ProductreviewId)(implicit c: Connection): Boolean
  def deleteByIds(productreviewids: Array[ProductreviewId])(implicit c: Connection): Int
  def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow]
  def insert(unsaved: ProductreviewRow)(implicit c: Connection): ProductreviewRow
  def insertStreaming(unsaved: Iterator[ProductreviewRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: ProductreviewRowUnsaved)(implicit c: Connection): ProductreviewRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductreviewRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[ProductreviewFields, ProductreviewRow]
  def selectAll(implicit c: Connection): List[ProductreviewRow]
  def selectById(productreviewid: ProductreviewId)(implicit c: Connection): Option[ProductreviewRow]
  def selectByIds(productreviewids: Array[ProductreviewId])(implicit c: Connection): List[ProductreviewRow]
  def update(row: ProductreviewRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[ProductreviewFields, ProductreviewRow]
  def upsert(unsaved: ProductreviewRow)(implicit c: Connection): ProductreviewRow
}
