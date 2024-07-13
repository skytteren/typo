/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
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

class ProductRepoMock(toRow: Function1[ProductRowUnsaved, ProductRow],
                      map: scala.collection.mutable.Map[ProductId, ProductRow] = scala.collection.mutable.Map.empty) extends ProductRepo {
  override def delete: DeleteBuilder[ProductFields, ProductRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductFields.structure, map)
  }
  override def deleteById(productid: ProductId): ConnectionIO[Boolean] = {
    delay(map.remove(productid).isDefined)
  }
  override def deleteByIds(productids: Array[ProductId]): ConnectionIO[Int] = {
    delay(productids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: ProductRow): ConnectionIO[ProductRow] = {
    delay {
      val _ = if (map.contains(unsaved.productid))
        sys.error(s"id ${unsaved.productid} already exists")
      else
        map.put(unsaved.productid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductRowUnsaved): ConnectionIO[ProductRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.productid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.productid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ProductFields, ProductRow] = {
    SelectBuilderMock(ProductFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(productid: ProductId): ConnectionIO[Option[ProductRow]] = {
    delay(map.get(productid))
  }
  override def selectByIds(productids: Array[ProductId]): Stream[ConnectionIO, ProductRow] = {
    Stream.emits(productids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(productids: Array[ProductId]): ConnectionIO[Map[ProductId, ProductRow]] = {
    selectByIds(productids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.productid, x)).toMap
      productids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductFields, ProductRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductFields.structure, map)
  }
  override def update(row: ProductRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.productid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: ProductRow): ConnectionIO[ProductRow] = {
    delay {
      map.put(unsaved.productid, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[ProductRow]): Stream[ConnectionIO, ProductRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.productid -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, ProductRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.productid -> row)
        num += 1
      }
      num
    }
  }
}
