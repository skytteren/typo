/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package edh

import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDate
import java.time.LocalDateTime

case class EdhViewRow(
  id: Option[Int],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.departmentid]] */
  departmentid: Option[DepartmentId],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.shiftid]] */
  shiftid: Option[ShiftId],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: Option[LocalDate],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.enddate]] */
  enddate: Option[LocalDate],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object EdhViewRow {
  implicit val decoder: Decoder[EdhViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        businessentityid <- c.downField("businessentityid").as[Option[BusinessentityId]]
        departmentid <- c.downField("departmentid").as[Option[DepartmentId]]
        shiftid <- c.downField("shiftid").as[Option[ShiftId]]
        startdate <- c.downField("startdate").as[Option[LocalDate]]
        enddate <- c.downField("enddate").as[Option[LocalDate]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield EdhViewRow(id, businessentityid, departmentid, shiftid, startdate, enddate, modifieddate)
  implicit val encoder: Encoder[EdhViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "businessentityid" := row.businessentityid,
        "departmentid" := row.departmentid,
        "shiftid" := row.shiftid,
        "startdate" := row.startdate,
        "enddate" := row.enddate,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[EdhViewRow] =
    new Read[EdhViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[DepartmentId], Nullability.Nullable),
        (Get[ShiftId], Nullability.Nullable),
        (Get[LocalDate], Nullability.Nullable),
        (Get[LocalDate], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => EdhViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 1),
        departmentid = Get[DepartmentId].unsafeGetNullable(rs, i + 2),
        shiftid = Get[ShiftId].unsafeGetNullable(rs, i + 3),
        startdate = Get[LocalDate].unsafeGetNullable(rs, i + 4),
        enddate = Get[LocalDate].unsafeGetNullable(rs, i + 5),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 6)
      )
    )
  

}