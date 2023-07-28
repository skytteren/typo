/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config

import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgTsConfigRow(
  oid: PgTsConfigId,
  cfgname: String,
  cfgnamespace: /* oid */ Long,
  cfgowner: /* oid */ Long,
  cfgparser: /* oid */ Long
)

object PgTsConfigRow {
  implicit val decoder: Decoder[PgTsConfigRow] = Decoder.forProduct5[PgTsConfigRow, PgTsConfigId, String, /* oid */ Long, /* oid */ Long, /* oid */ Long]("oid", "cfgname", "cfgnamespace", "cfgowner", "cfgparser")(PgTsConfigRow.apply)
  implicit val encoder: Encoder[PgTsConfigRow] = Encoder.forProduct5[PgTsConfigRow, PgTsConfigId, String, /* oid */ Long, /* oid */ Long, /* oid */ Long]("oid", "cfgname", "cfgnamespace", "cfgowner", "cfgparser")(x => (x.oid, x.cfgname, x.cfgnamespace, x.cfgowner, x.cfgparser))
  implicit val read: Read[PgTsConfigRow] = new Read[PgTsConfigRow](
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
