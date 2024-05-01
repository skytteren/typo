/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import adventureworks.userdefined.FirstName
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: person.person
    Human beings involved with AdventureWorks: employees, customer contacts, and vendor contacts.
    Primary key: businessentityid */
case class PersonRow(
  /** Primary key for Person records.
      Points to [[businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary type of person: SC = Store Contact, IN = Individual (retail) customer, SP = Sales person, EM = Employee (non-sales), VC = Vendor contact, GC = General contact
      Constraint CK_Person_PersonType affecting columns persontype: (((persontype IS NULL) OR (upper((persontype)::text) = ANY (ARRAY['SC'::text, 'VC'::text, 'IN'::text, 'EM'::text, 'SP'::text, 'GC'::text])))) */
  persontype: /* bpchar, max 2 chars */ String,
  /** 0 = The data in FirstName and LastName are stored in western style (first name, last name) order.  1 = Eastern style (last name, first name) order.
      Default: false */
  namestyle: NameStyle,
  /** A courtesy title. For example, Mr. or Ms. */
  title: Option[/* max 8 chars */ String],
  /** First name of the person. */
  firstname: /* user-picked */ FirstName,
  /** Middle name or middle initial of the person. */
  middlename: Option[Name],
  /** Last name of the person. */
  lastname: Name,
  /** Surname suffix. For example, Sr. or Jr. */
  suffix: Option[/* max 10 chars */ String],
  /** 0 = Contact does not wish to receive e-mail promotions, 1 = Contact does wish to receive e-mail promotions from AdventureWorks, 2 = Contact does wish to receive e-mail promotions from AdventureWorks and selected partners.
      Default: 0
      Constraint CK_Person_EmailPromotion affecting columns emailpromotion: (((emailpromotion >= 0) AND (emailpromotion <= 2))) */
  emailpromotion: Int,
  /** Additional contact information about the person stored in xml format. */
  additionalcontactinfo: Option[TypoXml],
  /** Personal information such as hobbies, and income collected from online shoppers. Used for sales analysis. */
  demographics: Option[TypoXml],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(namestyle: Defaulted[NameStyle] = Defaulted.Provided(this.namestyle), emailpromotion: Defaulted[Int] = Defaulted.Provided(this.emailpromotion), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): PersonRowUnsaved =
     PersonRowUnsaved(businessentityid, persontype, title, firstname, middlename, lastname, suffix, additionalcontactinfo, demographics, namestyle, emailpromotion, rowguid, modifieddate)
 }

object PersonRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PersonRow] = new JdbcDecoder[PersonRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PersonRow) =
      columIndex + 12 ->
        PersonRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          persontype = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          namestyle = NameStyle.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          title = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          firstname = FirstName.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          middlename = JdbcDecoder.optionDecoder(Name.jdbcDecoder).unsafeDecode(columIndex + 5, rs)._2,
          lastname = Name.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2,
          suffix = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          emailpromotion = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 8, rs)._2,
          additionalcontactinfo = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 9, rs)._2,
          demographics = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 10, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 11, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 12, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PersonRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val persontype = jsonObj.get("persontype").toRight("Missing field 'persontype'").flatMap(_.as(JsonDecoder.string))
    val namestyle = jsonObj.get("namestyle").toRight("Missing field 'namestyle'").flatMap(_.as(NameStyle.jsonDecoder))
    val title = jsonObj.get("title").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val firstname = jsonObj.get("firstname").toRight("Missing field 'firstname'").flatMap(_.as(FirstName.jsonDecoder))
    val middlename = jsonObj.get("middlename").fold[Either[String, Option[Name]]](Right(None))(_.as(JsonDecoder.option(using Name.jsonDecoder)))
    val lastname = jsonObj.get("lastname").toRight("Missing field 'lastname'").flatMap(_.as(Name.jsonDecoder))
    val suffix = jsonObj.get("suffix").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val emailpromotion = jsonObj.get("emailpromotion").toRight("Missing field 'emailpromotion'").flatMap(_.as(JsonDecoder.int))
    val additionalcontactinfo = jsonObj.get("additionalcontactinfo").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val demographics = jsonObj.get("demographics").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && persontype.isRight && namestyle.isRight && title.isRight && firstname.isRight && middlename.isRight && lastname.isRight && suffix.isRight && emailpromotion.isRight && additionalcontactinfo.isRight && demographics.isRight && rowguid.isRight && modifieddate.isRight)
      Right(PersonRow(businessentityid = businessentityid.toOption.get, persontype = persontype.toOption.get, namestyle = namestyle.toOption.get, title = title.toOption.get, firstname = firstname.toOption.get, middlename = middlename.toOption.get, lastname = lastname.toOption.get, suffix = suffix.toOption.get, emailpromotion = emailpromotion.toOption.get, additionalcontactinfo = additionalcontactinfo.toOption.get, demographics = demographics.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonRow] = new JsonEncoder[PersonRow] {
    override def unsafeEncode(a: PersonRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""persontype":""")
      JsonEncoder.string.unsafeEncode(a.persontype, indent, out)
      out.write(",")
      out.write(""""namestyle":""")
      NameStyle.jsonEncoder.unsafeEncode(a.namestyle, indent, out)
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
      out.write(""""emailpromotion":""")
      JsonEncoder.int.unsafeEncode(a.emailpromotion, indent, out)
      out.write(",")
      out.write(""""additionalcontactinfo":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.additionalcontactinfo, indent, out)
      out.write(",")
      out.write(""""demographics":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.demographics, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[PersonRow] = Text.instance[PersonRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.persontype, sb)
    sb.append(Text.DELIMETER)
    NameStyle.text.unsafeEncode(row.namestyle, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.title, sb)
    sb.append(Text.DELIMETER)
    /* user-picked */ FirstName.text.unsafeEncode(row.firstname, sb)
    sb.append(Text.DELIMETER)
    Text.option(Name.text).unsafeEncode(row.middlename, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.lastname, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.suffix, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.emailpromotion, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.additionalcontactinfo, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.demographics, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
