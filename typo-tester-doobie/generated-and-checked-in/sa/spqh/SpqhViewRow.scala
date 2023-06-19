/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package spqh

import adventureworks.person.businessentity.BusinessentityId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

case class SpqhViewRow(
  id: Option[Int],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.quotadate]] */
  quotadate: Option[LocalDateTime],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.salesquota]] */
  salesquota: Option[BigDecimal],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object SpqhViewRow {
  implicit val decoder: Decoder[SpqhViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        businessentityid <- c.downField("businessentityid").as[Option[BusinessentityId]]
        quotadate <- c.downField("quotadate").as[Option[LocalDateTime]]
        salesquota <- c.downField("salesquota").as[Option[BigDecimal]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield SpqhViewRow(id, businessentityid, quotadate, salesquota, rowguid, modifieddate)
  implicit val encoder: Encoder[SpqhViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "businessentityid" := row.businessentityid,
        "quotadate" := row.quotadate,
        "salesquota" := row.salesquota,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[SpqhViewRow] =
    new Read[SpqhViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => SpqhViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 1),
        quotadate = Get[LocalDateTime].unsafeGetNullable(rs, i + 2),
        salesquota = Get[BigDecimal].unsafeGetNullable(rs, i + 3),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 4),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 5)
      )
    )
  

}
