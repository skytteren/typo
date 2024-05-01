/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.TypoUnknownCitext
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

class UsersRepoMock(toRow: Function1[UsersRowUnsaved, UsersRow],
                    map: scala.collection.mutable.Map[UsersId, UsersRow] = scala.collection.mutable.Map.empty) extends UsersRepo {
  override def delete: DeleteBuilder[UsersFields, UsersRow] = {
    DeleteBuilderMock(DeleteParams.empty, UsersFields.structure.fields, map)
  }
  override def deleteById(userId: UsersId)(implicit c: Connection): Boolean = {
    map.remove(userId).isDefined
  }
  override def deleteByIds(userIds: Array[UsersId])(implicit c: Connection): Int = {
    userIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: UsersRow)(implicit c: Connection): UsersRow = {
    val _ = if (map.contains(unsaved.userId))
      sys.error(s"id ${unsaved.userId} already exists")
    else
      map.put(unsaved.userId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: UsersRowUnsaved)(implicit c: Connection): UsersRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[UsersRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.userId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[UsersRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.userId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[UsersFields, UsersRow] = {
    SelectBuilderMock(UsersFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[UsersRow] = {
    map.values.toList
  }
  override def selectById(userId: UsersId)(implicit c: Connection): Option[UsersRow] = {
    map.get(userId)
  }
  override def selectByIds(userIds: Array[UsersId])(implicit c: Connection): List[UsersRow] = {
    userIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(userIds: Array[UsersId])(implicit c: Connection): Map[UsersId, Option[UsersRow]] = {
    val byId = selectByIds(userIds).view.map(x => (x.userId, x)).toMap
    userIds.view.map(id => (id, byId.get(id))).toMap
  }
  override def selectByUniqueEmail(email: TypoUnknownCitext)(implicit c: Connection): Option[UsersRow] = {
    map.values.find(v => email == v.email)
  }
  override def update: UpdateBuilder[UsersFields, UsersRow] = {
    UpdateBuilderMock(UpdateParams.empty, UsersFields.structure.fields, map)
  }
  override def update(row: UsersRow)(implicit c: Connection): Boolean = {
    map.get(row.userId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.userId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: UsersRow)(implicit c: Connection): UsersRow = {
    map.put(unsaved.userId, unsaved): @nowarn
    unsaved
  }
}
