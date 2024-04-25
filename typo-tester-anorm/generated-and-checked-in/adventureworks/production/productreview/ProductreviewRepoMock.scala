/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

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

class ProductreviewRepoMock(toRow: Function1[ProductreviewRowUnsaved, ProductreviewRow],
                            map: scala.collection.mutable.Map[ProductreviewId, ProductreviewRow] = scala.collection.mutable.Map.empty) extends ProductreviewRepo {
  override def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductreviewFields.structure.fields, map)
  }
  override def deleteById(productreviewid: ProductreviewId)(implicit c: Connection): Boolean = {
    map.remove(productreviewid).isDefined
  }
  override def deleteByIds(productreviewids: Array[ProductreviewId])(implicit c: Connection): Int = {
    productreviewids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductreviewRow)(implicit c: Connection): ProductreviewRow = {
    val _ = if (map.contains(unsaved.productreviewid))
      sys.error(s"id ${unsaved.productreviewid} already exists")
    else
      map.put(unsaved.productreviewid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductreviewRowUnsaved)(implicit c: Connection): ProductreviewRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductreviewRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.productreviewid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductreviewRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.productreviewid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductreviewFields, ProductreviewRow] = {
    SelectBuilderMock(ProductreviewFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductreviewRow] = {
    map.values.toList
  }
  override def selectById(productreviewid: ProductreviewId)(implicit c: Connection): Option[ProductreviewRow] = {
    map.get(productreviewid)
  }
  override def selectByIds(productreviewids: Array[ProductreviewId])(implicit c: Connection): List[ProductreviewRow] = {
    productreviewids.flatMap(map.get).toList
  }
  override def update: UpdateBuilder[ProductreviewFields, ProductreviewRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductreviewFields.structure.fields, map)
  }
  override def update(row: ProductreviewRow)(implicit c: Connection): Boolean = {
    map.get(row.productreviewid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.productreviewid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductreviewRow)(implicit c: Connection): ProductreviewRow = {
    map.put(unsaved.productreviewid, unsaved): @nowarn
    unsaved
  }
}
