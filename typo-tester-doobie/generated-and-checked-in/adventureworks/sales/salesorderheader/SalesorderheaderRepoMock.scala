/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

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

class SalesorderheaderRepoMock(toRow: Function1[SalesorderheaderRowUnsaved, SalesorderheaderRow],
                               map: scala.collection.mutable.Map[SalesorderheaderId, SalesorderheaderRow] = scala.collection.mutable.Map.empty) extends SalesorderheaderRepo {
  override def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesorderheaderFields.structure.fields, map)
  }
  override def deleteById(salesorderid: SalesorderheaderId): ConnectionIO[Boolean] = {
    delay(map.remove(salesorderid).isDefined)
  }
  override def deleteByIds(salesorderids: Array[SalesorderheaderId]): ConnectionIO[Int] = {
    delay(salesorderids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow] = {
    delay {
      val _ = if (map.contains(unsaved.salesorderid))
        sys.error(s"id ${unsaved.salesorderid} already exists")
      else
        map.put(unsaved.salesorderid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved): ConnectionIO[SalesorderheaderRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalesorderheaderRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.salesorderid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesorderheaderRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.salesorderid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    SelectBuilderMock(SalesorderheaderFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, SalesorderheaderRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(salesorderid: SalesorderheaderId): ConnectionIO[Option[SalesorderheaderRow]] = {
    delay(map.get(salesorderid))
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId]): Stream[ConnectionIO, SalesorderheaderRow] = {
    Stream.emits(salesorderids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(salesorderids: Array[SalesorderheaderId]): ConnectionIO[Map[SalesorderheaderId, Option[SalesorderheaderRow]]] = {
    selectByIds(salesorderids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.salesorderid, x)).toMap
      salesorderids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesorderheaderFields.structure.fields, map)
  }
  override def update(row: SalesorderheaderRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.salesorderid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.salesorderid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow] = {
    delay {
      map.put(unsaved.salesorderid, unsaved): @nowarn
      unsaved
    }
  }
}
