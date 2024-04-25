/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait CountryregionRepo {
  def delete(countryregioncode: CountryregionId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(countryregioncodes: Array[CountryregionId]): ZIO[ZConnection, Throwable, Long]
  def delete: DeleteBuilder[CountryregionFields, CountryregionRow]
  def insert(unsaved: CountryregionRow): ZIO[ZConnection, Throwable, CountryregionRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CountryregionRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: CountryregionRowUnsaved): ZIO[ZConnection, Throwable, CountryregionRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CountryregionRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[CountryregionFields, CountryregionRow]
  def selectAll: ZStream[ZConnection, Throwable, CountryregionRow]
  def selectById(countryregioncode: CountryregionId): ZIO[ZConnection, Throwable, Option[CountryregionRow]]
  def selectByIds(countryregioncodes: Array[CountryregionId]): ZStream[ZConnection, Throwable, CountryregionRow]
  def update(row: CountryregionRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[CountryregionFields, CountryregionRow]
  def upsert(unsaved: CountryregionRow): ZIO[ZConnection, Throwable, UpdateResult[CountryregionRow]]
}
