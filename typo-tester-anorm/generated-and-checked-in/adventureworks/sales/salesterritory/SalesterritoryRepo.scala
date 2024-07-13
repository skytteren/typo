/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalesterritoryRepo {
  def delete: DeleteBuilder[SalesterritoryFields, SalesterritoryRow]
  def deleteById(territoryid: SalesterritoryId)(implicit c: Connection): Boolean
  def deleteByIds(territoryids: Array[SalesterritoryId])(implicit c: Connection): Int
  def insert(unsaved: SalesterritoryRow)(implicit c: Connection): SalesterritoryRow
  def insert(unsaved: SalesterritoryRowUnsaved)(implicit c: Connection): SalesterritoryRow
  def insertStreaming(unsaved: Iterator[SalesterritoryRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[SalesterritoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[SalesterritoryFields, SalesterritoryRow]
  def selectAll(implicit c: Connection): List[SalesterritoryRow]
  def selectById(territoryid: SalesterritoryId)(implicit c: Connection): Option[SalesterritoryRow]
  def selectByIds(territoryids: Array[SalesterritoryId])(implicit c: Connection): List[SalesterritoryRow]
  def selectByIdsTracked(territoryids: Array[SalesterritoryId])(implicit c: Connection): Map[SalesterritoryId, SalesterritoryRow]
  def update: UpdateBuilder[SalesterritoryFields, SalesterritoryRow]
  def update(row: SalesterritoryRow)(implicit c: Connection): Boolean
  def upsert(unsaved: SalesterritoryRow)(implicit c: Connection): SalesterritoryRow
  def upsertBatch(unsaved: Iterable[SalesterritoryRow])(implicit c: Connection): List[SalesterritoryRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[SalesterritoryRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
