/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.person.businessentity.BusinessentityId
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PersonRepo {
  def delete: DeleteBuilder[PersonFields, PersonRow]
  def deleteById(businessentityid: BusinessentityId)(implicit c: Connection): Boolean
  def deleteByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): Int
  def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow
  def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow
  def insertStreaming(unsaved: Iterator[PersonRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[PersonRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[PersonFields, PersonRow]
  def selectAll(implicit c: Connection): List[PersonRow]
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[PersonRow]
  def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[PersonRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId])(implicit c: Connection): Map[BusinessentityId, Option[PersonRow]]
  def update: UpdateBuilder[PersonFields, PersonRow]
  def update(row: PersonRow)(implicit c: Connection): Boolean
  def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow
}
