/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

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

class ProductphotoRepoMock(toRow: Function1[ProductphotoRowUnsaved, ProductphotoRow],
                           map: scala.collection.mutable.Map[ProductphotoId, ProductphotoRow] = scala.collection.mutable.Map.empty) extends ProductphotoRepo {
  override def delete(productphotoid: ProductphotoId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(productphotoid).isDefined)
  }
  override def deleteByIds(productphotoids: Array[ProductphotoId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(productphotoids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def delete: DeleteBuilder[ProductphotoFields, ProductphotoRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductphotoFields.structure.fields, map)
  }
  override def insert(unsaved: ProductphotoRow): ZIO[ZConnection, Throwable, ProductphotoRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.productphotoid))
          sys.error(s"id ${unsaved.productphotoid} already exists")
        else
          map.put(unsaved.productphotoid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductphotoRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.productphotoid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: ProductphotoRowUnsaved): ZIO[ZConnection, Throwable, ProductphotoRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductphotoRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.productphotoid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[ProductphotoFields, ProductphotoRow] = {
    SelectBuilderMock(ProductphotoFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductphotoRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(productphotoid: ProductphotoId): ZIO[ZConnection, Throwable, Option[ProductphotoRow]] = {
    ZIO.succeed(map.get(productphotoid))
  }
  override def selectByIds(productphotoids: Array[ProductphotoId]): ZStream[ZConnection, Throwable, ProductphotoRow] = {
    ZStream.fromIterable(productphotoids.flatMap(map.get))
  }
  override def update(row: ProductphotoRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.productphotoid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productphotoid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductphotoFields, ProductphotoRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductphotoFields.structure.fields, map)
  }
  override def upsert(unsaved: ProductphotoRow): ZIO[ZConnection, Throwable, UpdateResult[ProductphotoRow]] = {
    ZIO.succeed {
      map.put(unsaved.productphotoid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
