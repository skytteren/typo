/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgRolesRepo {
  def selectAll(implicit c: Connection): List[PgRolesRow]
  def selectByFieldValues(fieldValues: List[PgRolesFieldValue[_]])(implicit c: Connection): List[PgRolesRow]
}