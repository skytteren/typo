/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_event_trigger

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class PgEventTriggerRepoMock(map: scala.collection.mutable.Map[PgEventTriggerId, PgEventTriggerRow] = scala.collection.mutable.Map.empty) extends PgEventTriggerRepo {
  override def delete(oid: PgEventTriggerId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgEventTriggerFields, map)
  }
  override def insert(unsaved: PgEventTriggerRow)(implicit c: Connection): PgEventTriggerRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    SelectBuilderMock(PgEventTriggerFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgEventTriggerRow] = {
    map.values.toList
  }
  override def selectById(oid: PgEventTriggerId)(implicit c: Connection): Option[PgEventTriggerRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgEventTriggerId])(implicit c: Connection): List[PgEventTriggerRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(evtname: String)(implicit c: Connection): Option[PgEventTriggerRow] = {
    map.values.find(v => evtname == v.evtname)
  }
  override def update(row: PgEventTriggerRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgEventTriggerFields, map)
  }
  override def upsert(unsaved: PgEventTriggerRow)(implicit c: Connection): PgEventTriggerRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}