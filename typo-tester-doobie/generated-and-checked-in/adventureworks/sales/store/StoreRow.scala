/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/**
 *Table: sales.store
 *
 * Customers (resellers) of Adventure Works products.
 *
 * Primary key: businessentityid */
case class StoreRow(
  /** Primary key. Foreign key to Customer.BusinessEntityID.
      Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Name of the store. */
  name: Name,
  /** ID of the sales person assigned to the customer. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  salespersonid: Option[BusinessentityId],
  /** Demographic informationg about the store such as the number of employees, annual sales and store type. */
  demographics: Option[TypoXml],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = businessentityid
   def toUnsavedRow(rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): StoreRowUnsaved =
     StoreRowUnsaved(businessentityid, name, salespersonid, demographics, rowguid, modifieddate)
 }

object StoreRow {
  implicit lazy val decoder: Decoder[StoreRow] = Decoder.forProduct6[StoreRow, BusinessentityId, Name, Option[BusinessentityId], Option[TypoXml], TypoUUID, TypoLocalDateTime]("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")(StoreRow.apply)(BusinessentityId.decoder, Name.decoder, Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(TypoXml.decoder), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[StoreRow] = Encoder.forProduct6[StoreRow, BusinessentityId, Name, Option[BusinessentityId], Option[TypoXml], TypoUUID, TypoLocalDateTime]("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")(x => (x.businessentityid, x.name, x.salespersonid, x.demographics, x.rowguid, x.modifieddate))(BusinessentityId.encoder, Name.encoder, Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(TypoXml.encoder), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[StoreRow] = new Read[StoreRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => StoreRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      salespersonid = BusinessentityId.get.unsafeGetNullable(rs, i + 2),
      demographics = TypoXml.get.unsafeGetNullable(rs, i + 3),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
  implicit lazy val text: Text[StoreRow] = Text.instance[StoreRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.salespersonid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.demographics, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
