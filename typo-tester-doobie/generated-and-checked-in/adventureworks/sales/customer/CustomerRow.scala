/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: sales.customer
    Current customer information. Also see the Person and Store tables.
    Primary key: customerid */
case class CustomerRow(
  /** Primary key.
      Default: nextval('sales.customer_customerid_seq'::regclass) */
  customerid: CustomerId,
  /** Foreign key to Person.BusinessEntityID
      Points to [[person.person.PersonRow.businessentityid]] */
  personid: Option[BusinessentityId],
  /** Foreign key to Store.BusinessEntityID
      Points to [[store.StoreRow.businessentityid]] */
  storeid: Option[BusinessentityId],
  /** ID of the territory in which the customer is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = customerid
   def toUnsavedRow(customerid: Defaulted[CustomerId], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CustomerRowUnsaved =
     CustomerRowUnsaved(personid, storeid, territoryid, customerid, rowguid, modifieddate)
 }

object CustomerRow {
  implicit lazy val decoder: Decoder[CustomerRow] = Decoder.forProduct6[CustomerRow, CustomerId, Option[BusinessentityId], Option[BusinessentityId], Option[SalesterritoryId], TypoUUID, TypoLocalDateTime]("customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate")(CustomerRow.apply)(CustomerId.decoder, Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(SalesterritoryId.decoder), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CustomerRow] = Encoder.forProduct6[CustomerRow, CustomerId, Option[BusinessentityId], Option[BusinessentityId], Option[SalesterritoryId], TypoUUID, TypoLocalDateTime]("customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate")(x => (x.customerid, x.personid, x.storeid, x.territoryid, x.rowguid, x.modifieddate))(CustomerId.encoder, Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(SalesterritoryId.encoder), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CustomerRow] = new Read[CustomerRow](
    gets = List(
      (CustomerId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (SalesterritoryId.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CustomerRow(
      customerid = CustomerId.get.unsafeGetNonNullable(rs, i + 0),
      personid = BusinessentityId.get.unsafeGetNullable(rs, i + 1),
      storeid = BusinessentityId.get.unsafeGetNullable(rs, i + 2),
      territoryid = SalesterritoryId.get.unsafeGetNullable(rs, i + 3),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
  implicit lazy val text: Text[CustomerRow] = Text.instance[CustomerRow]{ (row, sb) =>
    CustomerId.text.unsafeEncode(row.customerid, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.personid, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.storeid, sb)
    sb.append(Text.DELIMETER)
    Text.option(SalesterritoryId.text).unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
