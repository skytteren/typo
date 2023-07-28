/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.salesperson` which has not been persisted yet */
case class SalespersonRowUnsaved(
  /** Primary key for SalesPerson records. Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Territory currently assigned to. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Projected yearly sales. */
  salesquota: Option[BigDecimal],
  /** Default: 0.00
      Bonus due if quota is met. */
  bonus: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Commision percent received per sale. */
  commissionpct: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Sales total year to date. */
  salesytd: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Sales total of previous year. */
  saleslastyear: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(bonusDefault: => BigDecimal, commissionpctDefault: => BigDecimal, salesytdDefault: => BigDecimal, saleslastyearDefault: => BigDecimal, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): SalespersonRow =
    SalespersonRow(
      businessentityid = businessentityid,
      territoryid = territoryid,
      salesquota = salesquota,
      bonus = bonus match {
                case Defaulted.UseDefault => bonusDefault
                case Defaulted.Provided(value) => value
              },
      commissionpct = commissionpct match {
                        case Defaulted.UseDefault => commissionpctDefault
                        case Defaulted.Provided(value) => value
                      },
      salesytd = salesytd match {
                   case Defaulted.UseDefault => salesytdDefault
                   case Defaulted.Provided(value) => value
                 },
      saleslastyear = saleslastyear match {
                        case Defaulted.UseDefault => saleslastyearDefault
                        case Defaulted.Provided(value) => value
                      },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalespersonRowUnsaved {
  implicit val reads: Reads[SalespersonRowUnsaved] = Reads[SalespersonRowUnsaved](json => JsResult.fromTry(
      Try(
        SalespersonRowUnsaved(
          businessentityid = json.\("businessentityid").as[BusinessentityId],
          territoryid = json.\("territoryid").toOption.map(_.as[SalesterritoryId]),
          salesquota = json.\("salesquota").toOption.map(_.as[BigDecimal]),
          bonus = json.\("bonus").as[Defaulted[BigDecimal]],
          commissionpct = json.\("commissionpct").as[Defaulted[BigDecimal]],
          salesytd = json.\("salesytd").as[Defaulted[BigDecimal]],
          saleslastyear = json.\("saleslastyear").as[Defaulted[BigDecimal]],
          rowguid = json.\("rowguid").as[Defaulted[UUID]],
          modifieddate = json.\("modifieddate").as[Defaulted[TypoLocalDateTime]]
        )
      )
    ),
  )
  implicit val writes: OWrites[SalespersonRowUnsaved] = OWrites[SalespersonRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Json.toJson(o.businessentityid),
      "territoryid" -> Json.toJson(o.territoryid),
      "salesquota" -> Json.toJson(o.salesquota),
      "bonus" -> Json.toJson(o.bonus),
      "commissionpct" -> Json.toJson(o.commissionpct),
      "salesytd" -> Json.toJson(o.salesytd),
      "saleslastyear" -> Json.toJson(o.saleslastyear),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
