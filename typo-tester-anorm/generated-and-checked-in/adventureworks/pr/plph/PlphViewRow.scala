/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
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

case class PlphViewRow(
  id: Option[Int],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.startdate]] */
  startdate: Option[TypoLocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.listprice]] */
  listprice: Option[BigDecimal],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PlphViewRow {
  implicit lazy val reads: Reads[PlphViewRow] = Reads[PlphViewRow](json => JsResult.fromTry(
      Try(
        PlphViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          productid = json.\("productid").toOption.map(_.as(ProductId.reads)),
          startdate = json.\("startdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          listprice = json.\("listprice").toOption.map(_.as(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PlphViewRow] = RowParser[PlphViewRow] { row =>
    Success(
      PlphViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        productid = row(idx + 1)(Column.columnToOption(ProductId.column)),
        startdate = row(idx + 2)(Column.columnToOption(TypoLocalDateTime.column)),
        enddate = row(idx + 3)(Column.columnToOption(TypoLocalDateTime.column)),
        listprice = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        modifieddate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PlphViewRow] = OWrites[PlphViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "productid" -> Writes.OptionWrites(ProductId.writes).writes(o.productid),
      "startdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "listprice" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.listprice),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}