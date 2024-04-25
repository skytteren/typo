/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package flaff

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

class FlaffRepoMock(map: scala.collection.mutable.Map[FlaffId, FlaffRow] = scala.collection.mutable.Map.empty) extends FlaffRepo {
  override def delete(compositeId: FlaffId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[FlaffId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def delete: DeleteBuilder[FlaffFields, FlaffRow] = {
    DeleteBuilderMock(DeleteParams.empty, FlaffFields.structure.fields, map)
  }
  override def insert(unsaved: FlaffRow): ConnectionIO[FlaffRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, FlaffRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[FlaffFields, FlaffRow] = {
    SelectBuilderMock(FlaffFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, FlaffRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: FlaffId): ConnectionIO[Option[FlaffRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[FlaffId]): Stream[ConnectionIO, FlaffRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def update(row: FlaffRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[FlaffFields, FlaffRow] = {
    UpdateBuilderMock(UpdateParams.empty, FlaffFields.structure.fields, map)
  }
  override def upsert(unsaved: FlaffRow): ConnectionIO[FlaffRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
