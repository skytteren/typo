/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

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

class IdentityTestRepoMock(toRow: Function1[IdentityTestRowUnsaved, IdentityTestRow],
                           map: scala.collection.mutable.Map[IdentityTestId, IdentityTestRow] = scala.collection.mutable.Map.empty) extends IdentityTestRepo {
  override def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow] = {
    DeleteBuilderMock(DeleteParams.empty, IdentityTestFields.structure.fields, map)
  }
  override def deleteById(name: IdentityTestId): ConnectionIO[Boolean] = {
    delay(map.remove(name).isDefined)
  }
  override def deleteByIds(names: Array[IdentityTestId]): ConnectionIO[Int] = {
    delay(names.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: IdentityTestRow): ConnectionIO[IdentityTestRow] = {
    delay {
      val _ = if (map.contains(unsaved.name))
        sys.error(s"id ${unsaved.name} already exists")
      else
        map.put(unsaved.name, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: IdentityTestRowUnsaved): ConnectionIO[IdentityTestRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, IdentityTestRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.name -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, IdentityTestRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.name -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[IdentityTestFields, IdentityTestRow] = {
    SelectBuilderMock(IdentityTestFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, IdentityTestRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(name: IdentityTestId): ConnectionIO[Option[IdentityTestRow]] = {
    delay(map.get(name))
  }
  override def selectByIds(names: Array[IdentityTestId]): Stream[ConnectionIO, IdentityTestRow] = {
    Stream.emits(names.flatMap(map.get).toList)
  }
  override def update: UpdateBuilder[IdentityTestFields, IdentityTestRow] = {
    UpdateBuilderMock(UpdateParams.empty, IdentityTestFields.structure.fields, map)
  }
  override def update(row: IdentityTestRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.name) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.name, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: IdentityTestRow): ConnectionIO[IdentityTestRow] = {
    delay {
      map.put(unsaved.name, unsaved): @nowarn
      unsaved
    }
  }
}
