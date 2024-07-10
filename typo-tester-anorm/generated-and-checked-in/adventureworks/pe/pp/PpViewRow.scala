/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/**
 *View: pe.pp */
case class PpViewRow(
  /** Points to [[person.personphone.PersonphoneRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[person.personphone.PersonphoneRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Phone,
  /** Points to [[person.personphone.PersonphoneRow.phonenumbertypeid]] */
  phonenumbertypeid: PhonenumbertypeId,
  /** Points to [[person.personphone.PersonphoneRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PpViewRow {
  implicit lazy val reads: Reads[PpViewRow] = Reads[PpViewRow](json => JsResult.fromTry(
      Try(
        PpViewRow(
          id = json.\("id").as(BusinessentityId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          phonenumber = json.\("phonenumber").as(Phone.reads),
          phonenumbertypeid = json.\("phonenumbertypeid").as(PhonenumbertypeId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PpViewRow] = RowParser[PpViewRow] { row =>
    Success(
      PpViewRow(
        id = row(idx + 0)(BusinessentityId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        phonenumber = row(idx + 2)(Phone.column),
        phonenumbertypeid = row(idx + 3)(PhonenumbertypeId.column),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PpViewRow] = OWrites[PpViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> BusinessentityId.writes.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "phonenumber" -> Phone.writes.writes(o.phonenumber),
      "phonenumbertypeid" -> PhonenumbertypeId.writes.writes(o.phonenumbertypeid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
