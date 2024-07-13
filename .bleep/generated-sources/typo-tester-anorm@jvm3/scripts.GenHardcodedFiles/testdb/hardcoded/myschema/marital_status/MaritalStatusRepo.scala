/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait MaritalStatusRepo {
  def delete: DeleteBuilder[MaritalStatusFields, MaritalStatusRow]
  def deleteById(id: MaritalStatusId)(implicit c: Connection): Boolean
  def deleteByIds(ids: Array[MaritalStatusId])(implicit c: Connection): Int
  def insert(unsaved: MaritalStatusRow)(implicit c: Connection): MaritalStatusRow
  def insertStreaming(unsaved: Iterator[MaritalStatusRow], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[MaritalStatusFields, MaritalStatusRow]
  def selectAll(implicit c: Connection): List[MaritalStatusRow]
  def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[?]])(implicit c: Connection): List[MaritalStatusRow]
  def selectById(id: MaritalStatusId)(implicit c: Connection): Option[MaritalStatusRow]
  def selectByIds(ids: Array[MaritalStatusId])(implicit c: Connection): List[MaritalStatusRow]
  def selectByIdsTracked(ids: Array[MaritalStatusId])(implicit c: Connection): Map[MaritalStatusId, MaritalStatusRow]
  def update: UpdateBuilder[MaritalStatusFields, MaritalStatusRow]
  def upsert(unsaved: MaritalStatusRow)(implicit c: Connection): MaritalStatusRow
  def upsertBatch(unsaved: Iterable[MaritalStatusRow])(implicit c: Connection): List[MaritalStatusRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[MaritalStatusRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
