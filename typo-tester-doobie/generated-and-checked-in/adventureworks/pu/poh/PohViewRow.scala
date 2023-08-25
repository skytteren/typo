/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package poh

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import adventureworks.purchasing.shipmethod.ShipmethodId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PohViewRow(
  id: Option[Int],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.purchaseorderid]] */
  purchaseorderid: Option[PurchaseorderheaderId],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.revisionnumber]] */
  revisionnumber: Option[Int],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.status]] */
  status: Option[Int],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.employeeid]] */
  employeeid: Option[BusinessentityId],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.vendorid]] */
  vendorid: Option[BusinessentityId],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.shipmethodid]] */
  shipmethodid: Option[ShipmethodId],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.orderdate]] */
  orderdate: Option[TypoLocalDateTime],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.shipdate]] */
  shipdate: Option[TypoLocalDateTime],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.subtotal]] */
  subtotal: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.taxamt]] */
  taxamt: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.freight]] */
  freight: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PohViewRow {
  implicit lazy val decoder: Decoder[PohViewRow] = Decoder.forProduct13[PohViewRow, Option[Int], Option[PurchaseorderheaderId], Option[Int], Option[Int], Option[BusinessentityId], Option[BusinessentityId], Option[ShipmethodId], Option[TypoLocalDateTime], Option[TypoLocalDateTime], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")(PohViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(PurchaseorderheaderId.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(ShipmethodId.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PohViewRow] = Encoder.forProduct13[PohViewRow, Option[Int], Option[PurchaseorderheaderId], Option[Int], Option[Int], Option[BusinessentityId], Option[BusinessentityId], Option[ShipmethodId], Option[TypoLocalDateTime], Option[TypoLocalDateTime], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")(x => (x.id, x.purchaseorderid, x.revisionnumber, x.status, x.employeeid, x.vendorid, x.shipmethodid, x.orderdate, x.shipdate, x.subtotal, x.taxamt, x.freight, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(PurchaseorderheaderId.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(ShipmethodId.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[PohViewRow] = new Read[PohViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (PurchaseorderheaderId.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (ShipmethodId.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PohViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      purchaseorderid = PurchaseorderheaderId.get.unsafeGetNullable(rs, i + 1),
      revisionnumber = Meta.IntMeta.get.unsafeGetNullable(rs, i + 2),
      status = Meta.IntMeta.get.unsafeGetNullable(rs, i + 3),
      employeeid = BusinessentityId.get.unsafeGetNullable(rs, i + 4),
      vendorid = BusinessentityId.get.unsafeGetNullable(rs, i + 5),
      shipmethodid = ShipmethodId.get.unsafeGetNullable(rs, i + 6),
      orderdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 7),
      shipdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 8),
      subtotal = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 9),
      taxamt = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 10),
      freight = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 11),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 12)
    )
  )
}