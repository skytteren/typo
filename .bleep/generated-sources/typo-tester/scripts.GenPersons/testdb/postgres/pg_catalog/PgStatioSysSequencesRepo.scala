/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgStatioSysSequencesRepo {
  def selectAll(implicit c: Connection): List[PgStatioSysSequencesRow]
  def selectByFieldValues(fieldValues: List[PgStatioSysSequencesFieldValue[_]])(implicit c: Connection): List[PgStatioSysSequencesRow]
}