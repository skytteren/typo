/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelcatalogdescription

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *View: production.vproductmodelcatalogdescription */
case class VproductmodelcatalogdescriptionViewRow(
  /** Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Points to [[productmodel.ProductmodelRow.name]] */
  name: Name,
  summary: /* nullability unknown */ Option[String],
  manufacturer: /* nullability unknown */ Option[String],
  copyright: /* nullability unknown */ Option[/* max 30 chars */ String],
  producturl: /* nullability unknown */ Option[/* max 256 chars */ String],
  warrantyperiod: /* nullability unknown */ Option[/* max 256 chars */ String],
  warrantydescription: /* nullability unknown */ Option[/* max 256 chars */ String],
  noofyears: /* nullability unknown */ Option[/* max 256 chars */ String],
  maintenancedescription: /* nullability unknown */ Option[/* max 256 chars */ String],
  wheel: /* nullability unknown */ Option[/* max 256 chars */ String],
  saddle: /* nullability unknown */ Option[/* max 256 chars */ String],
  pedal: /* nullability unknown */ Option[/* max 256 chars */ String],
  bikeframe: /* nullability unknown */ Option[String],
  crankset: /* nullability unknown */ Option[/* max 256 chars */ String],
  pictureangle: /* nullability unknown */ Option[/* max 256 chars */ String],
  picturesize: /* nullability unknown */ Option[/* max 256 chars */ String],
  productphotoid: /* nullability unknown */ Option[/* max 256 chars */ String],
  material: /* nullability unknown */ Option[/* max 256 chars */ String],
  color: /* nullability unknown */ Option[/* max 256 chars */ String],
  productline: /* nullability unknown */ Option[/* max 256 chars */ String],
  style: /* nullability unknown */ Option[/* max 256 chars */ String],
  riderexperience: /* nullability unknown */ Option[/* max 1024 chars */ String],
  /** Points to [[productmodel.ProductmodelRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VproductmodelcatalogdescriptionViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VproductmodelcatalogdescriptionViewRow] = new JdbcDecoder[VproductmodelcatalogdescriptionViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VproductmodelcatalogdescriptionViewRow) =
      columIndex + 24 ->
        VproductmodelcatalogdescriptionViewRow(
          productmodelid = ProductmodelId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          summary = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          manufacturer = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          copyright = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          producturl = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          warrantyperiod = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          warrantydescription = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          noofyears = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2,
          maintenancedescription = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 9, rs)._2,
          wheel = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 10, rs)._2,
          saddle = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 11, rs)._2,
          pedal = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 12, rs)._2,
          bikeframe = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 13, rs)._2,
          crankset = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 14, rs)._2,
          pictureangle = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 15, rs)._2,
          picturesize = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 16, rs)._2,
          productphotoid = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 17, rs)._2,
          material = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 18, rs)._2,
          color = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 19, rs)._2,
          productline = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 20, rs)._2,
          style = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 21, rs)._2,
          riderexperience = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 22, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 23, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 24, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VproductmodelcatalogdescriptionViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productmodelid = jsonObj.get("productmodelid").toRight("Missing field 'productmodelid'").flatMap(_.as(ProductmodelId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val summary = jsonObj.get("Summary").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val manufacturer = jsonObj.get("manufacturer").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val copyright = jsonObj.get("copyright").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val producturl = jsonObj.get("producturl").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val warrantyperiod = jsonObj.get("warrantyperiod").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val warrantydescription = jsonObj.get("warrantydescription").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val noofyears = jsonObj.get("noofyears").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val maintenancedescription = jsonObj.get("maintenancedescription").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val wheel = jsonObj.get("wheel").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val saddle = jsonObj.get("saddle").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val pedal = jsonObj.get("pedal").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val bikeframe = jsonObj.get("bikeframe").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val crankset = jsonObj.get("crankset").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val pictureangle = jsonObj.get("pictureangle").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val picturesize = jsonObj.get("picturesize").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val productphotoid = jsonObj.get("productphotoid").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val material = jsonObj.get("material").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val color = jsonObj.get("color").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val productline = jsonObj.get("productline").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val style = jsonObj.get("style").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val riderexperience = jsonObj.get("riderexperience").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (productmodelid.isRight && name.isRight && summary.isRight && manufacturer.isRight && copyright.isRight && producturl.isRight && warrantyperiod.isRight && warrantydescription.isRight && noofyears.isRight && maintenancedescription.isRight && wheel.isRight && saddle.isRight && pedal.isRight && bikeframe.isRight && crankset.isRight && pictureangle.isRight && picturesize.isRight && productphotoid.isRight && material.isRight && color.isRight && productline.isRight && style.isRight && riderexperience.isRight && rowguid.isRight && modifieddate.isRight)
      Right(VproductmodelcatalogdescriptionViewRow(productmodelid = productmodelid.toOption.get, name = name.toOption.get, summary = summary.toOption.get, manufacturer = manufacturer.toOption.get, copyright = copyright.toOption.get, producturl = producturl.toOption.get, warrantyperiod = warrantyperiod.toOption.get, warrantydescription = warrantydescription.toOption.get, noofyears = noofyears.toOption.get, maintenancedescription = maintenancedescription.toOption.get, wheel = wheel.toOption.get, saddle = saddle.toOption.get, pedal = pedal.toOption.get, bikeframe = bikeframe.toOption.get, crankset = crankset.toOption.get, pictureangle = pictureangle.toOption.get, picturesize = picturesize.toOption.get, productphotoid = productphotoid.toOption.get, material = material.toOption.get, color = color.toOption.get, productline = productline.toOption.get, style = style.toOption.get, riderexperience = riderexperience.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productmodelid, name, summary, manufacturer, copyright, producturl, warrantyperiod, warrantydescription, noofyears, maintenancedescription, wheel, saddle, pedal, bikeframe, crankset, pictureangle, picturesize, productphotoid, material, color, productline, style, riderexperience, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VproductmodelcatalogdescriptionViewRow] = new JsonEncoder[VproductmodelcatalogdescriptionViewRow] {
    override def unsafeEncode(a: VproductmodelcatalogdescriptionViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productmodelid":""")
      ProductmodelId.jsonEncoder.unsafeEncode(a.productmodelid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""Summary":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.summary, indent, out)
      out.write(",")
      out.write(""""manufacturer":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.manufacturer, indent, out)
      out.write(",")
      out.write(""""copyright":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.copyright, indent, out)
      out.write(",")
      out.write(""""producturl":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.producturl, indent, out)
      out.write(",")
      out.write(""""warrantyperiod":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.warrantyperiod, indent, out)
      out.write(",")
      out.write(""""warrantydescription":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.warrantydescription, indent, out)
      out.write(",")
      out.write(""""noofyears":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.noofyears, indent, out)
      out.write(",")
      out.write(""""maintenancedescription":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.maintenancedescription, indent, out)
      out.write(",")
      out.write(""""wheel":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.wheel, indent, out)
      out.write(",")
      out.write(""""saddle":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.saddle, indent, out)
      out.write(",")
      out.write(""""pedal":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.pedal, indent, out)
      out.write(",")
      out.write(""""bikeframe":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.bikeframe, indent, out)
      out.write(",")
      out.write(""""crankset":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.crankset, indent, out)
      out.write(",")
      out.write(""""pictureangle":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.pictureangle, indent, out)
      out.write(",")
      out.write(""""picturesize":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.picturesize, indent, out)
      out.write(",")
      out.write(""""productphotoid":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.productphotoid, indent, out)
      out.write(",")
      out.write(""""material":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.material, indent, out)
      out.write(",")
      out.write(""""color":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.color, indent, out)
      out.write(",")
      out.write(""""productline":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.productline, indent, out)
      out.write(",")
      out.write(""""style":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.style, indent, out)
      out.write(",")
      out.write(""""riderexperience":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.riderexperience, indent, out)
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
