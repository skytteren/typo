/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config

import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams
import zio.Chunk
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

class PgTsConfigRepoMock(map: scala.collection.mutable.Map[PgTsConfigId, PgTsConfigRow] = scala.collection.mutable.Map.empty) extends PgTsConfigRepo {
  override def delete(oid: PgTsConfigId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgTsConfigFields, PgTsConfigRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgTsConfigFields, map)
  }
  override def insert(unsaved: PgTsConfigRow): ZIO[ZConnection, Throwable, PgTsConfigRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.oid))
          sys.error(s"id ${unsaved.oid} already exists")
        else
          map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgTsConfigFields, PgTsConfigRow] = {
    SelectBuilderMock(PgTsConfigFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgTsConfigRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(oid: PgTsConfigId): ZIO[ZConnection, Throwable, Option[PgTsConfigRow]] = {
    ZIO.succeed(map.get(oid))
  }
  override def selectByIds(oids: Array[PgTsConfigId]): ZStream[ZConnection, Throwable, PgTsConfigRow] = {
    ZStream.fromIterable(oids.flatMap(map.get))
  }
  override def selectByUnique(cfgname: String, cfgnamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgTsConfigRow]] = {
    ZIO.succeed(map.values.find(v => cfgname == v.cfgname && cfgnamespace == v.cfgnamespace))
  }
  override def update(row: PgTsConfigRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgTsConfigFields, PgTsConfigRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgTsConfigFields, map)
  }
  override def upsert(unsaved: PgTsConfigRow): ZIO[ZConnection, Throwable, UpdateResult[PgTsConfigRow]] = {
    ZIO.succeed {
      map.put(unsaved.oid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}