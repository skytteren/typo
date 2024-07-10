/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *Table: production.productcategory
 *
 * High-level product categorization.
 *
 * Primary key: productcategoryid */
case class ProductcategoryRow(
  /** Primary key for ProductCategory records.
      Default: nextval('production.productcategory_productcategoryid_seq'::regclass) */
  productcategoryid: ProductcategoryId,
  /** Category description. */
  name: Name,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = productcategoryid
   def toUnsavedRow(productcategoryid: Defaulted[ProductcategoryId], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductcategoryRowUnsaved =
     ProductcategoryRowUnsaved(name, productcategoryid, rowguid, modifieddate)
 }

object ProductcategoryRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductcategoryRow] = new JdbcDecoder[ProductcategoryRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ProductcategoryRow) =
      columIndex + 3 ->
        ProductcategoryRow(
          productcategoryid = ProductcategoryId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ProductcategoryRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productcategoryid = jsonObj.get("productcategoryid").toRight("Missing field 'productcategoryid'").flatMap(_.as(ProductcategoryId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (productcategoryid.isRight && name.isRight && rowguid.isRight && modifieddate.isRight)
      Right(ProductcategoryRow(productcategoryid = productcategoryid.toOption.get, name = name.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productcategoryid, name, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductcategoryRow] = new JsonEncoder[ProductcategoryRow] {
    override def unsafeEncode(a: ProductcategoryRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productcategoryid":""")
      ProductcategoryId.jsonEncoder.unsafeEncode(a.productcategoryid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductcategoryRow] = Text.instance[ProductcategoryRow]{ (row, sb) =>
    ProductcategoryId.text.unsafeEncode(row.productcategoryid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
