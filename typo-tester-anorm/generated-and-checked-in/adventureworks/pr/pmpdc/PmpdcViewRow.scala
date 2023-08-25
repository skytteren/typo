/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmpdc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PmpdcViewRow(
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.productdescriptionid]] */
  productdescriptionid: Option[ProductdescriptionId],
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.cultureid]] */
  cultureid: Option[CultureId],
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PmpdcViewRow {
  implicit lazy val reads: Reads[PmpdcViewRow] = Reads[PmpdcViewRow](json => JsResult.fromTry(
      Try(
        PmpdcViewRow(
          productmodelid = json.\("productmodelid").toOption.map(_.as(ProductmodelId.reads)),
          productdescriptionid = json.\("productdescriptionid").toOption.map(_.as(ProductdescriptionId.reads)),
          cultureid = json.\("cultureid").toOption.map(_.as(CultureId.reads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PmpdcViewRow] = RowParser[PmpdcViewRow] { row =>
    Success(
      PmpdcViewRow(
        productmodelid = row(idx + 0)(Column.columnToOption(ProductmodelId.column)),
        productdescriptionid = row(idx + 1)(Column.columnToOption(ProductdescriptionId.column)),
        cultureid = row(idx + 2)(Column.columnToOption(CultureId.column)),
        modifieddate = row(idx + 3)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PmpdcViewRow] = OWrites[PmpdcViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> Writes.OptionWrites(ProductmodelId.writes).writes(o.productmodelid),
      "productdescriptionid" -> Writes.OptionWrites(ProductdescriptionId.writes).writes(o.productdescriptionid),
      "cultureid" -> Writes.OptionWrites(CultureId.writes).writes(o.cultureid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}