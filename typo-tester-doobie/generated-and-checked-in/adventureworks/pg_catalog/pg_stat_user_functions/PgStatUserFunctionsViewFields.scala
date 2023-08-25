/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_functions

import typo.dsl.SqlExpr.OptField

trait PgStatUserFunctionsViewFields[Row] {
  val funcid: OptField[/* oid */ Long, Row]
  val schemaname: OptField[String, Row]
  val funcname: OptField[String, Row]
  val calls: OptField[Long, Row]
  val totalTime: OptField[Double, Row]
  val selfTime: OptField[Double, Row]
}
object PgStatUserFunctionsViewFields extends PgStatUserFunctionsViewStructure[PgStatUserFunctionsViewRow](None, identity, (_, x) => x)
