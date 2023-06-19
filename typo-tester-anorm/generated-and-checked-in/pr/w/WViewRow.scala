/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package w

import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.production.workorder.WorkorderId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class WViewRow(
  id: Option[Int],
  /** Points to [[production.workorder.WorkorderRow.workorderid]] */
  workorderid: Option[WorkorderId],
  /** Points to [[production.workorder.WorkorderRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.workorder.WorkorderRow.orderqty]] */
  orderqty: Option[Int],
  /** Points to [[production.workorder.WorkorderRow.scrappedqty]] */
  scrappedqty: Option[Int],
  /** Points to [[production.workorder.WorkorderRow.startdate]] */
  startdate: Option[LocalDateTime],
  /** Points to [[production.workorder.WorkorderRow.enddate]] */
  enddate: Option[LocalDateTime],
  /** Points to [[production.workorder.WorkorderRow.duedate]] */
  duedate: Option[LocalDateTime],
  /** Points to [[production.workorder.WorkorderRow.scrapreasonid]] */
  scrapreasonid: Option[ScrapreasonId],
  /** Points to [[production.workorder.WorkorderRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object WViewRow {
  val rowParser: RowParser[WViewRow] =
    RowParser[WViewRow] { row =>
      Success(
        WViewRow(
          id = row[Option[Int]]("id"),
          workorderid = row[Option[WorkorderId]]("workorderid"),
          productid = row[Option[ProductId]]("productid"),
          orderqty = row[Option[Int]]("orderqty"),
          scrappedqty = row[Option[Int]]("scrappedqty"),
          startdate = row[Option[LocalDateTime]]("startdate"),
          enddate = row[Option[LocalDateTime]]("enddate"),
          duedate = row[Option[LocalDateTime]]("duedate"),
          scrapreasonid = row[Option[ScrapreasonId]]("scrapreasonid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[WViewRow] = new OFormat[WViewRow]{
    override def writes(o: WViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "workorderid" -> o.workorderid,
        "productid" -> o.productid,
        "orderqty" -> o.orderqty,
        "scrappedqty" -> o.scrappedqty,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "duedate" -> o.duedate,
        "scrapreasonid" -> o.scrapreasonid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[WViewRow] = {
      JsResult.fromTry(
        Try(
          WViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            workorderid = json.\("workorderid").toOption.map(_.as[WorkorderId]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            orderqty = json.\("orderqty").toOption.map(_.as[Int]),
            scrappedqty = json.\("scrappedqty").toOption.map(_.as[Int]),
            startdate = json.\("startdate").toOption.map(_.as[LocalDateTime]),
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            duedate = json.\("duedate").toOption.map(_.as[LocalDateTime]),
            scrapreasonid = json.\("scrapreasonid").toOption.map(_.as[ScrapreasonId]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
