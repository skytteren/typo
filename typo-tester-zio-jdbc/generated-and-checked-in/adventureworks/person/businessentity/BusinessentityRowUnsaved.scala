/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `person.businessentity` which has not been persisted yet */
case class BusinessentityRowUnsaved(
  /** Default: nextval('person.businessentity_businessentityid_seq'::regclass)
      Primary key for all customers, vendors, and employees. */
  businessentityid: Defaulted[BusinessentityId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(businessentityidDefault: => BusinessentityId, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): BusinessentityRow =
    BusinessentityRow(
      businessentityid = businessentityid match {
                           case Defaulted.UseDefault => businessentityidDefault
                           case Defaulted.Provided(value) => value
                         },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BusinessentityRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[BusinessentityRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(Defaulted.jsonDecoder(BusinessentityId.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (businessentityid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(BusinessentityRowUnsaved(businessentityid = businessentityid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[BusinessentityRowUnsaved] = new JsonEncoder[BusinessentityRowUnsaved] {
    override def unsafeEncode(a: BusinessentityRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      Defaulted.jsonEncoder(BusinessentityId.jsonEncoder).unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}