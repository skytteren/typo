/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: production.productmodelillustration
    Cross-reference table mapping product models and illustrations.
    Composite primary key: productmodelid, illustrationid */
case class ProductmodelillustrationRow(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to Illustration.IllustrationID.
      Points to [[illustration.IllustrationRow.illustrationid]] */
  illustrationid: IllustrationId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductmodelillustrationId = ProductmodelillustrationId(productmodelid, illustrationid)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductmodelillustrationRowUnsaved =
     ProductmodelillustrationRowUnsaved(productmodelid, illustrationid, modifieddate)
 }

object ProductmodelillustrationRow {
  def apply(compositeId: ProductmodelillustrationId, modifieddate: TypoLocalDateTime) =
    new ProductmodelillustrationRow(compositeId.productmodelid, compositeId.illustrationid, modifieddate)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductmodelillustrationRow] = new JdbcDecoder[ProductmodelillustrationRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ProductmodelillustrationRow) =
      columIndex + 2 ->
        ProductmodelillustrationRow(
          productmodelid = ProductmodelId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          illustrationid = IllustrationId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ProductmodelillustrationRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productmodelid = jsonObj.get("productmodelid").toRight("Missing field 'productmodelid'").flatMap(_.as(ProductmodelId.jsonDecoder))
    val illustrationid = jsonObj.get("illustrationid").toRight("Missing field 'illustrationid'").flatMap(_.as(IllustrationId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (productmodelid.isRight && illustrationid.isRight && modifieddate.isRight)
      Right(ProductmodelillustrationRow(productmodelid = productmodelid.toOption.get, illustrationid = illustrationid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productmodelid, illustrationid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductmodelillustrationRow] = new JsonEncoder[ProductmodelillustrationRow] {
    override def unsafeEncode(a: ProductmodelillustrationRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productmodelid":""")
      ProductmodelId.jsonEncoder.unsafeEncode(a.productmodelid, indent, out)
      out.write(",")
      out.write(""""illustrationid":""")
      IllustrationId.jsonEncoder.unsafeEncode(a.illustrationid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductmodelillustrationRow] = Text.instance[ProductmodelillustrationRow]{ (row, sb) =>
    ProductmodelId.text.unsafeEncode(row.productmodelid, sb)
    sb.append(Text.DELIMETER)
    IllustrationId.text.unsafeEncode(row.illustrationid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
