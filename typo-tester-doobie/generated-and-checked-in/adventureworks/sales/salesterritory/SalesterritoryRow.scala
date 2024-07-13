/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: sales.salesterritory
    Sales territory lookup table.
    Primary key: territoryid */
case class SalesterritoryRow(
  /** Primary key for SalesTerritory records.
      Default: nextval('sales.salesterritory_territoryid_seq'::regclass) */
  territoryid: SalesterritoryId,
  /** Sales territory description */
  name: Name,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Geographic area to which the sales territory belong. */
  group: /* max 50 chars */ String,
  /** Sales in the territory year to date.
      Default: 0.00
      Constraint CK_SalesTerritory_SalesYTD affecting columns salesytd: ((salesytd >= 0.00)) */
  salesytd: BigDecimal,
  /** Sales in the territory the previous year.
      Default: 0.00
      Constraint CK_SalesTerritory_SalesLastYear affecting columns saleslastyear: ((saleslastyear >= 0.00)) */
  saleslastyear: BigDecimal,
  /** Business costs in the territory year to date.
      Default: 0.00
      Constraint CK_SalesTerritory_CostYTD affecting columns costytd: ((costytd >= 0.00)) */
  costytd: BigDecimal,
  /** Business costs in the territory the previous year.
      Default: 0.00
      Constraint CK_SalesTerritory_CostLastYear affecting columns costlastyear: ((costlastyear >= 0.00)) */
  costlastyear: BigDecimal,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = territoryid
   def toUnsavedRow(territoryid: Defaulted[SalesterritoryId], salesytd: Defaulted[BigDecimal] = Defaulted.Provided(this.salesytd), saleslastyear: Defaulted[BigDecimal] = Defaulted.Provided(this.saleslastyear), costytd: Defaulted[BigDecimal] = Defaulted.Provided(this.costytd), costlastyear: Defaulted[BigDecimal] = Defaulted.Provided(this.costlastyear), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalesterritoryRowUnsaved =
     SalesterritoryRowUnsaved(name, countryregioncode, group, territoryid, salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate)
 }

object SalesterritoryRow {
  implicit lazy val decoder: Decoder[SalesterritoryRow] = Decoder.forProduct10[SalesterritoryRow, SalesterritoryId, Name, CountryregionId, /* max 50 chars */ String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, TypoUUID, TypoLocalDateTime]("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")(SalesterritoryRow.apply)(SalesterritoryId.decoder, Name.decoder, CountryregionId.decoder, Decoder.decodeString, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SalesterritoryRow] = Encoder.forProduct10[SalesterritoryRow, SalesterritoryId, Name, CountryregionId, /* max 50 chars */ String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, TypoUUID, TypoLocalDateTime]("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")(x => (x.territoryid, x.name, x.countryregioncode, x.group, x.salesytd, x.saleslastyear, x.costytd, x.costlastyear, x.rowguid, x.modifieddate))(SalesterritoryId.encoder, Name.encoder, CountryregionId.encoder, Encoder.encodeString, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SalesterritoryRow] = new Read[SalesterritoryRow](
    gets = List(
      (SalesterritoryId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (CountryregionId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesterritoryRow(
      territoryid = SalesterritoryId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      countryregioncode = CountryregionId.get.unsafeGetNonNullable(rs, i + 2),
      group = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      salesytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
      saleslastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
      costytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
      costlastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
  implicit lazy val text: Text[SalesterritoryRow] = Text.instance[SalesterritoryRow]{ (row, sb) =>
    SalesterritoryId.text.unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    CountryregionId.text.unsafeEncode(row.countryregioncode, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.group, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.salesytd, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.saleslastyear, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.costytd, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.costlastyear, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val write: Write[SalesterritoryRow] = new Write[SalesterritoryRow](
    puts = List((SalesterritoryId.put, Nullability.NoNulls),
                (Name.put, Nullability.NoNulls),
                (CountryregionId.put, Nullability.NoNulls),
                (Meta.StringMeta.put, Nullability.NoNulls),
                (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                (TypoUUID.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.territoryid, x.name, x.countryregioncode, x.group, x.salesytd, x.saleslastyear, x.costytd, x.costlastyear, x.rowguid, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  SalesterritoryId.put.unsafeSetNonNullable(rs, i + 0, a.territoryid)
                  Name.put.unsafeSetNonNullable(rs, i + 1, a.name)
                  CountryregionId.put.unsafeSetNonNullable(rs, i + 2, a.countryregioncode)
                  Meta.StringMeta.put.unsafeSetNonNullable(rs, i + 3, a.group)
                  Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 4, a.salesytd)
                  Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 5, a.saleslastyear)
                  Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 6, a.costytd)
                  Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 7, a.costlastyear)
                  TypoUUID.put.unsafeSetNonNullable(rs, i + 8, a.rowguid)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 9, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     SalesterritoryId.put.unsafeUpdateNonNullable(ps, i + 0, a.territoryid)
                     Name.put.unsafeUpdateNonNullable(ps, i + 1, a.name)
                     CountryregionId.put.unsafeUpdateNonNullable(ps, i + 2, a.countryregioncode)
                     Meta.StringMeta.put.unsafeUpdateNonNullable(ps, i + 3, a.group)
                     Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 4, a.salesytd)
                     Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 5, a.saleslastyear)
                     Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 6, a.costytd)
                     Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 7, a.costlastyear)
                     TypoUUID.put.unsafeUpdateNonNullable(ps, i + 8, a.rowguid)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 9, a.modifieddate)
                   }
  )
}
