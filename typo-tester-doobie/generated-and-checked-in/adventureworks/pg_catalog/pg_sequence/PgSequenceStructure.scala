/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequence

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class PgSequenceStructure[Row](val prefix: Option[String], val extract: Row => PgSequenceRow, val merge: (Row, PgSequenceRow) => Row)
  extends Relation[PgSequenceFields, PgSequenceRow, Row]
    with PgSequenceFields[Row] { outer =>

  override val seqrelid = new IdField[PgSequenceId, Row](prefix, "seqrelid", None, Some("oid"))(x => extract(x).seqrelid, (row, value) => merge(row, extract(row).copy(seqrelid = value)))
  override val seqtypid = new Field[/* oid */ Long, Row](prefix, "seqtypid", None, Some("oid"))(x => extract(x).seqtypid, (row, value) => merge(row, extract(row).copy(seqtypid = value)))
  override val seqstart = new Field[Long, Row](prefix, "seqstart", None, Some("int8"))(x => extract(x).seqstart, (row, value) => merge(row, extract(row).copy(seqstart = value)))
  override val seqincrement = new Field[Long, Row](prefix, "seqincrement", None, Some("int8"))(x => extract(x).seqincrement, (row, value) => merge(row, extract(row).copy(seqincrement = value)))
  override val seqmax = new Field[Long, Row](prefix, "seqmax", None, Some("int8"))(x => extract(x).seqmax, (row, value) => merge(row, extract(row).copy(seqmax = value)))
  override val seqmin = new Field[Long, Row](prefix, "seqmin", None, Some("int8"))(x => extract(x).seqmin, (row, value) => merge(row, extract(row).copy(seqmin = value)))
  override val seqcache = new Field[Long, Row](prefix, "seqcache", None, Some("int8"))(x => extract(x).seqcache, (row, value) => merge(row, extract(row).copy(seqcache = value)))
  override val seqcycle = new Field[Boolean, Row](prefix, "seqcycle", None, None)(x => extract(x).seqcycle, (row, value) => merge(row, extract(row).copy(seqcycle = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgSequenceRow, merge: (NewRow, PgSequenceRow) => NewRow): PgSequenceStructure[NewRow] =
    new PgSequenceStructure(prefix, extract, merge)
}