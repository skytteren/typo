/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

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

class AddresstypeRepoMock(toRow: Function1[AddresstypeRowUnsaved, AddresstypeRow],
                          map: scala.collection.mutable.Map[AddresstypeId, AddresstypeRow] = scala.collection.mutable.Map.empty) extends AddresstypeRepo {
  override def delete(addresstypeid: AddresstypeId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(addresstypeid).isDefined)
  }
  override def deleteByIds(addresstypeids: Array[AddresstypeId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(addresstypeids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[AddresstypeFields, AddresstypeRow] = {
    DeleteBuilderMock(DeleteParams.empty, AddresstypeFields.structure.fields, map)
  }
  override def insert(unsaved: AddresstypeRow): ZIO[ZConnection, Throwable, AddresstypeRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.addresstypeid))
          sys.error(s"id ${unsaved.addresstypeid} already exists")
        else
          map.put(unsaved.addresstypeid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, AddresstypeRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.addresstypeid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: AddresstypeRowUnsaved): ZIO[ZConnection, Throwable, AddresstypeRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, AddresstypeRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.addresstypeid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[AddresstypeFields, AddresstypeRow] = {
    SelectBuilderMock(AddresstypeFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, AddresstypeRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(addresstypeid: AddresstypeId): ZIO[ZConnection, Throwable, Option[AddresstypeRow]] = {
    ZIO.succeed(map.get(addresstypeid))
  }
  override def selectByIds(addresstypeids: Array[AddresstypeId]): ZStream[ZConnection, Throwable, AddresstypeRow] = {
    ZStream.fromIterable(addresstypeids.flatMap(map.get))
  }
  override def update(row: AddresstypeRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.addresstypeid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.addresstypeid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[AddresstypeFields, AddresstypeRow] = {
    UpdateBuilderMock(UpdateParams.empty, AddresstypeFields.structure.fields, map)
  }
  override def upsert(unsaved: AddresstypeRow): ZIO[ZConnection, Throwable, UpdateResult[AddresstypeRow]] = {
    ZIO.succeed {
      map.put(unsaved.addresstypeid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
