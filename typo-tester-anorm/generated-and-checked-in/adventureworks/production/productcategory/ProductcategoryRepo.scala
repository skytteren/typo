/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductcategoryRepo {
  def delete: DeleteBuilder[ProductcategoryFields, ProductcategoryRow]
  def deleteById(productcategoryid: ProductcategoryId)(implicit c: Connection): Boolean
  def deleteByIds(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): Int
  def insert(unsaved: ProductcategoryRow)(implicit c: Connection): ProductcategoryRow
  def insert(unsaved: ProductcategoryRowUnsaved)(implicit c: Connection): ProductcategoryRow
  def insertStreaming(unsaved: Iterator[ProductcategoryRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductcategoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ProductcategoryFields, ProductcategoryRow]
  def selectAll(implicit c: Connection): List[ProductcategoryRow]
  def selectById(productcategoryid: ProductcategoryId)(implicit c: Connection): Option[ProductcategoryRow]
  def selectByIds(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): List[ProductcategoryRow]
  def selectByIdsTracked(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): Map[ProductcategoryId, ProductcategoryRow]
  def update: UpdateBuilder[ProductcategoryFields, ProductcategoryRow]
  def update(row: ProductcategoryRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductcategoryRow)(implicit c: Connection): ProductcategoryRow
  def upsertBatch(unsaved: Iterable[ProductcategoryRow])(implicit c: Connection): List[ProductcategoryRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ProductcategoryRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
