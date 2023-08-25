/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.specialofferproduct` which has not been persisted yet */
case class SpecialofferproductRowUnsaved(
  /** Primary key for SpecialOfferProduct records.
      Points to [[specialoffer.SpecialofferRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): SpecialofferproductRow =
    SpecialofferproductRow(
      specialofferid = specialofferid,
      productid = productid,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SpecialofferproductRowUnsaved {
  implicit lazy val reads: Reads[SpecialofferproductRowUnsaved] = Reads[SpecialofferproductRowUnsaved](json => JsResult.fromTry(
      Try(
        SpecialofferproductRowUnsaved(
          specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
          productid = json.\("productid").as(ProductId.reads),
          rowguid = json.\("rowguid").as(Defaulted.reads(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[SpecialofferproductRowUnsaved] = OWrites[SpecialofferproductRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
      "productid" -> ProductId.writes.writes(o.productid),
      "rowguid" -> Defaulted.writes(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}