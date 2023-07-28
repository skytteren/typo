/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class VemployeeViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[employee.EmployeeRow.jobtitle]] */
  jobtitle: Option[/* max 50 chars */ String],
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  phonenumbertype: Option[Name],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Option[Int],
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.city]] */
  city: Option[/* max 30 chars */ String],
  stateprovincename: Option[Name],
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: Option[/* max 15 chars */ String],
  countryregionname: Option[Name],
  /** Points to [[person.person.PersonRow.additionalcontactinfo]] */
  additionalcontactinfo: Option[TypoXml]
)

object VemployeeViewRow {
  implicit val reads: Reads[VemployeeViewRow] = Reads[VemployeeViewRow](json => JsResult.fromTry(
      Try(
        VemployeeViewRow(
          businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
          title = json.\("title").toOption.map(_.as[/* max 8 chars */ String]),
          firstname = json.\("firstname").toOption.map(_.as[Name]),
          middlename = json.\("middlename").toOption.map(_.as[Name]),
          lastname = json.\("lastname").toOption.map(_.as[Name]),
          suffix = json.\("suffix").toOption.map(_.as[/* max 10 chars */ String]),
          jobtitle = json.\("jobtitle").toOption.map(_.as[/* max 50 chars */ String]),
          phonenumber = json.\("phonenumber").toOption.map(_.as[Phone]),
          phonenumbertype = json.\("phonenumbertype").toOption.map(_.as[Name]),
          emailaddress = json.\("emailaddress").toOption.map(_.as[/* max 50 chars */ String]),
          emailpromotion = json.\("emailpromotion").toOption.map(_.as[Int]),
          addressline1 = json.\("addressline1").toOption.map(_.as[/* max 60 chars */ String]),
          addressline2 = json.\("addressline2").toOption.map(_.as[/* max 60 chars */ String]),
          city = json.\("city").toOption.map(_.as[/* max 30 chars */ String]),
          stateprovincename = json.\("stateprovincename").toOption.map(_.as[Name]),
          postalcode = json.\("postalcode").toOption.map(_.as[/* max 15 chars */ String]),
          countryregionname = json.\("countryregionname").toOption.map(_.as[Name]),
          additionalcontactinfo = json.\("additionalcontactinfo").toOption.map(_.as[TypoXml])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VemployeeViewRow] = RowParser[VemployeeViewRow] { row =>
    Success(
      VemployeeViewRow(
        businessentityid = row[Option[BusinessentityId]](idx + 0),
        title = row[Option[/* max 8 chars */ String]](idx + 1),
        firstname = row[Option[Name]](idx + 2),
        middlename = row[Option[Name]](idx + 3),
        lastname = row[Option[Name]](idx + 4),
        suffix = row[Option[/* max 10 chars */ String]](idx + 5),
        jobtitle = row[Option[/* max 50 chars */ String]](idx + 6),
        phonenumber = row[Option[Phone]](idx + 7),
        phonenumbertype = row[Option[Name]](idx + 8),
        emailaddress = row[Option[/* max 50 chars */ String]](idx + 9),
        emailpromotion = row[Option[Int]](idx + 10),
        addressline1 = row[Option[/* max 60 chars */ String]](idx + 11),
        addressline2 = row[Option[/* max 60 chars */ String]](idx + 12),
        city = row[Option[/* max 30 chars */ String]](idx + 13),
        stateprovincename = row[Option[Name]](idx + 14),
        postalcode = row[Option[/* max 15 chars */ String]](idx + 15),
        countryregionname = row[Option[Name]](idx + 16),
        additionalcontactinfo = row[Option[TypoXml]](idx + 17)
      )
    )
  }
  implicit val writes: OWrites[VemployeeViewRow] = OWrites[VemployeeViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Json.toJson(o.businessentityid),
      "title" -> Json.toJson(o.title),
      "firstname" -> Json.toJson(o.firstname),
      "middlename" -> Json.toJson(o.middlename),
      "lastname" -> Json.toJson(o.lastname),
      "suffix" -> Json.toJson(o.suffix),
      "jobtitle" -> Json.toJson(o.jobtitle),
      "phonenumber" -> Json.toJson(o.phonenumber),
      "phonenumbertype" -> Json.toJson(o.phonenumbertype),
      "emailaddress" -> Json.toJson(o.emailaddress),
      "emailpromotion" -> Json.toJson(o.emailpromotion),
      "addressline1" -> Json.toJson(o.addressline1),
      "addressline2" -> Json.toJson(o.addressline2),
      "city" -> Json.toJson(o.city),
      "stateprovincename" -> Json.toJson(o.stateprovincename),
      "postalcode" -> Json.toJson(o.postalcode),
      "countryregionname" -> Json.toJson(o.countryregionname),
      "additionalcontactinfo" -> Json.toJson(o.additionalcontactinfo)
    ))
  )
}
