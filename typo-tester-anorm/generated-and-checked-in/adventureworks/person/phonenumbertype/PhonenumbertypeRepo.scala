/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PhonenumbertypeRepo {
  def delete: DeleteBuilder[PhonenumbertypeFields, PhonenumbertypeRow]
  def deleteById(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Boolean
  def deleteByIds(phonenumbertypeids: Array[PhonenumbertypeId])(implicit c: Connection): Int
  def insert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow
  def insert(unsaved: PhonenumbertypeRowUnsaved)(implicit c: Connection): PhonenumbertypeRow
  def insertStreaming(unsaved: Iterator[PhonenumbertypeRow], batchSize: Int)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[PhonenumbertypeRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[PhonenumbertypeFields, PhonenumbertypeRow]
  def selectAll(implicit c: Connection): List[PhonenumbertypeRow]
  def selectById(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Option[PhonenumbertypeRow]
  def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId])(implicit c: Connection): List[PhonenumbertypeRow]
  def update: UpdateBuilder[PhonenumbertypeFields, PhonenumbertypeRow]
  def update(row: PhonenumbertypeRow)(implicit c: Connection): Boolean
  def upsert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow
}
