/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgStatAllTablesRepo {
  def selectAll(implicit c: Connection): List[PgStatAllTablesRow]
  def selectByFieldValues(fieldValues: List[PgStatAllTablesFieldValue[_]])(implicit c: Connection): List[PgStatAllTablesRow]
}