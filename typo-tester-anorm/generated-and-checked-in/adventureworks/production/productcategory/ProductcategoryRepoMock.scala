/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

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

class ProductcategoryRepoMock(toRow: Function1[ProductcategoryRowUnsaved, ProductcategoryRow],
                              map: scala.collection.mutable.Map[ProductcategoryId, ProductcategoryRow] = scala.collection.mutable.Map.empty) extends ProductcategoryRepo {
  override def delete: DeleteBuilder[ProductcategoryFields, ProductcategoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductcategoryFields.structure.fields, map)
  }
  override def deleteById(productcategoryid: ProductcategoryId)(implicit c: Connection): Boolean = {
    map.remove(productcategoryid).isDefined
  }
  override def deleteByIds(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): Int = {
    productcategoryids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductcategoryRow)(implicit c: Connection): ProductcategoryRow = {
    val _ = if (map.contains(unsaved.productcategoryid))
      sys.error(s"id ${unsaved.productcategoryid} already exists")
    else
      map.put(unsaved.productcategoryid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductcategoryRowUnsaved)(implicit c: Connection): ProductcategoryRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductcategoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.productcategoryid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductcategoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.productcategoryid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductcategoryFields, ProductcategoryRow] = {
    SelectBuilderMock(ProductcategoryFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductcategoryRow] = {
    map.values.toList
  }
  override def selectById(productcategoryid: ProductcategoryId)(implicit c: Connection): Option[ProductcategoryRow] = {
    map.get(productcategoryid)
  }
  override def selectByIds(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): List[ProductcategoryRow] = {
    productcategoryids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): Map[ProductcategoryId, Option[ProductcategoryRow]] = {
    val byId = selectByIds(productcategoryids).view.map(x => (x.productcategoryid, x)).toMap
    productcategoryids.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[ProductcategoryFields, ProductcategoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductcategoryFields.structure.fields, map)
  }
  override def update(row: ProductcategoryRow)(implicit c: Connection): Boolean = {
    map.get(row.productcategoryid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.productcategoryid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductcategoryRow)(implicit c: Connection): ProductcategoryRow = {
    map.put(unsaved.productcategoryid, unsaved): @nowarn
    unsaved
  }
}
