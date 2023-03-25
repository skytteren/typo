/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgAuthMembersRepo {
  def selectAll(implicit c: Connection): List[PgAuthMembersRow]
  def selectById(compositeId: PgAuthMembersId)(implicit c: Connection): Option[PgAuthMembersRow]
  def selectByFieldValues(fieldValues: List[PgAuthMembersFieldValue[_]])(implicit c: Connection): List[PgAuthMembersRow]
  def updateFieldValues(compositeId: PgAuthMembersId, fieldValues: List[PgAuthMembersFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgAuthMembersId, unsaved: PgAuthMembersRowUnsaved)(implicit c: Connection): Boolean
  def delete(compositeId: PgAuthMembersId)(implicit c: Connection): Boolean
  def selectByUniqueMemberRoleid(member: Long, roleid: Long)(implicit c: Connection): Option[PgAuthMembersRow]
}