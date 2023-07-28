/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package referential_constraints

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ReferentialConstraintsViewRow(
  constraintCatalog: Option[SqlIdentifier],
  constraintSchema: Option[SqlIdentifier],
  constraintName: Option[SqlIdentifier],
  uniqueConstraintCatalog: Option[SqlIdentifier],
  uniqueConstraintSchema: Option[SqlIdentifier],
  uniqueConstraintName: Option[SqlIdentifier],
  matchOption: Option[CharacterData],
  updateRule: Option[CharacterData],
  deleteRule: Option[CharacterData]
)

object ReferentialConstraintsViewRow {
  implicit val decoder: Decoder[ReferentialConstraintsViewRow] = Decoder.forProduct9[ReferentialConstraintsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[CharacterData], Option[CharacterData]]("constraint_catalog", "constraint_schema", "constraint_name", "unique_constraint_catalog", "unique_constraint_schema", "unique_constraint_name", "match_option", "update_rule", "delete_rule")(ReferentialConstraintsViewRow.apply)
  implicit val encoder: Encoder[ReferentialConstraintsViewRow] = Encoder.forProduct9[ReferentialConstraintsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[CharacterData], Option[CharacterData]]("constraint_catalog", "constraint_schema", "constraint_name", "unique_constraint_catalog", "unique_constraint_schema", "unique_constraint_name", "match_option", "update_rule", "delete_rule")(x => (x.constraintCatalog, x.constraintSchema, x.constraintName, x.uniqueConstraintCatalog, x.uniqueConstraintSchema, x.uniqueConstraintName, x.matchOption, x.updateRule, x.deleteRule))
  implicit val read: Read[ReferentialConstraintsViewRow] = new Read[ReferentialConstraintsViewRow](
    gets = List(
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[CharacterData], Nullability.Nullable),
      (Get[CharacterData], Nullability.Nullable),
      (Get[CharacterData], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ReferentialConstraintsViewRow(
      constraintCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 0),
      constraintSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 1),
      constraintName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 2),
      uniqueConstraintCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 3),
      uniqueConstraintSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 4),
      uniqueConstraintName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 5),
      matchOption = Get[CharacterData].unsafeGetNullable(rs, i + 6),
      updateRule = Get[CharacterData].unsafeGetNullable(rs, i + 7),
      deleteRule = Get[CharacterData].unsafeGetNullable(rs, i + 8)
    )
  )
}
