/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.userdefined.CustomCreditcardId
import anorm.ToStatement
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

class PersoncreditcardRepoMock(toRow: Function1[PersoncreditcardRowUnsaved, PersoncreditcardRow],
                               map: scala.collection.mutable.Map[PersoncreditcardId, PersoncreditcardRow] = scala.collection.mutable.Map.empty) extends PersoncreditcardRepo {
  override def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersoncreditcardFields.structure.fields, map)
  }
  override def deleteById(compositeId: PersoncreditcardId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[PersoncreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved)(implicit c: Connection): PersoncreditcardRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[PersoncreditcardRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PersoncreditcardRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    SelectBuilderMock(PersoncreditcardFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PersoncreditcardRow] = {
    map.values.toList
  }
  override def selectById(compositeId: PersoncreditcardId)(implicit c: Connection): Option[PersoncreditcardRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[PersoncreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): List[PersoncreditcardRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[PersoncreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): Map[PersoncreditcardId, Option[PersoncreditcardRow]] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersoncreditcardFields.structure.fields, map)
  }
  override def update(row: PersoncreditcardRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
