/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *Table: sales.currency
 *
 * Lookup table containing standard ISO currencies.
 *
 * Primary key: currencycode */
case class CurrencyRow(
  /** The ISO code for the Currency. */
  currencycode: CurrencyId,
  /** Currency name. */
  name: Name,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = currencycode
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CurrencyRowUnsaved =
     CurrencyRowUnsaved(currencycode, name, modifieddate)
 }

object CurrencyRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[CurrencyRow] = new JdbcDecoder[CurrencyRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, CurrencyRow) =
      columIndex + 2 ->
        CurrencyRow(
          currencycode = CurrencyId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[CurrencyRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val currencycode = jsonObj.get("currencycode").toRight("Missing field 'currencycode'").flatMap(_.as(CurrencyId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (currencycode.isRight && name.isRight && modifieddate.isRight)
      Right(CurrencyRow(currencycode = currencycode.toOption.get, name = name.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](currencycode, name, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CurrencyRow] = new JsonEncoder[CurrencyRow] {
    override def unsafeEncode(a: CurrencyRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""currencycode":""")
      CurrencyId.jsonEncoder.unsafeEncode(a.currencycode, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[CurrencyRow] = Text.instance[CurrencyRow]{ (row, sb) =>
    CurrencyId.text.unsafeEncode(row.currencycode, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
