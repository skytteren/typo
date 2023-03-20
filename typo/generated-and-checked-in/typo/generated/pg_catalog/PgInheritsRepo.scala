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

trait PgInheritsRepo {
  def selectAll(implicit c: Connection): List[PgInheritsRow]
  def selectById(compositeId: PgInheritsId)(implicit c: Connection): Option[PgInheritsRow]
  def selectByFieldValues(fieldValues: List[PgInheritsFieldValue[_]])(implicit c: Connection): List[PgInheritsRow]
  def updateFieldValues(compositeId: PgInheritsId, fieldValues: List[PgInheritsFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgInheritsId, unsaved: PgInheritsRowUnsaved)(implicit c: Connection): Boolean
  def delete(compositeId: PgInheritsId)(implicit c: Connection): Boolean
}
