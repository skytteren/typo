/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

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

class SalesorderheaderRepoMock(toRow: Function1[SalesorderheaderRowUnsaved, SalesorderheaderRow],
                               map: scala.collection.mutable.Map[SalesorderheaderId, SalesorderheaderRow] = scala.collection.mutable.Map.empty) extends SalesorderheaderRepo {
  override def delete(salesorderid: SalesorderheaderId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(salesorderid).isDefined)
  }
  override def deleteByIds(salesorderids: Array[SalesorderheaderId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(salesorderids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesorderheaderFields.structure.fields, map)
  }
  override def insert(unsaved: SalesorderheaderRow): ZIO[ZConnection, Throwable, SalesorderheaderRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.salesorderid))
          sys.error(s"id ${unsaved.salesorderid} already exists")
        else
          map.put(unsaved.salesorderid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheaderRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.salesorderid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved): ZIO[ZConnection, Throwable, SalesorderheaderRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheaderRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.salesorderid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    SelectBuilderMock(SalesorderheaderFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalesorderheaderRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(salesorderid: SalesorderheaderId): ZIO[ZConnection, Throwable, Option[SalesorderheaderRow]] = {
    ZIO.succeed(map.get(salesorderid))
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId]): ZStream[ZConnection, Throwable, SalesorderheaderRow] = {
    ZStream.fromIterable(salesorderids.flatMap(map.get))
  }
  override def update(row: SalesorderheaderRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.salesorderid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.salesorderid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesorderheaderFields.structure.fields, map)
  }
  override def upsert(unsaved: SalesorderheaderRow): ZIO[ZConnection, Throwable, UpdateResult[SalesorderheaderRow]] = {
    ZIO.succeed {
      map.put(unsaved.salesorderid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
