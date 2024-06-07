/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.userdefined.CustomCreditcardId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: sales.personcreditcard
    Cross-reference table mapping people to their credit card information in the CreditCard table.
    Composite primary key: businessentityid, creditcardid */
case class PersoncreditcardRow(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Credit card identification number. Foreign key to CreditCard.CreditCardID.
      Points to [[creditcard.CreditcardRow.creditcardid]] */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: PersoncreditcardId = PersoncreditcardId(businessentityid, creditcardid)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): PersoncreditcardRowUnsaved =
     PersoncreditcardRowUnsaved(businessentityid, creditcardid, modifieddate)
 }

object PersoncreditcardRow {
  def apply(compositeId: PersoncreditcardId, modifieddate: TypoLocalDateTime) =
    new PersoncreditcardRow(compositeId.businessentityid, compositeId.creditcardid, modifieddate)
  implicit lazy val jdbcDecoder: JdbcDecoder[PersoncreditcardRow] = new JdbcDecoder[PersoncreditcardRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PersoncreditcardRow) =
      columIndex + 2 ->
        PersoncreditcardRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          creditcardid = CustomCreditcardId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PersoncreditcardRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val creditcardid = jsonObj.get("creditcardid").toRight("Missing field 'creditcardid'").flatMap(_.as(CustomCreditcardId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && creditcardid.isRight && modifieddate.isRight)
      Right(PersoncreditcardRow(businessentityid = businessentityid.toOption.get, creditcardid = creditcardid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, creditcardid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersoncreditcardRow] = new JsonEncoder[PersoncreditcardRow] {
    override def unsafeEncode(a: PersoncreditcardRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""creditcardid":""")
      CustomCreditcardId.jsonEncoder.unsafeEncode(a.creditcardid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[PersoncreditcardRow] = Text.instance[PersoncreditcardRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    /* user-picked */ CustomCreditcardId.text.unsafeEncode(row.creditcardid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
