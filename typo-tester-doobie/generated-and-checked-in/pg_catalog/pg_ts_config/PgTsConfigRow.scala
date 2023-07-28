/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config

import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class PgTsConfigRow(
  oid: PgTsConfigId,
  cfgname: String,
  cfgnamespace: /* oid */ Long,
  cfgowner: /* oid */ Long,
  cfgparser: /* oid */ Long
)

object PgTsConfigRow {
  implicit val decoder: Decoder[PgTsConfigRow] =
    (c: HCursor) =>
      for {
        oid <- c.downField("oid").as[PgTsConfigId]
        cfgname <- c.downField("cfgname").as[String]
        cfgnamespace <- c.downField("cfgnamespace").as[/* oid */ Long]
        cfgowner <- c.downField("cfgowner").as[/* oid */ Long]
        cfgparser <- c.downField("cfgparser").as[/* oid */ Long]
      } yield PgTsConfigRow(oid, cfgname, cfgnamespace, cfgowner, cfgparser)
  implicit val encoder: Encoder[PgTsConfigRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "oid" := row.oid,
        "cfgname" := row.cfgname,
        "cfgnamespace" := row.cfgnamespace,
        "cfgowner" := row.cfgowner,
        "cfgparser" := row.cfgparser
      )}
  implicit val read: Read[PgTsConfigRow] =
    new Read[PgTsConfigRow](
      gets = List(
        (Get[PgTsConfigId], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[/* oid */ Long], Nullability.NoNulls),
        (Get[/* oid */ Long], Nullability.NoNulls),
        (Get[/* oid */ Long], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PgTsConfigRow(
        oid = Get[PgTsConfigId].unsafeGetNonNullable(rs, i + 0),
        cfgname = Get[String].unsafeGetNonNullable(rs, i + 1),
        cfgnamespace = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 2),
        cfgowner = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 3),
        cfgparser = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 4)
      )
    )
  

}