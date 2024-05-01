/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

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

class PurchaseorderheaderRepoMock(toRow: Function1[PurchaseorderheaderRowUnsaved, PurchaseorderheaderRow],
                                  map: scala.collection.mutable.Map[PurchaseorderheaderId, PurchaseorderheaderRow] = scala.collection.mutable.Map.empty) extends PurchaseorderheaderRepo {
  override def delete: DeleteBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    DeleteBuilderMock(DeleteParams.empty, PurchaseorderheaderFields.structure.fields, map)
  }
  override def deleteById(purchaseorderid: PurchaseorderheaderId): ConnectionIO[Boolean] = {
    delay(map.remove(purchaseorderid).isDefined)
  }
  override def deleteByIds(purchaseorderids: Array[PurchaseorderheaderId]): ConnectionIO[Int] = {
    delay(purchaseorderids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: PurchaseorderheaderRow): ConnectionIO[PurchaseorderheaderRow] = {
    delay {
      val _ = if (map.contains(unsaved.purchaseorderid))
        sys.error(s"id ${unsaved.purchaseorderid} already exists")
      else
        map.put(unsaved.purchaseorderid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PurchaseorderheaderRowUnsaved): ConnectionIO[PurchaseorderheaderRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PurchaseorderheaderRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.purchaseorderid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PurchaseorderheaderRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.purchaseorderid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    SelectBuilderMock(PurchaseorderheaderFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PurchaseorderheaderRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(purchaseorderid: PurchaseorderheaderId): ConnectionIO[Option[PurchaseorderheaderRow]] = {
    delay(map.get(purchaseorderid))
  }
  override def selectByIds(purchaseorderids: Array[PurchaseorderheaderId]): Stream[ConnectionIO, PurchaseorderheaderRow] = {
    Stream.emits(purchaseorderids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(purchaseorderids: Array[PurchaseorderheaderId]): ConnectionIO[Map[PurchaseorderheaderId, Option[PurchaseorderheaderRow]]] = {
    selectByIds(purchaseorderids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.purchaseorderid, x)).toMap
      purchaseorderids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    UpdateBuilderMock(UpdateParams.empty, PurchaseorderheaderFields.structure.fields, map)
  }
  override def update(row: PurchaseorderheaderRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.purchaseorderid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.purchaseorderid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: PurchaseorderheaderRow): ConnectionIO[PurchaseorderheaderRow] = {
    delay {
      map.put(unsaved.purchaseorderid, unsaved): @nowarn
      unsaved
    }
  }
}
