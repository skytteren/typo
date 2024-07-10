/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.currency.CurrencyId
import adventureworks.sales.currencyrate.CurrencyrateId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *View: sa.cr */
case class CrViewRow(
  /** Points to [[sales.currencyrate.CurrencyrateRow.currencyrateid]] */
  currencyrateid: CurrencyrateId,
  /** Points to [[sales.currencyrate.CurrencyrateRow.currencyratedate]] */
  currencyratedate: TypoLocalDateTime,
  /** Points to [[sales.currencyrate.CurrencyrateRow.fromcurrencycode]] */
  fromcurrencycode: CurrencyId,
  /** Points to [[sales.currencyrate.CurrencyrateRow.tocurrencycode]] */
  tocurrencycode: CurrencyId,
  /** Points to [[sales.currencyrate.CurrencyrateRow.averagerate]] */
  averagerate: BigDecimal,
  /** Points to [[sales.currencyrate.CurrencyrateRow.endofdayrate]] */
  endofdayrate: BigDecimal,
  /** Points to [[sales.currencyrate.CurrencyrateRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object CrViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[CrViewRow] = new JdbcDecoder[CrViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, CrViewRow) =
      columIndex + 6 ->
        CrViewRow(
          currencyrateid = CurrencyrateId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          currencyratedate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          fromcurrencycode = CurrencyId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          tocurrencycode = CurrencyId.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          averagerate = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 4, rs)._2,
          endofdayrate = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 5, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[CrViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val currencyrateid = jsonObj.get("currencyrateid").toRight("Missing field 'currencyrateid'").flatMap(_.as(CurrencyrateId.jsonDecoder))
    val currencyratedate = jsonObj.get("currencyratedate").toRight("Missing field 'currencyratedate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val fromcurrencycode = jsonObj.get("fromcurrencycode").toRight("Missing field 'fromcurrencycode'").flatMap(_.as(CurrencyId.jsonDecoder))
    val tocurrencycode = jsonObj.get("tocurrencycode").toRight("Missing field 'tocurrencycode'").flatMap(_.as(CurrencyId.jsonDecoder))
    val averagerate = jsonObj.get("averagerate").toRight("Missing field 'averagerate'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val endofdayrate = jsonObj.get("endofdayrate").toRight("Missing field 'endofdayrate'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (currencyrateid.isRight && currencyratedate.isRight && fromcurrencycode.isRight && tocurrencycode.isRight && averagerate.isRight && endofdayrate.isRight && modifieddate.isRight)
      Right(CrViewRow(currencyrateid = currencyrateid.toOption.get, currencyratedate = currencyratedate.toOption.get, fromcurrencycode = fromcurrencycode.toOption.get, tocurrencycode = tocurrencycode.toOption.get, averagerate = averagerate.toOption.get, endofdayrate = endofdayrate.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CrViewRow] = new JsonEncoder[CrViewRow] {
    override def unsafeEncode(a: CrViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""currencyrateid":""")
      CurrencyrateId.jsonEncoder.unsafeEncode(a.currencyrateid, indent, out)
      out.write(",")
      out.write(""""currencyratedate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.currencyratedate, indent, out)
      out.write(",")
      out.write(""""fromcurrencycode":""")
      CurrencyId.jsonEncoder.unsafeEncode(a.fromcurrencycode, indent, out)
      out.write(",")
      out.write(""""tocurrencycode":""")
      CurrencyId.jsonEncoder.unsafeEncode(a.tocurrencycode, indent, out)
      out.write(",")
      out.write(""""averagerate":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.averagerate, indent, out)
      out.write(",")
      out.write(""""endofdayrate":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.endofdayrate, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
