/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.Defaulted
import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.productmodelproductdescriptionculture` which has not been persisted yet */
case class ProductmodelproductdescriptioncultureRowUnsaved(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to ProductDescription.ProductDescriptionID.
      Points to [[productdescription.ProductdescriptionRow.productdescriptionid]] */
  productdescriptionid: ProductdescriptionId,
  /** Culture identification number. Foreign key to Culture.CultureID.
      Points to [[culture.CultureRow.cultureid]] */
  cultureid: CultureId,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): ProductmodelproductdescriptioncultureRow =
    ProductmodelproductdescriptioncultureRow(
      productmodelid = productmodelid,
      productdescriptionid = productdescriptionid,
      cultureid = cultureid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelproductdescriptioncultureRowUnsaved {
  implicit val oFormat: OFormat[ProductmodelproductdescriptioncultureRowUnsaved] = new OFormat[ProductmodelproductdescriptioncultureRowUnsaved]{
    override def writes(o: ProductmodelproductdescriptioncultureRowUnsaved): JsObject =
      Json.obj(
        "productmodelid" -> o.productmodelid,
        "productdescriptionid" -> o.productdescriptionid,
        "cultureid" -> o.cultureid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductmodelproductdescriptioncultureRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductmodelproductdescriptioncultureRowUnsaved(
            productmodelid = json.\("productmodelid").as[ProductmodelId],
            productdescriptionid = json.\("productdescriptionid").as[ProductdescriptionId],
            cultureid = json.\("cultureid").as[CultureId],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}