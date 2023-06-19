/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import adventureworks.TypoXml
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
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

case class PmViewRow(
  id: Option[Int],
  /** Points to [[production.productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.productmodel.ProductmodelRow.name]] */
  name: Option[Name],
  /** Points to [[production.productmodel.ProductmodelRow.catalogdescription]] */
  catalogdescription: Option[TypoXml],
  /** Points to [[production.productmodel.ProductmodelRow.instructions]] */
  instructions: Option[TypoXml],
  /** Points to [[production.productmodel.ProductmodelRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PmViewRow {
  implicit val decoder: Decoder[PmViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        productmodelid <- c.downField("productmodelid").as[Option[ProductmodelId]]
        name <- c.downField("name").as[Option[Name]]
        catalogdescription <- c.downField("catalogdescription").as[Option[TypoXml]]
        instructions <- c.downField("instructions").as[Option[TypoXml]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield PmViewRow(id, productmodelid, name, catalogdescription, instructions, rowguid, modifieddate)
  implicit val encoder: Encoder[PmViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "productmodelid" := row.productmodelid,
        "name" := row.name,
        "catalogdescription" := row.catalogdescription,
        "instructions" := row.instructions,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[PmViewRow] =
    new Read[PmViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[ProductmodelId], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[TypoXml], Nullability.Nullable),
        (Get[TypoXml], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PmViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        productmodelid = Get[ProductmodelId].unsafeGetNullable(rs, i + 1),
        name = Get[Name].unsafeGetNullable(rs, i + 2),
        catalogdescription = Get[TypoXml].unsafeGetNullable(rs, i + 3),
        instructions = Get[TypoXml].unsafeGetNullable(rs, i + 4),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 5),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 6)
      )
    )
  

}
