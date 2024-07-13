/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.userdefined.CustomCreditcardId
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
import zio.jdbc.JdbcEncoder
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

class PersoncreditcardRepoMock(toRow: Function1[PersoncreditcardRowUnsaved, PersoncreditcardRow],
                               map: scala.collection.mutable.Map[PersoncreditcardId, PersoncreditcardRow] = scala.collection.mutable.Map.empty) extends PersoncreditcardRepo {
  override def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersoncreditcardFields.structure, map)
  }
  override def deleteById(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(compositeIds.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, PersoncreditcardRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved): ZIO[ZConnection, Throwable, PersoncreditcardRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    SelectBuilderMock(PersoncreditcardFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PersoncreditcardRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Option[PersoncreditcardRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZStream[ZConnection, Throwable, PersoncreditcardRow] = {
    ZStream.fromIterable(compositeIds.flatMap(map.get))
  }
  override def selectByIdsTracked(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Map[PersoncreditcardId, PersoncreditcardRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersoncreditcardFields.structure, map)
  }
  override def update(row: PersoncreditcardRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def upsert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, UpdateResult[PersoncreditcardRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
