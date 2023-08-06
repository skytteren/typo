/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_statements

import adventureworks.TypoOffsetDateTime
import adventureworks.TypoRegtype
import typo.dsl.SqlExpr.OptField

trait PgPreparedStatementsViewFields[Row] {
  val name: OptField[String, Row]
  val statement: OptField[String, Row]
  val prepareTime: OptField[TypoOffsetDateTime, Row]
  val parameterTypes: OptField[Array[TypoRegtype], Row]
  val fromSql: OptField[Boolean, Row]
  val genericPlans: OptField[Long, Row]
  val customPlans: OptField[Long, Row]
}
object PgPreparedStatementsViewFields extends PgPreparedStatementsViewStructure[PgPreparedStatementsViewRow](None, identity, (_, x) => x)
