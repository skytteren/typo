/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

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

class IdentityTestRepoMock(toRow: Function1[IdentityTestRowUnsaved, IdentityTestRow],
                           map: scala.collection.mutable.Map[IdentityTestId, IdentityTestRow] = scala.collection.mutable.Map.empty) extends IdentityTestRepo {
  override def delete(name: IdentityTestId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(name).isDefined)
  }
  override def deleteByIds(names: Array[IdentityTestId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(names.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow] = {
    DeleteBuilderMock(DeleteParams.empty, IdentityTestFields.structure.fields, map)
  }
  override def insert(unsaved: IdentityTestRow): ZIO[ZConnection, Throwable, IdentityTestRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.name))
          sys.error(s"id ${unsaved.name} already exists")
        else
          map.put(unsaved.name, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, IdentityTestRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.name -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: IdentityTestRowUnsaved): ZIO[ZConnection, Throwable, IdentityTestRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, IdentityTestRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.name -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[IdentityTestFields, IdentityTestRow] = {
    SelectBuilderMock(IdentityTestFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, IdentityTestRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(name: IdentityTestId): ZIO[ZConnection, Throwable, Option[IdentityTestRow]] = {
    ZIO.succeed(map.get(name))
  }
  override def selectByIds(names: Array[IdentityTestId]): ZStream[ZConnection, Throwable, IdentityTestRow] = {
    ZStream.fromIterable(names.flatMap(map.get))
  }
  override def update(row: IdentityTestRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.name) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.name, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[IdentityTestFields, IdentityTestRow] = {
    UpdateBuilderMock(UpdateParams.empty, IdentityTestFields.structure.fields, map)
  }
  override def upsert(unsaved: IdentityTestRow): ZIO[ZConnection, Throwable, UpdateResult[IdentityTestRow]] = {
    ZIO.succeed {
      map.put(unsaved.name, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
