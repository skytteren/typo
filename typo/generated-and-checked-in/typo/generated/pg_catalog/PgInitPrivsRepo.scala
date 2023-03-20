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

trait PgInitPrivsRepo {
  def selectAll(implicit c: Connection): List[PgInitPrivsRow]
  def selectById(compositeId: PgInitPrivsId)(implicit c: Connection): Option[PgInitPrivsRow]
  def selectByFieldValues(fieldValues: List[PgInitPrivsFieldValue[_]])(implicit c: Connection): List[PgInitPrivsRow]
  def updateFieldValues(compositeId: PgInitPrivsId, fieldValues: List[PgInitPrivsFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgInitPrivsId, unsaved: PgInitPrivsRowUnsaved)(implicit c: Connection): Boolean
  def delete(compositeId: PgInitPrivsId)(implicit c: Connection): Boolean
}
