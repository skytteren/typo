/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
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

case class SalesterritoryhistoryRow(
  /** Primary key. The sales rep.  Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Territory identification number. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Primary key. Date the sales representive started work in the territory. */
  startdate: LocalDateTime,
  /** Date the sales representative left work in the territory. */
  enddate: Option[LocalDateTime],
  rowguid: UUID,
  modifieddate: LocalDateTime
){
   val compositeId: SalesterritoryhistoryId = SalesterritoryhistoryId(businessentityid, startdate, territoryid)
 }

object SalesterritoryhistoryRow {
  val rowParser: RowParser[SalesterritoryhistoryRow] =
    RowParser[SalesterritoryhistoryRow] { row =>
      Success(
        SalesterritoryhistoryRow(
          businessentityid = row[BusinessentityId]("businessentityid"),
          territoryid = row[SalesterritoryId]("territoryid"),
          startdate = row[LocalDateTime]("startdate"),
          enddate = row[Option[LocalDateTime]]("enddate"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[SalesterritoryhistoryRow] = new OFormat[SalesterritoryhistoryRow]{
    override def writes(o: SalesterritoryhistoryRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "territoryid" -> o.territoryid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalesterritoryhistoryRow] = {
      JsResult.fromTry(
        Try(
          SalesterritoryhistoryRow(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            territoryid = json.\("territoryid").as[SalesterritoryId],
            startdate = json.\("startdate").as[LocalDateTime],
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
