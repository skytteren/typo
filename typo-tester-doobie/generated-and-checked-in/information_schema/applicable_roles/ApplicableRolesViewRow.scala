/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package applicable_roles

import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ApplicableRolesViewRow(
  grantee: Option[SqlIdentifier],
  roleName: Option[SqlIdentifier],
  isGrantable: Option[YesOrNo]
)

object ApplicableRolesViewRow {
  implicit val decoder: Decoder[ApplicableRolesViewRow] = Decoder.forProduct3[ApplicableRolesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[YesOrNo]]("grantee", "role_name", "is_grantable")(ApplicableRolesViewRow.apply)
  implicit val encoder: Encoder[ApplicableRolesViewRow] = Encoder.forProduct3[ApplicableRolesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[YesOrNo]]("grantee", "role_name", "is_grantable")(x => (x.grantee, x.roleName, x.isGrantable))
  implicit val read: Read[ApplicableRolesViewRow] = new Read[ApplicableRolesViewRow](
    gets = List(
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[YesOrNo], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ApplicableRolesViewRow(
      grantee = Get[SqlIdentifier].unsafeGetNullable(rs, i + 0),
      roleName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 1),
      isGrantable = Get[YesOrNo].unsafeGetNullable(rs, i + 2)
    )
  )
}
