/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgPublicationTablesRepo {
  def selectAll(implicit c: Connection): List[PgPublicationTablesRow]
  def selectByFieldValues(fieldValues: List[PgPublicationTablesFieldValue[_]])(implicit c: Connection): List[PgPublicationTablesRow]
}
