/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.workorderrouting` which has not been persisted yet */
case class WorkorderroutingRowUnsaved(
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
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): WorkorderroutingRow =
    WorkorderroutingRow(
      workorderid = workorderid,
      productid = productid,
      operationsequence = operationsequence,
      locationid = locationid,
      scheduledstartdate = scheduledstartdate,
      scheduledenddate = scheduledenddate,
      actualstartdate = actualstartdate,
      actualenddate = actualenddate,
      actualresourcehrs = actualresourcehrs,
      plannedcost = plannedcost,
      actualcost = actualcost,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object WorkorderroutingRowUnsaved {
  implicit val decoder: Decoder[WorkorderroutingRowUnsaved] = Decoder.forProduct12[WorkorderroutingRowUnsaved, WorkorderId, Int, Int, LocationId, TypoLocalDateTime, TypoLocalDateTime, Option[TypoLocalDateTime], Option[TypoLocalDateTime], Option[BigDecimal], BigDecimal, Option[BigDecimal], Defaulted[TypoLocalDateTime]]("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate")(WorkorderroutingRowUnsaved.apply)
  implicit val encoder: Encoder[WorkorderroutingRowUnsaved] = Encoder.forProduct12[WorkorderroutingRowUnsaved, WorkorderId, Int, Int, LocationId, TypoLocalDateTime, TypoLocalDateTime, Option[TypoLocalDateTime], Option[TypoLocalDateTime], Option[BigDecimal], BigDecimal, Option[BigDecimal], Defaulted[TypoLocalDateTime]]("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate")(x => (x.workorderid, x.productid, x.operationsequence, x.locationid, x.scheduledstartdate, x.scheduledenddate, x.actualstartdate, x.actualenddate, x.actualresourcehrs, x.plannedcost, x.actualcost, x.modifieddate))
}
