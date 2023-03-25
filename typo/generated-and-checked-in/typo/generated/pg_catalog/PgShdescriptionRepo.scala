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

trait PgShdescriptionRepo {
  def selectAll(implicit c: Connection): List[PgShdescriptionRow]
  def selectById(compositeId: PgShdescriptionId)(implicit c: Connection): Option[PgShdescriptionRow]
  def selectByFieldValues(fieldValues: List[PgShdescriptionFieldValue[_]])(implicit c: Connection): List[PgShdescriptionRow]
  def updateFieldValues(compositeId: PgShdescriptionId, fieldValues: List[PgShdescriptionFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgShdescriptionId, unsaved: PgShdescriptionRowUnsaved)(implicit c: Connection): Boolean
  def delete(compositeId: PgShdescriptionId)(implicit c: Connection): Boolean
}