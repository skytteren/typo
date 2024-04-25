/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.userdefined.CustomCreditcardId
import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import doobie.util.Put
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

class PersoncreditcardRepoMock(toRow: Function1[PersoncreditcardRowUnsaved, PersoncreditcardRow],
                               map: scala.collection.mutable.Map[PersoncreditcardId, PersoncreditcardRow] = scala.collection.mutable.Map.empty) extends PersoncreditcardRepo {
  override def delete(compositeId: PersoncreditcardId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[PersoncreditcardId])(implicit put0: Put[Array[/* user-picked */ CustomCreditcardId]]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersoncreditcardFields.structure.fields, map)
  }
  override def insert(unsaved: PersoncreditcardRow): ConnectionIO[PersoncreditcardRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PersoncreditcardRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved): ConnectionIO[PersoncreditcardRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersoncreditcardRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    SelectBuilderMock(PersoncreditcardFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PersoncreditcardRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: PersoncreditcardId): ConnectionIO[Option[PersoncreditcardRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[PersoncreditcardId])(implicit puts0: Put[Array[/* user-picked */ CustomCreditcardId]]): Stream[ConnectionIO, PersoncreditcardRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def update(row: PersoncreditcardRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersoncreditcardFields.structure.fields, map)
  }
  override def upsert(unsaved: PersoncreditcardRow): ConnectionIO[PersoncreditcardRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
