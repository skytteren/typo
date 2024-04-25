/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

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

class PhonenumbertypeRepoMock(toRow: Function1[PhonenumbertypeRowUnsaved, PhonenumbertypeRow],
                              map: scala.collection.mutable.Map[PhonenumbertypeId, PhonenumbertypeRow] = scala.collection.mutable.Map.empty) extends PhonenumbertypeRepo {
  override def delete(phonenumbertypeid: PhonenumbertypeId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(phonenumbertypeid).isDefined)
  }
  override def deleteByIds(phonenumbertypeids: Array[PhonenumbertypeId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(phonenumbertypeids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    DeleteBuilderMock(DeleteParams.empty, PhonenumbertypeFields.structure.fields, map)
  }
  override def insert(unsaved: PhonenumbertypeRow): ZIO[ZConnection, Throwable, PhonenumbertypeRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.phonenumbertypeid))
          sys.error(s"id ${unsaved.phonenumbertypeid} already exists")
        else
          map.put(unsaved.phonenumbertypeid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PhonenumbertypeRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.phonenumbertypeid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved): ZIO[ZConnection, Throwable, PhonenumbertypeRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PhonenumbertypeRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.phonenumbertypeid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    SelectBuilderMock(PhonenumbertypeFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PhonenumbertypeRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId): ZIO[ZConnection, Throwable, Option[PhonenumbertypeRow]] = {
    ZIO.succeed(map.get(phonenumbertypeid))
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId]): ZStream[ZConnection, Throwable, PhonenumbertypeRow] = {
    ZStream.fromIterable(phonenumbertypeids.flatMap(map.get))
  }
  override def update(row: PhonenumbertypeRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.phonenumbertypeid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.phonenumbertypeid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    UpdateBuilderMock(UpdateParams.empty, PhonenumbertypeFields.structure.fields, map)
  }
  override def upsert(unsaved: PhonenumbertypeRow): ZIO[ZConnection, Throwable, UpdateResult[PhonenumbertypeRow]] = {
    ZIO.succeed {
      map.put(unsaved.phonenumbertypeid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
