/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait CultureRepo {
  def delete: DeleteBuilder[CultureFields, CultureRow]
  def deleteById(cultureid: CultureId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(cultureids: Array[CultureId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: CultureRow): ZIO[ZConnection, Throwable, CultureRow]
  def insert(unsaved: CultureRowUnsaved): ZIO[ZConnection, Throwable, CultureRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CultureRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CultureRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[CultureFields, CultureRow]
  def selectAll: ZStream[ZConnection, Throwable, CultureRow]
  def selectById(cultureid: CultureId): ZIO[ZConnection, Throwable, Option[CultureRow]]
  def selectByIds(cultureids: Array[CultureId]): ZStream[ZConnection, Throwable, CultureRow]
  def selectByIdsTracked(cultureids: Array[CultureId]): ZIO[ZConnection, Throwable, Map[CultureId, Option[CultureRow]]]
  def update: UpdateBuilder[CultureFields, CultureRow]
  def update(row: CultureRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: CultureRow): ZIO[ZConnection, Throwable, UpdateResult[CultureRow]]
}
