/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pp

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PpViewRow(
  id: Option[Int],
  /** Points to [[person.personphone.PersonphoneRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  /** Points to [[person.personphone.PersonphoneRow.phonenumbertypeid]] */
  phonenumbertypeid: Option[PhonenumbertypeId],
  /** Points to [[person.personphone.PersonphoneRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PpViewRow {
  val rowParser: RowParser[PpViewRow] =
    RowParser[PpViewRow] { row =>
      Success(
        PpViewRow(
          id = row[Option[Int]]("id"),
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          phonenumber = row[Option[Phone]]("phonenumber"),
          phonenumbertypeid = row[Option[PhonenumbertypeId]]("phonenumbertypeid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[PpViewRow] = new OFormat[PpViewRow]{
    override def writes(o: PpViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "phonenumber" -> o.phonenumber,
        "phonenumbertypeid" -> o.phonenumbertypeid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PpViewRow] = {
      JsResult.fromTry(
        Try(
          PpViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            phonenumber = json.\("phonenumber").toOption.map(_.as[Phone]),
            phonenumbertypeid = json.\("phonenumbertypeid").toOption.map(_.as[PhonenumbertypeId]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
