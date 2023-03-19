/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgCastRepo {
  def selectAll(implicit c: Connection): List[PgCastRow]
  def selectById(oid: PgCastId)(implicit c: Connection): Option[PgCastRow]
  def selectByIds(oids: List[PgCastId])(implicit c: Connection): List[PgCastRow]
  def selectByFieldValues(fieldValues: List[PgCastFieldValue[_]])(implicit c: Connection): List[PgCastRow]
  def updateFieldValues(oid: PgCastId, fieldValues: List[PgCastFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgCastId, unsaved: PgCastRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgCastId)(implicit c: Connection): Boolean
  def selectByUnique(castsource: Long, casttarget: Long)(implicit c: Connection): Option[PgCastRow]
}
