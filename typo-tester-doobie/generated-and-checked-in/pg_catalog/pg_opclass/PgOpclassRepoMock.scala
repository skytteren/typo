/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opclass

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class PgOpclassRepoMock(map: scala.collection.mutable.Map[PgOpclassId, PgOpclassRow] = scala.collection.mutable.Map.empty) extends PgOpclassRepo {
  override def delete(oid: PgOpclassId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def insert(unsaved: PgOpclassRow): ConnectionIO[PgOpclassRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def selectAll: Stream[ConnectionIO, PgOpclassRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgOpclassId): ConnectionIO[Option[PgOpclassRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgOpclassId]): Stream[ConnectionIO, PgOpclassRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgOpclassRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row)
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: PgOpclassRow): ConnectionIO[PgOpclassRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}