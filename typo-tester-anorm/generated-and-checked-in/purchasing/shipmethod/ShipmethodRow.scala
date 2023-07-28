/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
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

case class ShipmethodRow(
  /** Primary key for ShipMethod records. */
  shipmethodid: ShipmethodId,
  /** Shipping company name. */
  name: Name,
  /** Minimum shipping charge. */
  shipbase: BigDecimal,
  /** Shipping charge per pound. */
  shiprate: BigDecimal,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object ShipmethodRow {
  implicit val reads: Reads[ShipmethodRow] = Reads[ShipmethodRow](json => JsResult.fromTry(
      Try(
        ShipmethodRow(
          shipmethodid = json.\("shipmethodid").as[ShipmethodId],
          name = json.\("name").as[Name],
          shipbase = json.\("shipbase").as[BigDecimal],
          shiprate = json.\("shiprate").as[BigDecimal],
          rowguid = json.\("rowguid").as[UUID],
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ShipmethodRow] = RowParser[ShipmethodRow] { row =>
    Success(
      ShipmethodRow(
        shipmethodid = row[ShipmethodId](idx + 0),
        name = row[Name](idx + 1),
        shipbase = row[BigDecimal](idx + 2),
        shiprate = row[BigDecimal](idx + 3),
        rowguid = row[UUID](idx + 4),
        modifieddate = row[TypoLocalDateTime](idx + 5)
      )
    )
  }
  implicit val writes: OWrites[ShipmethodRow] = OWrites[ShipmethodRow](o =>
    new JsObject(ListMap[String, JsValue](
      "shipmethodid" -> Json.toJson(o.shipmethodid),
      "name" -> Json.toJson(o.name),
      "shipbase" -> Json.toJson(o.shipbase),
      "shiprate" -> Json.toJson(o.shiprate),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
