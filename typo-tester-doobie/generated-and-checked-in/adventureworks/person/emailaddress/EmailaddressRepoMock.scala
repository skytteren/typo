/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

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

class EmailaddressRepoMock(toRow: Function1[EmailaddressRowUnsaved, EmailaddressRow],
                           map: scala.collection.mutable.Map[EmailaddressId, EmailaddressRow] = scala.collection.mutable.Map.empty) extends EmailaddressRepo {
  override def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmailaddressFields.structure, map)
  }
  override def deleteById(compositeId: EmailaddressId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[EmailaddressId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: EmailaddressRowUnsaved): ConnectionIO[EmailaddressRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, EmailaddressRow], batchSize: Int = 10000): ConnectionIO[Long] = {
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
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, EmailaddressRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[EmailaddressFields, EmailaddressRow] = {
    SelectBuilderMock(EmailaddressFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, EmailaddressRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: EmailaddressId): ConnectionIO[Option[EmailaddressRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[EmailaddressId]): Stream[ConnectionIO, EmailaddressRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(compositeIds: Array[EmailaddressId]): ConnectionIO[Map[EmailaddressId, EmailaddressRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[EmailaddressFields, EmailaddressRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmailaddressFields.structure, map)
  }
  override def update(row: EmailaddressRow): ConnectionIO[Boolean] = {
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
  override def upsert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[EmailaddressRow]): Stream[ConnectionIO, EmailaddressRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.compositeId -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, EmailaddressRow], batchSize: Int = 10000): ConnectionIO[Int] = {
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
