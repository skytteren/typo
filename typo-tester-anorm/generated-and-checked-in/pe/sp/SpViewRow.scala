/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class SpViewRow(
  id: Option[Int],
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: Option[StateprovinceId],
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovincecode]] */
  stateprovincecode: Option[/* bpchar */ String],
  /** Points to [[person.stateprovince.StateprovinceRow.countryregioncode]] */
  countryregioncode: Option[CountryregionId],
  /** Points to [[person.stateprovince.StateprovinceRow.isonlystateprovinceflag]] */
  isonlystateprovinceflag: Flag,
  /** Points to [[person.stateprovince.StateprovinceRow.name]] */
  name: Option[Name],
  /** Points to [[person.stateprovince.StateprovinceRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[person.stateprovince.StateprovinceRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.stateprovince.StateprovinceRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SpViewRow {
  implicit val reads: Reads[SpViewRow] = Reads[SpViewRow](json => JsResult.fromTry(
      Try(
        SpViewRow(
          id = json.\("id").toOption.map(_.as[Int]),
          stateprovinceid = json.\("stateprovinceid").toOption.map(_.as[StateprovinceId]),
          stateprovincecode = json.\("stateprovincecode").toOption.map(_.as[/* bpchar */ String]),
          countryregioncode = json.\("countryregioncode").toOption.map(_.as[CountryregionId]),
          isonlystateprovinceflag = json.\("isonlystateprovinceflag").as[Flag],
          name = json.\("name").toOption.map(_.as[Name]),
          territoryid = json.\("territoryid").toOption.map(_.as[SalesterritoryId]),
          rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
          modifieddate = json.\("modifieddate").toOption.map(_.as[TypoLocalDateTime])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SpViewRow] = RowParser[SpViewRow] { row =>
    Success(
      SpViewRow(
        id = row[Option[Int]](idx + 0),
        stateprovinceid = row[Option[StateprovinceId]](idx + 1),
        stateprovincecode = row[Option[/* bpchar */ String]](idx + 2),
        countryregioncode = row[Option[CountryregionId]](idx + 3),
        isonlystateprovinceflag = row[Flag](idx + 4),
        name = row[Option[Name]](idx + 5),
        territoryid = row[Option[SalesterritoryId]](idx + 6),
        rowguid = row[Option[UUID]](idx + 7),
        modifieddate = row[Option[TypoLocalDateTime]](idx + 8)
      )
    )
  }
  implicit val writes: OWrites[SpViewRow] = OWrites[SpViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Json.toJson(o.id),
      "stateprovinceid" -> Json.toJson(o.stateprovinceid),
      "stateprovincecode" -> Json.toJson(o.stateprovincecode),
      "countryregioncode" -> Json.toJson(o.countryregioncode),
      "isonlystateprovinceflag" -> Json.toJson(o.isonlystateprovinceflag),
      "name" -> Json.toJson(o.name),
      "territoryid" -> Json.toJson(o.territoryid),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
