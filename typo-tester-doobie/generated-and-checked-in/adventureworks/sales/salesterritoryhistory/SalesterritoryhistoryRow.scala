/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

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

/**
 *Table: sales.salesterritoryhistory
 *
 * Sales representative transfers to other sales territories.
 *
 * Composite primary key: businessentityid, startdate, territoryid */
case class SalesterritoryhistoryRow(
  /** Primary key. The sales rep.  Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Territory identification number. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Primary key. Date the sales representive started work in the territory.
      Constraint CK_SalesTerritoryHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Date the sales representative left work in the territory.
      Constraint CK_SalesTerritoryHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesterritoryhistoryId = SalesterritoryhistoryId(businessentityid, startdate, territoryid)
   val id = compositeId
   def toUnsavedRow(rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalesterritoryhistoryRowUnsaved =
     SalesterritoryhistoryRowUnsaved(businessentityid, territoryid, startdate, enddate, rowguid, modifieddate)
 }

object SalesterritoryhistoryRow {
  def apply(compositeId: SalesterritoryhistoryId, enddate: Option[TypoLocalDateTime], rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new SalesterritoryhistoryRow(compositeId.businessentityid, compositeId.territoryid, compositeId.startdate, enddate, rowguid, modifieddate)
  implicit lazy val decoder: Decoder[SalesterritoryhistoryRow] = Decoder.forProduct6[SalesterritoryhistoryRow, BusinessentityId, SalesterritoryId, TypoLocalDateTime, Option[TypoLocalDateTime], TypoUUID, TypoLocalDateTime]("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")(SalesterritoryhistoryRow.apply)(BusinessentityId.decoder, SalesterritoryId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SalesterritoryhistoryRow] = Encoder.forProduct6[SalesterritoryhistoryRow, BusinessentityId, SalesterritoryId, TypoLocalDateTime, Option[TypoLocalDateTime], TypoUUID, TypoLocalDateTime]("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")(x => (x.businessentityid, x.territoryid, x.startdate, x.enddate, x.rowguid, x.modifieddate))(BusinessentityId.encoder, SalesterritoryId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SalesterritoryhistoryRow] = new Read[SalesterritoryhistoryRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (SalesterritoryId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesterritoryhistoryRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      territoryid = SalesterritoryId.get.unsafeGetNonNullable(rs, i + 1),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2),
      enddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 3),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
  implicit lazy val text: Text[SalesterritoryhistoryRow] = Text.instance[SalesterritoryhistoryRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    SalesterritoryId.text.unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
