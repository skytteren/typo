/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.person.businessentity.BusinessentityId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class EmployeepayhistoryRow(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Date the change in pay is effective */
  ratechangedate: LocalDateTime,
  /** Salary hourly rate. */
  rate: BigDecimal,
  /** 1 = Salary received monthly, 2 = Salary received biweekly */
  payfrequency: Int,
  modifieddate: LocalDateTime
){
   val compositeId: EmployeepayhistoryId = EmployeepayhistoryId(businessentityid, ratechangedate)
 }

object EmployeepayhistoryRow {
  implicit val decoder: Decoder[EmployeepayhistoryRow] =
    (c: HCursor) =>
      for {
        businessentityid <- c.downField("businessentityid").as[BusinessentityId]
        ratechangedate <- c.downField("ratechangedate").as[LocalDateTime]
        rate <- c.downField("rate").as[BigDecimal]
        payfrequency <- c.downField("payfrequency").as[Int]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield EmployeepayhistoryRow(businessentityid, ratechangedate, rate, payfrequency, modifieddate)
  implicit val encoder: Encoder[EmployeepayhistoryRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "businessentityid" := row.businessentityid,
        "ratechangedate" := row.ratechangedate,
        "rate" := row.rate,
        "payfrequency" := row.payfrequency,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[EmployeepayhistoryRow] =
    new Read[EmployeepayhistoryRow](
      gets = List(
        (Get[BusinessentityId], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls),
        (Get[BigDecimal], Nullability.NoNulls),
        (Get[Int], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => EmployeepayhistoryRow(
        businessentityid = Get[BusinessentityId].unsafeGetNonNullable(rs, i + 0),
        ratechangedate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 1),
        rate = Get[BigDecimal].unsafeGetNonNullable(rs, i + 2),
        payfrequency = Get[Int].unsafeGetNonNullable(rs, i + 3),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 4)
      )
    )
  

}
