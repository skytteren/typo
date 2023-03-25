/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgTablespaceRepo {
  def selectAll(implicit c: Connection): List[PgTablespaceRow]
  def selectById(oid: PgTablespaceId)(implicit c: Connection): Option[PgTablespaceRow]
  def selectByIds(oids: List[PgTablespaceId])(implicit c: Connection): List[PgTablespaceRow]
  def selectByFieldValues(fieldValues: List[PgTablespaceFieldValue[_]])(implicit c: Connection): List[PgTablespaceRow]
  def updateFieldValues(oid: PgTablespaceId, fieldValues: List[PgTablespaceFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgTablespaceId, unsaved: PgTablespaceRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgTablespaceId)(implicit c: Connection): Boolean
  def selectByUniqueSpcname(spcname: String)(implicit c: Connection): Option[PgTablespaceRow]
}