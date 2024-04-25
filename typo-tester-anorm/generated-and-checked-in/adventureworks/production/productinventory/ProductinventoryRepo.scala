/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductinventoryRepo {
  def delete(compositeId: ProductinventoryId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[ProductinventoryId])(implicit c: Connection): Int
  def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow]
  def insert(unsaved: ProductinventoryRow)(implicit c: Connection): ProductinventoryRow
  def insertStreaming(unsaved: Iterator[ProductinventoryRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: ProductinventoryRowUnsaved)(implicit c: Connection): ProductinventoryRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductinventoryRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow]
  def selectAll(implicit c: Connection): List[ProductinventoryRow]
  def selectById(compositeId: ProductinventoryId)(implicit c: Connection): Option[ProductinventoryRow]
  def selectByIds(compositeIds: Array[ProductinventoryId])(implicit c: Connection): List[ProductinventoryRow]
  def update(row: ProductinventoryRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow]
  def upsert(unsaved: ProductinventoryRow)(implicit c: Connection): ProductinventoryRow
}
