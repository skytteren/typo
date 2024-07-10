/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_namespace

import java.sql.Connection

trait PgNamespaceRepo {
  def deleteById(oid: PgNamespaceId)(implicit c: Connection): Boolean
  def deleteByIds(oids: Array[PgNamespaceId])(implicit c: Connection): Int
  def insert(unsaved: PgNamespaceRow)(implicit c: Connection): PgNamespaceRow
  def insertStreaming(unsaved: Iterator[PgNamespaceRow], batchSize: Int = 10000)(implicit c: Connection): Long
  def selectAll(implicit c: Connection): List[PgNamespaceRow]
  def selectById(oid: PgNamespaceId)(implicit c: Connection): Option[PgNamespaceRow]
  def selectByIds(oids: Array[PgNamespaceId])(implicit c: Connection): List[PgNamespaceRow]
  def selectByIdsTracked(oids: Array[PgNamespaceId])(implicit c: Connection): Map[PgNamespaceId, PgNamespaceRow]
  def selectByUniqueNspname(nspname: String)(implicit c: Connection): Option[PgNamespaceRow]
  def update(row: PgNamespaceRow)(implicit c: Connection): Boolean
  def upsert(unsaved: PgNamespaceRow)(implicit c: Connection): PgNamespaceRow
}
