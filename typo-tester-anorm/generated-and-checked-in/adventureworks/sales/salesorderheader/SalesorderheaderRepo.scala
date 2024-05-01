/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalesorderheaderRepo {
  def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def deleteById(salesorderid: SalesorderheaderId)(implicit c: Connection): Boolean
  def deleteByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): Int
  def insert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow
  def insert(unsaved: SalesorderheaderRowUnsaved)(implicit c: Connection): SalesorderheaderRow
  def insertStreaming(unsaved: Iterator[SalesorderheaderRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[SalesorderheaderRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def selectAll(implicit c: Connection): List[SalesorderheaderRow]
  def selectById(salesorderid: SalesorderheaderId)(implicit c: Connection): Option[SalesorderheaderRow]
  def selectByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): List[SalesorderheaderRow]
  def selectByIdsTracked(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): Map[SalesorderheaderId, Option[SalesorderheaderRow]]
  def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def update(row: SalesorderheaderRow)(implicit c: Connection): Boolean
  def upsert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow
}
