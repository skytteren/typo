/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait SalestaxrateFields[Row] {
  val salestaxrateid: IdField[SalestaxrateId, Row]
  val stateprovinceid: Field[StateprovinceId, Row]
  val taxtype: Field[TypoShort, Row]
  val taxrate: Field[BigDecimal, Row]
  val name: Field[Name, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SalestaxrateFields extends SalestaxrateStructure[SalestaxrateRow](None, identity, (_, x) => x)
