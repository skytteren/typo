/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import java.sql.Connection

trait TableConstraintsRepo {
  def selectAll(implicit c: Connection): List[TableConstraintsRow]
  def selectByFieldValues(fieldValues: List[TableConstraintsFieldValue[_]])(implicit c: Connection): List[TableConstraintsRow]
}