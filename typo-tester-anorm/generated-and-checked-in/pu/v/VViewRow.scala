/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package v

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VViewRow(
  id: Option[Int],
  /** Points to [[purchasing.vendor.VendorRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[purchasing.vendor.VendorRow.accountnumber]] */
  accountnumber: Option[AccountNumber],
  /** Points to [[purchasing.vendor.VendorRow.name]] */
  name: Option[Name],
  /** Points to [[purchasing.vendor.VendorRow.creditrating]] */
  creditrating: Option[Int],
  /** Points to [[purchasing.vendor.VendorRow.preferredvendorstatus]] */
  preferredvendorstatus: Flag,
  /** Points to [[purchasing.vendor.VendorRow.activeflag]] */
  activeflag: Flag,
  /** Points to [[purchasing.vendor.VendorRow.purchasingwebserviceurl]] */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  /** Points to [[purchasing.vendor.VendorRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object VViewRow {
  def rowParser(idx: Int): RowParser[VViewRow] =
    RowParser[VViewRow] { row =>
      Success(
        VViewRow(
          id = row[Option[Int]](idx + 0),
          businessentityid = row[Option[BusinessentityId]](idx + 1),
          accountnumber = row[Option[AccountNumber]](idx + 2),
          name = row[Option[Name]](idx + 3),
          creditrating = row[Option[Int]](idx + 4),
          preferredvendorstatus = row[Flag](idx + 5),
          activeflag = row[Flag](idx + 6),
          purchasingwebserviceurl = row[Option[/* max 1024 chars */ String]](idx + 7),
          modifieddate = row[Option[LocalDateTime]](idx + 8)
        )
      )
    }
  implicit val oFormat: OFormat[VViewRow] = new OFormat[VViewRow]{
    override def writes(o: VViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "accountnumber" -> o.accountnumber,
        "name" -> o.name,
        "creditrating" -> o.creditrating,
        "preferredvendorstatus" -> o.preferredvendorstatus,
        "activeflag" -> o.activeflag,
        "purchasingwebserviceurl" -> o.purchasingwebserviceurl,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[VViewRow] = {
      JsResult.fromTry(
        Try(
          VViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            accountnumber = json.\("accountnumber").toOption.map(_.as[AccountNumber]),
            name = json.\("name").toOption.map(_.as[Name]),
            creditrating = json.\("creditrating").toOption.map(_.as[Int]),
            preferredvendorstatus = json.\("preferredvendorstatus").as[Flag],
            activeflag = json.\("activeflag").as[Flag],
            purchasingwebserviceurl = json.\("purchasingwebserviceurl").toOption.map(_.as[/* max 1024 chars */ String]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
