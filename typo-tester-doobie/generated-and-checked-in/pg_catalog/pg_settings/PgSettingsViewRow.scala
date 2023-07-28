/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_settings

import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgSettingsViewRow(
  name: Option[String],
  setting: Option[String],
  unit: Option[String],
  category: Option[String],
  shortDesc: Option[String],
  extraDesc: Option[String],
  context: Option[String],
  vartype: Option[String],
  source: Option[String],
  minVal: Option[String],
  maxVal: Option[String],
  enumvals: Option[Array[String]],
  bootVal: Option[String],
  resetVal: Option[String],
  sourcefile: Option[String],
  sourceline: Option[Int],
  pendingRestart: Option[Boolean]
)

object PgSettingsViewRow {
  implicit val decoder: Decoder[PgSettingsViewRow] = Decoder.forProduct17[PgSettingsViewRow, Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[Array[String]], Option[String], Option[String], Option[String], Option[Int], Option[Boolean]]("name", "setting", "unit", "category", "short_desc", "extra_desc", "context", "vartype", "source", "min_val", "max_val", "enumvals", "boot_val", "reset_val", "sourcefile", "sourceline", "pending_restart")(PgSettingsViewRow.apply)
  implicit val encoder: Encoder[PgSettingsViewRow] = Encoder.forProduct17[PgSettingsViewRow, Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[Array[String]], Option[String], Option[String], Option[String], Option[Int], Option[Boolean]]("name", "setting", "unit", "category", "short_desc", "extra_desc", "context", "vartype", "source", "min_val", "max_val", "enumvals", "boot_val", "reset_val", "sourcefile", "sourceline", "pending_restart")(x => (x.name, x.setting, x.unit, x.category, x.shortDesc, x.extraDesc, x.context, x.vartype, x.source, x.minVal, x.maxVal, x.enumvals, x.bootVal, x.resetVal, x.sourcefile, x.sourceline, x.pendingRestart))
  implicit val read: Read[PgSettingsViewRow] = new Read[PgSettingsViewRow](
    gets = List(
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[Array[String]], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[Int], Nullability.Nullable),
      (Get[Boolean], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgSettingsViewRow(
      name = Get[String].unsafeGetNullable(rs, i + 0),
      setting = Get[String].unsafeGetNullable(rs, i + 1),
      unit = Get[String].unsafeGetNullable(rs, i + 2),
      category = Get[String].unsafeGetNullable(rs, i + 3),
      shortDesc = Get[String].unsafeGetNullable(rs, i + 4),
      extraDesc = Get[String].unsafeGetNullable(rs, i + 5),
      context = Get[String].unsafeGetNullable(rs, i + 6),
      vartype = Get[String].unsafeGetNullable(rs, i + 7),
      source = Get[String].unsafeGetNullable(rs, i + 8),
      minVal = Get[String].unsafeGetNullable(rs, i + 9),
      maxVal = Get[String].unsafeGetNullable(rs, i + 10),
      enumvals = Get[Array[String]].unsafeGetNullable(rs, i + 11),
      bootVal = Get[String].unsafeGetNullable(rs, i + 12),
      resetVal = Get[String].unsafeGetNullable(rs, i + 13),
      sourcefile = Get[String].unsafeGetNullable(rs, i + 14),
      sourceline = Get[Int].unsafeGetNullable(rs, i + 15),
      pendingRestart = Get[Boolean].unsafeGetNullable(rs, i + 16)
    )
  )
}
