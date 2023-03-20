/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgAmRepo {
  def selectAll(implicit c: Connection): List[PgAmRow]
  def selectById(oid: PgAmId)(implicit c: Connection): Option[PgAmRow]
  def selectByIds(oids: List[PgAmId])(implicit c: Connection): List[PgAmRow]
  def selectByFieldValues(fieldValues: List[PgAmFieldValue[_]])(implicit c: Connection): List[PgAmRow]
  def updateFieldValues(oid: PgAmId, fieldValues: List[PgAmFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgAmId, unsaved: PgAmRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgAmId)(implicit c: Connection): Boolean
  def selectByUnique(amname: String)(implicit c: Connection): Option[PgAmRow]
}
