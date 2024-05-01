/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait MaritalStatusRepo {
  def delete: DeleteBuilder[MaritalStatusFields, MaritalStatusRow]
  def deleteById(id: MaritalStatusId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(ids: Array[MaritalStatusId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: MaritalStatusRow): ZIO[ZConnection, Throwable, MaritalStatusRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, MaritalStatusRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[MaritalStatusFields, MaritalStatusRow]
  def selectAll: ZStream[ZConnection, Throwable, MaritalStatusRow]
  def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, MaritalStatusRow]
  def selectById(id: MaritalStatusId): ZIO[ZConnection, Throwable, Option[MaritalStatusRow]]
  def selectByIds(ids: Array[MaritalStatusId]): ZStream[ZConnection, Throwable, MaritalStatusRow]
  def selectByIdsTracked(ids: Array[MaritalStatusId]): ZIO[ZConnection, Throwable, Map[MaritalStatusId, Option[MaritalStatusRow]]]
  def update: UpdateBuilder[MaritalStatusFields, MaritalStatusRow]
  def upsert(unsaved: MaritalStatusRow): ZIO[ZConnection, Throwable, UpdateResult[MaritalStatusRow]]
}
