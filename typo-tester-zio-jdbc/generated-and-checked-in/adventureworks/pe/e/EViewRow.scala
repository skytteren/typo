/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *View: pe.e */
case class EViewRow(
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddressid]] */
  id: Int,
  /** Points to [[person.emailaddress.EmailaddressRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddressid]] */
  emailaddressid: Int,
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[person.emailaddress.EmailaddressRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[person.emailaddress.EmailaddressRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object EViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[EViewRow] = new JdbcDecoder[EViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, EViewRow) =
      columIndex + 5 ->
        EViewRow(
          id = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 0, rs)._2,
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          emailaddressid = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 2, rs)._2,
          emailaddress = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[EViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(JsonDecoder.int))
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val emailaddressid = jsonObj.get("emailaddressid").toRight("Missing field 'emailaddressid'").flatMap(_.as(JsonDecoder.int))
    val emailaddress = jsonObj.get("emailaddress").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && businessentityid.isRight && emailaddressid.isRight && emailaddress.isRight && rowguid.isRight && modifieddate.isRight)
      Right(EViewRow(id = id.toOption.get, businessentityid = businessentityid.toOption.get, emailaddressid = emailaddressid.toOption.get, emailaddress = emailaddress.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, businessentityid, emailaddressid, emailaddress, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[EViewRow] = new JsonEncoder[EViewRow] {
    override def unsafeEncode(a: EViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      JsonEncoder.int.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""emailaddressid":""")
      JsonEncoder.int.unsafeEncode(a.emailaddressid, indent, out)
      out.write(",")
      out.write(""""emailaddress":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.emailaddress, indent, out)
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
