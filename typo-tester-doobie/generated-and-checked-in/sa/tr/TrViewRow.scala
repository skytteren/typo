/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package tr

import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import adventureworks.sales.salestaxrate.SalestaxrateId
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

case class TrViewRow(
  id: Option[Int],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.salestaxrateid]] */
  salestaxrateid: Option[SalestaxrateId],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.stateprovinceid]] */
  stateprovinceid: Option[StateprovinceId],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.taxtype]] */
  taxtype: Option[Int],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.taxrate]] */
  taxrate: Option[BigDecimal],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.name]] */
  name: Option[Name],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object TrViewRow {
  implicit val decoder: Decoder[TrViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        salestaxrateid <- c.downField("salestaxrateid").as[Option[SalestaxrateId]]
        stateprovinceid <- c.downField("stateprovinceid").as[Option[StateprovinceId]]
        taxtype <- c.downField("taxtype").as[Option[Int]]
        taxrate <- c.downField("taxrate").as[Option[BigDecimal]]
        name <- c.downField("name").as[Option[Name]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield TrViewRow(id, salestaxrateid, stateprovinceid, taxtype, taxrate, name, rowguid, modifieddate)
  implicit val encoder: Encoder[TrViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "salestaxrateid" := row.salestaxrateid,
        "stateprovinceid" := row.stateprovinceid,
        "taxtype" := row.taxtype,
        "taxrate" := row.taxrate,
        "name" := row.name,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[TrViewRow] =
    new Read[TrViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[SalestaxrateId], Nullability.Nullable),
        (Get[StateprovinceId], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => TrViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        salestaxrateid = Get[SalestaxrateId].unsafeGetNullable(rs, i + 1),
        stateprovinceid = Get[StateprovinceId].unsafeGetNullable(rs, i + 2),
        taxtype = Get[Int].unsafeGetNullable(rs, i + 3),
        taxrate = Get[BigDecimal].unsafeGetNullable(rs, i + 4),
        name = Get[Name].unsafeGetNullable(rs, i + 5),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 6),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 7)
      )
    )
  

}