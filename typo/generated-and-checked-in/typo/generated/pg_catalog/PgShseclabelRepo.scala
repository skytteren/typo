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

trait PgShseclabelRepo {
  def selectAll(implicit c: Connection): List[PgShseclabelRow]
  def selectById(compositeId: PgShseclabelId)(implicit c: Connection): Option[PgShseclabelRow]
  def selectByFieldValues(fieldValues: List[PgShseclabelFieldValue[_]])(implicit c: Connection): List[PgShseclabelRow]
  def updateFieldValues(compositeId: PgShseclabelId, fieldValues: List[PgShseclabelFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgShseclabelId, unsaved: PgShseclabelRowUnsaved)(implicit c: Connection): Boolean
  def delete(compositeId: PgShseclabelId)(implicit c: Connection): Boolean
}
