/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SpecialofferRepo {
  def delete: DeleteBuilder[SpecialofferFields, SpecialofferRow]
  def deleteById(specialofferid: SpecialofferId)(implicit c: Connection): Boolean
  def deleteByIds(specialofferids: Array[SpecialofferId])(implicit c: Connection): Int
  def insert(unsaved: SpecialofferRow)(implicit c: Connection): SpecialofferRow
  def insert(unsaved: SpecialofferRowUnsaved)(implicit c: Connection): SpecialofferRow
  def insertStreaming(unsaved: Iterator[SpecialofferRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[SpecialofferRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[SpecialofferFields, SpecialofferRow]
  def selectAll(implicit c: Connection): List[SpecialofferRow]
  def selectById(specialofferid: SpecialofferId)(implicit c: Connection): Option[SpecialofferRow]
  def selectByIds(specialofferids: Array[SpecialofferId])(implicit c: Connection): List[SpecialofferRow]
  def selectByIdsTracked(specialofferids: Array[SpecialofferId])(implicit c: Connection): Map[SpecialofferId, SpecialofferRow]
  def update: UpdateBuilder[SpecialofferFields, SpecialofferRow]
  def update(row: SpecialofferRow)(implicit c: Connection): Boolean
  def upsert(unsaved: SpecialofferRow)(implicit c: Connection): SpecialofferRow
  def upsertBatch(unsaved: Iterable[SpecialofferRow])(implicit c: Connection): List[SpecialofferRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[SpecialofferRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
