/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *Table: production.productinventory
 *
 * Product inventory information.
 *
 * Composite primary key: productid, locationid */
case class ProductinventoryRow(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Inventory location identification number. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Storage compartment within an inventory location. */
  shelf: /* max 10 chars */ String,
  /** Storage container on a shelf in an inventory location.
      Constraint CK_ProductInventory_Bin affecting columns bin: (((bin >= 0) AND (bin <= 100))) */
  bin: TypoShort,
  /** Quantity of products in the inventory location.
      Default: 0 */
  quantity: TypoShort,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductinventoryId = ProductinventoryId(productid, locationid)
   val id = compositeId
   def toUnsavedRow(quantity: Defaulted[TypoShort] = Defaulted.Provided(this.quantity), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductinventoryRowUnsaved =
     ProductinventoryRowUnsaved(productid, locationid, shelf, bin, quantity, rowguid, modifieddate)
 }

object ProductinventoryRow {
  def apply(compositeId: ProductinventoryId, shelf: /* max 10 chars */ String, bin: TypoShort, quantity: TypoShort, rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new ProductinventoryRow(compositeId.productid, compositeId.locationid, shelf, bin, quantity, rowguid, modifieddate)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductinventoryRow] = new JdbcDecoder[ProductinventoryRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ProductinventoryRow) =
      columIndex + 6 ->
        ProductinventoryRow(
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          locationid = LocationId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          shelf = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          bin = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          quantity = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ProductinventoryRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val locationid = jsonObj.get("locationid").toRight("Missing field 'locationid'").flatMap(_.as(LocationId.jsonDecoder))
    val shelf = jsonObj.get("shelf").toRight("Missing field 'shelf'").flatMap(_.as(JsonDecoder.string))
    val bin = jsonObj.get("bin").toRight("Missing field 'bin'").flatMap(_.as(TypoShort.jsonDecoder))
    val quantity = jsonObj.get("quantity").toRight("Missing field 'quantity'").flatMap(_.as(TypoShort.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (productid.isRight && locationid.isRight && shelf.isRight && bin.isRight && quantity.isRight && rowguid.isRight && modifieddate.isRight)
      Right(ProductinventoryRow(productid = productid.toOption.get, locationid = locationid.toOption.get, shelf = shelf.toOption.get, bin = bin.toOption.get, quantity = quantity.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productid, locationid, shelf, bin, quantity, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductinventoryRow] = new JsonEncoder[ProductinventoryRow] {
    override def unsafeEncode(a: ProductinventoryRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""locationid":""")
      LocationId.jsonEncoder.unsafeEncode(a.locationid, indent, out)
      out.write(",")
      out.write(""""shelf":""")
      JsonEncoder.string.unsafeEncode(a.shelf, indent, out)
      out.write(",")
      out.write(""""bin":""")
      TypoShort.jsonEncoder.unsafeEncode(a.bin, indent, out)
      out.write(",")
      out.write(""""quantity":""")
      TypoShort.jsonEncoder.unsafeEncode(a.quantity, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductinventoryRow] = Text.instance[ProductinventoryRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    LocationId.text.unsafeEncode(row.locationid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.shelf, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.bin, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.quantity, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
