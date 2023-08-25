/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_range

import adventureworks.customtypes.TypoRegproc
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgRangeFields[Row] {
  val rngtypid: IdField[PgRangeId, Row]
  val rngsubtype: Field[/* oid */ Long, Row]
  val rngmultitypid: Field[/* oid */ Long, Row]
  val rngcollation: Field[/* oid */ Long, Row]
  val rngsubopc: Field[/* oid */ Long, Row]
  val rngcanonical: Field[TypoRegproc, Row]
  val rngsubdiff: Field[TypoRegproc, Row]
}
object PgRangeFields extends PgRangeStructure[PgRangeRow](None, identity, (_, x) => x)
