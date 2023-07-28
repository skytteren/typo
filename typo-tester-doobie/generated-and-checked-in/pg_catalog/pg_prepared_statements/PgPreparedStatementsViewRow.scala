/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_statements

import adventureworks.TypoOffsetDateTime
import adventureworks.TypoRegtype
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgPreparedStatementsViewRow(
  name: Option[String],
  statement: Option[String],
  prepareTime: Option[TypoOffsetDateTime],
  parameterTypes: Option[Array[TypoRegtype]],
  fromSql: Option[Boolean],
  genericPlans: Option[Long],
  customPlans: Option[Long]
)

object PgPreparedStatementsViewRow {
  implicit val decoder: Decoder[PgPreparedStatementsViewRow] = Decoder.forProduct7[PgPreparedStatementsViewRow, Option[String], Option[String], Option[TypoOffsetDateTime], Option[Array[TypoRegtype]], Option[Boolean], Option[Long], Option[Long]]("name", "statement", "prepare_time", "parameter_types", "from_sql", "generic_plans", "custom_plans")(PgPreparedStatementsViewRow.apply)
  implicit val encoder: Encoder[PgPreparedStatementsViewRow] = Encoder.forProduct7[PgPreparedStatementsViewRow, Option[String], Option[String], Option[TypoOffsetDateTime], Option[Array[TypoRegtype]], Option[Boolean], Option[Long], Option[Long]]("name", "statement", "prepare_time", "parameter_types", "from_sql", "generic_plans", "custom_plans")(x => (x.name, x.statement, x.prepareTime, x.parameterTypes, x.fromSql, x.genericPlans, x.customPlans))
  implicit val read: Read[PgPreparedStatementsViewRow] = new Read[PgPreparedStatementsViewRow](
    gets = List(
      (Get[String], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[TypoOffsetDateTime], Nullability.Nullable),
      (Get[Array[TypoRegtype]], Nullability.Nullable),
      (Get[Boolean], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgPreparedStatementsViewRow(
      name = Get[String].unsafeGetNullable(rs, i + 0),
      statement = Get[String].unsafeGetNullable(rs, i + 1),
      prepareTime = Get[TypoOffsetDateTime].unsafeGetNullable(rs, i + 2),
      parameterTypes = Get[Array[TypoRegtype]].unsafeGetNullable(rs, i + 3),
      fromSql = Get[Boolean].unsafeGetNullable(rs, i + 4),
      genericPlans = Get[Long].unsafeGetNullable(rs, i + 5),
      customPlans = Get[Long].unsafeGetNullable(rs, i + 6)
    )
  )
}
