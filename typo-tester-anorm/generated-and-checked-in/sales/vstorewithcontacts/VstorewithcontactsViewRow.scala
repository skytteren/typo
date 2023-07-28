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
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VstorewithcontactsViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.contacttype.ContacttypeRow.name]] */
  name: Option[Name],
  contacttype: Option[Name],
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
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  phonenumbertype: Option[Name],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Option[Int]
)

object VstorewithcontactsViewRow {
  def rowParser(idx: Int): RowParser[VstorewithcontactsViewRow] =
    RowParser[VstorewithcontactsViewRow] { row =>
      Success(
        VstorewithcontactsViewRow(
          businessentityid = row[Option[BusinessentityId]](idx + 0),
          name = row[Option[Name]](idx + 1),
          contacttype = row[Option[Name]](idx + 2),
          title = row[Option[/* max 8 chars */ String]](idx + 3),
          firstname = row[Option[Name]](idx + 4),
          middlename = row[Option[Name]](idx + 5),
          lastname = row[Option[Name]](idx + 6),
          suffix = row[Option[/* max 10 chars */ String]](idx + 7),
          phonenumber = row[Option[Phone]](idx + 8),
          phonenumbertype = row[Option[Name]](idx + 9),
          emailaddress = row[Option[/* max 50 chars */ String]](idx + 10),
          emailpromotion = row[Option[Int]](idx + 11)
        )
      )
    }
  implicit val oFormat: OFormat[VstorewithcontactsViewRow] = new OFormat[VstorewithcontactsViewRow]{
    override def writes(o: VstorewithcontactsViewRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "name" -> o.name,
        "contacttype" -> o.contacttype,
        "title" -> o.title,
        "firstname" -> o.firstname,
        "middlename" -> o.middlename,
        "lastname" -> o.lastname,
        "suffix" -> o.suffix,
        "phonenumber" -> o.phonenumber,
        "phonenumbertype" -> o.phonenumbertype,
        "emailaddress" -> o.emailaddress,
        "emailpromotion" -> o.emailpromotion
      )
  
    override def reads(json: JsValue): JsResult[VstorewithcontactsViewRow] = {
      JsResult.fromTry(
        Try(
          VstorewithcontactsViewRow(
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            name = json.\("name").toOption.map(_.as[Name]),
            contacttype = json.\("contacttype").toOption.map(_.as[Name]),
            title = json.\("title").toOption.map(_.as[/* max 8 chars */ String]),
            firstname = json.\("firstname").toOption.map(_.as[Name]),
            middlename = json.\("middlename").toOption.map(_.as[Name]),
            lastname = json.\("lastname").toOption.map(_.as[Name]),
            suffix = json.\("suffix").toOption.map(_.as[/* max 10 chars */ String]),
            phonenumber = json.\("phonenumber").toOption.map(_.as[Phone]),
            phonenumbertype = json.\("phonenumbertype").toOption.map(_.as[Name]),
            emailaddress = json.\("emailaddress").toOption.map(_.as[/* max 50 chars */ String]),
            emailpromotion = json.\("emailpromotion").toOption.map(_.as[Int])
          )
        )
      )
    }
  }
}