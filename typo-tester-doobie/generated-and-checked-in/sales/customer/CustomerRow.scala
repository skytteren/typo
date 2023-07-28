/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

case class CustomerRow(
  /** Primary key. */
  customerid: CustomerId,
  /** Foreign key to Person.BusinessEntityID
      Points to [[person.person.PersonRow.businessentityid]] */
  personid: Option[BusinessentityId],
  /** Foreign key to Store.BusinessEntityID
      Points to [[store.StoreRow.businessentityid]] */
  storeid: Option[BusinessentityId],
  /** ID of the territory in which the customer is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object CustomerRow {
  implicit val decoder: Decoder[CustomerRow] =
    (c: HCursor) =>
      for {
        customerid <- c.downField("customerid").as[CustomerId]
        personid <- c.downField("personid").as[Option[BusinessentityId]]
        storeid <- c.downField("storeid").as[Option[BusinessentityId]]
        territoryid <- c.downField("territoryid").as[Option[SalesterritoryId]]
        rowguid <- c.downField("rowguid").as[UUID]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield CustomerRow(customerid, personid, storeid, territoryid, rowguid, modifieddate)
  implicit val encoder: Encoder[CustomerRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "customerid" := row.customerid,
        "personid" := row.personid,
        "storeid" := row.storeid,
        "territoryid" := row.territoryid,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[CustomerRow] =
    new Read[CustomerRow](
      gets = List(
        (Get[CustomerId], Nullability.NoNulls),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[SalesterritoryId], Nullability.Nullable),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => CustomerRow(
        customerid = Get[CustomerId].unsafeGetNonNullable(rs, i + 0),
        personid = Get[BusinessentityId].unsafeGetNullable(rs, i + 1),
        storeid = Get[BusinessentityId].unsafeGetNullable(rs, i + 2),
        territoryid = Get[SalesterritoryId].unsafeGetNullable(rs, i + 3),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 4),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 5)
      )
    )
  

}