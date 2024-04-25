/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SpecialofferproductRepo {
  def delete: DeleteBuilder[SpecialofferproductFields, SpecialofferproductRow]
  def deleteById(compositeId: SpecialofferproductId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[SpecialofferproductId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: SpecialofferproductRow): ZIO[ZConnection, Throwable, SpecialofferproductRow]
  def insert(unsaved: SpecialofferproductRowUnsaved): ZIO[ZConnection, Throwable, SpecialofferproductRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SpecialofferproductRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SpecialofferproductRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[SpecialofferproductFields, SpecialofferproductRow]
  def selectAll: ZStream[ZConnection, Throwable, SpecialofferproductRow]
  def selectById(compositeId: SpecialofferproductId): ZIO[ZConnection, Throwable, Option[SpecialofferproductRow]]
  def selectByIds(compositeIds: Array[SpecialofferproductId]): ZStream[ZConnection, Throwable, SpecialofferproductRow]
  def update: UpdateBuilder[SpecialofferproductFields, SpecialofferproductRow]
  def update(row: SpecialofferproductRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: SpecialofferproductRow): ZIO[ZConnection, Throwable, UpdateResult[SpecialofferproductRow]]
}
