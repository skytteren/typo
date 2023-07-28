/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject

import java.sql.Connection

trait PgLargeobjectRepo {
  def delete(compositeId: PgLargeobjectId)(implicit c: Connection): Boolean
  def insert(unsaved: PgLargeobjectRow)(implicit c: Connection): PgLargeobjectRow
  def selectAll(implicit c: Connection): List[PgLargeobjectRow]
  def selectById(compositeId: PgLargeobjectId)(implicit c: Connection): Option[PgLargeobjectRow]
  def update(row: PgLargeobjectRow)(implicit c: Connection): Boolean
  def upsert(unsaved: PgLargeobjectRow)(implicit c: Connection): PgLargeobjectRow
}