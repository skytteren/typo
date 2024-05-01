/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.Text
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

/** Table: sales.specialoffer
    Sale discounts lookup table.
    Primary key: specialofferid */
case class SpecialofferRow(
  /** Primary key for SpecialOffer records.
      Default: nextval('sales.specialoffer_specialofferid_seq'::regclass) */
  specialofferid: SpecialofferId,
  /** Discount description. */
  description: /* max 255 chars */ String,
  /** Discount precentage.
      Default: 0.00
      Constraint CK_SpecialOffer_DiscountPct affecting columns discountpct: ((discountpct >= 0.00)) */
  discountpct: BigDecimal,
  /** Discount type category. */
  `type`: /* max 50 chars */ String,
  /** Group the discount applies to such as Reseller or Customer. */
  category: /* max 50 chars */ String,
  /** Discount start date.
      Constraint CK_SpecialOffer_EndDate affecting columns enddate, startdate: ((enddate >= startdate)) */
  startdate: TypoLocalDateTime,
  /** Discount end date.
      Constraint CK_SpecialOffer_EndDate affecting columns enddate, startdate: ((enddate >= startdate)) */
  enddate: TypoLocalDateTime,
  /** Minimum discount percent allowed.
      Default: 0
      Constraint CK_SpecialOffer_MinQty affecting columns minqty: ((minqty >= 0)) */
  minqty: Int,
  /** Maximum discount percent allowed.
      Constraint CK_SpecialOffer_MaxQty affecting columns maxqty: ((maxqty >= 0)) */
  maxqty: Option[Int],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(specialofferid: Defaulted[SpecialofferId], discountpct: Defaulted[BigDecimal] = Defaulted.Provided(this.discountpct), minqty: Defaulted[Int] = Defaulted.Provided(this.minqty), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SpecialofferRowUnsaved =
     SpecialofferRowUnsaved(description, `type`, category, startdate, enddate, maxqty, specialofferid, discountpct, minqty, rowguid, modifieddate)
 }

object SpecialofferRow {
  implicit lazy val reads: Reads[SpecialofferRow] = Reads[SpecialofferRow](json => JsResult.fromTry(
      Try(
        SpecialofferRow(
          specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
          description = json.\("description").as(Reads.StringReads),
          discountpct = json.\("discountpct").as(Reads.bigDecReads),
          `type` = json.\("type").as(Reads.StringReads),
          category = json.\("category").as(Reads.StringReads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").as(TypoLocalDateTime.reads),
          minqty = json.\("minqty").as(Reads.IntReads),
          maxqty = json.\("maxqty").toOption.map(_.as(Reads.IntReads)),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SpecialofferRow] = RowParser[SpecialofferRow] { row =>
    Success(
      SpecialofferRow(
        specialofferid = row(idx + 0)(SpecialofferId.column),
        description = row(idx + 1)(Column.columnToString),
        discountpct = row(idx + 2)(Column.columnToScalaBigDecimal),
        `type` = row(idx + 3)(Column.columnToString),
        category = row(idx + 4)(Column.columnToString),
        startdate = row(idx + 5)(TypoLocalDateTime.column),
        enddate = row(idx + 6)(TypoLocalDateTime.column),
        minqty = row(idx + 7)(Column.columnToInt),
        maxqty = row(idx + 8)(Column.columnToOption(Column.columnToInt)),
        rowguid = row(idx + 9)(TypoUUID.column),
        modifieddate = row(idx + 10)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[SpecialofferRow] = Text.instance[SpecialofferRow]{ (row, sb) =>
    SpecialofferId.text.unsafeEncode(row.specialofferid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.description, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.discountpct, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.`type`, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.category, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.minqty, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.intInstance).unsafeEncode(row.maxqty, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[SpecialofferRow] = OWrites[SpecialofferRow](o =>
    new JsObject(ListMap[String, JsValue](
      "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
      "description" -> Writes.StringWrites.writes(o.description),
      "discountpct" -> Writes.BigDecimalWrites.writes(o.discountpct),
      "type" -> Writes.StringWrites.writes(o.`type`),
      "category" -> Writes.StringWrites.writes(o.category),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> TypoLocalDateTime.writes.writes(o.enddate),
      "minqty" -> Writes.IntWrites.writes(o.minqty),
      "maxqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.maxqty),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
