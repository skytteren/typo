/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.person.businessentity.BusinessentityId
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

class PasswordRepoMock(toRow: Function1[PasswordRowUnsaved, PasswordRow],
                       map: scala.collection.mutable.Map[BusinessentityId, PasswordRow] = scala.collection.mutable.Map.empty) extends PasswordRepo {
  override def delete: DeleteBuilder[PasswordFields, PasswordRow] = {
    DeleteBuilderMock(DeleteParams.empty, PasswordFields.structure, map)
  }
  override def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    delay(map.remove(businessentityid).isDefined)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    delay(businessentityids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: PasswordRow): ConnectionIO[PasswordRow] = {
    delay {
      val _ = if (map.contains(unsaved.businessentityid))
        sys.error(s"id ${unsaved.businessentityid} already exists")
      else
        map.put(unsaved.businessentityid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PasswordRowUnsaved): ConnectionIO[PasswordRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PasswordRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.businessentityid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PasswordRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.businessentityid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[PasswordFields, PasswordRow] = {
    SelectBuilderMock(PasswordFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PasswordRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[PasswordRow]] = {
    delay(map.get(businessentityid))
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, PasswordRow] = {
    Stream.emits(businessentityids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ConnectionIO[Map[BusinessentityId, PasswordRow]] = {
    selectByIds(businessentityids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[PasswordFields, PasswordRow] = {
    UpdateBuilderMock(UpdateParams.empty, PasswordFields.structure, map)
  }
  override def update(row: PasswordRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.businessentityid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.businessentityid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: PasswordRow): ConnectionIO[PasswordRow] = {
    delay {
      map.put(unsaved.businessentityid, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[PasswordRow]): Stream[ConnectionIO, PasswordRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.businessentityid -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, PasswordRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.businessentityid -> row)
        num += 1
      }
      num
    }
  }
}
