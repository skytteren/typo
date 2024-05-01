/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

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

class ProductsubcategoryRepoMock(toRow: Function1[ProductsubcategoryRowUnsaved, ProductsubcategoryRow],
                                 map: scala.collection.mutable.Map[ProductsubcategoryId, ProductsubcategoryRow] = scala.collection.mutable.Map.empty) extends ProductsubcategoryRepo {
  override def delete: DeleteBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductsubcategoryFields.structure.fields, map)
  }
  override def deleteById(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Boolean = {
    map.remove(productsubcategoryid).isDefined
  }
  override def deleteByIds(productsubcategoryids: Array[ProductsubcategoryId])(implicit c: Connection): Int = {
    productsubcategoryids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductsubcategoryRow)(implicit c: Connection): ProductsubcategoryRow = {
    val _ = if (map.contains(unsaved.productsubcategoryid))
      sys.error(s"id ${unsaved.productsubcategoryid} already exists")
    else
      map.put(unsaved.productsubcategoryid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductsubcategoryRowUnsaved)(implicit c: Connection): ProductsubcategoryRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductsubcategoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.productsubcategoryid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductsubcategoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.productsubcategoryid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    SelectBuilderMock(ProductsubcategoryFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductsubcategoryRow] = {
    map.values.toList
  }
  override def selectById(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Option[ProductsubcategoryRow] = {
    map.get(productsubcategoryid)
  }
  override def selectByIds(productsubcategoryids: Array[ProductsubcategoryId])(implicit c: Connection): List[ProductsubcategoryRow] = {
    productsubcategoryids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(productsubcategoryids: Array[ProductsubcategoryId])(implicit c: Connection): Map[ProductsubcategoryId, Option[ProductsubcategoryRow]] = {
    val byId = selectByIds(productsubcategoryids).view.map(x => (x.productsubcategoryid, x)).toMap
    productsubcategoryids.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductsubcategoryFields.structure.fields, map)
  }
  override def update(row: ProductsubcategoryRow)(implicit c: Connection): Boolean = {
    map.get(row.productsubcategoryid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.productsubcategoryid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductsubcategoryRow)(implicit c: Connection): ProductsubcategoryRow = {
    map.put(unsaved.productsubcategoryid, unsaved): @nowarn
    unsaved
  }
}
