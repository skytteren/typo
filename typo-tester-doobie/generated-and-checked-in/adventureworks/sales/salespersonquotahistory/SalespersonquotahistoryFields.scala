/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait SalespersonquotahistoryFields[Row] {
  val businessentityid: IdField[BusinessentityId, Row]
  val quotadate: IdField[TypoLocalDateTime, Row]
  val salesquota: Field[BigDecimal, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SalespersonquotahistoryFields extends SalespersonquotahistoryStructure[SalespersonquotahistoryRow](None, identity, (_, x) => x)
