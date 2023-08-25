/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

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

class PgStatisticExtRepoMock(map: scala.collection.mutable.Map[PgStatisticExtId, PgStatisticExtRow] = scala.collection.mutable.Map.empty) extends PgStatisticExtRepo {
  override def delete(oid: PgStatisticExtId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgStatisticExtFields, PgStatisticExtRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgStatisticExtFields, map)
  }
  override def insert(unsaved: PgStatisticExtRow)(implicit c: Connection): PgStatisticExtRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgStatisticExtFields, PgStatisticExtRow] = {
    SelectBuilderMock(PgStatisticExtFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgStatisticExtRow] = {
    map.values.toList
  }
  override def selectById(oid: PgStatisticExtId)(implicit c: Connection): Option[PgStatisticExtRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgStatisticExtId])(implicit c: Connection): List[PgStatisticExtRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(stxname: String, stxnamespace: /* oid */ Long)(implicit c: Connection): Option[PgStatisticExtRow] = {
    map.values.find(v => stxname == v.stxname && stxnamespace == v.stxnamespace)
  }
  override def update(row: PgStatisticExtRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgStatisticExtFields, PgStatisticExtRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgStatisticExtFields, map)
  }
  override def upsert(unsaved: PgStatisticExtRow)(implicit c: Connection): PgStatisticExtRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}