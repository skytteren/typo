/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

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

class ProductdocumentRepoMock(toRow: Function1[ProductdocumentRowUnsaved, ProductdocumentRow],
                              map: scala.collection.mutable.Map[ProductdocumentId, ProductdocumentRow] = scala.collection.mutable.Map.empty) extends ProductdocumentRepo {
  override def delete: DeleteBuilder[ProductdocumentFields, ProductdocumentRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductdocumentFields.structure.fields, map)
  }
  override def deleteById(compositeId: ProductdocumentId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[ProductdocumentId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductdocumentRow)(implicit c: Connection): ProductdocumentRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductdocumentRowUnsaved)(implicit c: Connection): ProductdocumentRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductdocumentRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductdocumentRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductdocumentFields, ProductdocumentRow] = {
    SelectBuilderMock(ProductdocumentFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductdocumentRow] = {
    map.values.toList
  }
  override def selectById(compositeId: ProductdocumentId)(implicit c: Connection): Option[ProductdocumentRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[ProductdocumentId])(implicit c: Connection): List[ProductdocumentRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[ProductdocumentId])(implicit c: Connection): Map[ProductdocumentId, Option[ProductdocumentRow]] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[ProductdocumentFields, ProductdocumentRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductdocumentFields.structure.fields, map)
  }
  override def update(row: ProductdocumentRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductdocumentRow)(implicit c: Connection): ProductdocumentRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
