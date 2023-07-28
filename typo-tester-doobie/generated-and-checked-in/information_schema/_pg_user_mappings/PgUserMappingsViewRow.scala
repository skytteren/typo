/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_user_mappings`

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgUserMappingsViewRow(
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.oid]] */
  oid: Option[/* oid */ Long],
  umoptions: Option[Array[String]],
  umuser: Option[/* oid */ Long],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerName]] */
  foreignServerName: Option[SqlIdentifier],
  srvowner: Option[SqlIdentifier]
)

object PgUserMappingsViewRow {
  implicit val decoder: Decoder[PgUserMappingsViewRow] = Decoder.forProduct7[PgUserMappingsViewRow, Option[/* oid */ Long], Option[Array[String]], Option[/* oid */ Long], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("oid", "umoptions", "umuser", "authorization_identifier", "foreign_server_catalog", "foreign_server_name", "srvowner")(PgUserMappingsViewRow.apply)
  implicit val encoder: Encoder[PgUserMappingsViewRow] = Encoder.forProduct7[PgUserMappingsViewRow, Option[/* oid */ Long], Option[Array[String]], Option[/* oid */ Long], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("oid", "umoptions", "umuser", "authorization_identifier", "foreign_server_catalog", "foreign_server_name", "srvowner")(x => (x.oid, x.umoptions, x.umuser, x.authorizationIdentifier, x.foreignServerCatalog, x.foreignServerName, x.srvowner))
  implicit val read: Read[PgUserMappingsViewRow] = new Read[PgUserMappingsViewRow](
    gets = List(
      (Get[/* oid */ Long], Nullability.Nullable),
      (Get[Array[String]], Nullability.Nullable),
      (Get[/* oid */ Long], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable),
      (Get[SqlIdentifier], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgUserMappingsViewRow(
      oid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 0),
      umoptions = Get[Array[String]].unsafeGetNullable(rs, i + 1),
      umuser = Get[/* oid */ Long].unsafeGetNullable(rs, i + 2),
      authorizationIdentifier = Get[SqlIdentifier].unsafeGetNullable(rs, i + 3),
      foreignServerCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 4),
      foreignServerName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 5),
      srvowner = Get[SqlIdentifier].unsafeGetNullable(rs, i + 6)
    )
  )
}
