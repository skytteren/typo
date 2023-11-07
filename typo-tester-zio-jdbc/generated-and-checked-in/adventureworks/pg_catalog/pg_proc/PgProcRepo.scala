/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import adventureworks.customtypes.TypoOidVector
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgProcRepo {
  def delete(oid: PgProcId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgProcFields, PgProcRow]
  def insert(unsaved: PgProcRow): ZIO[ZConnection, Throwable, PgProcRow]
  def select: SelectBuilder[PgProcFields, PgProcRow]
  def selectAll: ZStream[ZConnection, Throwable, PgProcRow]
  def selectById(oid: PgProcId): ZIO[ZConnection, Throwable, Option[PgProcRow]]
  def selectByIds(oids: Array[PgProcId]): ZStream[ZConnection, Throwable, PgProcRow]
  def selectByUnique(proname: String, proargtypes: TypoOidVector, pronamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgProcRow]]
  def update(row: PgProcRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgProcFields, PgProcRow]
  def upsert(unsaved: PgProcRow): ZIO[ZConnection, Throwable, UpdateResult[PgProcRow]]
}