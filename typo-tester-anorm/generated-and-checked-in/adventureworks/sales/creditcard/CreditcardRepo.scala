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
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CreditcardRepo {
  def delete: DeleteBuilder[CreditcardFields, CreditcardRow]
  def deleteById(creditcardid: /* user-picked */ CustomCreditcardId)(implicit c: Connection): Boolean
  def deleteByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): Int
  def insert(unsaved: CreditcardRow)(implicit c: Connection): CreditcardRow
  def insert(unsaved: CreditcardRowUnsaved)(implicit c: Connection): CreditcardRow
  def insertStreaming(unsaved: Iterator[CreditcardRow], batchSize: Int)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[CreditcardRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[CreditcardFields, CreditcardRow]
  def selectAll(implicit c: Connection): List[CreditcardRow]
  def selectById(creditcardid: /* user-picked */ CustomCreditcardId)(implicit c: Connection): Option[CreditcardRow]
  def selectByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): List[CreditcardRow]
  def update: UpdateBuilder[CreditcardFields, CreditcardRow]
  def update(row: CreditcardRow)(implicit c: Connection): Boolean
  def upsert(unsaved: CreditcardRow)(implicit c: Connection): CreditcardRow
}
