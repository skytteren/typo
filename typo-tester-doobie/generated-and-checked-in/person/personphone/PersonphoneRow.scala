/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PersonphoneRow(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Telephone number identification number. */
  phonenumber: Phone,
  /** Kind of phone number. Foreign key to PhoneNumberType.PhoneNumberTypeID.
      Points to [[phonenumbertype.PhonenumbertypeRow.phonenumbertypeid]] */
  phonenumbertypeid: PhonenumbertypeId,
  modifieddate: TypoLocalDateTime
){
   val compositeId: PersonphoneId = PersonphoneId(businessentityid, phonenumber, phonenumbertypeid)
 }

object PersonphoneRow {
  implicit val decoder: Decoder[PersonphoneRow] = Decoder.forProduct4[PersonphoneRow, BusinessentityId, Phone, PhonenumbertypeId, TypoLocalDateTime]("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")(PersonphoneRow.apply)
  implicit val encoder: Encoder[PersonphoneRow] = Encoder.forProduct4[PersonphoneRow, BusinessentityId, Phone, PhonenumbertypeId, TypoLocalDateTime]("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")(x => (x.businessentityid, x.phonenumber, x.phonenumbertypeid, x.modifieddate))
  implicit val read: Read[PersonphoneRow] = new Read[PersonphoneRow](
    gets = List(
      (Get[BusinessentityId], Nullability.NoNulls),
      (Get[Phone], Nullability.NoNulls),
      (Get[PhonenumbertypeId], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PersonphoneRow(
      businessentityid = Get[BusinessentityId].unsafeGetNonNullable(rs, i + 0),
      phonenumber = Get[Phone].unsafeGetNonNullable(rs, i + 1),
      phonenumbertypeid = Get[PhonenumbertypeId].unsafeGetNonNullable(rs, i + 2),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 3)
    )
  )
}
