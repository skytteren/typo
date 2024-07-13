/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

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

class ShipmethodRepoMock(toRow: Function1[ShipmethodRowUnsaved, ShipmethodRow],
                         map: scala.collection.mutable.Map[ShipmethodId, ShipmethodRow] = scala.collection.mutable.Map.empty) extends ShipmethodRepo {
  override def delete: DeleteBuilder[ShipmethodFields, ShipmethodRow] = {
    DeleteBuilderMock(DeleteParams.empty, ShipmethodFields.structure, map)
  }
  override def deleteById(shipmethodid: ShipmethodId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(shipmethodid).isDefined)
  }
  override def deleteByIds(shipmethodids: Array[ShipmethodId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(shipmethodids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: ShipmethodRow): ZIO[ZConnection, Throwable, ShipmethodRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.shipmethodid))
          sys.error(s"id ${unsaved.shipmethodid} already exists")
        else
          map.put(unsaved.shipmethodid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ShipmethodRowUnsaved): ZIO[ZConnection, Throwable, ShipmethodRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ShipmethodRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.shipmethodid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ShipmethodRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.shipmethodid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[ShipmethodFields, ShipmethodRow] = {
    SelectBuilderMock(ShipmethodFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ShipmethodRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(shipmethodid: ShipmethodId): ZIO[ZConnection, Throwable, Option[ShipmethodRow]] = {
    ZIO.succeed(map.get(shipmethodid))
  }
  override def selectByIds(shipmethodids: Array[ShipmethodId]): ZStream[ZConnection, Throwable, ShipmethodRow] = {
    ZStream.fromIterable(shipmethodids.flatMap(map.get))
  }
  override def selectByIdsTracked(shipmethodids: Array[ShipmethodId]): ZIO[ZConnection, Throwable, Map[ShipmethodId, ShipmethodRow]] = {
    selectByIds(shipmethodids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.shipmethodid, x)).toMap
      shipmethodids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ShipmethodFields, ShipmethodRow] = {
    UpdateBuilderMock(UpdateParams.empty, ShipmethodFields.structure, map)
  }
  override def update(row: ShipmethodRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.shipmethodid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.shipmethodid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: ShipmethodRow): ZIO[ZConnection, Throwable, UpdateResult[ShipmethodRow]] = {
    ZIO.succeed {
      map.put(unsaved.shipmethodid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ShipmethodRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.shipmethodid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
