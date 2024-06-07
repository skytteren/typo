/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

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
   val id = compositeId
   def toUnsavedRow(emailaddressid: Defaulted[Int], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): EmailaddressRowUnsaved =
     EmailaddressRowUnsaved(businessentityid, emailaddress, emailaddressid, rowguid, modifieddate)
 }

object EmailaddressRow {
  def apply(compositeId: EmailaddressId, emailaddress: Option[/* max 50 chars */ String], rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new EmailaddressRow(compositeId.businessentityid, compositeId.emailaddressid, emailaddress, rowguid, modifieddate)
  implicit lazy val decoder: Decoder[EmailaddressRow] = Decoder.forProduct5[EmailaddressRow, BusinessentityId, Int, Option[/* max 50 chars */ String], TypoUUID, TypoLocalDateTime]("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")(EmailaddressRow.apply)(BusinessentityId.decoder, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[EmailaddressRow] = Encoder.forProduct5[EmailaddressRow, BusinessentityId, Int, Option[/* max 50 chars */ String], TypoUUID, TypoLocalDateTime]("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")(x => (x.businessentityid, x.emailaddressid, x.emailaddress, x.rowguid, x.modifieddate))(BusinessentityId.encoder, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[EmailaddressRow] = new Read[EmailaddressRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => EmailaddressRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      emailaddressid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
      emailaddress = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
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
}
