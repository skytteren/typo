/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import adventureworks.person.businessentity.BusinessentityId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class EViewRow(
  id: Option[Int],
  /** Points to [[person.emailaddress.EmailaddressRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddressid]] */
  emailaddressid: Option[Int],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[person.emailaddress.EmailaddressRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.emailaddress.EmailaddressRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object EViewRow {
  def rowParser(idx: Int): RowParser[EViewRow] =
    RowParser[EViewRow] { row =>
      Success(
        EViewRow(
          id = row[Option[Int]](idx + 0),
          businessentityid = row[Option[BusinessentityId]](idx + 1),
          emailaddressid = row[Option[Int]](idx + 2),
          emailaddress = row[Option[/* max 50 chars */ String]](idx + 3),
          rowguid = row[Option[UUID]](idx + 4),
          modifieddate = row[Option[LocalDateTime]](idx + 5)
        )
      )
    }
  implicit val oFormat: OFormat[EViewRow] = new OFormat[EViewRow]{
    override def writes(o: EViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "emailaddressid" -> o.emailaddressid,
        "emailaddress" -> o.emailaddress,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[EViewRow] = {
      JsResult.fromTry(
        Try(
          EViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            emailaddressid = json.\("emailaddressid").toOption.map(_.as[Int]),
            emailaddress = json.\("emailaddress").toOption.map(_.as[/* max 50 chars */ String]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}