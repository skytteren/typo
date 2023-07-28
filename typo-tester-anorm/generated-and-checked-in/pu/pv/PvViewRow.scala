/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pv

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PvViewRow(
  id: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[purchasing.productvendor.ProductvendorRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[purchasing.productvendor.ProductvendorRow.averageleadtime]] */
  averageleadtime: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.standardprice]] */
  standardprice: Option[BigDecimal],
  /** Points to [[purchasing.productvendor.ProductvendorRow.lastreceiptcost]] */
  lastreceiptcost: Option[BigDecimal],
  /** Points to [[purchasing.productvendor.ProductvendorRow.lastreceiptdate]] */
  lastreceiptdate: Option[LocalDateTime],
  /** Points to [[purchasing.productvendor.ProductvendorRow.minorderqty]] */
  minorderqty: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.maxorderqty]] */
  maxorderqty: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.onorderqty]] */
  onorderqty: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.unitmeasurecode]] */
  unitmeasurecode: Option[UnitmeasureId],
  /** Points to [[purchasing.productvendor.ProductvendorRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PvViewRow {
  def rowParser(idx: Int): RowParser[PvViewRow] =
    RowParser[PvViewRow] { row =>
      Success(
        PvViewRow(
          id = row[Option[Int]](idx + 0),
          productid = row[Option[ProductId]](idx + 1),
          businessentityid = row[Option[BusinessentityId]](idx + 2),
          averageleadtime = row[Option[Int]](idx + 3),
          standardprice = row[Option[BigDecimal]](idx + 4),
          lastreceiptcost = row[Option[BigDecimal]](idx + 5),
          lastreceiptdate = row[Option[LocalDateTime]](idx + 6),
          minorderqty = row[Option[Int]](idx + 7),
          maxorderqty = row[Option[Int]](idx + 8),
          onorderqty = row[Option[Int]](idx + 9),
          unitmeasurecode = row[Option[UnitmeasureId]](idx + 10),
          modifieddate = row[Option[LocalDateTime]](idx + 11)
        )
      )
    }
  implicit val oFormat: OFormat[PvViewRow] = new OFormat[PvViewRow]{
    override def writes(o: PvViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productid" -> o.productid,
        "businessentityid" -> o.businessentityid,
        "averageleadtime" -> o.averageleadtime,
        "standardprice" -> o.standardprice,
        "lastreceiptcost" -> o.lastreceiptcost,
        "lastreceiptdate" -> o.lastreceiptdate,
        "minorderqty" -> o.minorderqty,
        "maxorderqty" -> o.maxorderqty,
        "onorderqty" -> o.onorderqty,
        "unitmeasurecode" -> o.unitmeasurecode,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PvViewRow] = {
      JsResult.fromTry(
        Try(
          PvViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            averageleadtime = json.\("averageleadtime").toOption.map(_.as[Int]),
            standardprice = json.\("standardprice").toOption.map(_.as[BigDecimal]),
            lastreceiptcost = json.\("lastreceiptcost").toOption.map(_.as[BigDecimal]),
            lastreceiptdate = json.\("lastreceiptdate").toOption.map(_.as[LocalDateTime]),
            minorderqty = json.\("minorderqty").toOption.map(_.as[Int]),
            maxorderqty = json.\("maxorderqty").toOption.map(_.as[Int]),
            onorderqty = json.\("onorderqty").toOption.map(_.as[Int]),
            unitmeasurecode = json.\("unitmeasurecode").toOption.map(_.as[UnitmeasureId]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
