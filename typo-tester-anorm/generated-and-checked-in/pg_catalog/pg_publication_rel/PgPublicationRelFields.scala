/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_rel

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgPublicationRelFields[Row] {
  val oid: IdField[PgPublicationRelId, Row]
  val prpubid: Field[/* oid */ Long, Row]
  val prrelid: Field[/* oid */ Long, Row]
}
object PgPublicationRelFields extends PgPublicationRelStructure[PgPublicationRelRow](None, identity, (_, x) => x)
