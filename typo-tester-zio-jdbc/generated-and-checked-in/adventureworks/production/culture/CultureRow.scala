/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: production.culture
    Lookup table containing the languages in which some AdventureWorks data is stored.
    Primary key: cultureid */
case class CultureRow(
  /** Primary key for Culture records. */
  cultureid: CultureId,
  /** Culture description. */
  name: Name,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CultureRowUnsaved =
     CultureRowUnsaved(cultureid, name, modifieddate)
 }

object CultureRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[CultureRow] = new JdbcDecoder[CultureRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, CultureRow) =
      columIndex + 2 ->
        CultureRow(
          cultureid = CultureId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[CultureRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val cultureid = jsonObj.get("cultureid").toRight("Missing field 'cultureid'").flatMap(_.as(CultureId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (cultureid.isRight && name.isRight && modifieddate.isRight)
      Right(CultureRow(cultureid = cultureid.toOption.get, name = name.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](cultureid, name, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CultureRow] = new JsonEncoder[CultureRow] {
    override def unsafeEncode(a: CultureRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""cultureid":""")
      CultureId.jsonEncoder.unsafeEncode(a.cultureid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[CultureRow] = Text.instance[CultureRow]{ (row, sb) =>
    CultureId.text.unsafeEncode(row.cultureid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
