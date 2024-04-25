/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductmodelproductdescriptioncultureRepo {
  def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def deleteById(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId])(implicit c: Connection): Int
  def insert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
  def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
  def insertStreaming(unsaved: Iterator[ProductmodelproductdescriptioncultureRow], batchSize: Int)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductmodelproductdescriptioncultureRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def selectAll(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow]
  def selectById(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Option[ProductmodelproductdescriptioncultureRow]
  def selectByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId])(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow]
  def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def update(row: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
}
