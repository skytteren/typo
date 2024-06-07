/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
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

/** Table: production.productdescription
    Product descriptions in several languages.
    Primary key: productdescriptionid */
case class ProductdescriptionRow(
  /** Primary key for ProductDescription records.
      Default: nextval('production.productdescription_productdescriptionid_seq'::regclass) */
  productdescriptionid: ProductdescriptionId,
  /** Description of the product. */
  description: /* max 400 chars */ String,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = productdescriptionid
   def toUnsavedRow(productdescriptionid: Defaulted[ProductdescriptionId], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductdescriptionRowUnsaved =
     ProductdescriptionRowUnsaved(description, productdescriptionid, rowguid, modifieddate)
 }

object ProductdescriptionRow {
  implicit lazy val reads: Reads[ProductdescriptionRow] = Reads[ProductdescriptionRow](json => JsResult.fromTry(
      Try(
        ProductdescriptionRow(
          productdescriptionid = json.\("productdescriptionid").as(ProductdescriptionId.reads),
          description = json.\("description").as(Reads.StringReads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductdescriptionRow] = RowParser[ProductdescriptionRow] { row =>
    Success(
      ProductdescriptionRow(
        productdescriptionid = row(idx + 0)(ProductdescriptionId.column),
        description = row(idx + 1)(Column.columnToString),
        rowguid = row(idx + 2)(TypoUUID.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ProductdescriptionRow] = Text.instance[ProductdescriptionRow]{ (row, sb) =>
    ProductdescriptionId.text.unsafeEncode(row.productdescriptionid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.description, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductdescriptionRow] = OWrites[ProductdescriptionRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productdescriptionid" -> ProductdescriptionId.writes.writes(o.productdescriptionid),
      "description" -> Writes.StringWrites.writes(o.description),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
