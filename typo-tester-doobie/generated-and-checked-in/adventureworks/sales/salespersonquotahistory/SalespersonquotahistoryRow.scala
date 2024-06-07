/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

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

/** Table: sales.salespersonquotahistory
    Sales performance tracking.
    Composite primary key: businessentityid, quotadate */
case class SalespersonquotahistoryRow(
  /** Sales person identification number. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Sales quota date. */
  quotadate: TypoLocalDateTime,
  /** Sales quota amount.
      Constraint CK_SalesPersonQuotaHistory_SalesQuota affecting columns salesquota: ((salesquota > 0.00)) */
  salesquota: BigDecimal,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalespersonquotahistoryId = SalespersonquotahistoryId(businessentityid, quotadate)
   val id = compositeId
   def toUnsavedRow(rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalespersonquotahistoryRowUnsaved =
     SalespersonquotahistoryRowUnsaved(businessentityid, quotadate, salesquota, rowguid, modifieddate)
 }

object SalespersonquotahistoryRow {
  def apply(compositeId: SalespersonquotahistoryId, salesquota: BigDecimal, rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new SalespersonquotahistoryRow(compositeId.businessentityid, compositeId.quotadate, salesquota, rowguid, modifieddate)
  implicit lazy val decoder: Decoder[SalespersonquotahistoryRow] = Decoder.forProduct5[SalespersonquotahistoryRow, BusinessentityId, TypoLocalDateTime, BigDecimal, TypoUUID, TypoLocalDateTime]("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate")(SalespersonquotahistoryRow.apply)(BusinessentityId.decoder, TypoLocalDateTime.decoder, Decoder.decodeBigDecimal, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SalespersonquotahistoryRow] = Encoder.forProduct5[SalespersonquotahistoryRow, BusinessentityId, TypoLocalDateTime, BigDecimal, TypoUUID, TypoLocalDateTime]("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate")(x => (x.businessentityid, x.quotadate, x.salesquota, x.rowguid, x.modifieddate))(BusinessentityId.encoder, TypoLocalDateTime.encoder, Encoder.encodeBigDecimal, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SalespersonquotahistoryRow] = new Read[SalespersonquotahistoryRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalespersonquotahistoryRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      quotadate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 1),
      salesquota = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 2),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
  implicit lazy val text: Text[SalespersonquotahistoryRow] = Text.instance[SalespersonquotahistoryRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.quotadate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.salesquota, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
