/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgIndexRepo {
  def selectAll(implicit c: Connection): List[PgIndexRow]
  def selectById(indexrelid: PgIndexId)(implicit c: Connection): Option[PgIndexRow]
  def selectByIds(indexrelids: List[PgIndexId])(implicit c: Connection): List[PgIndexRow]
  def selectByFieldValues(fieldValues: List[PgIndexFieldValue[_]])(implicit c: Connection): List[PgIndexRow]
  def updateFieldValues(indexrelid: PgIndexId, fieldValues: List[PgIndexFieldValue[_]])(implicit c: Connection): Int
  def insert(indexrelid: PgIndexId, unsaved: PgIndexRowUnsaved)(implicit c: Connection): Boolean
  def delete(indexrelid: PgIndexId)(implicit c: Connection): Boolean
}