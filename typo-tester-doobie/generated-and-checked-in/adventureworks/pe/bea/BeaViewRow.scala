/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bea

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class BeaViewRow(
  id: Option[Int],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.addressid]] */
  addressid: Option[AddressId],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.addresstypeid]] */
  addresstypeid: Option[AddresstypeId],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object BeaViewRow {
  implicit lazy val decoder: Decoder[BeaViewRow] = Decoder.forProduct6[BeaViewRow, Option[Int], Option[BusinessentityId], Option[AddressId], Option[AddresstypeId], Option[UUID], Option[TypoLocalDateTime]]("id", "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")(BeaViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(AddressId.decoder), Decoder.decodeOption(AddresstypeId.decoder), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[BeaViewRow] = Encoder.forProduct6[BeaViewRow, Option[Int], Option[BusinessentityId], Option[AddressId], Option[AddresstypeId], Option[UUID], Option[TypoLocalDateTime]]("id", "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.addressid, x.addresstypeid, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(AddressId.encoder), Encoder.encodeOption(AddresstypeId.encoder), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[BeaViewRow] = new Read[BeaViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (AddressId.get, Nullability.Nullable),
      (AddresstypeId.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => BeaViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 1),
      addressid = AddressId.get.unsafeGetNullable(rs, i + 2),
      addresstypeid = AddresstypeId.get.unsafeGetNullable(rs, i + 3),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5)
    )
  )
}