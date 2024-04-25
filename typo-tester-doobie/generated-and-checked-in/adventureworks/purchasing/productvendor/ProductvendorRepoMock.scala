/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

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

class ProductvendorRepoMock(toRow: Function1[ProductvendorRowUnsaved, ProductvendorRow],
                            map: scala.collection.mutable.Map[ProductvendorId, ProductvendorRow] = scala.collection.mutable.Map.empty) extends ProductvendorRepo {
  override def delete(compositeId: ProductvendorId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[ProductvendorId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def delete: DeleteBuilder[ProductvendorFields, ProductvendorRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductvendorFields.structure.fields, map)
  }
  override def insert(unsaved: ProductvendorRow): ConnectionIO[ProductvendorRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductvendorRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: ProductvendorRowUnsaved): ConnectionIO[ProductvendorRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductvendorRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[ProductvendorFields, ProductvendorRow] = {
    SelectBuilderMock(ProductvendorFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductvendorRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: ProductvendorId): ConnectionIO[Option[ProductvendorRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[ProductvendorId]): Stream[ConnectionIO, ProductvendorRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def update(row: ProductvendorRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[ProductvendorFields, ProductvendorRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductvendorFields.structure.fields, map)
  }
  override def upsert(unsaved: ProductvendorRow): ConnectionIO[ProductvendorRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
