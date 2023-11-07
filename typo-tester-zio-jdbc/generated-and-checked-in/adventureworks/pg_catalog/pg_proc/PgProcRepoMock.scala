/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import adventureworks.customtypes.TypoOidVector
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

class PgProcRepoMock(map: scala.collection.mutable.Map[PgProcId, PgProcRow] = scala.collection.mutable.Map.empty) extends PgProcRepo {
  override def delete(oid: PgProcId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgProcFields, PgProcRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgProcFields, map)
  }
  override def insert(unsaved: PgProcRow): ZIO[ZConnection, Throwable, PgProcRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.oid))
          sys.error(s"id ${unsaved.oid} already exists")
        else
          map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgProcFields, PgProcRow] = {
    SelectBuilderMock(PgProcFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgProcRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(oid: PgProcId): ZIO[ZConnection, Throwable, Option[PgProcRow]] = {
    ZIO.succeed(map.get(oid))
  }
  override def selectByIds(oids: Array[PgProcId]): ZStream[ZConnection, Throwable, PgProcRow] = {
    ZStream.fromIterable(oids.flatMap(map.get))
  }
  override def selectByUnique(proname: String, proargtypes: TypoOidVector, pronamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgProcRow]] = {
    ZIO.succeed(map.values.find(v => proname == v.proname && proargtypes == v.proargtypes && pronamespace == v.pronamespace))
  }
  override def update(row: PgProcRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[PgProcFields, PgProcRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgProcFields, map)
  }
  override def upsert(unsaved: PgProcRow): ZIO[ZConnection, Throwable, UpdateResult[PgProcRow]] = {
    ZIO.succeed {
      map.put(unsaved.oid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}