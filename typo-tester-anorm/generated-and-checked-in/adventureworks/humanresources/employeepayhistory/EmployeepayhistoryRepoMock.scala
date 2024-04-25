/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

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

class EmployeepayhistoryRepoMock(toRow: Function1[EmployeepayhistoryRowUnsaved, EmployeepayhistoryRow],
                                 map: scala.collection.mutable.Map[EmployeepayhistoryId, EmployeepayhistoryRow] = scala.collection.mutable.Map.empty) extends EmployeepayhistoryRepo {
  override def delete(compositeId: EmployeepayhistoryId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[EmployeepayhistoryId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmployeepayhistoryFields.structure.fields, map)
  }
  override def insert(unsaved: EmployeepayhistoryRow)(implicit c: Connection): EmployeepayhistoryRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[EmployeepayhistoryRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: EmployeepayhistoryRowUnsaved)(implicit c: Connection): EmployeepayhistoryRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[EmployeepayhistoryRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    SelectBuilderMock(EmployeepayhistoryFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[EmployeepayhistoryRow] = {
    map.values.toList
  }
  override def selectById(compositeId: EmployeepayhistoryId)(implicit c: Connection): Option[EmployeepayhistoryRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[EmployeepayhistoryId])(implicit c: Connection): List[EmployeepayhistoryRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def update(row: EmployeepayhistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmployeepayhistoryFields.structure.fields, map)
  }
  override def upsert(unsaved: EmployeepayhistoryRow)(implicit c: Connection): EmployeepayhistoryRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
