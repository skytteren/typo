/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

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

class ContacttypeRepoMock(toRow: Function1[ContacttypeRowUnsaved, ContacttypeRow],
                          map: scala.collection.mutable.Map[ContacttypeId, ContacttypeRow] = scala.collection.mutable.Map.empty) extends ContacttypeRepo {
  override def delete: DeleteBuilder[ContacttypeFields, ContacttypeRow] = {
    DeleteBuilderMock(DeleteParams.empty, ContacttypeFields.structure, map)
  }
  override def deleteById(contacttypeid: ContacttypeId): ConnectionIO[Boolean] = {
    delay(map.remove(contacttypeid).isDefined)
  }
  override def deleteByIds(contacttypeids: Array[ContacttypeId]): ConnectionIO[Int] = {
    delay(contacttypeids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: ContacttypeRow): ConnectionIO[ContacttypeRow] = {
    delay {
      val _ = if (map.contains(unsaved.contacttypeid))
        sys.error(s"id ${unsaved.contacttypeid} already exists")
      else
        map.put(unsaved.contacttypeid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ContacttypeRowUnsaved): ConnectionIO[ContacttypeRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ContacttypeRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.contacttypeid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ContacttypeRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.contacttypeid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ContacttypeFields, ContacttypeRow] = {
    SelectBuilderMock(ContacttypeFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ContacttypeRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(contacttypeid: ContacttypeId): ConnectionIO[Option[ContacttypeRow]] = {
    delay(map.get(contacttypeid))
  }
  override def selectByIds(contacttypeids: Array[ContacttypeId]): Stream[ConnectionIO, ContacttypeRow] = {
    Stream.emits(contacttypeids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(contacttypeids: Array[ContacttypeId]): ConnectionIO[Map[ContacttypeId, ContacttypeRow]] = {
    selectByIds(contacttypeids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.contacttypeid, x)).toMap
      contacttypeids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ContacttypeFields, ContacttypeRow] = {
    UpdateBuilderMock(UpdateParams.empty, ContacttypeFields.structure, map)
  }
  override def update(row: ContacttypeRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.contacttypeid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.contacttypeid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: ContacttypeRow): ConnectionIO[ContacttypeRow] = {
    delay {
      map.put(unsaved.contacttypeid, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[ContacttypeRow]): Stream[ConnectionIO, ContacttypeRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.contacttypeid -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, ContacttypeRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.contacttypeid -> row)
        num += 1
      }
      num
    }
  }
}
