/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.person.businessentity.BusinessentityId
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

class SalespersonRepoMock(toRow: Function1[SalespersonRowUnsaved, SalespersonRow],
                          map: scala.collection.mutable.Map[BusinessentityId, SalespersonRow] = scala.collection.mutable.Map.empty) extends SalespersonRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    map.remove(businessentityid).isDefined
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): Int = {
    businessentityids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def delete: DeleteBuilder[SalespersonFields, SalespersonRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalespersonFields.structure.fields, map)
  }
  override def insert(unsaved: SalespersonRow)(implicit c: Connection): SalespersonRow = {
    val _ = if (map.contains(unsaved.businessentityid))
      sys.error(s"id ${unsaved.businessentityid} already exists")
    else
      map.put(unsaved.businessentityid, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[SalespersonRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.businessentityid -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: SalespersonRowUnsaved)(implicit c: Connection): SalespersonRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalespersonRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.businessentityid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[SalespersonFields, SalespersonRow] = {
    SelectBuilderMock(SalespersonFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[SalespersonRow] = {
    map.values.toList
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[SalespersonRow] = {
    map.get(businessentityid)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[SalespersonRow] = {
    businessentityids.flatMap(map.get).toList
  }
  override def update(row: SalespersonRow)(implicit c: Connection): Boolean = {
    map.get(row.businessentityid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.businessentityid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[SalespersonFields, SalespersonRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalespersonFields.structure.fields, map)
  }
  override def upsert(unsaved: SalespersonRow)(implicit c: Connection): SalespersonRow = {
    map.put(unsaved.businessentityid, unsaved): @nowarn
    unsaved
  }
}
