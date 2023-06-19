/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class ProductmodelillustrationRow(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to Illustration.IllustrationID.
      Points to [[illustration.IllustrationRow.illustrationid]] */
  illustrationid: IllustrationId,
  modifieddate: LocalDateTime
){
   val compositeId: ProductmodelillustrationId = ProductmodelillustrationId(productmodelid, illustrationid)
 }

object ProductmodelillustrationRow {
  implicit val decoder: Decoder[ProductmodelillustrationRow] =
    (c: HCursor) =>
      for {
        productmodelid <- c.downField("productmodelid").as[ProductmodelId]
        illustrationid <- c.downField("illustrationid").as[IllustrationId]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield ProductmodelillustrationRow(productmodelid, illustrationid, modifieddate)
  implicit val encoder: Encoder[ProductmodelillustrationRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "productmodelid" := row.productmodelid,
        "illustrationid" := row.illustrationid,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[ProductmodelillustrationRow] =
    new Read[ProductmodelillustrationRow](
      gets = List(
        (Get[ProductmodelId], Nullability.NoNulls),
        (Get[IllustrationId], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => ProductmodelillustrationRow(
        productmodelid = Get[ProductmodelId].unsafeGetNonNullable(rs, i + 0),
        illustrationid = Get[IllustrationId].unsafeGetNonNullable(rs, i + 1),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 2)
      )
    )
  

}
