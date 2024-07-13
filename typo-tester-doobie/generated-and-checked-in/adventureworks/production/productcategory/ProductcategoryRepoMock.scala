/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

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

class ProductcategoryRepoMock(toRow: Function1[ProductcategoryRowUnsaved, ProductcategoryRow],
                              map: scala.collection.mutable.Map[ProductcategoryId, ProductcategoryRow] = scala.collection.mutable.Map.empty) extends ProductcategoryRepo {
  override def delete: DeleteBuilder[ProductcategoryFields, ProductcategoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductcategoryFields.structure, map)
  }
  override def deleteById(productcategoryid: ProductcategoryId): ConnectionIO[Boolean] = {
    delay(map.remove(productcategoryid).isDefined)
  }
  override def deleteByIds(productcategoryids: Array[ProductcategoryId]): ConnectionIO[Int] = {
    delay(productcategoryids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: ProductcategoryRow): ConnectionIO[ProductcategoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.productcategoryid))
        sys.error(s"id ${unsaved.productcategoryid} already exists")
      else
        map.put(unsaved.productcategoryid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductcategoryRowUnsaved): ConnectionIO[ProductcategoryRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductcategoryRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.productcategoryid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductcategoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.productcategoryid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ProductcategoryFields, ProductcategoryRow] = {
    SelectBuilderMock(ProductcategoryFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductcategoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(productcategoryid: ProductcategoryId): ConnectionIO[Option[ProductcategoryRow]] = {
    delay(map.get(productcategoryid))
  }
  override def selectByIds(productcategoryids: Array[ProductcategoryId]): Stream[ConnectionIO, ProductcategoryRow] = {
    Stream.emits(productcategoryids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(productcategoryids: Array[ProductcategoryId]): ConnectionIO[Map[ProductcategoryId, ProductcategoryRow]] = {
    selectByIds(productcategoryids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.productcategoryid, x)).toMap
      productcategoryids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductcategoryFields, ProductcategoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductcategoryFields.structure, map)
  }
  override def update(row: ProductcategoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.productcategoryid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productcategoryid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: ProductcategoryRow): ConnectionIO[ProductcategoryRow] = {
    delay {
      map.put(unsaved.productcategoryid, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[ProductcategoryRow]): Stream[ConnectionIO, ProductcategoryRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.productcategoryid -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, ProductcategoryRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.productcategoryid -> row)
        num += 1
      }
      num
    }
  }
}
