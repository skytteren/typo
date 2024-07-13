/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

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

class SalesterritoryhistoryRepoMock(toRow: Function1[SalesterritoryhistoryRowUnsaved, SalesterritoryhistoryRow],
                                    map: scala.collection.mutable.Map[SalesterritoryhistoryId, SalesterritoryhistoryRow] = scala.collection.mutable.Map.empty) extends SalesterritoryhistoryRepo {
  override def delete: DeleteBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesterritoryhistoryFields.structure, map)
  }
  override def deleteById(compositeId: SalesterritoryhistoryId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[SalesterritoryhistoryId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(compositeIds.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: SalesterritoryhistoryRow): ZIO[ZConnection, Throwable, SalesterritoryhistoryRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SalesterritoryhistoryRowUnsaved): ZIO[ZConnection, Throwable, SalesterritoryhistoryRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesterritoryhistoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesterritoryhistoryRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    SelectBuilderMock(SalesterritoryhistoryFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalesterritoryhistoryRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: SalesterritoryhistoryId): ZIO[ZConnection, Throwable, Option[SalesterritoryhistoryRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[SalesterritoryhistoryId]): ZStream[ZConnection, Throwable, SalesterritoryhistoryRow] = {
    ZStream.fromIterable(compositeIds.flatMap(map.get))
  }
  override def selectByIdsTracked(compositeIds: Array[SalesterritoryhistoryId]): ZIO[ZConnection, Throwable, Map[SalesterritoryhistoryId, SalesterritoryhistoryRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesterritoryhistoryFields.structure, map)
  }
  override def update(row: SalesterritoryhistoryRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def upsert(unsaved: SalesterritoryhistoryRow): ZIO[ZConnection, Throwable, UpdateResult[SalesterritoryhistoryRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesterritoryhistoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
