/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

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

class EmployeedepartmenthistoryRepoMock(toRow: Function1[EmployeedepartmenthistoryRowUnsaved, EmployeedepartmenthistoryRow],
                                        map: scala.collection.mutable.Map[EmployeedepartmenthistoryId, EmployeedepartmenthistoryRow] = scala.collection.mutable.Map.empty) extends EmployeedepartmenthistoryRepo {
  override def delete(compositeId: EmployeedepartmenthistoryId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[EmployeedepartmenthistoryId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(compositeIds.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmployeedepartmenthistoryFields.structure.fields, map)
  }
  override def insert(unsaved: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, EmployeedepartmenthistoryRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: EmployeedepartmenthistoryRowUnsaved): ZIO[ZConnection, Throwable, EmployeedepartmenthistoryRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    SelectBuilderMock(EmployeedepartmenthistoryFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: EmployeedepartmenthistoryId): ZIO[ZConnection, Throwable, Option[EmployeedepartmenthistoryRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[EmployeedepartmenthistoryId]): ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow] = {
    ZStream.fromIterable(compositeIds.flatMap(map.get))
  }
  override def update(row: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmployeedepartmenthistoryFields.structure.fields, map)
  }
  override def upsert(unsaved: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeedepartmenthistoryRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
