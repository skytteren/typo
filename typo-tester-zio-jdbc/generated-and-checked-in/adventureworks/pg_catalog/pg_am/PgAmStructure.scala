/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_am

import adventureworks.customtypes.TypoRegproc
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class PgAmStructure[Row](val prefix: Option[String], val extract: Row => PgAmRow, val merge: (Row, PgAmRow) => Row)
  extends Relation[PgAmFields, PgAmRow, Row]
    with PgAmFields[Row] { outer =>

  override val oid = new IdField[PgAmId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val amname = new Field[String, Row](prefix, "amname", None, Some("name"))(x => extract(x).amname, (row, value) => merge(row, extract(row).copy(amname = value)))
  override val amhandler = new Field[TypoRegproc, Row](prefix, "amhandler", None, Some("regproc"))(x => extract(x).amhandler, (row, value) => merge(row, extract(row).copy(amhandler = value)))
  override val amtype = new Field[String, Row](prefix, "amtype", None, Some("char"))(x => extract(x).amtype, (row, value) => merge(row, extract(row).copy(amtype = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, amname, amhandler, amtype)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgAmRow, merge: (NewRow, PgAmRow) => NewRow): PgAmStructure[NewRow] =
    new PgAmStructure(prefix, extract, merge)
}