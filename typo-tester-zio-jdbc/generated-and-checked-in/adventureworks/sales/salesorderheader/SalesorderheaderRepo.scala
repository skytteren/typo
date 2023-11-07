/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SalesorderheaderRepo {
  def delete(salesorderid: SalesorderheaderId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def insert(unsaved: SalesorderheaderRow): ZIO[ZConnection, Throwable, SalesorderheaderRow]
  def insert(unsaved: SalesorderheaderRowUnsaved): ZIO[ZConnection, Throwable, SalesorderheaderRow]
  def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def selectAll: ZStream[ZConnection, Throwable, SalesorderheaderRow]
  def selectById(salesorderid: SalesorderheaderId): ZIO[ZConnection, Throwable, Option[SalesorderheaderRow]]
  def selectByIds(salesorderids: Array[SalesorderheaderId]): ZStream[ZConnection, Throwable, SalesorderheaderRow]
  def update(row: SalesorderheaderRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def upsert(unsaved: SalesorderheaderRow): ZIO[ZConnection, Throwable, UpdateResult[SalesorderheaderRow]]
}