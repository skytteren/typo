/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import java.sql.Connection

trait RoleUsageGrantsRepo {
  def selectAll(implicit c: Connection): List[RoleUsageGrantsRow]
  def selectByFieldValues(fieldValues: List[RoleUsageGrantsFieldValue[_]])(implicit c: Connection): List[RoleUsageGrantsRow]
}