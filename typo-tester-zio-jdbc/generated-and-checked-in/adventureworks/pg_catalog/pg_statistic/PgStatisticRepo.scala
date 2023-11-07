/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgStatisticRepo {
  def delete(compositeId: PgStatisticId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgStatisticFields, PgStatisticRow]
  def insert(unsaved: PgStatisticRow): ZIO[ZConnection, Throwable, PgStatisticRow]
  def select: SelectBuilder[PgStatisticFields, PgStatisticRow]
  def selectAll: ZStream[ZConnection, Throwable, PgStatisticRow]
  def selectById(compositeId: PgStatisticId): ZIO[ZConnection, Throwable, Option[PgStatisticRow]]
  def update(row: PgStatisticRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgStatisticFields, PgStatisticRow]
  def upsert(unsaved: PgStatisticRow): ZIO[ZConnection, Throwable, UpdateResult[PgStatisticRow]]
}