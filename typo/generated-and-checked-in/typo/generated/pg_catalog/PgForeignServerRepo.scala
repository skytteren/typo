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

import java.sql.Connection

trait PgForeignServerRepo {
  def selectAll(implicit c: Connection): List[PgForeignServerRow]
  def selectById(oid: PgForeignServerId)(implicit c: Connection): Option[PgForeignServerRow]
  def selectByIds(oids: List[PgForeignServerId])(implicit c: Connection): List[PgForeignServerRow]
  def selectByFieldValues(fieldValues: List[PgForeignServerFieldValue[_]])(implicit c: Connection): List[PgForeignServerRow]
  def updateFieldValues(oid: PgForeignServerId, fieldValues: List[PgForeignServerFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgForeignServerId, unsaved: PgForeignServerRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgForeignServerId)(implicit c: Connection): Boolean
  def selectByUnique(srvname: String)(implicit c: Connection): Option[PgForeignServerRow]
}