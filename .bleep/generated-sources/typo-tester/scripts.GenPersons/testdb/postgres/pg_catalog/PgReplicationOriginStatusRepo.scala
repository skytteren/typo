/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgReplicationOriginStatusRepo {
  def selectAll(implicit c: Connection): List[PgReplicationOriginStatusRow]
  def selectByFieldValues(fieldValues: List[PgReplicationOriginStatusFieldValue[_]])(implicit c: Connection): List[PgReplicationOriginStatusRow]
}
