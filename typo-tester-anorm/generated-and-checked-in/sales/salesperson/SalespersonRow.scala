/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class SalespersonRow(
  /** Primary key for SalesPerson records. Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Territory currently assigned to. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Projected yearly sales. */
  salesquota: Option[BigDecimal],
  /** Bonus due if quota is met. */
  bonus: BigDecimal,
  /** Commision percent received per sale. */
  commissionpct: BigDecimal,
  /** Sales total year to date. */
  salesytd: BigDecimal,
  /** Sales total of previous year. */
  saleslastyear: BigDecimal,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object SalespersonRow {
  implicit val reads: Reads[SalespersonRow] = Reads[SalespersonRow](json => JsResult.fromTry(
      Try(
        SalespersonRow(
          businessentityid = json.\("businessentityid").as[BusinessentityId],
          territoryid = json.\("territoryid").toOption.map(_.as[SalesterritoryId]),
          salesquota = json.\("salesquota").toOption.map(_.as[BigDecimal]),
          bonus = json.\("bonus").as[BigDecimal],
          commissionpct = json.\("commissionpct").as[BigDecimal],
          salesytd = json.\("salesytd").as[BigDecimal],
          saleslastyear = json.\("saleslastyear").as[BigDecimal],
          rowguid = json.\("rowguid").as[UUID],
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalespersonRow] = RowParser[SalespersonRow] { row =>
    Success(
      SalespersonRow(
        businessentityid = row[BusinessentityId](idx + 0),
        territoryid = row[Option[SalesterritoryId]](idx + 1),
        salesquota = row[Option[BigDecimal]](idx + 2),
        bonus = row[BigDecimal](idx + 3),
        commissionpct = row[BigDecimal](idx + 4),
        salesytd = row[BigDecimal](idx + 5),
        saleslastyear = row[BigDecimal](idx + 6),
        rowguid = row[UUID](idx + 7),
        modifieddate = row[TypoLocalDateTime](idx + 8)
      )
    )
  }
  implicit val writes: OWrites[SalespersonRow] = OWrites[SalespersonRow](o =>
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
