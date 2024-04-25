/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

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

class ProductreviewRepoMock(toRow: Function1[ProductreviewRowUnsaved, ProductreviewRow],
                            map: scala.collection.mutable.Map[ProductreviewId, ProductreviewRow] = scala.collection.mutable.Map.empty) extends ProductreviewRepo {
  override def delete(productreviewid: ProductreviewId): ConnectionIO[Boolean] = {
    delay(map.remove(productreviewid).isDefined)
  }
  override def deleteByIds(productreviewids: Array[ProductreviewId]): ConnectionIO[Int] = {
    delay(productreviewids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductreviewFields.structure.fields, map)
  }
  override def insert(unsaved: ProductreviewRow): ConnectionIO[ProductreviewRow] = {
    delay {
      val _ = if (map.contains(unsaved.productreviewid))
        sys.error(s"id ${unsaved.productreviewid} already exists")
      else
        map.put(unsaved.productreviewid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductreviewRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.productreviewid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: ProductreviewRowUnsaved): ConnectionIO[ProductreviewRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductreviewRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.productreviewid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ProductreviewFields, ProductreviewRow] = {
    SelectBuilderMock(ProductreviewFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductreviewRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(productreviewid: ProductreviewId): ConnectionIO[Option[ProductreviewRow]] = {
    delay(map.get(productreviewid))
  }
  override def selectByIds(productreviewids: Array[ProductreviewId]): Stream[ConnectionIO, ProductreviewRow] = {
    Stream.emits(productreviewids.flatMap(map.get).toList)
  }
  override def update(row: ProductreviewRow): ConnectionIO[Boolean] = {
    delay {
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
  override def upsert(unsaved: ProductreviewRow): ConnectionIO[ProductreviewRow] = {
    delay {
      map.put(unsaved.productreviewid, unsaved): @nowarn
      unsaved
    }
  }
}
