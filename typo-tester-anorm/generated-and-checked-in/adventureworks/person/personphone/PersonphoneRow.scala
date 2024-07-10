/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.customtypes.Defaulted
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
 *Table: person.personphone
 *
 * Telephone number and type of a person.
 *
 * Composite primary key: businessentityid, phonenumber, phonenumbertypeid */
case class PersonphoneRow(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Telephone number identification number. */
  phonenumber: Phone,
  /** Kind of phone number. Foreign key to PhoneNumberType.PhoneNumberTypeID.
      Points to [[phonenumbertype.PhonenumbertypeRow.phonenumbertypeid]] */
  phonenumbertypeid: PhonenumbertypeId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: PersonphoneId = PersonphoneId(businessentityid, phonenumber, phonenumbertypeid)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): PersonphoneRowUnsaved =
     PersonphoneRowUnsaved(businessentityid, phonenumber, phonenumbertypeid, modifieddate)
 }

object PersonphoneRow {
  def apply(compositeId: PersonphoneId, modifieddate: TypoLocalDateTime) =
    new PersonphoneRow(compositeId.businessentityid, compositeId.phonenumber, compositeId.phonenumbertypeid, modifieddate)
  implicit lazy val reads: Reads[PersonphoneRow] = Reads[PersonphoneRow](json => JsResult.fromTry(
      Try(
        PersonphoneRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          phonenumber = json.\("phonenumber").as(Phone.reads),
          phonenumbertypeid = json.\("phonenumbertypeid").as(PhonenumbertypeId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PersonphoneRow] = RowParser[PersonphoneRow] { row =>
    Success(
      PersonphoneRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        phonenumber = row(idx + 1)(Phone.column),
        phonenumbertypeid = row(idx + 2)(PhonenumbertypeId.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[PersonphoneRow] = Text.instance[PersonphoneRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Phone.text.unsafeEncode(row.phonenumber, sb)
    sb.append(Text.DELIMETER)
    PhonenumbertypeId.text.unsafeEncode(row.phonenumbertypeid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[PersonphoneRow] = OWrites[PersonphoneRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "phonenumber" -> Phone.writes.writes(o.phonenumber),
      "phonenumbertypeid" -> PhonenumbertypeId.writes.writes(o.phonenumbertypeid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
