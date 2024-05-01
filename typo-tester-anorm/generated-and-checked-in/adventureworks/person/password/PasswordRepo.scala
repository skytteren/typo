/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.person.businessentity.BusinessentityId
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PasswordRepo {
  def delete: DeleteBuilder[PasswordFields, PasswordRow]
  def deleteById(businessentityid: BusinessentityId)(implicit c: Connection): Boolean
  def deleteByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): Int
  def insert(unsaved: PasswordRow)(implicit c: Connection): PasswordRow
  def insert(unsaved: PasswordRowUnsaved)(implicit c: Connection): PasswordRow
  def insertStreaming(unsaved: Iterator[PasswordRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[PasswordRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[PasswordFields, PasswordRow]
  def selectAll(implicit c: Connection): List[PasswordRow]
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[PasswordRow]
  def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[PasswordRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId])(implicit c: Connection): Map[BusinessentityId, Option[PasswordRow]]
  def update: UpdateBuilder[PasswordFields, PasswordRow]
  def update(row: PasswordRow)(implicit c: Connection): Boolean
  def upsert(unsaved: PasswordRow)(implicit c: Connection): PasswordRow
}
