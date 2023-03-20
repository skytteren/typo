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

trait PgDefaultAclRepo {
  def selectAll(implicit c: Connection): List[PgDefaultAclRow]
  def selectById(oid: PgDefaultAclId)(implicit c: Connection): Option[PgDefaultAclRow]
  def selectByIds(oids: List[PgDefaultAclId])(implicit c: Connection): List[PgDefaultAclRow]
  def selectByFieldValues(fieldValues: List[PgDefaultAclFieldValue[_]])(implicit c: Connection): List[PgDefaultAclRow]
  def updateFieldValues(oid: PgDefaultAclId, fieldValues: List[PgDefaultAclFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgDefaultAclId, unsaved: PgDefaultAclRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgDefaultAclId)(implicit c: Connection): Boolean
  def selectByUnique(defaclrole: Long, defaclnamespace: Long, defaclobjtype: String)(implicit c: Connection): Option[PgDefaultAclRow]
}
