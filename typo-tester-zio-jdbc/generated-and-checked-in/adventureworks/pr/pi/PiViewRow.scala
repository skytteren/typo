/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pi

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
 *View: pr.pi */
case class PiViewRow(
  /** Points to [[production.productinventory.ProductinventoryRow.productid]] */
  id: ProductId,
  /** Points to [[production.productinventory.ProductinventoryRow.productid]] */
  productid: ProductId,
  /** Points to [[production.productinventory.ProductinventoryRow.locationid]] */
  locationid: LocationId,
  /** Points to [[production.productinventory.ProductinventoryRow.shelf]] */
  shelf: /* max 10 chars */ String,
  /** Points to [[production.productinventory.ProductinventoryRow.bin]] */
  bin: TypoShort,
  /** Points to [[production.productinventory.ProductinventoryRow.quantity]] */
  quantity: TypoShort,
  /** Points to [[production.productinventory.ProductinventoryRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[production.productinventory.ProductinventoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PiViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PiViewRow] = new JdbcDecoder[PiViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PiViewRow) =
      columIndex + 7 ->
        PiViewRow(
          id = ProductId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          locationid = LocationId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          shelf = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 3, rs)._2,
          bin = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          quantity = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 7, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PiViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(ProductId.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val locationid = jsonObj.get("locationid").toRight("Missing field 'locationid'").flatMap(_.as(LocationId.jsonDecoder))
    val shelf = jsonObj.get("shelf").toRight("Missing field 'shelf'").flatMap(_.as(JsonDecoder.string))
    val bin = jsonObj.get("bin").toRight("Missing field 'bin'").flatMap(_.as(TypoShort.jsonDecoder))
    val quantity = jsonObj.get("quantity").toRight("Missing field 'quantity'").flatMap(_.as(TypoShort.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && productid.isRight && locationid.isRight && shelf.isRight && bin.isRight && quantity.isRight && rowguid.isRight && modifieddate.isRight)
      Right(PiViewRow(id = id.toOption.get, productid = productid.toOption.get, locationid = locationid.toOption.get, shelf = shelf.toOption.get, bin = bin.toOption.get, quantity = quantity.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, productid, locationid, shelf, bin, quantity, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PiViewRow] = new JsonEncoder[PiViewRow] {
    override def unsafeEncode(a: PiViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      ProductId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
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
}
