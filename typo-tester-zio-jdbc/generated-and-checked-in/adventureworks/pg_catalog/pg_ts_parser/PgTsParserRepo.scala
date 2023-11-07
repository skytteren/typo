/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_parser

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgTsParserRepo {
  def delete(oid: PgTsParserId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgTsParserFields, PgTsParserRow]
  def insert(unsaved: PgTsParserRow): ZIO[ZConnection, Throwable, PgTsParserRow]
  def select: SelectBuilder[PgTsParserFields, PgTsParserRow]
  def selectAll: ZStream[ZConnection, Throwable, PgTsParserRow]
  def selectById(oid: PgTsParserId): ZIO[ZConnection, Throwable, Option[PgTsParserRow]]
  def selectByIds(oids: Array[PgTsParserId]): ZStream[ZConnection, Throwable, PgTsParserRow]
  def selectByUnique(prsname: String, prsnamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgTsParserRow]]
  def update(row: PgTsParserRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgTsParserFields, PgTsParserRow]
  def upsert(unsaved: PgTsParserRow): ZIO[ZConnection, Throwable, UpdateResult[PgTsParserRow]]
}