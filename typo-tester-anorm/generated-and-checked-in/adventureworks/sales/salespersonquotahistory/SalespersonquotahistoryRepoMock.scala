/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

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

class SalespersonquotahistoryRepoMock(toRow: Function1[SalespersonquotahistoryRowUnsaved, SalespersonquotahistoryRow],
                                      map: scala.collection.mutable.Map[SalespersonquotahistoryId, SalespersonquotahistoryRow] = scala.collection.mutable.Map.empty) extends SalespersonquotahistoryRepo {
  override def delete(compositeId: SalespersonquotahistoryId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def delete: DeleteBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalespersonquotahistoryFields, map)
  }
  override def insert(unsaved: SalespersonquotahistoryRow)(implicit c: Connection): SalespersonquotahistoryRow = {
    if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    unsaved
  }
  override def insert(unsaved: SalespersonquotahistoryRowUnsaved)(implicit c: Connection): SalespersonquotahistoryRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    SelectBuilderMock(SalespersonquotahistoryFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[SalespersonquotahistoryRow] = {
    map.values.toList
  }
  override def selectById(compositeId: SalespersonquotahistoryId)(implicit c: Connection): Option[SalespersonquotahistoryRow] = {
    map.get(compositeId)
  }
  override def update(row: SalespersonquotahistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalespersonquotahistoryFields, map)
  }
  override def upsert(unsaved: SalespersonquotahistoryRow)(implicit c: Connection): SalespersonquotahistoryRow = {
    map.put(unsaved.compositeId, unsaved)
    unsaved
  }
}