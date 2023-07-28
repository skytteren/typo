/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class WorkorderroutingRow(
  /** Primary key. Foreign key to WorkOrder.WorkOrderID.
      Points to [[workorder.WorkorderRow.workorderid]] */
  workorderid: WorkorderId,
  /** Primary key. Foreign key to Product.ProductID. */
  productid: Int,
  /** Primary key. Indicates the manufacturing process sequence. */
  operationsequence: Int,
  /** Manufacturing location where the part is processed. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Planned manufacturing start date. */
  scheduledstartdate: TypoLocalDateTime,
  /** Planned manufacturing end date. */
  scheduledenddate: TypoLocalDateTime,
  /** Actual start date. */
  actualstartdate: Option[TypoLocalDateTime],
  /** Actual end date. */
  actualenddate: Option[TypoLocalDateTime],
  /** Number of manufacturing hours used. */
  actualresourcehrs: Option[BigDecimal],
  /** Estimated manufacturing cost. */
  plannedcost: BigDecimal,
  /** Actual manufacturing cost. */
  actualcost: Option[BigDecimal],
  modifieddate: TypoLocalDateTime
){
   val compositeId: WorkorderroutingId = WorkorderroutingId(workorderid, productid, operationsequence)
 }

object WorkorderroutingRow {
  implicit val reads: Reads[WorkorderroutingRow] = Reads[WorkorderroutingRow](json => JsResult.fromTry(
      Try(
        WorkorderroutingRow(
          workorderid = json.\("workorderid").as[WorkorderId],
          productid = json.\("productid").as[Int],
          operationsequence = json.\("operationsequence").as[Int],
          locationid = json.\("locationid").as[LocationId],
          scheduledstartdate = json.\("scheduledstartdate").as[TypoLocalDateTime],
          scheduledenddate = json.\("scheduledenddate").as[TypoLocalDateTime],
          actualstartdate = json.\("actualstartdate").toOption.map(_.as[TypoLocalDateTime]),
          actualenddate = json.\("actualenddate").toOption.map(_.as[TypoLocalDateTime]),
          actualresourcehrs = json.\("actualresourcehrs").toOption.map(_.as[BigDecimal]),
          plannedcost = json.\("plannedcost").as[BigDecimal],
          actualcost = json.\("actualcost").toOption.map(_.as[BigDecimal]),
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[WorkorderroutingRow] = RowParser[WorkorderroutingRow] { row =>
    Success(
      WorkorderroutingRow(
        workorderid = row[WorkorderId](idx + 0),
        productid = row[Int](idx + 1),
        operationsequence = row[Int](idx + 2),
        locationid = row[LocationId](idx + 3),
        scheduledstartdate = row[TypoLocalDateTime](idx + 4),
        scheduledenddate = row[TypoLocalDateTime](idx + 5),
        actualstartdate = row[Option[TypoLocalDateTime]](idx + 6),
        actualenddate = row[Option[TypoLocalDateTime]](idx + 7),
        actualresourcehrs = row[Option[BigDecimal]](idx + 8),
        plannedcost = row[BigDecimal](idx + 9),
        actualcost = row[Option[BigDecimal]](idx + 10),
        modifieddate = row[TypoLocalDateTime](idx + 11)
      )
    )
  }
  implicit val writes: OWrites[WorkorderroutingRow] = OWrites[WorkorderroutingRow](o =>
    new JsObject(ListMap[String, JsValue](
      "workorderid" -> Json.toJson(o.workorderid),
      "productid" -> Json.toJson(o.productid),
      "operationsequence" -> Json.toJson(o.operationsequence),
      "locationid" -> Json.toJson(o.locationid),
      "scheduledstartdate" -> Json.toJson(o.scheduledstartdate),
      "scheduledenddate" -> Json.toJson(o.scheduledenddate),
      "actualstartdate" -> Json.toJson(o.actualstartdate),
      "actualenddate" -> Json.toJson(o.actualenddate),
      "actualresourcehrs" -> Json.toJson(o.actualresourcehrs),
      "plannedcost" -> Json.toJson(o.plannedcost),
      "actualcost" -> Json.toJson(o.actualcost),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
