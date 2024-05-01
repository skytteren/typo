/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
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

/** Table: production.workorder
    Manufacturing work orders.
    Primary key: workorderid */
case class WorkorderRow(
  /** Primary key for WorkOrder records.
      Default: nextval('production.workorder_workorderid_seq'::regclass) */
  workorderid: WorkorderId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product quantity to build.
      Constraint CK_WorkOrder_OrderQty affecting columns orderqty: ((orderqty > 0)) */
  orderqty: Int,
  /** Quantity that failed inspection.
      Constraint CK_WorkOrder_ScrappedQty affecting columns scrappedqty: ((scrappedqty >= 0)) */
  scrappedqty: TypoShort,
  /** Work order start date.
      Constraint CK_WorkOrder_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Work order end date.
      Constraint CK_WorkOrder_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Work order due date. */
  duedate: TypoLocalDateTime,
  /** Reason for inspection failure.
      Points to [[scrapreason.ScrapreasonRow.scrapreasonid]] */
  scrapreasonid: Option[ScrapreasonId],
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(workorderid: Defaulted[WorkorderId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): WorkorderRowUnsaved =
     WorkorderRowUnsaved(productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, workorderid, modifieddate)
 }

object WorkorderRow {
  implicit lazy val reads: Reads[WorkorderRow] = Reads[WorkorderRow](json => JsResult.fromTry(
      Try(
        WorkorderRow(
          workorderid = json.\("workorderid").as(WorkorderId.reads),
          productid = json.\("productid").as(ProductId.reads),
          orderqty = json.\("orderqty").as(Reads.IntReads),
          scrappedqty = json.\("scrappedqty").as(TypoShort.reads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          duedate = json.\("duedate").as(TypoLocalDateTime.reads),
          scrapreasonid = json.\("scrapreasonid").toOption.map(_.as(ScrapreasonId.reads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[WorkorderRow] = RowParser[WorkorderRow] { row =>
    Success(
      WorkorderRow(
        workorderid = row(idx + 0)(WorkorderId.column),
        productid = row(idx + 1)(ProductId.column),
        orderqty = row(idx + 2)(Column.columnToInt),
        scrappedqty = row(idx + 3)(TypoShort.column),
        startdate = row(idx + 4)(TypoLocalDateTime.column),
        enddate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column)),
        duedate = row(idx + 6)(TypoLocalDateTime.column),
        scrapreasonid = row(idx + 7)(Column.columnToOption(ScrapreasonId.column)),
        modifieddate = row(idx + 8)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[WorkorderRow] = Text.instance[WorkorderRow]{ (row, sb) =>
    WorkorderId.text.unsafeEncode(row.workorderid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.orderqty, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.scrappedqty, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.duedate, sb)
    sb.append(Text.DELIMETER)
    Text.option(ScrapreasonId.text).unsafeEncode(row.scrapreasonid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[WorkorderRow] = OWrites[WorkorderRow](o =>
    new JsObject(ListMap[String, JsValue](
      "workorderid" -> WorkorderId.writes.writes(o.workorderid),
      "productid" -> ProductId.writes.writes(o.productid),
      "orderqty" -> Writes.IntWrites.writes(o.orderqty),
      "scrappedqty" -> TypoShort.writes.writes(o.scrappedqty),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "duedate" -> TypoLocalDateTime.writes.writes(o.duedate),
      "scrapreasonid" -> Writes.OptionWrites(ScrapreasonId.writes).writes(o.scrapreasonid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
