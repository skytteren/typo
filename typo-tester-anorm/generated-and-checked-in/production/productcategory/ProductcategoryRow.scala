/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ProductcategoryRow(
  /** Primary key for ProductCategory records. */
  productcategoryid: ProductcategoryId,
  /** Category description. */
  name: Name,
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object ProductcategoryRow {
  val rowParser: RowParser[ProductcategoryRow] =
    RowParser[ProductcategoryRow] { row =>
      Success(
        ProductcategoryRow(
          productcategoryid = row[ProductcategoryId]("productcategoryid"),
          name = row[Name]("name"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[ProductcategoryRow] = new OFormat[ProductcategoryRow]{
    override def writes(o: ProductcategoryRow): JsObject =
      Json.obj(
        "productcategoryid" -> o.productcategoryid,
        "name" -> o.name,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductcategoryRow] = {
      JsResult.fromTry(
        Try(
          ProductcategoryRow(
            productcategoryid = json.\("productcategoryid").as[ProductcategoryId],
            name = json.\("name").as[Name],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
