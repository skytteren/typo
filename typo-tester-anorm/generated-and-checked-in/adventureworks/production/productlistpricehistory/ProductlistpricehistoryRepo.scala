/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductlistpricehistoryRepo {
  def delete(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): Int
  def delete: DeleteBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def insert(unsaved: ProductlistpricehistoryRow)(implicit c: Connection): ProductlistpricehistoryRow
  def insertStreaming(unsaved: Iterator[ProductlistpricehistoryRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: ProductlistpricehistoryRowUnsaved)(implicit c: Connection): ProductlistpricehistoryRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductlistpricehistoryRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def selectAll(implicit c: Connection): List[ProductlistpricehistoryRow]
  def selectById(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Option[ProductlistpricehistoryRow]
  def selectByIds(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): List[ProductlistpricehistoryRow]
  def update(row: ProductlistpricehistoryRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def upsert(unsaved: ProductlistpricehistoryRow)(implicit c: Connection): ProductlistpricehistoryRow
}
