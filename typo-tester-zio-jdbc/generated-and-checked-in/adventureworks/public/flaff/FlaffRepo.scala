/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package flaff

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait FlaffRepo {
  def delete(compositeId: FlaffId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[FlaffFields, FlaffRow]
  def insert(unsaved: FlaffRow): ZIO[ZConnection, Throwable, FlaffRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, FlaffRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[FlaffFields, FlaffRow]
  def selectAll: ZStream[ZConnection, Throwable, FlaffRow]
  def selectById(compositeId: FlaffId): ZIO[ZConnection, Throwable, Option[FlaffRow]]
  def update(row: FlaffRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[FlaffFields, FlaffRow]
  def upsert(unsaved: FlaffRow): ZIO[ZConnection, Throwable, UpdateResult[FlaffRow]]
}
