/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: person.address
    Street address information for customers, employees, and vendors.
    Primary key: addressid */
case class AddressRow(
  /** Primary key for Address records.
      Default: nextval('person.address_addressid_seq'::regclass) */
  addressid: AddressId,
  /** First street address line. */
  addressline1: /* max 60 chars */ String,
  /** Second street address line. */
  addressline2: Option[/* max 60 chars */ String],
  /** Name of the city. */
  city: /* max 30 chars */ String,
  /** Unique identification number for the state or province. Foreign key to StateProvince table.
      Points to [[stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Postal code for the street address. */
  postalcode: /* max 15 chars */ String,
  /** Latitude and longitude of this address. */
  spatiallocation: Option[TypoBytea],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = addressid
   def toUnsavedRow(addressid: Defaulted[AddressId], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): AddressRowUnsaved =
     AddressRowUnsaved(addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, addressid, rowguid, modifieddate)
 }

object AddressRow {
  implicit lazy val decoder: Decoder[AddressRow] = Decoder.forProduct9[AddressRow, AddressId, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, StateprovinceId, /* max 15 chars */ String, Option[TypoBytea], TypoUUID, TypoLocalDateTime]("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")(AddressRow.apply)(AddressId.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, StateprovinceId.decoder, Decoder.decodeString, Decoder.decodeOption(TypoBytea.decoder), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[AddressRow] = Encoder.forProduct9[AddressRow, AddressId, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, StateprovinceId, /* max 15 chars */ String, Option[TypoBytea], TypoUUID, TypoLocalDateTime]("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")(x => (x.addressid, x.addressline1, x.addressline2, x.city, x.stateprovinceid, x.postalcode, x.spatiallocation, x.rowguid, x.modifieddate))(AddressId.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, StateprovinceId.encoder, Encoder.encodeString, Encoder.encodeOption(TypoBytea.encoder), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[AddressRow] = new Read[AddressRow](
    gets = List(
      (AddressId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (StateprovinceId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoBytea.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => AddressRow(
      addressid = AddressId.get.unsafeGetNonNullable(rs, i + 0),
      addressline1 = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      addressline2 = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      city = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      stateprovinceid = StateprovinceId.get.unsafeGetNonNullable(rs, i + 4),
      postalcode = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      spatiallocation = TypoBytea.get.unsafeGetNullable(rs, i + 6),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
  implicit lazy val text: Text[AddressRow] = Text.instance[AddressRow]{ (row, sb) =>
    AddressId.text.unsafeEncode(row.addressid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.addressline1, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.addressline2, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.city, sb)
    sb.append(Text.DELIMETER)
    StateprovinceId.text.unsafeEncode(row.stateprovinceid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.postalcode, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoBytea.text).unsafeEncode(row.spatiallocation, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val write: Write[AddressRow] = new Write[AddressRow](
    puts = List((AddressId.put, Nullability.NoNulls),
                (Meta.StringMeta.put, Nullability.NoNulls),
                (Meta.StringMeta.put, Nullability.Nullable),
                (Meta.StringMeta.put, Nullability.NoNulls),
                (StateprovinceId.put, Nullability.NoNulls),
                (Meta.StringMeta.put, Nullability.NoNulls),
                (TypoBytea.put, Nullability.Nullable),
                (TypoUUID.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.addressid, x.addressline1, x.addressline2, x.city, x.stateprovinceid, x.postalcode, x.spatiallocation, x.rowguid, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  AddressId.put.unsafeSetNonNullable(rs, i + 0, a.addressid)
                  Meta.StringMeta.put.unsafeSetNonNullable(rs, i + 1, a.addressline1)
                  Meta.StringMeta.put.unsafeSetNullable(rs, i + 2, a.addressline2)
                  Meta.StringMeta.put.unsafeSetNonNullable(rs, i + 3, a.city)
                  StateprovinceId.put.unsafeSetNonNullable(rs, i + 4, a.stateprovinceid)
                  Meta.StringMeta.put.unsafeSetNonNullable(rs, i + 5, a.postalcode)
                  TypoBytea.put.unsafeSetNullable(rs, i + 6, a.spatiallocation)
                  TypoUUID.put.unsafeSetNonNullable(rs, i + 7, a.rowguid)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 8, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     AddressId.put.unsafeUpdateNonNullable(ps, i + 0, a.addressid)
                     Meta.StringMeta.put.unsafeUpdateNonNullable(ps, i + 1, a.addressline1)
                     Meta.StringMeta.put.unsafeUpdateNullable(ps, i + 2, a.addressline2)
                     Meta.StringMeta.put.unsafeUpdateNonNullable(ps, i + 3, a.city)
                     StateprovinceId.put.unsafeUpdateNonNullable(ps, i + 4, a.stateprovinceid)
                     Meta.StringMeta.put.unsafeUpdateNonNullable(ps, i + 5, a.postalcode)
                     TypoBytea.put.unsafeUpdateNullable(ps, i + 6, a.spatiallocation)
                     TypoUUID.put.unsafeUpdateNonNullable(ps, i + 7, a.rowguid)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 8, a.modifieddate)
                   }
  )
}
