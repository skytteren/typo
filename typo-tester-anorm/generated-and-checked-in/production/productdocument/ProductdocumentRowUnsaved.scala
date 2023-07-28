/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.Defaulted
import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.productdocument` which has not been persisted yet */
case class ProductdocumentRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault,
  /** Default: '/'::character varying
      Document identification number. Foreign key to Document.DocumentNode.
      Points to [[document.DocumentRow.documentnode]] */
  documentnode: Defaulted[DocumentId] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime, documentnodeDefault: => DocumentId): ProductdocumentRow =
    ProductdocumentRow(
      productid = productid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     },
      documentnode = documentnode match {
                       case Defaulted.UseDefault => documentnodeDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductdocumentRowUnsaved {
  implicit val oFormat: OFormat[ProductdocumentRowUnsaved] = new OFormat[ProductdocumentRowUnsaved]{
    override def writes(o: ProductdocumentRowUnsaved): JsObject =
      Json.obj(
        "productid" -> o.productid,
        "modifieddate" -> o.modifieddate,
        "documentnode" -> o.documentnode
      )
  
    override def reads(json: JsValue): JsResult[ProductdocumentRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductdocumentRowUnsaved(
            productid = json.\("productid").as[ProductId],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]],
            documentnode = json.\("documentnode").as[Defaulted[DocumentId]]
          )
        )
      )
    }
  }
}