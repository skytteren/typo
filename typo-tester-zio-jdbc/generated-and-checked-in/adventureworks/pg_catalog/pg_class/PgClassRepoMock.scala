/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_class

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

class PgClassRepoMock(map: scala.collection.mutable.Map[PgClassId, PgClassRow] = scala.collection.mutable.Map.empty) extends PgClassRepo {
  override def delete(oid: PgClassId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgClassFields, PgClassRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgClassFields, map)
  }
  override def insert(unsaved: PgClassRow): ZIO[ZConnection, Throwable, PgClassRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.oid))
          sys.error(s"id ${unsaved.oid} already exists")
        else
          map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgClassFields, PgClassRow] = {
    SelectBuilderMock(PgClassFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgClassRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(oid: PgClassId): ZIO[ZConnection, Throwable, Option[PgClassRow]] = {
    ZIO.succeed(map.get(oid))
  }
  override def selectByIds(oids: Array[PgClassId]): ZStream[ZConnection, Throwable, PgClassRow] = {
    ZStream.fromIterable(oids.flatMap(map.get))
  }
  override def selectByUnique(relname: String, relnamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgClassRow]] = {
    ZIO.succeed(map.values.find(v => relname == v.relname && relnamespace == v.relnamespace))
  }
  override def update(row: PgClassRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[PgClassFields, PgClassRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgClassFields, map)
  }
  override def upsert(unsaved: PgClassRow): ZIO[ZConnection, Throwable, UpdateResult[PgClassRow]] = {
    ZIO.succeed {
      map.put(unsaved.oid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}