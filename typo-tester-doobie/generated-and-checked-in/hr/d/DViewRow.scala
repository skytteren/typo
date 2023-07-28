/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package d

import adventureworks.humanresources.department.DepartmentId
import adventureworks.public.Name
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class DViewRow(
  id: Option[Int],
  /** Points to [[humanresources.department.DepartmentRow.departmentid]] */
  departmentid: Option[DepartmentId],
  /** Points to [[humanresources.department.DepartmentRow.name]] */
  name: Option[Name],
  /** Points to [[humanresources.department.DepartmentRow.groupname]] */
  groupname: Option[Name],
  /** Points to [[humanresources.department.DepartmentRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object DViewRow {
  implicit val decoder: Decoder[DViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        departmentid <- c.downField("departmentid").as[Option[DepartmentId]]
        name <- c.downField("name").as[Option[Name]]
        groupname <- c.downField("groupname").as[Option[Name]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield DViewRow(id, departmentid, name, groupname, modifieddate)
  implicit val encoder: Encoder[DViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "departmentid" := row.departmentid,
        "name" := row.name,
        "groupname" := row.groupname,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[DViewRow] =
    new Read[DViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[DepartmentId], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => DViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        departmentid = Get[DepartmentId].unsafeGetNullable(rs, i + 1),
        name = Get[Name].unsafeGetNullable(rs, i + 2),
        groupname = Get[Name].unsafeGetNullable(rs, i + 3),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 4)
      )
    )
  

}