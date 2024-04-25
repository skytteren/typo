/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait IllustrationRepo {
  def delete(illustrationid: IllustrationId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(illustrationids: Array[IllustrationId]): ZIO[ZConnection, Throwable, Long]
  def delete: DeleteBuilder[IllustrationFields, IllustrationRow]
  def insert(unsaved: IllustrationRow): ZIO[ZConnection, Throwable, IllustrationRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, IllustrationRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: IllustrationRowUnsaved): ZIO[ZConnection, Throwable, IllustrationRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, IllustrationRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[IllustrationFields, IllustrationRow]
  def selectAll: ZStream[ZConnection, Throwable, IllustrationRow]
  def selectById(illustrationid: IllustrationId): ZIO[ZConnection, Throwable, Option[IllustrationRow]]
  def selectByIds(illustrationids: Array[IllustrationId]): ZStream[ZConnection, Throwable, IllustrationRow]
  def update(row: IllustrationRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[IllustrationFields, IllustrationRow]
  def upsert(unsaved: IllustrationRow): ZIO[ZConnection, Throwable, UpdateResult[IllustrationRow]]
}
