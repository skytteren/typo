/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: humanresources.department
    Lookup table containing the departments within the Adventure Works Cycles company.
    Primary key: departmentid */
case class DepartmentRow(
  /** Primary key for Department records.
      Default: nextval('humanresources.department_departmentid_seq'::regclass) */
  departmentid: DepartmentId,
  /** Name of the department. */
  name: Name,
  /** Name of the group to which the department belongs. */
  groupname: Name,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = departmentid
   def toUnsavedRow(departmentid: Defaulted[DepartmentId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): DepartmentRowUnsaved =
     DepartmentRowUnsaved(name, groupname, departmentid, modifieddate)
 }

object DepartmentRow {
  implicit lazy val decoder: Decoder[DepartmentRow] = Decoder.forProduct4[DepartmentRow, DepartmentId, Name, Name, TypoLocalDateTime]("departmentid", "name", "groupname", "modifieddate")(DepartmentRow.apply)(DepartmentId.decoder, Name.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[DepartmentRow] = Encoder.forProduct4[DepartmentRow, DepartmentId, Name, Name, TypoLocalDateTime]("departmentid", "name", "groupname", "modifieddate")(x => (x.departmentid, x.name, x.groupname, x.modifieddate))(DepartmentId.encoder, Name.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[DepartmentRow] = new Read[DepartmentRow](
    gets = List(
      (DepartmentId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => DepartmentRow(
      departmentid = DepartmentId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      groupname = Name.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
  implicit lazy val text: Text[DepartmentRow] = Text.instance[DepartmentRow]{ (row, sb) =>
    DepartmentId.text.unsafeEncode(row.departmentid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.groupname, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
