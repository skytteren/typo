/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

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

class BusinessentityaddressRepoMock(toRow: Function1[BusinessentityaddressRowUnsaved, BusinessentityaddressRow],
                                    map: scala.collection.mutable.Map[BusinessentityaddressId, BusinessentityaddressRow] = scala.collection.mutable.Map.empty) extends BusinessentityaddressRepo {
  override def delete: DeleteBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    DeleteBuilderMock(DeleteParams.empty, BusinessentityaddressFields.structure.fields, map)
  }
  override def deleteById(compositeId: BusinessentityaddressId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[BusinessentityaddressId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(compositeIds.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: BusinessentityaddressRow): ZIO[ZConnection, Throwable, BusinessentityaddressRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: BusinessentityaddressRowUnsaved): ZIO[ZConnection, Throwable, BusinessentityaddressRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityaddressRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    SelectBuilderMock(BusinessentityaddressFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, BusinessentityaddressRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: BusinessentityaddressId): ZIO[ZConnection, Throwable, Option[BusinessentityaddressRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[BusinessentityaddressId]): ZStream[ZConnection, Throwable, BusinessentityaddressRow] = {
    ZStream.fromIterable(compositeIds.flatMap(map.get))
  }
  override def selectByIdsTracked(compositeIds: Array[BusinessentityaddressId]): ZIO[ZConnection, Throwable, Map[BusinessentityaddressId, Option[BusinessentityaddressRow]]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    UpdateBuilderMock(UpdateParams.empty, BusinessentityaddressFields.structure.fields, map)
  }
  override def update(row: BusinessentityaddressRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def upsert(unsaved: BusinessentityaddressRow): ZIO[ZConnection, Throwable, UpdateResult[BusinessentityaddressRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
