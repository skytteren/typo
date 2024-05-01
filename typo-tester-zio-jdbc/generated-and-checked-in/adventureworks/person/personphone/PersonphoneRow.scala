/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: person.personphone
    Telephone number and type of a person.
    Composite primary key: businessentityid, phonenumber, phonenumbertypeid */
case class PersonphoneRow(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Telephone number identification number. */
  phonenumber: Phone,
  /** Kind of phone number. Foreign key to PhoneNumberType.PhoneNumberTypeID.
      Points to [[phonenumbertype.PhonenumbertypeRow.phonenumbertypeid]] */
  phonenumbertypeid: PhonenumbertypeId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: PersonphoneId = PersonphoneId(businessentityid, phonenumber, phonenumbertypeid)
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): PersonphoneRowUnsaved =
     PersonphoneRowUnsaved(businessentityid, phonenumber, phonenumbertypeid, modifieddate)
 }

object PersonphoneRow {
  def apply(compositeId: PersonphoneId, modifieddate: TypoLocalDateTime) =
    new PersonphoneRow(compositeId.businessentityid, compositeId.phonenumber, compositeId.phonenumbertypeid, modifieddate)
  implicit lazy val jdbcDecoder: JdbcDecoder[PersonphoneRow] = new JdbcDecoder[PersonphoneRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PersonphoneRow) =
      columIndex + 3 ->
        PersonphoneRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          phonenumber = Phone.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          phonenumbertypeid = PhonenumbertypeId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PersonphoneRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val phonenumber = jsonObj.get("phonenumber").toRight("Missing field 'phonenumber'").flatMap(_.as(Phone.jsonDecoder))
    val phonenumbertypeid = jsonObj.get("phonenumbertypeid").toRight("Missing field 'phonenumbertypeid'").flatMap(_.as(PhonenumbertypeId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && phonenumber.isRight && phonenumbertypeid.isRight && modifieddate.isRight)
      Right(PersonphoneRow(businessentityid = businessentityid.toOption.get, phonenumber = phonenumber.toOption.get, phonenumbertypeid = phonenumbertypeid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, phonenumber, phonenumbertypeid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonphoneRow] = new JsonEncoder[PersonphoneRow] {
    override def unsafeEncode(a: PersonphoneRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""phonenumber":""")
      Phone.jsonEncoder.unsafeEncode(a.phonenumber, indent, out)
      out.write(",")
      out.write(""""phonenumbertypeid":""")
      PhonenumbertypeId.jsonEncoder.unsafeEncode(a.phonenumbertypeid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[PersonphoneRow] = Text.instance[PersonphoneRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Phone.text.unsafeEncode(row.phonenumber, sb)
    sb.append(Text.DELIMETER)
    PhonenumbertypeId.text.unsafeEncode(row.phonenumbertypeid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
