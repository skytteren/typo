/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

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

/** Table: person.password
    One way hashed authentication information
    Primary key: businessentityid */
case class PasswordRow(
  /** Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Password for the e-mail account. */
  passwordhash: /* max 128 chars */ String,
  /** Random value concatenated with the password string before the password is hashed. */
  passwordsalt: /* max 10 chars */ String,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): PasswordRowUnsaved =
     PasswordRowUnsaved(businessentityid, passwordhash, passwordsalt, rowguid, modifieddate)
 }

object PasswordRow {
  implicit lazy val decoder: Decoder[PasswordRow] = Decoder.forProduct5[PasswordRow, BusinessentityId, /* max 128 chars */ String, /* max 10 chars */ String, TypoUUID, TypoLocalDateTime]("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")(PasswordRow.apply)(BusinessentityId.decoder, Decoder.decodeString, Decoder.decodeString, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PasswordRow] = Encoder.forProduct5[PasswordRow, BusinessentityId, /* max 128 chars */ String, /* max 10 chars */ String, TypoUUID, TypoLocalDateTime]("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")(x => (x.businessentityid, x.passwordhash, x.passwordsalt, x.rowguid, x.modifieddate))(BusinessentityId.encoder, Encoder.encodeString, Encoder.encodeString, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PasswordRow] = new Read[PasswordRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PasswordRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      passwordhash = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      passwordsalt = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
  implicit lazy val text: Text[PasswordRow] = Text.instance[PasswordRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.passwordhash, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.passwordsalt, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
