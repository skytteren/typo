/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.TypoUnknownCitext
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

class UsersRepoMock(toRow: Function1[UsersRowUnsaved, UsersRow],
                    map: scala.collection.mutable.Map[UsersId, UsersRow] = scala.collection.mutable.Map.empty) extends UsersRepo {
  override def delete(userId: UsersId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(userId).isDefined)
  }
  override def deleteByIds(userIds: Array[UsersId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(userIds.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[UsersFields, UsersRow] = {
    DeleteBuilderMock(DeleteParams.empty, UsersFields.structure.fields, map)
  }
  override def insert(unsaved: UsersRow): ZIO[ZConnection, Throwable, UsersRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.userId))
          sys.error(s"id ${unsaved.userId} already exists")
        else
          map.put(unsaved.userId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, UsersRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.userId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: UsersRowUnsaved): ZIO[ZConnection, Throwable, UsersRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, UsersRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.userId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[UsersFields, UsersRow] = {
    SelectBuilderMock(UsersFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, UsersRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(userId: UsersId): ZIO[ZConnection, Throwable, Option[UsersRow]] = {
    ZIO.succeed(map.get(userId))
  }
  override def selectByIds(userIds: Array[UsersId]): ZStream[ZConnection, Throwable, UsersRow] = {
    ZStream.fromIterable(userIds.flatMap(map.get))
  }
  override def selectByUniqueEmail(email: TypoUnknownCitext): ZIO[ZConnection, Throwable, Option[UsersRow]] = {
    ZIO.succeed(map.values.find(v => email == v.email))
  }
  override def update(row: UsersRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.userId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.userId, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[UsersFields, UsersRow] = {
    UpdateBuilderMock(UpdateParams.empty, UsersFields.structure.fields, map)
  }
  override def upsert(unsaved: UsersRow): ZIO[ZConnection, Throwable, UpdateResult[UsersRow]] = {
    ZIO.succeed {
      map.put(unsaved.userId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
