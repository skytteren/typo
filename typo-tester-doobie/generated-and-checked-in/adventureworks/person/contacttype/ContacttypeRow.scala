/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: person.contacttype
    Lookup table containing the types of business entity contacts.
    Primary key: contacttypeid */
case class ContacttypeRow(
  /** Primary key for ContactType records.
      Default: nextval('person.contacttype_contacttypeid_seq'::regclass) */
  contacttypeid: ContacttypeId,
  /** Contact type description. */
  name: Name,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = contacttypeid
   def toUnsavedRow(contacttypeid: Defaulted[ContacttypeId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ContacttypeRowUnsaved =
     ContacttypeRowUnsaved(name, contacttypeid, modifieddate)
 }

object ContacttypeRow {
  implicit lazy val decoder: Decoder[ContacttypeRow] = Decoder.forProduct3[ContacttypeRow, ContacttypeId, Name, TypoLocalDateTime]("contacttypeid", "name", "modifieddate")(ContacttypeRow.apply)(ContacttypeId.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ContacttypeRow] = Encoder.forProduct3[ContacttypeRow, ContacttypeId, Name, TypoLocalDateTime]("contacttypeid", "name", "modifieddate")(x => (x.contacttypeid, x.name, x.modifieddate))(ContacttypeId.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ContacttypeRow] = new Read[ContacttypeRow](
    gets = List(
      (ContacttypeId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ContacttypeRow(
      contacttypeid = ContacttypeId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
  implicit lazy val text: Text[ContacttypeRow] = Text.instance[ContacttypeRow]{ (row, sb) =>
    ContacttypeId.text.unsafeEncode(row.contacttypeid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val write: Write[ContacttypeRow] = new Write[ContacttypeRow](
    puts = List((ContacttypeId.put, Nullability.NoNulls),
                (Name.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.contacttypeid, x.name, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  ContacttypeId.put.unsafeSetNonNullable(rs, i + 0, a.contacttypeid)
                  Name.put.unsafeSetNonNullable(rs, i + 1, a.name)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 2, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     ContacttypeId.put.unsafeUpdateNonNullable(ps, i + 0, a.contacttypeid)
                     Name.put.unsafeUpdateNonNullable(ps, i + 1, a.name)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 2, a.modifieddate)
                   }
  )
}
