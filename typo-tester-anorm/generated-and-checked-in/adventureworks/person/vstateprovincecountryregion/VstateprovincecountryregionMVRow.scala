/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vstateprovincecountryregion

import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
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
 *Materialized View: person.vstateprovincecountryregion */
case class VstateprovincecountryregionMVRow(
  /** Points to [[stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Points to [[stateprovince.StateprovinceRow.stateprovincecode]] */
  stateprovincecode: /* bpchar, max 3 chars */ String,
  /** Points to [[stateprovince.StateprovinceRow.isonlystateprovinceflag]] */
  isonlystateprovinceflag: Flag,
  /** Points to [[stateprovince.StateprovinceRow.name]] */
  stateprovincename: Name,
  /** Points to [[stateprovince.StateprovinceRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Points to [[countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Points to [[countryregion.CountryregionRow.name]] */
  countryregionname: Name
)

object VstateprovincecountryregionMVRow {
  implicit lazy val reads: Reads[VstateprovincecountryregionMVRow] = Reads[VstateprovincecountryregionMVRow](json => JsResult.fromTry(
      Try(
        VstateprovincecountryregionMVRow(
          stateprovinceid = json.\("stateprovinceid").as(StateprovinceId.reads),
          stateprovincecode = json.\("stateprovincecode").as(Reads.StringReads),
          isonlystateprovinceflag = json.\("isonlystateprovinceflag").as(Flag.reads),
          stateprovincename = json.\("stateprovincename").as(Name.reads),
          territoryid = json.\("territoryid").as(SalesterritoryId.reads),
          countryregioncode = json.\("countryregioncode").as(CountryregionId.reads),
          countryregionname = json.\("countryregionname").as(Name.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VstateprovincecountryregionMVRow] = RowParser[VstateprovincecountryregionMVRow] { row =>
    Success(
      VstateprovincecountryregionMVRow(
        stateprovinceid = row(idx + 0)(StateprovinceId.column),
        stateprovincecode = row(idx + 1)(Column.columnToString),
        isonlystateprovinceflag = row(idx + 2)(Flag.column),
        stateprovincename = row(idx + 3)(Name.column),
        territoryid = row(idx + 4)(SalesterritoryId.column),
        countryregioncode = row(idx + 5)(CountryregionId.column),
        countryregionname = row(idx + 6)(Name.column)
      )
    )
  }
  implicit lazy val writes: OWrites[VstateprovincecountryregionMVRow] = OWrites[VstateprovincecountryregionMVRow](o =>
    new JsObject(ListMap[String, JsValue](
      "stateprovinceid" -> StateprovinceId.writes.writes(o.stateprovinceid),
      "stateprovincecode" -> Writes.StringWrites.writes(o.stateprovincecode),
      "isonlystateprovinceflag" -> Flag.writes.writes(o.isonlystateprovinceflag),
      "stateprovincename" -> Name.writes.writes(o.stateprovincename),
      "territoryid" -> SalesterritoryId.writes.writes(o.territoryid),
      "countryregioncode" -> CountryregionId.writes.writes(o.countryregioncode),
      "countryregionname" -> Name.writes.writes(o.countryregionname)
    ))
  )
}
