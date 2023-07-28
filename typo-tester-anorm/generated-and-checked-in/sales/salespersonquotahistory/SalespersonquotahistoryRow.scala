/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
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

case class SalespersonquotahistoryRow(
  /** Sales person identification number. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Sales quota date. */
  quotadate: TypoLocalDateTime,
  /** Sales quota amount. */
  salesquota: BigDecimal,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalespersonquotahistoryId = SalespersonquotahistoryId(businessentityid, quotadate)
 }

object SalespersonquotahistoryRow {
  implicit val reads: Reads[SalespersonquotahistoryRow] = Reads[SalespersonquotahistoryRow](json => JsResult.fromTry(
      Try(
        SalespersonquotahistoryRow(
          businessentityid = json.\("businessentityid").as[BusinessentityId],
          quotadate = json.\("quotadate").as[TypoLocalDateTime],
          salesquota = json.\("salesquota").as[BigDecimal],
          rowguid = json.\("rowguid").as[UUID],
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalespersonquotahistoryRow] = RowParser[SalespersonquotahistoryRow] { row =>
    Success(
      SalespersonquotahistoryRow(
        businessentityid = row[BusinessentityId](idx + 0),
        quotadate = row[TypoLocalDateTime](idx + 1),
        salesquota = row[BigDecimal](idx + 2),
        rowguid = row[UUID](idx + 3),
        modifieddate = row[TypoLocalDateTime](idx + 4)
      )
    )
  }
  implicit val writes: OWrites[SalespersonquotahistoryRow] = OWrites[SalespersonquotahistoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Json.toJson(o.businessentityid),
      "quotadate" -> Json.toJson(o.quotadate),
      "salesquota" -> Json.toJson(o.salesquota),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
