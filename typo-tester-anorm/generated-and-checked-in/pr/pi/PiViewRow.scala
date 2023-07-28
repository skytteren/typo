/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pi

import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PiViewRow(
  id: Option[Int],
  /** Points to [[production.productinventory.ProductinventoryRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productinventory.ProductinventoryRow.locationid]] */
  locationid: Option[LocationId],
  /** Points to [[production.productinventory.ProductinventoryRow.shelf]] */
  shelf: Option[/* max 10 chars */ String],
  /** Points to [[production.productinventory.ProductinventoryRow.bin]] */
  bin: Option[Int],
  /** Points to [[production.productinventory.ProductinventoryRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[production.productinventory.ProductinventoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productinventory.ProductinventoryRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PiViewRow {
  def rowParser(idx: Int): RowParser[PiViewRow] =
    RowParser[PiViewRow] { row =>
      Success(
        PiViewRow(
          id = row[Option[Int]](idx + 0),
          productid = row[Option[ProductId]](idx + 1),
          locationid = row[Option[LocationId]](idx + 2),
          shelf = row[Option[/* max 10 chars */ String]](idx + 3),
          bin = row[Option[Int]](idx + 4),
          quantity = row[Option[Int]](idx + 5),
          rowguid = row[Option[UUID]](idx + 6),
          modifieddate = row[Option[LocalDateTime]](idx + 7)
        )
      )
    }
  implicit val oFormat: OFormat[PiViewRow] = new OFormat[PiViewRow]{
    override def writes(o: PiViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productid" -> o.productid,
        "locationid" -> o.locationid,
        "shelf" -> o.shelf,
        "bin" -> o.bin,
        "quantity" -> o.quantity,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PiViewRow] = {
      JsResult.fromTry(
        Try(
          PiViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            locationid = json.\("locationid").toOption.map(_.as[LocationId]),
            shelf = json.\("shelf").toOption.map(_.as[/* max 10 chars */ String]),
            bin = json.\("bin").toOption.map(_.as[Int]),
            quantity = json.\("quantity").toOption.map(_.as[Int]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
