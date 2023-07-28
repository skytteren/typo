/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class DepartmentRow(
  /** Primary key for Department records. */
  departmentid: DepartmentId,
  /** Name of the department. */
  name: Name,
  /** Name of the group to which the department belongs. */
  groupname: Name,
  modifieddate: TypoLocalDateTime
)

object DepartmentRow {
  implicit val decoder: Decoder[DepartmentRow] = Decoder.forProduct4[DepartmentRow, DepartmentId, Name, Name, TypoLocalDateTime]("departmentid", "name", "groupname", "modifieddate")(DepartmentRow.apply)
  implicit val encoder: Encoder[DepartmentRow] = Encoder.forProduct4[DepartmentRow, DepartmentId, Name, Name, TypoLocalDateTime]("departmentid", "name", "groupname", "modifieddate")(x => (x.departmentid, x.name, x.groupname, x.modifieddate))
  implicit val read: Read[DepartmentRow] = new Read[DepartmentRow](
    gets = List(
      (Get[DepartmentId], Nullability.NoNulls),
      (Get[Name], Nullability.NoNulls),
      (Get[Name], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => DepartmentRow(
      departmentid = Get[DepartmentId].unsafeGetNonNullable(rs, i + 0),
      name = Get[Name].unsafeGetNonNullable(rs, i + 1),
      groupname = Get[Name].unsafeGetNonNullable(rs, i + 2),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 3)
    )
  )
}
