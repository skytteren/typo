/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.customtypes.Defaulted
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

/**
 *Table: production.productlistpricehistory
 *
 * Changes in the list price of a product over time.
 *
 * Composite primary key: productid, startdate */
case class ProductlistpricehistoryRow(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** List price start date.
      Constraint CK_ProductListPriceHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** List price end date
      Constraint CK_ProductListPriceHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Product list price.
      Constraint CK_ProductListPriceHistory_ListPrice affecting columns listprice: ((listprice > 0.00)) */
  listprice: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductlistpricehistoryId = ProductlistpricehistoryId(productid, startdate)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductlistpricehistoryRowUnsaved =
     ProductlistpricehistoryRowUnsaved(productid, startdate, enddate, listprice, modifieddate)
 }

object ProductlistpricehistoryRow {
  def apply(compositeId: ProductlistpricehistoryId, enddate: Option[TypoLocalDateTime], listprice: BigDecimal, modifieddate: TypoLocalDateTime) =
    new ProductlistpricehistoryRow(compositeId.productid, compositeId.startdate, enddate, listprice, modifieddate)
  implicit lazy val reads: Reads[ProductlistpricehistoryRow] = Reads[ProductlistpricehistoryRow](json => JsResult.fromTry(
      Try(
        ProductlistpricehistoryRow(
          productid = json.\("productid").as(ProductId.reads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          listprice = json.\("listprice").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductlistpricehistoryRow] = RowParser[ProductlistpricehistoryRow] { row =>
    Success(
      ProductlistpricehistoryRow(
        productid = row(idx + 0)(ProductId.column),
        startdate = row(idx + 1)(TypoLocalDateTime.column),
        enddate = row(idx + 2)(Column.columnToOption(TypoLocalDateTime.column)),
        listprice = row(idx + 3)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ProductlistpricehistoryRow] = Text.instance[ProductlistpricehistoryRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.listprice, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductlistpricehistoryRow] = OWrites[ProductlistpricehistoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "listprice" -> Writes.BigDecimalWrites.writes(o.listprice),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
