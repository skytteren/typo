/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: production.productcosthistory
    Changes in the cost of a product over time.
    Composite primary key: productid, startdate */
case class ProductcosthistoryRow(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product cost start date.
      Constraint CK_ProductCostHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Product cost end date.
      Constraint CK_ProductCostHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Standard cost of the product.
      Constraint CK_ProductCostHistory_StandardCost affecting columns standardcost: ((standardcost >= 0.00)) */
  standardcost: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductcosthistoryId = ProductcosthistoryId(productid, startdate)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductcosthistoryRowUnsaved =
     ProductcosthistoryRowUnsaved(productid, startdate, enddate, standardcost, modifieddate)
 }

object ProductcosthistoryRow {
  def apply(compositeId: ProductcosthistoryId, enddate: Option[TypoLocalDateTime], standardcost: BigDecimal, modifieddate: TypoLocalDateTime) =
    new ProductcosthistoryRow(compositeId.productid, compositeId.startdate, enddate, standardcost, modifieddate)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductcosthistoryRow] = new JdbcDecoder[ProductcosthistoryRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ProductcosthistoryRow) =
      columIndex + 4 ->
        ProductcosthistoryRow(
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          startdate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          enddate = JdbcDecoder.optionDecoder(TypoLocalDateTime.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          standardcost = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ProductcosthistoryRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDateTime.jsonDecoder)))
    val standardcost = jsonObj.get("standardcost").toRight("Missing field 'standardcost'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (productid.isRight && startdate.isRight && enddate.isRight && standardcost.isRight && modifieddate.isRight)
      Right(ProductcosthistoryRow(productid = productid.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, standardcost = standardcost.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productid, startdate, enddate, standardcost, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductcosthistoryRow] = new JsonEncoder[ProductcosthistoryRow] {
    override def unsafeEncode(a: ProductcosthistoryRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      JsonEncoder.option(using TypoLocalDateTime.jsonEncoder).unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""standardcost":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.standardcost, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductcosthistoryRow] = Text.instance[ProductcosthistoryRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.standardcost, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
