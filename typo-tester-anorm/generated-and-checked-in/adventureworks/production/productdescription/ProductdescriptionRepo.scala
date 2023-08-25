/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductdescriptionRepo {
  def delete(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def insert(unsaved: ProductdescriptionRow)(implicit c: Connection): ProductdescriptionRow
  def insert(unsaved: ProductdescriptionRowUnsaved)(implicit c: Connection): ProductdescriptionRow
  def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def selectAll(implicit c: Connection): List[ProductdescriptionRow]
  def selectById(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Option[ProductdescriptionRow]
  def selectByIds(productdescriptionids: Array[ProductdescriptionId])(implicit c: Connection): List[ProductdescriptionRow]
  def update(row: ProductdescriptionRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def upsert(unsaved: ProductdescriptionRow)(implicit c: Connection): ProductdescriptionRow
}