/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

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

class VendorRepoMock(toRow: Function1[VendorRowUnsaved, VendorRow],
                     map: scala.collection.mutable.Map[BusinessentityId, VendorRow] = scala.collection.mutable.Map.empty) extends VendorRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    delay(map.remove(businessentityid).isDefined)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    delay(businessentityids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def delete: DeleteBuilder[VendorFields, VendorRow] = {
    DeleteBuilderMock(DeleteParams.empty, VendorFields.structure.fields, map)
  }
  override def insert(unsaved: VendorRow): ConnectionIO[VendorRow] = {
    delay {
      val _ = if (map.contains(unsaved.businessentityid))
        sys.error(s"id ${unsaved.businessentityid} already exists")
      else
        map.put(unsaved.businessentityid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, VendorRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.businessentityid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: VendorRowUnsaved): ConnectionIO[VendorRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, VendorRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[VendorFields, VendorRow] = {
    SelectBuilderMock(VendorFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, VendorRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[VendorRow]] = {
    delay(map.get(businessentityid))
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, VendorRow] = {
    Stream.emits(businessentityids.flatMap(map.get).toList)
  }
  override def update(row: VendorRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[VendorFields, VendorRow] = {
    UpdateBuilderMock(UpdateParams.empty, VendorFields.structure.fields, map)
  }
  override def upsert(unsaved: VendorRow): ConnectionIO[VendorRow] = {
    delay {
      map.put(unsaved.businessentityid, unsaved): @nowarn
      unsaved
    }
  }
}
