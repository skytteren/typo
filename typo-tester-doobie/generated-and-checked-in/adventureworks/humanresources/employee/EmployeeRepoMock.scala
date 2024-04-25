/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

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

class EmployeeRepoMock(toRow: Function1[EmployeeRowUnsaved, EmployeeRow],
                       map: scala.collection.mutable.Map[BusinessentityId, EmployeeRow] = scala.collection.mutable.Map.empty) extends EmployeeRepo {
  override def delete: DeleteBuilder[EmployeeFields, EmployeeRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmployeeFields.structure.fields, map)
  }
  override def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    delay(map.remove(businessentityid).isDefined)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    delay(businessentityids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow] = {
    delay {
      val _ = if (map.contains(unsaved.businessentityid))
        sys.error(s"id ${unsaved.businessentityid} already exists")
      else
        map.put(unsaved.businessentityid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: EmployeeRowUnsaved): ConnectionIO[EmployeeRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, EmployeeRow], batchSize: Int): ConnectionIO[Long] = {
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
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, EmployeeRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[EmployeeFields, EmployeeRow] = {
    SelectBuilderMock(EmployeeFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, EmployeeRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[EmployeeRow]] = {
    delay(map.get(businessentityid))
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, EmployeeRow] = {
    Stream.emits(businessentityids.flatMap(map.get).toList)
  }
  override def update: UpdateBuilder[EmployeeFields, EmployeeRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmployeeFields.structure.fields, map)
  }
  override def update(row: EmployeeRow): ConnectionIO[Boolean] = {
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
  override def upsert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow] = {
    delay {
      map.put(unsaved.businessentityid, unsaved): @nowarn
      unsaved
    }
  }
}
