/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_event_trigger

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

class PgEventTriggerRepoMock(map: scala.collection.mutable.Map[PgEventTriggerId, PgEventTriggerRow] = scala.collection.mutable.Map.empty) extends PgEventTriggerRepo {
  override def delete(oid: PgEventTriggerId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgEventTriggerFields, map)
  }
  override def insert(unsaved: PgEventTriggerRow): ZIO[ZConnection, Throwable, PgEventTriggerRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.oid))
          sys.error(s"id ${unsaved.oid} already exists")
        else
          map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    SelectBuilderMock(PgEventTriggerFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgEventTriggerRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(oid: PgEventTriggerId): ZIO[ZConnection, Throwable, Option[PgEventTriggerRow]] = {
    ZIO.succeed(map.get(oid))
  }
  override def selectByIds(oids: Array[PgEventTriggerId]): ZStream[ZConnection, Throwable, PgEventTriggerRow] = {
    ZStream.fromIterable(oids.flatMap(map.get))
  }
  override def selectByUnique(evtname: String): ZIO[ZConnection, Throwable, Option[PgEventTriggerRow]] = {
    ZIO.succeed(map.values.find(v => evtname == v.evtname))
  }
  override def update(row: PgEventTriggerRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgEventTriggerFields, map)
  }
  override def upsert(unsaved: PgEventTriggerRow): ZIO[ZConnection, Throwable, UpdateResult[PgEventTriggerRow]] = {
    ZIO.succeed {
      map.put(unsaved.oid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}