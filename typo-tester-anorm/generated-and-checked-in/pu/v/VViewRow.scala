/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package v

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
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
  modifieddate: Option[TypoLocalDateTime]
)

object VViewRow {
  implicit val reads: Reads[VViewRow] = Reads[VViewRow](json => JsResult.fromTry(
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
          modifieddate = json.\("modifieddate").toOption.map(_.as[TypoLocalDateTime])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VViewRow] = RowParser[VViewRow] { row =>
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
        modifieddate = row[Option[TypoLocalDateTime]](idx + 8)
      )
    )
  }
  implicit val writes: OWrites[VViewRow] = OWrites[VViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Json.toJson(o.id),
      "businessentityid" -> Json.toJson(o.businessentityid),
      "accountnumber" -> Json.toJson(o.accountnumber),
      "name" -> Json.toJson(o.name),
      "creditrating" -> Json.toJson(o.creditrating),
      "preferredvendorstatus" -> Json.toJson(o.preferredvendorstatus),
      "activeflag" -> Json.toJson(o.activeflag),
      "purchasingwebserviceurl" -> Json.toJson(o.purchasingwebserviceurl),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
