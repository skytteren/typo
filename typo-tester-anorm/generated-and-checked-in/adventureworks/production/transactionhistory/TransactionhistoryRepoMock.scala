/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import java.sql.Connection
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

class TransactionhistoryRepoMock(toRow: Function1[TransactionhistoryRowUnsaved, TransactionhistoryRow],
                                 map: scala.collection.mutable.Map[TransactionhistoryId, TransactionhistoryRow] = scala.collection.mutable.Map.empty) extends TransactionhistoryRepo {
  override def delete(transactionid: TransactionhistoryId)(implicit c: Connection): Boolean = {
    map.remove(transactionid).isDefined
  }
  override def deleteByIds(transactionids: Array[TransactionhistoryId])(implicit c: Connection): Int = {
    transactionids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def delete: DeleteBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, TransactionhistoryFields.structure.fields, map)
  }
  override def insert(unsaved: TransactionhistoryRow)(implicit c: Connection): TransactionhistoryRow = {
    val _ = if (map.contains(unsaved.transactionid))
      sys.error(s"id ${unsaved.transactionid} already exists")
    else
      map.put(unsaved.transactionid, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[TransactionhistoryRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.transactionid -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: TransactionhistoryRowUnsaved)(implicit c: Connection): TransactionhistoryRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[TransactionhistoryRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.transactionid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    SelectBuilderMock(TransactionhistoryFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[TransactionhistoryRow] = {
    map.values.toList
  }
  override def selectById(transactionid: TransactionhistoryId)(implicit c: Connection): Option[TransactionhistoryRow] = {
    map.get(transactionid)
  }
  override def selectByIds(transactionids: Array[TransactionhistoryId])(implicit c: Connection): List[TransactionhistoryRow] = {
    transactionids.flatMap(map.get).toList
  }
  override def update(row: TransactionhistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.transactionid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.transactionid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, TransactionhistoryFields.structure.fields, map)
  }
  override def upsert(unsaved: TransactionhistoryRow)(implicit c: Connection): TransactionhistoryRow = {
    map.put(unsaved.transactionid, unsaved): @nowarn
    unsaved
  }
}
