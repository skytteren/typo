/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sr

import adventureworks.public.Name
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

case class SrViewRow(
  id: Option[Int],
  /** Points to [[sales.salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: Option[SalesreasonId],
  /** Points to [[sales.salesreason.SalesreasonRow.name]] */
  name: Option[Name],
  /** Points to [[sales.salesreason.SalesreasonRow.reasontype]] */
  reasontype: Option[Name],
  /** Points to [[sales.salesreason.SalesreasonRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object SrViewRow {
  def rowParser(idx: Int): RowParser[SrViewRow] =
    RowParser[SrViewRow] { row =>
      Success(
        SrViewRow(
          id = row[Option[Int]](idx + 0),
          salesreasonid = row[Option[SalesreasonId]](idx + 1),
          name = row[Option[Name]](idx + 2),
          reasontype = row[Option[Name]](idx + 3),
          modifieddate = row[Option[LocalDateTime]](idx + 4)
        )
      )
    }
  implicit val oFormat: OFormat[SrViewRow] = new OFormat[SrViewRow]{
    override def writes(o: SrViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "salesreasonid" -> o.salesreasonid,
        "name" -> o.name,
        "reasontype" -> o.reasontype,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SrViewRow] = {
      JsResult.fromTry(
        Try(
          SrViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            salesreasonid = json.\("salesreasonid").toOption.map(_.as[SalesreasonId]),
            name = json.\("name").toOption.map(_.as[Name]),
            reasontype = json.\("reasontype").toOption.map(_.as[Name]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
