/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

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

class ProductreviewRepoMock(toRow: Function1[ProductreviewRowUnsaved, ProductreviewRow],
                            map: scala.collection.mutable.Map[ProductreviewId, ProductreviewRow] = scala.collection.mutable.Map.empty) extends ProductreviewRepo {
  override def delete(productreviewid: ProductreviewId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(productreviewid).isDefined)
  }
  override def deleteByIds(productreviewids: Array[ProductreviewId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(productreviewids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductreviewFields.structure.fields, map)
  }
  override def insert(unsaved: ProductreviewRow): ZIO[ZConnection, Throwable, ProductreviewRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.productreviewid))
          sys.error(s"id ${unsaved.productreviewid} already exists")
        else
          map.put(unsaved.productreviewid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductreviewRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.productreviewid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: ProductreviewRowUnsaved): ZIO[ZConnection, Throwable, ProductreviewRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductreviewRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.productreviewid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[ProductreviewFields, ProductreviewRow] = {
    SelectBuilderMock(ProductreviewFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductreviewRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(productreviewid: ProductreviewId): ZIO[ZConnection, Throwable, Option[ProductreviewRow]] = {
    ZIO.succeed(map.get(productreviewid))
  }
  override def selectByIds(productreviewids: Array[ProductreviewId]): ZStream[ZConnection, Throwable, ProductreviewRow] = {
    ZStream.fromIterable(productreviewids.flatMap(map.get))
  }
  override def update(row: ProductreviewRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.productreviewid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productreviewid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductreviewFields, ProductreviewRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductreviewFields.structure.fields, map)
  }
  override def upsert(unsaved: ProductreviewRow): ZIO[ZConnection, Throwable, UpdateResult[ProductreviewRow]] = {
    ZIO.succeed {
      map.put(unsaved.productreviewid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
