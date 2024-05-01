/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
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

/** Table: person.emailaddress
    Where to send a person email.
    Composite primary key: businessentityid, emailaddressid */
case class EmailaddressRow(
  /** Primary key. Person associated with this email address.  Foreign key to Person.BusinessEntityID
      Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. ID of this email address.
      Default: nextval('person.emailaddress_emailaddressid_seq'::regclass) */
  emailaddressid: Int,
  /** E-mail address for the person. */
  emailaddress: Option[/* max 50 chars */ String],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: EmailaddressId = EmailaddressId(businessentityid, emailaddressid)
   def toUnsavedRow(emailaddressid: Defaulted[Int], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): EmailaddressRowUnsaved =
     EmailaddressRowUnsaved(businessentityid, emailaddress, emailaddressid, rowguid, modifieddate)
 }

object EmailaddressRow {
  def apply(compositeId: EmailaddressId, emailaddress: Option[/* max 50 chars */ String], rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new EmailaddressRow(compositeId.businessentityid, compositeId.emailaddressid, emailaddress, rowguid, modifieddate)
  implicit lazy val reads: Reads[EmailaddressRow] = Reads[EmailaddressRow](json => JsResult.fromTry(
      Try(
        EmailaddressRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          emailaddressid = json.\("emailaddressid").as(Reads.IntReads),
          emailaddress = json.\("emailaddress").toOption.map(_.as(Reads.StringReads)),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EmailaddressRow] = RowParser[EmailaddressRow] { row =>
    Success(
      EmailaddressRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        emailaddressid = row(idx + 1)(Column.columnToInt),
        emailaddress = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        rowguid = row(idx + 3)(TypoUUID.column),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[EmailaddressRow] = Text.instance[EmailaddressRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.emailaddressid, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.emailaddress, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[EmailaddressRow] = OWrites[EmailaddressRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "emailaddressid" -> Writes.IntWrites.writes(o.emailaddressid),
      "emailaddress" -> Writes.OptionWrites(Writes.StringWrites).writes(o.emailaddress),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
