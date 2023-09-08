/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.TypoUnknownCitext
import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
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
  override def delete(userId: UsersId): ConnectionIO[Boolean] = {
    delay(map.remove(userId).isDefined)
  }
  override def delete: DeleteBuilder[UsersFields, UsersRow] = {
    DeleteBuilderMock(DeleteParams.empty, UsersFields, map)
  }
  override def insert(unsaved: UsersRow): ConnectionIO[UsersRow] = {
    delay {
      if (map.contains(unsaved.userId))
        sys.error(s"id ${unsaved.userId} already exists")
      else
        map.put(unsaved.userId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: UsersRowUnsaved): ConnectionIO[UsersRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[UsersFields, UsersRow] = {
    SelectBuilderMock(UsersFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, UsersRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(userId: UsersId): ConnectionIO[Option[UsersRow]] = {
    delay(map.get(userId))
  }
  override def selectByIds(userIds: Array[UsersId]): Stream[ConnectionIO, UsersRow] = {
    Stream.emits(userIds.flatMap(map.get).toList)
  }
  override def selectByUnique(email: TypoUnknownCitext): ConnectionIO[Option[UsersRow]] = {
    delay(map.values.find(v => email == v.email))
  }
  override def update(row: UsersRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.userId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.userId, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[UsersFields, UsersRow] = {
    UpdateBuilderMock(UpdateParams.empty, UsersFields, map)
  }
  override def upsert(unsaved: UsersRow): ConnectionIO[UsersRow] = {
    delay {
      map.put(unsaved.userId, unsaved)
      unsaved
    }
  }
}
