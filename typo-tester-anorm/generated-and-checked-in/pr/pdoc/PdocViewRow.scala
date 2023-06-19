/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pdoc

import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PdocViewRow(
  id: Option[Int],
  /** Points to [[production.productdocument.ProductdocumentRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productdocument.ProductdocumentRow.modifieddate]] */
  modifieddate: Option[LocalDateTime],
  /** Points to [[production.productdocument.ProductdocumentRow.documentnode]] */
  documentnode: Option[DocumentId]
)

object PdocViewRow {
  val rowParser: RowParser[PdocViewRow] =
    RowParser[PdocViewRow] { row =>
      Success(
        PdocViewRow(
          id = row[Option[Int]]("id"),
          productid = row[Option[ProductId]]("productid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate"),
          documentnode = row[Option[DocumentId]]("documentnode")
        )
      )
    }
  implicit val oFormat: OFormat[PdocViewRow] = new OFormat[PdocViewRow]{
    override def writes(o: PdocViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productid" -> o.productid,
        "modifieddate" -> o.modifieddate,
        "documentnode" -> o.documentnode
      )
  
    override def reads(json: JsValue): JsResult[PdocViewRow] = {
      JsResult.fromTry(
        Try(
          PdocViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime]),
            documentnode = json.\("documentnode").toOption.map(_.as[DocumentId])
          )
        )
      )
    }
  }
}
