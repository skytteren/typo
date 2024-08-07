/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import adventureworks.purchasing.shipmethod.ShipmethodId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *View: pu.sm */
case class SmViewRow(
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  id: ShipmethodId,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.name]] */
  name: Name,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipbase]] */
  shipbase: BigDecimal,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shiprate]] */
  shiprate: BigDecimal,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SmViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SmViewRow] = new JdbcDecoder[SmViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SmViewRow) =
      columIndex + 6 ->
        SmViewRow(
          id = ShipmethodId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          shipmethodid = ShipmethodId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          shipbase = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 3, rs)._2,
          shiprate = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 4, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SmViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(ShipmethodId.jsonDecoder))
    val shipmethodid = jsonObj.get("shipmethodid").toRight("Missing field 'shipmethodid'").flatMap(_.as(ShipmethodId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val shipbase = jsonObj.get("shipbase").toRight("Missing field 'shipbase'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val shiprate = jsonObj.get("shiprate").toRight("Missing field 'shiprate'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && shipmethodid.isRight && name.isRight && shipbase.isRight && shiprate.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SmViewRow(id = id.toOption.get, shipmethodid = shipmethodid.toOption.get, name = name.toOption.get, shipbase = shipbase.toOption.get, shiprate = shiprate.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, shipmethodid, name, shipbase, shiprate, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SmViewRow] = new JsonEncoder[SmViewRow] {
    override def unsafeEncode(a: SmViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      ShipmethodId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""shipmethodid":""")
      ShipmethodId.jsonEncoder.unsafeEncode(a.shipmethodid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""shipbase":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.shipbase, indent, out)
      out.write(",")
      out.write(""""shiprate":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.shiprate, indent, out)
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
