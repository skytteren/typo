/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package a

import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.stateprovince.StateprovinceId
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
 *View: pe.a */
case class AViewRow(
  /** Points to [[person.address.AddressRow.addressid]] */
  id: AddressId,
  /** Points to [[person.address.AddressRow.addressid]] */
  addressid: AddressId,
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: /* max 60 chars */ String,
  /** Points to [[person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.city]] */
  city: /* max 30 chars */ String,
  /** Points to [[person.address.AddressRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: /* max 15 chars */ String,
  /** Points to [[person.address.AddressRow.spatiallocation]] */
  spatiallocation: Option[TypoBytea],
  /** Points to [[person.address.AddressRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[person.address.AddressRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object AViewRow {
  implicit lazy val reads: Reads[AViewRow] = Reads[AViewRow](json => JsResult.fromTry(
      Try(
        AViewRow(
          id = json.\("id").as(AddressId.reads),
          addressid = json.\("addressid").as(AddressId.reads),
          addressline1 = json.\("addressline1").as(Reads.StringReads),
          addressline2 = json.\("addressline2").toOption.map(_.as(Reads.StringReads)),
          city = json.\("city").as(Reads.StringReads),
          stateprovinceid = json.\("stateprovinceid").as(StateprovinceId.reads),
          postalcode = json.\("postalcode").as(Reads.StringReads),
          spatiallocation = json.\("spatiallocation").toOption.map(_.as(TypoBytea.reads)),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[AViewRow] = RowParser[AViewRow] { row =>
    Success(
      AViewRow(
        id = row(idx + 0)(AddressId.column),
        addressid = row(idx + 1)(AddressId.column),
        addressline1 = row(idx + 2)(Column.columnToString),
        addressline2 = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        city = row(idx + 4)(Column.columnToString),
        stateprovinceid = row(idx + 5)(StateprovinceId.column),
        postalcode = row(idx + 6)(Column.columnToString),
        spatiallocation = row(idx + 7)(Column.columnToOption(TypoBytea.column)),
        rowguid = row(idx + 8)(TypoUUID.column),
        modifieddate = row(idx + 9)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[AViewRow] = OWrites[AViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> AddressId.writes.writes(o.id),
      "addressid" -> AddressId.writes.writes(o.addressid),
      "addressline1" -> Writes.StringWrites.writes(o.addressline1),
      "addressline2" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline2),
      "city" -> Writes.StringWrites.writes(o.city),
      "stateprovinceid" -> StateprovinceId.writes.writes(o.stateprovinceid),
      "postalcode" -> Writes.StringWrites.writes(o.postalcode),
      "spatiallocation" -> Writes.OptionWrites(TypoBytea.writes).writes(o.spatiallocation),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
