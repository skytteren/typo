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
package pg_constraint

import java.sql.Connection

trait PgConstraintRepo {
  def delete(oid: PgConstraintId)(implicit c: Connection): Boolean
  def insert(oid: PgConstraintId, unsaved: PgConstraintRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[PgConstraintRow]
  def selectByFieldValues(fieldValues: List[PgConstraintFieldOrIdValue[_]])(implicit c: Connection): List[PgConstraintRow]
  def selectById(oid: PgConstraintId)(implicit c: Connection): Option[PgConstraintRow]
  def selectByIds(oids: Array[PgConstraintId])(implicit c: Connection): List[PgConstraintRow]
  def selectByUnique(conrelid: /* oid */ Long, contypid: /* oid */ Long, conname: String)(implicit c: Connection): Option[PgConstraintRow]
  def update(row: PgConstraintRow)(implicit c: Connection): Boolean
  def updateFieldValues(oid: PgConstraintId, fieldValues: List[PgConstraintFieldValue[_]])(implicit c: Connection): Boolean
}