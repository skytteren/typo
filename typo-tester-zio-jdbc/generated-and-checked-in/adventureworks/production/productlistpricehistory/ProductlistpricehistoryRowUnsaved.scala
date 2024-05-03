/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.productlistpricehistory` which has not been persisted yet */
case class ProductlistpricehistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** List price start date.
      Constraint CK_ProductListPriceHistory_EndDate affecting columns enddate, startdate:  (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** List price end date
      Constraint CK_ProductListPriceHistory_EndDate affecting columns enddate, startdate:  (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Product list price.
      Constraint CK_ProductListPriceHistory_ListPrice affecting columns listprice:  ((listprice > 0.00)) */
  listprice: BigDecimal,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): ProductlistpricehistoryRow =
    ProductlistpricehistoryRow(
      productid = productid,
      startdate = startdate,
      enddate = enddate,
      listprice = listprice,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductlistpricehistoryRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ProductlistpricehistoryRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDateTime.jsonDecoder)))
    val listprice = jsonObj.get("listprice").toRight("Missing field 'listprice'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (productid.isRight && startdate.isRight && enddate.isRight && listprice.isRight && modifieddate.isRight)
      Right(ProductlistpricehistoryRowUnsaved(productid = productid.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, listprice = listprice.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productid, startdate, enddate, listprice, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductlistpricehistoryRowUnsaved] = new JsonEncoder[ProductlistpricehistoryRowUnsaved] {
    override def unsafeEncode(a: ProductlistpricehistoryRowUnsaved, indent: Option[Int], out: Write): Unit = {
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
      out.write(""""listprice":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.listprice, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductlistpricehistoryRowUnsaved] = Text.instance[ProductlistpricehistoryRowUnsaved]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.listprice, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
