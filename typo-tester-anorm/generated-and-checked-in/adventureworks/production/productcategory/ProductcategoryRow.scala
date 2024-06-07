/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Table: production.productcategory
    High-level product categorization.
    Primary key: productcategoryid */
case class ProductcategoryRow(
  /** Primary key for ProductCategory records.
      Default: nextval('production.productcategory_productcategoryid_seq'::regclass) */
  productcategoryid: ProductcategoryId,
  /** Category description. */
  name: Name,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = productcategoryid
   def toUnsavedRow(productcategoryid: Defaulted[ProductcategoryId], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductcategoryRowUnsaved =
     ProductcategoryRowUnsaved(name, productcategoryid, rowguid, modifieddate)
 }

object ProductcategoryRow {
  implicit lazy val reads: Reads[ProductcategoryRow] = Reads[ProductcategoryRow](json => JsResult.fromTry(
      Try(
        ProductcategoryRow(
          productcategoryid = json.\("productcategoryid").as(ProductcategoryId.reads),
          name = json.\("name").as(Name.reads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductcategoryRow] = RowParser[ProductcategoryRow] { row =>
    Success(
      ProductcategoryRow(
        productcategoryid = row(idx + 0)(ProductcategoryId.column),
        name = row(idx + 1)(Name.column),
        rowguid = row(idx + 2)(TypoUUID.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ProductcategoryRow] = Text.instance[ProductcategoryRow]{ (row, sb) =>
    ProductcategoryId.text.unsafeEncode(row.productcategoryid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductcategoryRow] = OWrites[ProductcategoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productcategoryid" -> ProductcategoryId.writes.writes(o.productcategoryid),
      "name" -> Name.writes.writes(o.name),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
