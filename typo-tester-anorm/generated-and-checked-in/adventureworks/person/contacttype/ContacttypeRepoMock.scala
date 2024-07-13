/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

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

class ContacttypeRepoMock(toRow: Function1[ContacttypeRowUnsaved, ContacttypeRow],
                          map: scala.collection.mutable.Map[ContacttypeId, ContacttypeRow] = scala.collection.mutable.Map.empty) extends ContacttypeRepo {
  override def delete: DeleteBuilder[ContacttypeFields, ContacttypeRow] = {
    DeleteBuilderMock(DeleteParams.empty, ContacttypeFields.structure, map)
  }
  override def deleteById(contacttypeid: ContacttypeId)(implicit c: Connection): Boolean = {
    map.remove(contacttypeid).isDefined
  }
  override def deleteByIds(contacttypeids: Array[ContacttypeId])(implicit c: Connection): Int = {
    contacttypeids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ContacttypeRow)(implicit c: Connection): ContacttypeRow = {
    val _ = if (map.contains(unsaved.contacttypeid))
      sys.error(s"id ${unsaved.contacttypeid} already exists")
    else
      map.put(unsaved.contacttypeid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ContacttypeRowUnsaved)(implicit c: Connection): ContacttypeRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ContacttypeRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.contacttypeid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ContacttypeRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.contacttypeid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ContacttypeFields, ContacttypeRow] = {
    SelectBuilderMock(ContacttypeFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ContacttypeRow] = {
    map.values.toList
  }
  override def selectById(contacttypeid: ContacttypeId)(implicit c: Connection): Option[ContacttypeRow] = {
    map.get(contacttypeid)
  }
  override def selectByIds(contacttypeids: Array[ContacttypeId])(implicit c: Connection): List[ContacttypeRow] = {
    contacttypeids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(contacttypeids: Array[ContacttypeId])(implicit c: Connection): Map[ContacttypeId, ContacttypeRow] = {
    val byId = selectByIds(contacttypeids).view.map(x => (x.contacttypeid, x)).toMap
    contacttypeids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ContacttypeFields, ContacttypeRow] = {
    UpdateBuilderMock(UpdateParams.empty, ContacttypeFields.structure, map)
  }
  override def update(row: ContacttypeRow)(implicit c: Connection): Boolean = {
    map.get(row.contacttypeid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.contacttypeid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ContacttypeRow)(implicit c: Connection): ContacttypeRow = {
    map.put(unsaved.contacttypeid, unsaved): @nowarn
    unsaved
  }
  override def upsertBatch(unsaved: Iterable[ContacttypeRow])(implicit c: Connection): List[ContacttypeRow] = {
    unsaved.map { row =>
      map += (row.contacttypeid -> row)
      row
    }.toList
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[ContacttypeRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.contacttypeid -> row)
    }
    unsaved.size
  }
}
