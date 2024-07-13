/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

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

class WorkorderroutingRepoMock(toRow: Function1[WorkorderroutingRowUnsaved, WorkorderroutingRow],
                               map: scala.collection.mutable.Map[WorkorderroutingId, WorkorderroutingRow] = scala.collection.mutable.Map.empty) extends WorkorderroutingRepo {
  override def delete: DeleteBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    DeleteBuilderMock(DeleteParams.empty, WorkorderroutingFields.structure, map)
  }
  override def deleteById(compositeId: WorkorderroutingId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[WorkorderroutingId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: WorkorderroutingRow): ConnectionIO[WorkorderroutingRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: WorkorderroutingRowUnsaved): ConnectionIO[WorkorderroutingRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, WorkorderroutingRow], batchSize: Int = 10000): ConnectionIO[Long] = {
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
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, WorkorderroutingRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    SelectBuilderMock(WorkorderroutingFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, WorkorderroutingRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: WorkorderroutingId): ConnectionIO[Option[WorkorderroutingRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[WorkorderroutingId]): Stream[ConnectionIO, WorkorderroutingRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(compositeIds: Array[WorkorderroutingId]): ConnectionIO[Map[WorkorderroutingId, WorkorderroutingRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    UpdateBuilderMock(UpdateParams.empty, WorkorderroutingFields.structure, map)
  }
  override def update(row: WorkorderroutingRow): ConnectionIO[Boolean] = {
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
  override def upsert(unsaved: WorkorderroutingRow): ConnectionIO[WorkorderroutingRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[WorkorderroutingRow]): Stream[ConnectionIO, WorkorderroutingRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.compositeId -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, WorkorderroutingRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
}
