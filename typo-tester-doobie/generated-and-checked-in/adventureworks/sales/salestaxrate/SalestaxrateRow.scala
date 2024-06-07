/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: sales.salestaxrate
    Tax rate lookup table.
    Primary key: salestaxrateid */
case class SalestaxrateRow(
  /** Primary key for SalesTaxRate records.
      Default: nextval('sales.salestaxrate_salestaxrateid_seq'::regclass) */
  salestaxrateid: SalestaxrateId,
  /** State, province, or country/region the sales tax applies to.
      Points to [[person.stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** 1 = Tax applied to retail transactions, 2 = Tax applied to wholesale transactions, 3 = Tax applied to all sales (retail and wholesale) transactions.
      Constraint CK_SalesTaxRate_TaxType affecting columns taxtype: (((taxtype >= 1) AND (taxtype <= 3))) */
  taxtype: TypoShort,
  /** Tax rate amount.
      Default: 0.00 */
  taxrate: BigDecimal,
  /** Tax rate description. */
  name: Name,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = salestaxrateid
   def toUnsavedRow(salestaxrateid: Defaulted[SalestaxrateId], taxrate: Defaulted[BigDecimal] = Defaulted.Provided(this.taxrate), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalestaxrateRowUnsaved =
     SalestaxrateRowUnsaved(stateprovinceid, taxtype, name, salestaxrateid, taxrate, rowguid, modifieddate)
 }

object SalestaxrateRow {
  implicit lazy val decoder: Decoder[SalestaxrateRow] = Decoder.forProduct7[SalestaxrateRow, SalestaxrateId, StateprovinceId, TypoShort, BigDecimal, Name, TypoUUID, TypoLocalDateTime]("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate")(SalestaxrateRow.apply)(SalestaxrateId.decoder, StateprovinceId.decoder, TypoShort.decoder, Decoder.decodeBigDecimal, Name.decoder, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SalestaxrateRow] = Encoder.forProduct7[SalestaxrateRow, SalestaxrateId, StateprovinceId, TypoShort, BigDecimal, Name, TypoUUID, TypoLocalDateTime]("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate")(x => (x.salestaxrateid, x.stateprovinceid, x.taxtype, x.taxrate, x.name, x.rowguid, x.modifieddate))(SalestaxrateId.encoder, StateprovinceId.encoder, TypoShort.encoder, Encoder.encodeBigDecimal, Name.encoder, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SalestaxrateRow] = new Read[SalestaxrateRow](
    gets = List(
      (SalestaxrateId.get, Nullability.NoNulls),
      (StateprovinceId.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalestaxrateRow(
      salestaxrateid = SalestaxrateId.get.unsafeGetNonNullable(rs, i + 0),
      stateprovinceid = StateprovinceId.get.unsafeGetNonNullable(rs, i + 1),
      taxtype = TypoShort.get.unsafeGetNonNullable(rs, i + 2),
      taxrate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
      name = Name.get.unsafeGetNonNullable(rs, i + 4),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
  implicit lazy val text: Text[SalestaxrateRow] = Text.instance[SalestaxrateRow]{ (row, sb) =>
    SalestaxrateId.text.unsafeEncode(row.salestaxrateid, sb)
    sb.append(Text.DELIMETER)
    StateprovinceId.text.unsafeEncode(row.stateprovinceid, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.taxtype, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.taxrate, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
