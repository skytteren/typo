/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgTsParserRepo {
  def selectAll(implicit c: Connection): List[PgTsParserRow]
  def selectById(oid: PgTsParserId)(implicit c: Connection): Option[PgTsParserRow]
  def selectByIds(oids: List[PgTsParserId])(implicit c: Connection): List[PgTsParserRow]
  def selectByFieldValues(fieldValues: List[PgTsParserFieldValue[_]])(implicit c: Connection): List[PgTsParserRow]
  def updateFieldValues(oid: PgTsParserId, fieldValues: List[PgTsParserFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgTsParserId, unsaved: PgTsParserRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgTsParserId)(implicit c: Connection): Boolean
  def selectByUnique(prsname: String, prsnamespace: Long)(implicit c: Connection): Option[PgTsParserRow]
}
