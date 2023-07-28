/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SalesorderheadersalesreasonRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. Foreign key to SalesReason.SalesReasonID.
      Points to [[salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  modifieddate: LocalDateTime
){
   val compositeId: SalesorderheadersalesreasonId = SalesorderheadersalesreasonId(salesorderid, salesreasonid)
 }

object SalesorderheadersalesreasonRow {
  def rowParser(idx: Int): RowParser[SalesorderheadersalesreasonRow] =
    RowParser[SalesorderheadersalesreasonRow] { row =>
      Success(
        SalesorderheadersalesreasonRow(
          salesorderid = row[SalesorderheaderId](idx + 0),
          salesreasonid = row[SalesreasonId](idx + 1),
          modifieddate = row[LocalDateTime](idx + 2)
        )
      )
    }
  implicit val oFormat: OFormat[SalesorderheadersalesreasonRow] = new OFormat[SalesorderheadersalesreasonRow]{
    override def writes(o: SalesorderheadersalesreasonRow): JsObject =
      Json.obj(
        "salesorderid" -> o.salesorderid,
        "salesreasonid" -> o.salesreasonid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalesorderheadersalesreasonRow] = {
      JsResult.fromTry(
        Try(
          SalesorderheadersalesreasonRow(
            salesorderid = json.\("salesorderid").as[SalesorderheaderId],
            salesreasonid = json.\("salesreasonid").as[SalesreasonId],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}