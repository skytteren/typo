/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.userdefined.CustomCreditcardId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: sales.creditcard
    Customer credit card information.
    Primary key: creditcardid */
case class CreditcardRow(
  /** Primary key for CreditCard records.
      Default: nextval('sales.creditcard_creditcardid_seq'::regclass) */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Credit card name. */
  cardtype: /* max 50 chars */ String,
  /** Credit card number. */
  cardnumber: /* max 25 chars */ String,
  /** Credit card expiration month. */
  expmonth: TypoShort,
  /** Credit card expiration year. */
  expyear: TypoShort,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(creditcardid: Defaulted[/* user-picked */ CustomCreditcardId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CreditcardRowUnsaved =
     CreditcardRowUnsaved(cardtype, cardnumber, expmonth, expyear, creditcardid, modifieddate)
 }

object CreditcardRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[CreditcardRow] = new JdbcDecoder[CreditcardRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, CreditcardRow) =
      columIndex + 5 ->
        CreditcardRow(
          creditcardid = CustomCreditcardId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          cardtype = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          cardnumber = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          expmonth = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          expyear = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[CreditcardRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val creditcardid = jsonObj.get("creditcardid").toRight("Missing field 'creditcardid'").flatMap(_.as(CustomCreditcardId.jsonDecoder))
    val cardtype = jsonObj.get("cardtype").toRight("Missing field 'cardtype'").flatMap(_.as(JsonDecoder.string))
    val cardnumber = jsonObj.get("cardnumber").toRight("Missing field 'cardnumber'").flatMap(_.as(JsonDecoder.string))
    val expmonth = jsonObj.get("expmonth").toRight("Missing field 'expmonth'").flatMap(_.as(TypoShort.jsonDecoder))
    val expyear = jsonObj.get("expyear").toRight("Missing field 'expyear'").flatMap(_.as(TypoShort.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (creditcardid.isRight && cardtype.isRight && cardnumber.isRight && expmonth.isRight && expyear.isRight && modifieddate.isRight)
      Right(CreditcardRow(creditcardid = creditcardid.toOption.get, cardtype = cardtype.toOption.get, cardnumber = cardnumber.toOption.get, expmonth = expmonth.toOption.get, expyear = expyear.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CreditcardRow] = new JsonEncoder[CreditcardRow] {
    override def unsafeEncode(a: CreditcardRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""creditcardid":""")
      CustomCreditcardId.jsonEncoder.unsafeEncode(a.creditcardid, indent, out)
      out.write(",")
      out.write(""""cardtype":""")
      JsonEncoder.string.unsafeEncode(a.cardtype, indent, out)
      out.write(",")
      out.write(""""cardnumber":""")
      JsonEncoder.string.unsafeEncode(a.cardnumber, indent, out)
      out.write(",")
      out.write(""""expmonth":""")
      TypoShort.jsonEncoder.unsafeEncode(a.expmonth, indent, out)
      out.write(",")
      out.write(""""expyear":""")
      TypoShort.jsonEncoder.unsafeEncode(a.expyear, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[CreditcardRow] = Text.instance[CreditcardRow]{ (row, sb) =>
    /* user-picked */ CustomCreditcardId.text.unsafeEncode(row.creditcardid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.cardtype, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.cardnumber, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.expmonth, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.expyear, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
