/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdescription

import java.sql.Connection

class PgShdescriptionRepoMock(map: scala.collection.mutable.Map[PgShdescriptionId, PgShdescriptionRow] = scala.collection.mutable.Map.empty) extends PgShdescriptionRepo {
  override def delete(compositeId: PgShdescriptionId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def insert(unsaved: PgShdescriptionRow)(implicit c: Connection): PgShdescriptionRow = {
    if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    unsaved
  }
  override def selectAll(implicit c: Connection): List[PgShdescriptionRow] = {
    map.values.toList
  }
  override def selectById(compositeId: PgShdescriptionId)(implicit c: Connection): Option[PgShdescriptionRow] = {
    map.get(compositeId)
  }
  override def update(row: PgShdescriptionRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: PgShdescriptionRow)(implicit c: Connection): PgShdescriptionRow = {
    map.put(unsaved.compositeId, unsaved)
    unsaved
  }
}