/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

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

class ProductmodelproductdescriptioncultureRepoMock(toRow: Function1[ProductmodelproductdescriptioncultureRowUnsaved, ProductmodelproductdescriptioncultureRow],
                                                    map: scala.collection.mutable.Map[ProductmodelproductdescriptioncultureId, ProductmodelproductdescriptioncultureRow] = scala.collection.mutable.Map.empty) extends ProductmodelproductdescriptioncultureRepo {
  override def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductmodelproductdescriptioncultureFields.structure.fields, map)
  }
  override def deleteById(compositeId: ProductmodelproductdescriptioncultureId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRow): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    SelectBuilderMock(ProductmodelproductdescriptioncultureFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: ProductmodelproductdescriptioncultureId): ConnectionIO[Option[ProductmodelproductdescriptioncultureRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId]): Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductmodelproductdescriptioncultureFields.structure.fields, map)
  }
  override def update(row: ProductmodelproductdescriptioncultureRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: ProductmodelproductdescriptioncultureRow): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
