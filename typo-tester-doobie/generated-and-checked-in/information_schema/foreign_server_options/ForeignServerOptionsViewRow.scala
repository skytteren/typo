/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_server_options

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class ForeignServerOptionsViewRow(
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerName]] */
  foreignServerName: Option[SqlIdentifier],
  optionName: Option[SqlIdentifier],
  optionValue: Option[CharacterData]
)

object ForeignServerOptionsViewRow {
  implicit val decoder: Decoder[ForeignServerOptionsViewRow] =
    (c: HCursor) =>
      for {
        foreignServerCatalog <- c.downField("foreign_server_catalog").as[Option[SqlIdentifier]]
        foreignServerName <- c.downField("foreign_server_name").as[Option[SqlIdentifier]]
        optionName <- c.downField("option_name").as[Option[SqlIdentifier]]
        optionValue <- c.downField("option_value").as[Option[CharacterData]]
      } yield ForeignServerOptionsViewRow(foreignServerCatalog, foreignServerName, optionName, optionValue)
  implicit val encoder: Encoder[ForeignServerOptionsViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "foreign_server_catalog" := row.foreignServerCatalog,
        "foreign_server_name" := row.foreignServerName,
        "option_name" := row.optionName,
        "option_value" := row.optionValue
      )}
  implicit val read: Read[ForeignServerOptionsViewRow] =
    new Read[ForeignServerOptionsViewRow](
      gets = List(
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[CharacterData], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => ForeignServerOptionsViewRow(
        foreignServerCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 0),
        foreignServerName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 1),
        optionName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 2),
        optionValue = Get[CharacterData].unsafeGetNullable(rs, i + 3)
      )
    )
  

}