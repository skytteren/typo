/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgStatUserIndexesRepo {
  def selectAll(implicit c: Connection): List[PgStatUserIndexesRow]
  def selectByFieldValues(fieldValues: List[PgStatUserIndexesFieldValue[_]])(implicit c: Connection): List[PgStatUserIndexesRow]
}