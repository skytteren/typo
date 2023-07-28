/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sohsr

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

case class SohsrViewRow(
  /** Points to [[sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.salesorderid]] */
  salesorderid: Option[SalesorderheaderId],
  /** Points to [[sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.salesreasonid]] */
  salesreasonid: Option[SalesreasonId],
  /** Points to [[sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object SohsrViewRow {
  def rowParser(idx: Int): RowParser[SohsrViewRow] =
    RowParser[SohsrViewRow] { row =>
      Success(
        SohsrViewRow(
          salesorderid = row[Option[SalesorderheaderId]](idx + 0),
          salesreasonid = row[Option[SalesreasonId]](idx + 1),
          modifieddate = row[Option[LocalDateTime]](idx + 2)
        )
      )
    }
  implicit val oFormat: OFormat[SohsrViewRow] = new OFormat[SohsrViewRow]{
    override def writes(o: SohsrViewRow): JsObject =
      Json.obj(
        "salesorderid" -> o.salesorderid,
        "salesreasonid" -> o.salesreasonid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SohsrViewRow] = {
      JsResult.fromTry(
        Try(
          SohsrViewRow(
            salesorderid = json.\("salesorderid").toOption.map(_.as[SalesorderheaderId]),
            salesreasonid = json.\("salesreasonid").toOption.map(_.as[SalesreasonId]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}