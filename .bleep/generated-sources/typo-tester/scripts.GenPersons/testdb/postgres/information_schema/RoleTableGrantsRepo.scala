/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import java.sql.Connection

trait RoleTableGrantsRepo {
  def selectAll(implicit c: Connection): List[RoleTableGrantsRow]
  def selectByFieldValues(fieldValues: List[RoleTableGrantsFieldValue[_]])(implicit c: Connection): List[RoleTableGrantsRow]
}
