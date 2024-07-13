/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

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

class ProductRepoMock(toRow: Function1[ProductRowUnsaved, ProductRow],
                      map: scala.collection.mutable.Map[ProductId, ProductRow] = scala.collection.mutable.Map.empty) extends ProductRepo {
  override def delete: DeleteBuilder[ProductFields, ProductRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductFields.structure, map)
  }
  override def deleteById(productid: ProductId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(productid).isDefined)
  }
  override def deleteByIds(productids: Array[ProductId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(productids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: ProductRow): ZIO[ZConnection, Throwable, ProductRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.productid))
          sys.error(s"id ${unsaved.productid} already exists")
        else
          map.put(unsaved.productid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductRowUnsaved): ZIO[ZConnection, Throwable, ProductRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.productid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.productid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[ProductFields, ProductRow] = {
    SelectBuilderMock(ProductFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(productid: ProductId): ZIO[ZConnection, Throwable, Option[ProductRow]] = {
    ZIO.succeed(map.get(productid))
  }
  override def selectByIds(productids: Array[ProductId]): ZStream[ZConnection, Throwable, ProductRow] = {
    ZStream.fromIterable(productids.flatMap(map.get))
  }
  override def selectByIdsTracked(productids: Array[ProductId]): ZIO[ZConnection, Throwable, Map[ProductId, ProductRow]] = {
    selectByIds(productids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.productid, x)).toMap
      productids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductFields, ProductRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductFields.structure, map)
  }
  override def update(row: ProductRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.productid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: ProductRow): ZIO[ZConnection, Throwable, UpdateResult[ProductRow]] = {
    ZIO.succeed {
      map.put(unsaved.productid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.productid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
