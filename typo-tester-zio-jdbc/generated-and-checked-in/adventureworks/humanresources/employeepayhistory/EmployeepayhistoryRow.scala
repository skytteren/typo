/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: humanresources.employeepayhistory
    Employee pay history.
    Composite primary key: businessentityid, ratechangedate */
case class EmployeepayhistoryRow(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Date the change in pay is effective */
  ratechangedate: TypoLocalDateTime,
  /** Salary hourly rate.
      Constraint CK_EmployeePayHistory_Rate affecting columns rate: (((rate >= 6.50) AND (rate <= 200.00))) */
  rate: BigDecimal,
  /** 1 = Salary received monthly, 2 = Salary received biweekly
      Constraint CK_EmployeePayHistory_PayFrequency affecting columns payfrequency: ((payfrequency = ANY (ARRAY[1, 2]))) */
  payfrequency: TypoShort,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: EmployeepayhistoryId = EmployeepayhistoryId(businessentityid, ratechangedate)
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): EmployeepayhistoryRowUnsaved =
     EmployeepayhistoryRowUnsaved(businessentityid, ratechangedate, rate, payfrequency, modifieddate)
 }

object EmployeepayhistoryRow {
  def apply(compositeId: EmployeepayhistoryId, rate: BigDecimal, payfrequency: TypoShort, modifieddate: TypoLocalDateTime) =
    new EmployeepayhistoryRow(compositeId.businessentityid, compositeId.ratechangedate, rate, payfrequency, modifieddate)
  implicit lazy val jdbcDecoder: JdbcDecoder[EmployeepayhistoryRow] = new JdbcDecoder[EmployeepayhistoryRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, EmployeepayhistoryRow) =
      columIndex + 4 ->
        EmployeepayhistoryRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          ratechangedate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          rate = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 2, rs)._2,
          payfrequency = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[EmployeepayhistoryRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val ratechangedate = jsonObj.get("ratechangedate").toRight("Missing field 'ratechangedate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val rate = jsonObj.get("rate").toRight("Missing field 'rate'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val payfrequency = jsonObj.get("payfrequency").toRight("Missing field 'payfrequency'").flatMap(_.as(TypoShort.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && ratechangedate.isRight && rate.isRight && payfrequency.isRight && modifieddate.isRight)
      Right(EmployeepayhistoryRow(businessentityid = businessentityid.toOption.get, ratechangedate = ratechangedate.toOption.get, rate = rate.toOption.get, payfrequency = payfrequency.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, ratechangedate, rate, payfrequency, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[EmployeepayhistoryRow] = new JsonEncoder[EmployeepayhistoryRow] {
    override def unsafeEncode(a: EmployeepayhistoryRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""ratechangedate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.ratechangedate, indent, out)
      out.write(",")
      out.write(""""rate":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.rate, indent, out)
      out.write(",")
      out.write(""""payfrequency":""")
      TypoShort.jsonEncoder.unsafeEncode(a.payfrequency, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[EmployeepayhistoryRow] = Text.instance[EmployeepayhistoryRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.ratechangedate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.rate, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.payfrequency, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
