/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `sales.salesorderheadersalesreason` */
case class SalesorderheadersalesreasonId(salesorderid: SalesorderheaderId, salesreasonid: SalesreasonId)
object SalesorderheadersalesreasonId {
  implicit val decoder: Decoder[SalesorderheadersalesreasonId] = Decoder.forProduct2[SalesorderheadersalesreasonId, SalesorderheaderId, SalesreasonId]("salesorderid", "salesreasonid")(SalesorderheadersalesreasonId.apply)
  implicit val encoder: Encoder[SalesorderheadersalesreasonId] = Encoder.forProduct2[SalesorderheadersalesreasonId, SalesorderheaderId, SalesreasonId]("salesorderid", "salesreasonid")(x => (x.salesorderid, x.salesreasonid))
  implicit val ordering: Ordering[SalesorderheadersalesreasonId] = Ordering.by(x => (x.salesorderid, x.salesreasonid))
}
