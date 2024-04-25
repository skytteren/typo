/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

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

class CultureRepoMock(toRow: Function1[CultureRowUnsaved, CultureRow],
                      map: scala.collection.mutable.Map[CultureId, CultureRow] = scala.collection.mutable.Map.empty) extends CultureRepo {
  override def delete: DeleteBuilder[CultureFields, CultureRow] = {
    DeleteBuilderMock(DeleteParams.empty, CultureFields.structure.fields, map)
  }
  override def deleteById(cultureid: CultureId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(cultureid).isDefined)
  }
  override def deleteByIds(cultureids: Array[CultureId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(cultureids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: CultureRow): ZIO[ZConnection, Throwable, CultureRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.cultureid))
          sys.error(s"id ${unsaved.cultureid} already exists")
        else
          map.put(unsaved.cultureid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CultureRowUnsaved): ZIO[ZConnection, Throwable, CultureRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CultureRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.cultureid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CultureRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.cultureid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[CultureFields, CultureRow] = {
    SelectBuilderMock(CultureFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CultureRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(cultureid: CultureId): ZIO[ZConnection, Throwable, Option[CultureRow]] = {
    ZIO.succeed(map.get(cultureid))
  }
  override def selectByIds(cultureids: Array[CultureId]): ZStream[ZConnection, Throwable, CultureRow] = {
    ZStream.fromIterable(cultureids.flatMap(map.get))
  }
  override def update: UpdateBuilder[CultureFields, CultureRow] = {
    UpdateBuilderMock(UpdateParams.empty, CultureFields.structure.fields, map)
  }
  override def update(row: CultureRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.cultureid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.cultureid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: CultureRow): ZIO[ZConnection, Throwable, UpdateResult[CultureRow]] = {
    ZIO.succeed {
      map.put(unsaved.cultureid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
