/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_db_role_setting

import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json

/** Type for the composite primary key of table `pg_catalog.pg_db_role_setting` */
case class PgDbRoleSettingId(setdatabase: /* oid */ Long, setrole: /* oid */ Long)
object PgDbRoleSettingId {
  implicit val ordering: Ordering[PgDbRoleSettingId] = Ordering.by(x => (x.setdatabase, x.setrole))
  implicit val decoder: Decoder[PgDbRoleSettingId] =
    (c: HCursor) =>
      for {
        setdatabase <- c.downField("setdatabase").as[/* oid */ Long]
        setrole <- c.downField("setrole").as[/* oid */ Long]
      } yield PgDbRoleSettingId(setdatabase, setrole)
  implicit val encoder: Encoder[PgDbRoleSettingId] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "setdatabase" := row.setdatabase,
        "setrole" := row.setrole
      )}
}