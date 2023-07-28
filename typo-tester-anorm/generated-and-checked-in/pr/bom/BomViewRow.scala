/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package bom

import adventureworks.TypoLocalDateTime
import adventureworks.production.billofmaterials.BillofmaterialsId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class BomViewRow(
  id: Option[Int],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.billofmaterialsid]] */
  billofmaterialsid: Option[BillofmaterialsId],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.productassemblyid]] */
  productassemblyid: Option[ProductId],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.componentid]] */
  componentid: Option[ProductId],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.startdate]] */
  startdate: Option[TypoLocalDateTime],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.unitmeasurecode]] */
  unitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.bomlevel]] */
  bomlevel: Option[Int],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.perassemblyqty]] */
  perassemblyqty: Option[BigDecimal],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object BomViewRow {
  implicit val reads: Reads[BomViewRow] = Reads[BomViewRow](json => JsResult.fromTry(
      Try(
        BomViewRow(
          id = json.\("id").toOption.map(_.as[Int]),
          billofmaterialsid = json.\("billofmaterialsid").toOption.map(_.as[BillofmaterialsId]),
          productassemblyid = json.\("productassemblyid").toOption.map(_.as[ProductId]),
          componentid = json.\("componentid").toOption.map(_.as[ProductId]),
          startdate = json.\("startdate").toOption.map(_.as[TypoLocalDateTime]),
          enddate = json.\("enddate").toOption.map(_.as[TypoLocalDateTime]),
          unitmeasurecode = json.\("unitmeasurecode").toOption.map(_.as[UnitmeasureId]),
          bomlevel = json.\("bomlevel").toOption.map(_.as[Int]),
          perassemblyqty = json.\("perassemblyqty").toOption.map(_.as[BigDecimal]),
          modifieddate = json.\("modifieddate").toOption.map(_.as[TypoLocalDateTime])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BomViewRow] = RowParser[BomViewRow] { row =>
    Success(
      BomViewRow(
        id = row[Option[Int]](idx + 0),
        billofmaterialsid = row[Option[BillofmaterialsId]](idx + 1),
        productassemblyid = row[Option[ProductId]](idx + 2),
        componentid = row[Option[ProductId]](idx + 3),
        startdate = row[Option[TypoLocalDateTime]](idx + 4),
        enddate = row[Option[TypoLocalDateTime]](idx + 5),
        unitmeasurecode = row[Option[UnitmeasureId]](idx + 6),
        bomlevel = row[Option[Int]](idx + 7),
        perassemblyqty = row[Option[BigDecimal]](idx + 8),
        modifieddate = row[Option[TypoLocalDateTime]](idx + 9)
      )
    )
  }
  implicit val writes: OWrites[BomViewRow] = OWrites[BomViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Json.toJson(o.id),
      "billofmaterialsid" -> Json.toJson(o.billofmaterialsid),
      "productassemblyid" -> Json.toJson(o.productassemblyid),
      "componentid" -> Json.toJson(o.componentid),
      "startdate" -> Json.toJson(o.startdate),
      "enddate" -> Json.toJson(o.enddate),
      "unitmeasurecode" -> Json.toJson(o.unitmeasurecode),
      "bomlevel" -> Json.toJson(o.bomlevel),
      "perassemblyqty" -> Json.toJson(o.perassemblyqty),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
