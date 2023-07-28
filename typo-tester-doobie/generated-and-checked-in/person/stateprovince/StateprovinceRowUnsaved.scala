/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.Defaulted
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

/** This class corresponds to a row in table `person.stateprovince` which has not been persisted yet */
case class StateprovinceRowUnsaved(
  /** ISO standard state or province code. */
  stateprovincecode: /* bpchar */ String,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** State or province description. */
  name: Name,
  /** ID of the territory in which the state or province is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Default: nextval('person.stateprovince_stateprovinceid_seq'::regclass)
      Primary key for StateProvince records. */
  stateprovinceid: Defaulted[StateprovinceId] = Defaulted.UseDefault,
  /** Default: true
      0 = StateProvinceCode exists. 1 = StateProvinceCode unavailable, using CountryRegionCode. */
  isonlystateprovinceflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(stateprovinceidDefault: => StateprovinceId, isonlystateprovinceflagDefault: => Flag, rowguidDefault: => UUID, modifieddateDefault: => LocalDateTime): StateprovinceRow =
    StateprovinceRow(
      stateprovincecode = stateprovincecode,
      countryregioncode = countryregioncode,
      name = name,
      territoryid = territoryid,
      stateprovinceid = stateprovinceid match {
                          case Defaulted.UseDefault => stateprovinceidDefault
                          case Defaulted.Provided(value) => value
                        },
      isonlystateprovinceflag = isonlystateprovinceflag match {
                                  case Defaulted.UseDefault => isonlystateprovinceflagDefault
                                  case Defaulted.Provided(value) => value
                                },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object StateprovinceRowUnsaved {
  implicit val decoder: Decoder[StateprovinceRowUnsaved] =
    (c: HCursor) =>
      for {
        stateprovincecode <- c.downField("stateprovincecode").as[/* bpchar */ String]
        countryregioncode <- c.downField("countryregioncode").as[CountryregionId]
        name <- c.downField("name").as[Name]
        territoryid <- c.downField("territoryid").as[SalesterritoryId]
        stateprovinceid <- c.downField("stateprovinceid").as[Defaulted[StateprovinceId]]
        isonlystateprovinceflag <- c.downField("isonlystateprovinceflag").as[Defaulted[Flag]]
        rowguid <- c.downField("rowguid").as[Defaulted[UUID]]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield StateprovinceRowUnsaved(stateprovincecode, countryregioncode, name, territoryid, stateprovinceid, isonlystateprovinceflag, rowguid, modifieddate)
  implicit val encoder: Encoder[StateprovinceRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "stateprovincecode" := row.stateprovincecode,
        "countryregioncode" := row.countryregioncode,
        "name" := row.name,
        "territoryid" := row.territoryid,
        "stateprovinceid" := row.stateprovinceid,
        "isonlystateprovinceflag" := row.isonlystateprovinceflag,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}