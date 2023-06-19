/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VsalespersonViewRow(
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
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]] */
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
  territoryname: Option[Name],
  territorygroup: Option[/* max 50 chars */ String],
  /** Points to [[salesperson.SalespersonRow.salesquota]] */
  salesquota: Option[BigDecimal],
  /** Points to [[salesperson.SalespersonRow.salesytd]] */
  salesytd: Option[BigDecimal],
  /** Points to [[salesperson.SalespersonRow.saleslastyear]] */
  saleslastyear: Option[BigDecimal]
)

object VsalespersonViewRow {
  val rowParser: RowParser[VsalespersonViewRow] =
    RowParser[VsalespersonViewRow] { row =>
      Success(
        VsalespersonViewRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          title = row[Option[/* max 8 chars */ String]]("title"),
          firstname = row[Option[Name]]("firstname"),
          middlename = row[Option[Name]]("middlename"),
          lastname = row[Option[Name]]("lastname"),
          suffix = row[Option[/* max 10 chars */ String]]("suffix"),
          jobtitle = row[Option[/* max 50 chars */ String]]("jobtitle"),
          phonenumber = row[Option[Phone]]("phonenumber"),
          phonenumbertype = row[Option[Name]]("phonenumbertype"),
          emailaddress = row[Option[/* max 50 chars */ String]]("emailaddress"),
          emailpromotion = row[Option[Int]]("emailpromotion"),
          addressline1 = row[Option[/* max 60 chars */ String]]("addressline1"),
          addressline2 = row[Option[/* max 60 chars */ String]]("addressline2"),
          city = row[Option[/* max 30 chars */ String]]("city"),
          stateprovincename = row[Option[Name]]("stateprovincename"),
          postalcode = row[Option[/* max 15 chars */ String]]("postalcode"),
          countryregionname = row[Option[Name]]("countryregionname"),
          territoryname = row[Option[Name]]("territoryname"),
          territorygroup = row[Option[/* max 50 chars */ String]]("territorygroup"),
          salesquota = row[Option[BigDecimal]]("salesquota"),
          salesytd = row[Option[BigDecimal]]("salesytd"),
          saleslastyear = row[Option[BigDecimal]]("saleslastyear")
        )
      )
    }
  implicit val oFormat: OFormat[VsalespersonViewRow] = new OFormat[VsalespersonViewRow]{
    override def writes(o: VsalespersonViewRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "title" -> o.title,
        "firstname" -> o.firstname,
        "middlename" -> o.middlename,
        "lastname" -> o.lastname,
        "suffix" -> o.suffix,
        "jobtitle" -> o.jobtitle,
        "phonenumber" -> o.phonenumber,
        "phonenumbertype" -> o.phonenumbertype,
        "emailaddress" -> o.emailaddress,
        "emailpromotion" -> o.emailpromotion,
        "addressline1" -> o.addressline1,
        "addressline2" -> o.addressline2,
        "city" -> o.city,
        "stateprovincename" -> o.stateprovincename,
        "postalcode" -> o.postalcode,
        "countryregionname" -> o.countryregionname,
        "territoryname" -> o.territoryname,
        "territorygroup" -> o.territorygroup,
        "salesquota" -> o.salesquota,
        "salesytd" -> o.salesytd,
        "saleslastyear" -> o.saleslastyear
      )
  
    override def reads(json: JsValue): JsResult[VsalespersonViewRow] = {
      JsResult.fromTry(
        Try(
          VsalespersonViewRow(
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
            territoryname = json.\("territoryname").toOption.map(_.as[Name]),
            territorygroup = json.\("territorygroup").toOption.map(_.as[/* max 50 chars */ String]),
            salesquota = json.\("salesquota").toOption.map(_.as[BigDecimal]),
            salesytd = json.\("salesytd").toOption.map(_.as[BigDecimal]),
            saleslastyear = json.\("saleslastyear").toOption.map(_.as[BigDecimal])
          )
        )
      )
    }
  }
}
