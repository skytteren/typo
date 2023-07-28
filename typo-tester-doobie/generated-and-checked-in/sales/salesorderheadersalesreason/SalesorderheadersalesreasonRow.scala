/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.TypoLocalDateTime
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class SalesorderheadersalesreasonRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. Foreign key to SalesReason.SalesReasonID.
      Points to [[salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderheadersalesreasonId = SalesorderheadersalesreasonId(salesorderid, salesreasonid)
 }

object SalesorderheadersalesreasonRow {
  implicit val decoder: Decoder[SalesorderheadersalesreasonRow] = Decoder.forProduct3[SalesorderheadersalesreasonRow, SalesorderheaderId, SalesreasonId, TypoLocalDateTime]("salesorderid", "salesreasonid", "modifieddate")(SalesorderheadersalesreasonRow.apply)
  implicit val encoder: Encoder[SalesorderheadersalesreasonRow] = Encoder.forProduct3[SalesorderheadersalesreasonRow, SalesorderheaderId, SalesreasonId, TypoLocalDateTime]("salesorderid", "salesreasonid", "modifieddate")(x => (x.salesorderid, x.salesreasonid, x.modifieddate))
  implicit val read: Read[SalesorderheadersalesreasonRow] = new Read[SalesorderheadersalesreasonRow](
    gets = List(
      (Get[SalesorderheaderId], Nullability.NoNulls),
      (Get[SalesreasonId], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesorderheadersalesreasonRow(
      salesorderid = Get[SalesorderheaderId].unsafeGetNonNullable(rs, i + 0),
      salesreasonid = Get[SalesreasonId].unsafeGetNonNullable(rs, i + 1),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 2)
    )
  )
}
