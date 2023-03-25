/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgDescriptionRepo {
  def selectAll(implicit c: Connection): List[PgDescriptionRow]
  def selectById(compositeId: PgDescriptionId)(implicit c: Connection): Option[PgDescriptionRow]
  def selectByFieldValues(fieldValues: List[PgDescriptionFieldValue[_]])(implicit c: Connection): List[PgDescriptionRow]
  def updateFieldValues(compositeId: PgDescriptionId, fieldValues: List[PgDescriptionFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgDescriptionId, unsaved: PgDescriptionRowUnsaved)(implicit c: Connection): Boolean
  def delete(compositeId: PgDescriptionId)(implicit c: Connection): Boolean
}