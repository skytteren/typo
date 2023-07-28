/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.production.productcategory.ProductcategoryId
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

case class ProductsubcategoryRow(
  /** Primary key for ProductSubcategory records. */
  productsubcategoryid: ProductsubcategoryId,
  /** Product category identification number. Foreign key to ProductCategory.ProductCategoryID.
      Points to [[productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: ProductcategoryId,
  /** Subcategory description. */
  name: Name,
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object ProductsubcategoryRow {
  implicit val decoder: Decoder[ProductsubcategoryRow] =
    (c: HCursor) =>
      for {
        productsubcategoryid <- c.downField("productsubcategoryid").as[ProductsubcategoryId]
        productcategoryid <- c.downField("productcategoryid").as[ProductcategoryId]
        name <- c.downField("name").as[Name]
        rowguid <- c.downField("rowguid").as[UUID]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield ProductsubcategoryRow(productsubcategoryid, productcategoryid, name, rowguid, modifieddate)
  implicit val encoder: Encoder[ProductsubcategoryRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "productsubcategoryid" := row.productsubcategoryid,
        "productcategoryid" := row.productcategoryid,
        "name" := row.name,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[ProductsubcategoryRow] =
    new Read[ProductsubcategoryRow](
      gets = List(
        (Get[ProductsubcategoryId], Nullability.NoNulls),
        (Get[ProductcategoryId], Nullability.NoNulls),
        (Get[Name], Nullability.NoNulls),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => ProductsubcategoryRow(
        productsubcategoryid = Get[ProductsubcategoryId].unsafeGetNonNullable(rs, i + 0),
        productcategoryid = Get[ProductcategoryId].unsafeGetNonNullable(rs, i + 1),
        name = Get[Name].unsafeGetNonNullable(rs, i + 2),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 3),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 4)
      )
    )
  

}