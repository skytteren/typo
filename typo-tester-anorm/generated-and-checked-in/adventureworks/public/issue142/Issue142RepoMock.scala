/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package issue142

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

class Issue142RepoMock(map: scala.collection.mutable.Map[Issue142Id, Issue142Row] = scala.collection.mutable.Map.empty) extends Issue142Repo {
  override def delete: DeleteBuilder[Issue142Fields, Issue142Row] = {
    DeleteBuilderMock(DeleteParams.empty, Issue142Fields.structure, map)
  }
  override def deleteById(tabellkode: Issue142Id)(implicit c: Connection): Boolean = {
    map.remove(tabellkode).isDefined
  }
  override def deleteByIds(tabellkodes: Array[Issue142Id])(implicit c: Connection): Int = {
    tabellkodes.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: Issue142Row)(implicit c: Connection): Issue142Row = {
    val _ = if (map.contains(unsaved.tabellkode))
      sys.error(s"id ${unsaved.tabellkode} already exists")
    else
      map.put(unsaved.tabellkode, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[Issue142Row], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.tabellkode -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[Issue142Fields, Issue142Row] = {
    SelectBuilderMock(Issue142Fields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[Issue142Row] = {
    map.values.toList
  }
  override def selectById(tabellkode: Issue142Id)(implicit c: Connection): Option[Issue142Row] = {
    map.get(tabellkode)
  }
  override def selectByIds(tabellkodes: Array[Issue142Id])(implicit c: Connection): List[Issue142Row] = {
    tabellkodes.flatMap(map.get).toList
  }
  override def selectByIdsTracked(tabellkodes: Array[Issue142Id])(implicit c: Connection): Map[Issue142Id, Issue142Row] = {
    val byId = selectByIds(tabellkodes).view.map(x => (x.tabellkode, x)).toMap
    tabellkodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[Issue142Fields, Issue142Row] = {
    UpdateBuilderMock(UpdateParams.empty, Issue142Fields.structure, map)
  }
  override def upsert(unsaved: Issue142Row)(implicit c: Connection): Issue142Row = {
    map.put(unsaved.tabellkode, unsaved): @nowarn
    unsaved
  }
  override def upsertBatch(unsaved: Iterable[Issue142Row])(implicit c: Connection): List[Issue142Row] = {
    unsaved.map { row =>
      map += (row.tabellkode -> row)
      row
    }.toList
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[Issue142Row], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.tabellkode -> row)
    }
    unsaved.size
  }
}
