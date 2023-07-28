/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sp

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
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
  /** Points to [[sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[sales.salesperson.SalespersonRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.salesperson.SalespersonRow.salesquota]] */
  salesquota: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.bonus]] */
  bonus: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.commissionpct]] */
  commissionpct: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.salesytd]] */
  salesytd: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.saleslastyear]] */
  saleslastyear: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.salesperson.SalespersonRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SpViewRow {
  implicit val reads: Reads[SpViewRow] = Reads[SpViewRow](json => JsResult.fromTry(
      Try(
        SpViewRow(
          id = json.\("id").toOption.map(_.as[Int]),
          businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
          territoryid = json.\("territoryid").toOption.map(_.as[SalesterritoryId]),
          salesquota = json.\("salesquota").toOption.map(_.as[BigDecimal]),
          bonus = json.\("bonus").toOption.map(_.as[BigDecimal]),
          commissionpct = json.\("commissionpct").toOption.map(_.as[BigDecimal]),
          salesytd = json.\("salesytd").toOption.map(_.as[BigDecimal]),
          saleslastyear = json.\("saleslastyear").toOption.map(_.as[BigDecimal]),
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
        businessentityid = row[Option[BusinessentityId]](idx + 1),
        territoryid = row[Option[SalesterritoryId]](idx + 2),
        salesquota = row[Option[BigDecimal]](idx + 3),
        bonus = row[Option[BigDecimal]](idx + 4),
        commissionpct = row[Option[BigDecimal]](idx + 5),
        salesytd = row[Option[BigDecimal]](idx + 6),
        saleslastyear = row[Option[BigDecimal]](idx + 7),
        rowguid = row[Option[UUID]](idx + 8),
        modifieddate = row[Option[TypoLocalDateTime]](idx + 9)
      )
    )
  }
  implicit val writes: OWrites[SpViewRow] = OWrites[SpViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Json.toJson(o.id),
      "businessentityid" -> Json.toJson(o.businessentityid),
      "territoryid" -> Json.toJson(o.territoryid),
      "salesquota" -> Json.toJson(o.salesquota),
      "bonus" -> Json.toJson(o.bonus),
      "commissionpct" -> Json.toJson(o.commissionpct),
      "salesytd" -> Json.toJson(o.salesytd),
      "saleslastyear" -> Json.toJson(o.saleslastyear),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
