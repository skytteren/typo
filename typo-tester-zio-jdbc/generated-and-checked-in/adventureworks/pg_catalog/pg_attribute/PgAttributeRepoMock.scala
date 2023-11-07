/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attribute

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

class PgAttributeRepoMock(map: scala.collection.mutable.Map[PgAttributeId, PgAttributeRow] = scala.collection.mutable.Map.empty) extends PgAttributeRepo {
  override def delete(compositeId: PgAttributeId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[PgAttributeFields, PgAttributeRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgAttributeFields, map)
  }
  override def insert(unsaved: PgAttributeRow): ZIO[ZConnection, Throwable, PgAttributeRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgAttributeFields, PgAttributeRow] = {
    SelectBuilderMock(PgAttributeFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgAttributeRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: PgAttributeId): ZIO[ZConnection, Throwable, Option[PgAttributeRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def selectByUnique(attrelid: /* oid */ Long, attname: String): ZIO[ZConnection, Throwable, Option[PgAttributeRow]] = {
    ZIO.succeed(map.values.find(v => attrelid == v.attrelid && attname == v.attname))
  }
  override def update(row: PgAttributeRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgAttributeFields, PgAttributeRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgAttributeFields, map)
  }
  override def upsert(unsaved: PgAttributeRow): ZIO[ZConnection, Throwable, UpdateResult[PgAttributeRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}