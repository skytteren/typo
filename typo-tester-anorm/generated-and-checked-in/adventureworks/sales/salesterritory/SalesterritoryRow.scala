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
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/**
 *Table: sales.salesterritory
 *
 * Sales territory lookup table.
 *
 * Primary key: territoryid */
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
  implicit lazy val reads: Reads[SalesterritoryRow] = Reads[SalesterritoryRow](json => JsResult.fromTry(
      Try(
        SalesterritoryRow(
          territoryid = json.\("territoryid").as(SalesterritoryId.reads),
          name = json.\("name").as(Name.reads),
          countryregioncode = json.\("countryregioncode").as(CountryregionId.reads),
          group = json.\("group").as(Reads.StringReads),
          salesytd = json.\("salesytd").as(Reads.bigDecReads),
          saleslastyear = json.\("saleslastyear").as(Reads.bigDecReads),
          costytd = json.\("costytd").as(Reads.bigDecReads),
          costlastyear = json.\("costlastyear").as(Reads.bigDecReads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalesterritoryRow] = RowParser[SalesterritoryRow] { row =>
    Success(
      SalesterritoryRow(
        territoryid = row(idx + 0)(SalesterritoryId.column),
        name = row(idx + 1)(Name.column),
        countryregioncode = row(idx + 2)(CountryregionId.column),
        group = row(idx + 3)(Column.columnToString),
        salesytd = row(idx + 4)(Column.columnToScalaBigDecimal),
        saleslastyear = row(idx + 5)(Column.columnToScalaBigDecimal),
        costytd = row(idx + 6)(Column.columnToScalaBigDecimal),
        costlastyear = row(idx + 7)(Column.columnToScalaBigDecimal),
        rowguid = row(idx + 8)(TypoUUID.column),
        modifieddate = row(idx + 9)(TypoLocalDateTime.column)
      )
    )
  }
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
  implicit lazy val writes: OWrites[SalesterritoryRow] = OWrites[SalesterritoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "territoryid" -> SalesterritoryId.writes.writes(o.territoryid),
      "name" -> Name.writes.writes(o.name),
      "countryregioncode" -> CountryregionId.writes.writes(o.countryregioncode),
      "group" -> Writes.StringWrites.writes(o.group),
      "salesytd" -> Writes.BigDecimalWrites.writes(o.salesytd),
      "saleslastyear" -> Writes.BigDecimalWrites.writes(o.saleslastyear),
      "costytd" -> Writes.BigDecimalWrites.writes(o.costytd),
      "costlastyear" -> Writes.BigDecimalWrites.writes(o.costlastyear),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
