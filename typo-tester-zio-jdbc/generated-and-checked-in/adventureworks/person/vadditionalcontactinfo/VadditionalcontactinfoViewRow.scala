/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vadditionalcontactinfo

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.userdefined.FirstName
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *View: person.vadditionalcontactinfo */
case class VadditionalcontactinfoViewRow(
  /** Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.PersonRow.lastname]] */
  lastname: Name,
  telephonenumber: /* nullability unknown */ Option[TypoXml],
  telephonespecialinstructions: /* nullability unknown */ Option[String],
  street: /* nullability unknown */ Option[TypoXml],
  city: /* nullability unknown */ Option[TypoXml],
  stateprovince: /* nullability unknown */ Option[TypoXml],
  postalcode: /* nullability unknown */ Option[TypoXml],
  countryregion: /* nullability unknown */ Option[TypoXml],
  homeaddressspecialinstructions: /* nullability unknown */ Option[TypoXml],
  emailaddress: /* nullability unknown */ Option[TypoXml],
  emailspecialinstructions: /* nullability unknown */ Option[String],
  emailtelephonenumber: /* nullability unknown */ Option[TypoXml],
  /** Points to [[person.PersonRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[person.PersonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VadditionalcontactinfoViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VadditionalcontactinfoViewRow] = new JdbcDecoder[VadditionalcontactinfoViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VadditionalcontactinfoViewRow) =
      columIndex + 16 ->
        VadditionalcontactinfoViewRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          firstname = FirstName.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          middlename = JdbcDecoder.optionDecoder(Name.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          lastname = Name.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          telephonenumber = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 4, rs)._2,
          telephonespecialinstructions = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          street = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 6, rs)._2,
          city = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 7, rs)._2,
          stateprovince = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 8, rs)._2,
          postalcode = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 9, rs)._2,
          countryregion = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 10, rs)._2,
          homeaddressspecialinstructions = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 11, rs)._2,
          emailaddress = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 12, rs)._2,
          emailspecialinstructions = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 13, rs)._2,
          emailtelephonenumber = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 14, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 15, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 16, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VadditionalcontactinfoViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val firstname = jsonObj.get("firstname").toRight("Missing field 'firstname'").flatMap(_.as(FirstName.jsonDecoder))
    val middlename = jsonObj.get("middlename").fold[Either[String, Option[Name]]](Right(None))(_.as(JsonDecoder.option(using Name.jsonDecoder)))
    val lastname = jsonObj.get("lastname").toRight("Missing field 'lastname'").flatMap(_.as(Name.jsonDecoder))
    val telephonenumber = jsonObj.get("telephonenumber").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val telephonespecialinstructions = jsonObj.get("telephonespecialinstructions").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val street = jsonObj.get("street").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val city = jsonObj.get("city").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val stateprovince = jsonObj.get("stateprovince").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val postalcode = jsonObj.get("postalcode").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val countryregion = jsonObj.get("countryregion").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val homeaddressspecialinstructions = jsonObj.get("homeaddressspecialinstructions").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val emailaddress = jsonObj.get("emailaddress").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val emailspecialinstructions = jsonObj.get("emailspecialinstructions").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val emailtelephonenumber = jsonObj.get("emailtelephonenumber").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && firstname.isRight && middlename.isRight && lastname.isRight && telephonenumber.isRight && telephonespecialinstructions.isRight && street.isRight && city.isRight && stateprovince.isRight && postalcode.isRight && countryregion.isRight && homeaddressspecialinstructions.isRight && emailaddress.isRight && emailspecialinstructions.isRight && emailtelephonenumber.isRight && rowguid.isRight && modifieddate.isRight)
      Right(VadditionalcontactinfoViewRow(businessentityid = businessentityid.toOption.get, firstname = firstname.toOption.get, middlename = middlename.toOption.get, lastname = lastname.toOption.get, telephonenumber = telephonenumber.toOption.get, telephonespecialinstructions = telephonespecialinstructions.toOption.get, street = street.toOption.get, city = city.toOption.get, stateprovince = stateprovince.toOption.get, postalcode = postalcode.toOption.get, countryregion = countryregion.toOption.get, homeaddressspecialinstructions = homeaddressspecialinstructions.toOption.get, emailaddress = emailaddress.toOption.get, emailspecialinstructions = emailspecialinstructions.toOption.get, emailtelephonenumber = emailtelephonenumber.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, firstname, middlename, lastname, telephonenumber, telephonespecialinstructions, street, city, stateprovince, postalcode, countryregion, homeaddressspecialinstructions, emailaddress, emailspecialinstructions, emailtelephonenumber, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VadditionalcontactinfoViewRow] = new JsonEncoder[VadditionalcontactinfoViewRow] {
    override def unsafeEncode(a: VadditionalcontactinfoViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""firstname":""")
      FirstName.jsonEncoder.unsafeEncode(a.firstname, indent, out)
      out.write(",")
      out.write(""""middlename":""")
      JsonEncoder.option(using Name.jsonEncoder).unsafeEncode(a.middlename, indent, out)
      out.write(",")
      out.write(""""lastname":""")
      Name.jsonEncoder.unsafeEncode(a.lastname, indent, out)
      out.write(",")
      out.write(""""telephonenumber":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.telephonenumber, indent, out)
      out.write(",")
      out.write(""""telephonespecialinstructions":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.telephonespecialinstructions, indent, out)
      out.write(",")
      out.write(""""street":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.street, indent, out)
      out.write(",")
      out.write(""""city":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.city, indent, out)
      out.write(",")
      out.write(""""stateprovince":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.stateprovince, indent, out)
      out.write(",")
      out.write(""""postalcode":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.postalcode, indent, out)
      out.write(",")
      out.write(""""countryregion":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.countryregion, indent, out)
      out.write(",")
      out.write(""""homeaddressspecialinstructions":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.homeaddressspecialinstructions, indent, out)
      out.write(",")
      out.write(""""emailaddress":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.emailaddress, indent, out)
      out.write(",")
      out.write(""""emailspecialinstructions":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.emailspecialinstructions, indent, out)
      out.write(",")
      out.write(""""emailtelephonenumber":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.emailtelephonenumber, indent, out)
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
