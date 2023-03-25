/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgStatisticExtDataRepo {
  def selectAll(implicit c: Connection): List[PgStatisticExtDataRow]
  def selectById(stxoid: PgStatisticExtDataId)(implicit c: Connection): Option[PgStatisticExtDataRow]
  def selectByIds(stxoids: List[PgStatisticExtDataId])(implicit c: Connection): List[PgStatisticExtDataRow]
  def selectByFieldValues(fieldValues: List[PgStatisticExtDataFieldValue[_]])(implicit c: Connection): List[PgStatisticExtDataRow]
  def updateFieldValues(stxoid: PgStatisticExtDataId, fieldValues: List[PgStatisticExtDataFieldValue[_]])(implicit c: Connection): Int
  def insert(stxoid: PgStatisticExtDataId, unsaved: PgStatisticExtDataRowUnsaved)(implicit c: Connection): Boolean
  def delete(stxoid: PgStatisticExtDataId)(implicit c: Connection): Boolean
}