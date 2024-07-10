/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import adventureworks.userdefined.FirstName
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *View: sales.vstorewithcontacts */
case class VstorewithcontactsViewRow(
  /** Points to [[store.StoreRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[store.StoreRow.name]] */
  name: Name,
  /** Points to [[person.contacttype.ContacttypeRow.name]] */
  contacttype: Name,
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Name,
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  /** Points to [[person.phonenumbertype.PhonenumbertypeRow.name]] */
  phonenumbertype: Option[Name],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Int
)

object VstorewithcontactsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VstorewithcontactsViewRow] = new JdbcDecoder[VstorewithcontactsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VstorewithcontactsViewRow) =
      columIndex + 11 ->
        VstorewithcontactsViewRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          contacttype = Name.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          title = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          firstname = FirstName.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          middlename = JdbcDecoder.optionDecoder(Name.jdbcDecoder).unsafeDecode(columIndex + 5, rs)._2,
          lastname = Name.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2,
          suffix = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          phonenumber = JdbcDecoder.optionDecoder(Phone.jdbcDecoder).unsafeDecode(columIndex + 8, rs)._2,
          phonenumbertype = JdbcDecoder.optionDecoder(Name.jdbcDecoder).unsafeDecode(columIndex + 9, rs)._2,
          emailaddress = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 10, rs)._2,
          emailpromotion = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 11, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VstorewithcontactsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val contacttype = jsonObj.get("contacttype").toRight("Missing field 'contacttype'").flatMap(_.as(Name.jsonDecoder))
    val title = jsonObj.get("title").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val firstname = jsonObj.get("firstname").toRight("Missing field 'firstname'").flatMap(_.as(FirstName.jsonDecoder))
    val middlename = jsonObj.get("middlename").fold[Either[String, Option[Name]]](Right(None))(_.as(JsonDecoder.option(using Name.jsonDecoder)))
    val lastname = jsonObj.get("lastname").toRight("Missing field 'lastname'").flatMap(_.as(Name.jsonDecoder))
    val suffix = jsonObj.get("suffix").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val phonenumber = jsonObj.get("phonenumber").fold[Either[String, Option[Phone]]](Right(None))(_.as(JsonDecoder.option(using Phone.jsonDecoder)))
    val phonenumbertype = jsonObj.get("phonenumbertype").fold[Either[String, Option[Name]]](Right(None))(_.as(JsonDecoder.option(using Name.jsonDecoder)))
    val emailaddress = jsonObj.get("emailaddress").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val emailpromotion = jsonObj.get("emailpromotion").toRight("Missing field 'emailpromotion'").flatMap(_.as(JsonDecoder.int))
    if (businessentityid.isRight && name.isRight && contacttype.isRight && title.isRight && firstname.isRight && middlename.isRight && lastname.isRight && suffix.isRight && phonenumber.isRight && phonenumbertype.isRight && emailaddress.isRight && emailpromotion.isRight)
      Right(VstorewithcontactsViewRow(businessentityid = businessentityid.toOption.get, name = name.toOption.get, contacttype = contacttype.toOption.get, title = title.toOption.get, firstname = firstname.toOption.get, middlename = middlename.toOption.get, lastname = lastname.toOption.get, suffix = suffix.toOption.get, phonenumber = phonenumber.toOption.get, phonenumbertype = phonenumbertype.toOption.get, emailaddress = emailaddress.toOption.get, emailpromotion = emailpromotion.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, name, contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VstorewithcontactsViewRow] = new JsonEncoder[VstorewithcontactsViewRow] {
    override def unsafeEncode(a: VstorewithcontactsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""contacttype":""")
      Name.jsonEncoder.unsafeEncode(a.contacttype, indent, out)
      out.write(",")
      out.write(""""title":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.title, indent, out)
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
      out.write(""""suffix":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.suffix, indent, out)
      out.write(",")
      out.write(""""phonenumber":""")
      JsonEncoder.option(using Phone.jsonEncoder).unsafeEncode(a.phonenumber, indent, out)
      out.write(",")
      out.write(""""phonenumbertype":""")
      JsonEncoder.option(using Name.jsonEncoder).unsafeEncode(a.phonenumbertype, indent, out)
      out.write(",")
      out.write(""""emailaddress":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.emailaddress, indent, out)
      out.write(",")
      out.write(""""emailpromotion":""")
      JsonEncoder.int.unsafeEncode(a.emailpromotion, indent, out)
      out.write("}")
    }
  }
}
