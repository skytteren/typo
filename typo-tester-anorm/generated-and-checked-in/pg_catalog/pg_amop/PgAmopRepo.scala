/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amop

import java.sql.Connection

trait PgAmopRepo {
  def delete(oid: PgAmopId)(implicit c: Connection): Boolean
  def insert(unsaved: PgAmopRow)(implicit c: Connection): PgAmopRow
  def selectAll(implicit c: Connection): List[PgAmopRow]
  def selectById(oid: PgAmopId)(implicit c: Connection): Option[PgAmopRow]
  def selectByIds(oids: Array[PgAmopId])(implicit c: Connection): List[PgAmopRow]
  def update(row: PgAmopRow)(implicit c: Connection): Boolean
  def upsert(unsaved: PgAmopRow)(implicit c: Connection): PgAmopRow
}