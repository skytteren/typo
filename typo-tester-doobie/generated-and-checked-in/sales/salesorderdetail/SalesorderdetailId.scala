/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.sales.salesorderheader.SalesorderheaderId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json

/** Type for the composite primary key of table `sales.salesorderdetail` */
case class SalesorderdetailId(salesorderid: SalesorderheaderId, salesorderdetailid: Int)
object SalesorderdetailId {
  implicit def ordering: Ordering[SalesorderdetailId] = Ordering.by(x => (x.salesorderid, x.salesorderdetailid))
  implicit val decoder: Decoder[SalesorderdetailId] =
    (c: HCursor) =>
      for {
        salesorderid <- c.downField("salesorderid").as[SalesorderheaderId]
        salesorderdetailid <- c.downField("salesorderdetailid").as[Int]
      } yield SalesorderdetailId(salesorderid, salesorderdetailid)
  implicit val encoder: Encoder[SalesorderdetailId] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "salesorderid" := row.salesorderid,
        "salesorderdetailid" := row.salesorderdetailid
      )}
}