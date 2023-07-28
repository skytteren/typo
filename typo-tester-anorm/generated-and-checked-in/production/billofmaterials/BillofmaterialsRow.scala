/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.TypoLocalDateTime
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

case class BillofmaterialsRow(
  /** Primary key for BillOfMaterials records. */
  billofmaterialsid: BillofmaterialsId,
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  componentid: ProductId,
  /** Date the component started being used in the assembly item. */
  startdate: TypoLocalDateTime,
  /** Date the component stopped being used in the assembly item. */
  enddate: Option[TypoLocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID). */
  bomlevel: Int,
  /** Quantity of the component needed to create the assembly. */
  perassemblyqty: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object BillofmaterialsRow {
  implicit val reads: Reads[BillofmaterialsRow] = Reads[BillofmaterialsRow](json => JsResult.fromTry(
      Try(
        BillofmaterialsRow(
          billofmaterialsid = json.\("billofmaterialsid").as[BillofmaterialsId],
          productassemblyid = json.\("productassemblyid").toOption.map(_.as[ProductId]),
          componentid = json.\("componentid").as[ProductId],
          startdate = json.\("startdate").as[TypoLocalDateTime],
          enddate = json.\("enddate").toOption.map(_.as[TypoLocalDateTime]),
          unitmeasurecode = json.\("unitmeasurecode").as[UnitmeasureId],
          bomlevel = json.\("bomlevel").as[Int],
          perassemblyqty = json.\("perassemblyqty").as[BigDecimal],
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BillofmaterialsRow] = RowParser[BillofmaterialsRow] { row =>
    Success(
      BillofmaterialsRow(
        billofmaterialsid = row[BillofmaterialsId](idx + 0),
        productassemblyid = row[Option[ProductId]](idx + 1),
        componentid = row[ProductId](idx + 2),
        startdate = row[TypoLocalDateTime](idx + 3),
        enddate = row[Option[TypoLocalDateTime]](idx + 4),
        unitmeasurecode = row[UnitmeasureId](idx + 5),
        bomlevel = row[Int](idx + 6),
        perassemblyqty = row[BigDecimal](idx + 7),
        modifieddate = row[TypoLocalDateTime](idx + 8)
      )
    )
  }
  implicit val writes: OWrites[BillofmaterialsRow] = OWrites[BillofmaterialsRow](o =>
    new JsObject(ListMap[String, JsValue](
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
