/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import adventureworks.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `person.businessentitycontact` which has not been persisted yet */
case class BusinessentitycontactRowUnsaved(
  /** Primary key. Foreign key to BusinessEntity.BusinessEntityID.
      Points to [[businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Foreign key to Person.BusinessEntityID.
      Points to [[person.PersonRow.businessentityid]] */
  personid: BusinessentityId,
  /** Primary key.  Foreign key to ContactType.ContactTypeID.
      Points to [[contacttype.ContacttypeRow.contacttypeid]] */
  contacttypeid: ContacttypeId,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): BusinessentitycontactRow =
    BusinessentitycontactRow(
      businessentityid = businessentityid,
      personid = personid,
      contacttypeid = contacttypeid,
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
object BusinessentitycontactRowUnsaved {
  implicit lazy val reads: Reads[BusinessentitycontactRowUnsaved] = Reads[BusinessentitycontactRowUnsaved](json => JsResult.fromTry(
      Try(
        BusinessentitycontactRowUnsaved(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          personid = json.\("personid").as(BusinessentityId.reads),
          contacttypeid = json.\("contacttypeid").as(ContacttypeId.reads),
          rowguid = json.\("rowguid").as(Defaulted.reads(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[BusinessentitycontactRowUnsaved] = OWrites[BusinessentitycontactRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "personid" -> BusinessentityId.writes.writes(o.personid),
      "contacttypeid" -> ContacttypeId.writes.writes(o.contacttypeid),
      "rowguid" -> Defaulted.writes(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}