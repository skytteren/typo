/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package c

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class CRow(
  id: Option[Int],
  /** Points to [[sales.customer.CustomerRow.customerid]] */
  customerid: Option[CustomerId],
  /** Points to [[sales.customer.CustomerRow.personid]] */
  personid: Option[BusinessentityId],
  /** Points to [[sales.customer.CustomerRow.storeid]] */
  storeid: Option[BusinessentityId],
  /** Points to [[sales.customer.CustomerRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.customer.CustomerRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.customer.CustomerRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object CRow {
  implicit val oFormat: OFormat[CRow] = new OFormat[CRow]{
    override def writes(o: CRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "customerid" -> o.customerid,
        "personid" -> o.personid,
        "storeid" -> o.storeid,
        "territoryid" -> o.territoryid,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CRow] = {
      JsResult.fromTry(
        Try(
          CRow(
            id = json.\("id").toOption.map(_.as[Int]),
            customerid = json.\("customerid").toOption.map(_.as[CustomerId]),
            personid = json.\("personid").toOption.map(_.as[BusinessentityId]),
            storeid = json.\("storeid").toOption.map(_.as[BusinessentityId]),
            territoryid = json.\("territoryid").toOption.map(_.as[SalesterritoryId]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}