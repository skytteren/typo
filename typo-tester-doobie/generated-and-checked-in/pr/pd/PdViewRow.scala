/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pd

import adventureworks.production.productdescription.ProductdescriptionId
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

case class PdViewRow(
  id: Option[Int],
  /** Points to [[production.productdescription.ProductdescriptionRow.productdescriptionid]] */
  productdescriptionid: Option[ProductdescriptionId],
  /** Points to [[production.productdescription.ProductdescriptionRow.description]] */
  description: Option[/* max 400 chars */ String],
  /** Points to [[production.productdescription.ProductdescriptionRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productdescription.ProductdescriptionRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PdViewRow {
  implicit val decoder: Decoder[PdViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        productdescriptionid <- c.downField("productdescriptionid").as[Option[ProductdescriptionId]]
        description <- c.downField("description").as[Option[/* max 400 chars */ String]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield PdViewRow(id, productdescriptionid, description, rowguid, modifieddate)
  implicit val encoder: Encoder[PdViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "productdescriptionid" := row.productdescriptionid,
        "description" := row.description,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[PdViewRow] =
    new Read[PdViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[ProductdescriptionId], Nullability.Nullable),
        (Get[/* max 400 chars */ String], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PdViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        productdescriptionid = Get[ProductdescriptionId].unsafeGetNullable(rs, i + 1),
        description = Get[/* max 400 chars */ String].unsafeGetNullable(rs, i + 2),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 3),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 4)
      )
    )
  

}