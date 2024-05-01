/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.userdefined.CustomCreditcardId
import anorm.ToStatement
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

class CreditcardRepoMock(toRow: Function1[CreditcardRowUnsaved, CreditcardRow],
                         map: scala.collection.mutable.Map[/* user-picked */ CustomCreditcardId, CreditcardRow] = scala.collection.mutable.Map.empty) extends CreditcardRepo {
  override def delete: DeleteBuilder[CreditcardFields, CreditcardRow] = {
    DeleteBuilderMock(DeleteParams.empty, CreditcardFields.structure.fields, map)
  }
  override def deleteById(creditcardid: /* user-picked */ CustomCreditcardId)(implicit c: Connection): Boolean = {
    map.remove(creditcardid).isDefined
  }
  override def deleteByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): Int = {
    creditcardids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: CreditcardRow)(implicit c: Connection): CreditcardRow = {
    val _ = if (map.contains(unsaved.creditcardid))
      sys.error(s"id ${unsaved.creditcardid} already exists")
    else
      map.put(unsaved.creditcardid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: CreditcardRowUnsaved)(implicit c: Connection): CreditcardRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[CreditcardRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.creditcardid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[CreditcardRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.creditcardid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[CreditcardFields, CreditcardRow] = {
    SelectBuilderMock(CreditcardFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[CreditcardRow] = {
    map.values.toList
  }
  override def selectById(creditcardid: /* user-picked */ CustomCreditcardId)(implicit c: Connection): Option[CreditcardRow] = {
    map.get(creditcardid)
  }
  override def selectByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): List[CreditcardRow] = {
    creditcardids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): Map[/* user-picked */ CustomCreditcardId, Option[CreditcardRow]] = {
    val byId = selectByIds(creditcardids).view.map(x => (x.creditcardid, x)).toMap
    creditcardids.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[CreditcardFields, CreditcardRow] = {
    UpdateBuilderMock(UpdateParams.empty, CreditcardFields.structure.fields, map)
  }
  override def update(row: CreditcardRow)(implicit c: Connection): Boolean = {
    map.get(row.creditcardid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.creditcardid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: CreditcardRow)(implicit c: Connection): CreditcardRow = {
    map.put(unsaved.creditcardid, unsaved): @nowarn
    unsaved
  }
}
