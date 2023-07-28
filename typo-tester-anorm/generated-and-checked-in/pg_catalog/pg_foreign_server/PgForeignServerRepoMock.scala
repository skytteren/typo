/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_server

import java.sql.Connection

class PgForeignServerRepoMock(map: scala.collection.mutable.Map[PgForeignServerId, PgForeignServerRow] = scala.collection.mutable.Map.empty) extends PgForeignServerRepo {
  override def delete(oid: PgForeignServerId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def insert(unsaved: PgForeignServerRow)(implicit c: Connection): PgForeignServerRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def selectAll(implicit c: Connection): List[PgForeignServerRow] = {
    map.values.toList
  }
  override def selectById(oid: PgForeignServerId)(implicit c: Connection): Option[PgForeignServerRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgForeignServerId])(implicit c: Connection): List[PgForeignServerRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgForeignServerRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: PgForeignServerRow)(implicit c: Connection): PgForeignServerRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}