/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

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
 *Table: person.countryregion
 *
 * Lookup table containing the ISO standard codes for countries and regions.
 *
 * Primary key: countryregioncode */
case class CountryregionRow(
  /** ISO standard code for countries and regions. */
  countryregioncode: CountryregionId,
  /** Country or region name. */
  name: Name,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = countryregioncode
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CountryregionRowUnsaved =
     CountryregionRowUnsaved(countryregioncode, name, modifieddate)
 }

object CountryregionRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[CountryregionRow] = new JdbcDecoder[CountryregionRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, CountryregionRow) =
      columIndex + 2 ->
        CountryregionRow(
          countryregioncode = CountryregionId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[CountryregionRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val countryregioncode = jsonObj.get("countryregioncode").toRight("Missing field 'countryregioncode'").flatMap(_.as(CountryregionId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (countryregioncode.isRight && name.isRight && modifieddate.isRight)
      Right(CountryregionRow(countryregioncode = countryregioncode.toOption.get, name = name.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](countryregioncode, name, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CountryregionRow] = new JsonEncoder[CountryregionRow] {
    override def unsafeEncode(a: CountryregionRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""countryregioncode":""")
      CountryregionId.jsonEncoder.unsafeEncode(a.countryregioncode, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[CountryregionRow] = Text.instance[CountryregionRow]{ (row, sb) =>
    CountryregionId.text.unsafeEncode(row.countryregioncode, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
