/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import java.sql.Connection

trait DataTypePrivilegesRepo {
  def selectAll(implicit c: Connection): List[DataTypePrivilegesRow]
  def selectByFieldValues(fieldValues: List[DataTypePrivilegesFieldValue[_]])(implicit c: Connection): List[DataTypePrivilegesRow]
}