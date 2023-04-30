/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package at

import adventureworks.person.addresstype.AddresstypeId
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class AtRow(
  id: Option[Int],
  /** Points to [[person.addresstype.AddresstypeRow.addresstypeid]] */
  addresstypeid: Option[AddresstypeId],
  /** Points to [[person.addresstype.AddresstypeRow.name]] */
  name: Option[Name],
  /** Points to [[person.addresstype.AddresstypeRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.addresstype.AddresstypeRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object AtRow {
  implicit val oFormat: OFormat[AtRow] = new OFormat[AtRow]{
    override def writes(o: AtRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "addresstypeid" -> o.addresstypeid,
        "name" -> o.name,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[AtRow] = {
      JsResult.fromTry(
        Try(
          AtRow(
            id = json.\("id").toOption.map(_.as[Int]),
            addresstypeid = json.\("addresstypeid").toOption.map(_.as[AddresstypeId]),
            name = json.\("name").toOption.map(_.as[Name]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}