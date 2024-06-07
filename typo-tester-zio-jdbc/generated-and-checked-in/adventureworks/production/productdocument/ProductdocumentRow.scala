/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: production.productdocument
    Cross-reference table mapping products to related product documents.
    Composite primary key: productid, documentnode */
case class ProductdocumentRow(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime,
  /** Document identification number. Foreign key to Document.DocumentNode.
      Default: '/'::character varying
      Points to [[document.DocumentRow.documentnode]] */
  documentnode: DocumentId
){
   val compositeId: ProductdocumentId = ProductdocumentId(productid, documentnode)
   val id = compositeId
   def toUnsavedRow(documentnode: Defaulted[DocumentId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductdocumentRowUnsaved =
     ProductdocumentRowUnsaved(productid, modifieddate, documentnode)
 }

object ProductdocumentRow {
  def apply(compositeId: ProductdocumentId, modifieddate: TypoLocalDateTime) =
    new ProductdocumentRow(compositeId.productid, modifieddate, compositeId.documentnode)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductdocumentRow] = new JdbcDecoder[ProductdocumentRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ProductdocumentRow) =
      columIndex + 2 ->
        ProductdocumentRow(
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          documentnode = DocumentId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ProductdocumentRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val documentnode = jsonObj.get("documentnode").toRight("Missing field 'documentnode'").flatMap(_.as(DocumentId.jsonDecoder))
    if (productid.isRight && modifieddate.isRight && documentnode.isRight)
      Right(ProductdocumentRow(productid = productid.toOption.get, modifieddate = modifieddate.toOption.get, documentnode = documentnode.toOption.get))
    else Left(List[Either[String, Any]](productid, modifieddate, documentnode).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductdocumentRow] = new JsonEncoder[ProductdocumentRow] {
    override def unsafeEncode(a: ProductdocumentRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write(",")
      out.write(""""documentnode":""")
      DocumentId.jsonEncoder.unsafeEncode(a.documentnode, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductdocumentRow] = Text.instance[ProductdocumentRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    sb.append(Text.DELIMETER)
    DocumentId.text.unsafeEncode(row.documentnode, sb)
  }
}
