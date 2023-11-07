/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait UnitmeasureRepo {
  def delete(unitmeasurecode: UnitmeasureId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[UnitmeasureFields, UnitmeasureRow]
  def insert(unsaved: UnitmeasureRow): ZIO[ZConnection, Throwable, UnitmeasureRow]
  def insert(unsaved: UnitmeasureRowUnsaved): ZIO[ZConnection, Throwable, UnitmeasureRow]
  def select: SelectBuilder[UnitmeasureFields, UnitmeasureRow]
  def selectAll: ZStream[ZConnection, Throwable, UnitmeasureRow]
  def selectById(unitmeasurecode: UnitmeasureId): ZIO[ZConnection, Throwable, Option[UnitmeasureRow]]
  def selectByIds(unitmeasurecodes: Array[UnitmeasureId]): ZStream[ZConnection, Throwable, UnitmeasureRow]
  def update(row: UnitmeasureRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[UnitmeasureFields, UnitmeasureRow]
  def upsert(unsaved: UnitmeasureRow): ZIO[ZConnection, Throwable, UpdateResult[UnitmeasureRow]]
}