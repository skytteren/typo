/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.person.businessentity.BusinessentityId
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

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[BusinessentityId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(businessentityid).isDefined)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(businessentityids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersonFields.structure.fields, map)
  }
  override def insert(unsaved: PersonRow): ZIO[ZConnection, Throwable, PersonRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.businessentityid))
          sys.error(s"id ${unsaved.businessentityid} already exists")
        else
          map.put(unsaved.businessentityid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: PersonRowUnsaved): ZIO[ZConnection, Throwable, PersonRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderMock(PersonFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PersonRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[PersonRow]] = {
    ZIO.succeed(map.get(businessentityid))
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, PersonRow] = {
    ZStream.fromIterable(businessentityids.flatMap(map.get))
  }
  override def update(row: PersonRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.businessentityid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.businessentityid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersonFields.structure.fields, map)
  }
  override def upsert(unsaved: PersonRow): ZIO[ZConnection, Throwable, UpdateResult[PersonRow]] = {
    ZIO.succeed {
      map.put(unsaved.businessentityid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
