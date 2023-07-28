/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database_conflicts

import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatDatabaseConflictsViewRow(
  datid: Option[/* oid */ Long],
  datname: Option[String],
  conflTablespace: Option[Long],
  conflLock: Option[Long],
  conflSnapshot: Option[Long],
  conflBufferpin: Option[Long],
  conflDeadlock: Option[Long]
)

object PgStatDatabaseConflictsViewRow {
  implicit val decoder: Decoder[PgStatDatabaseConflictsViewRow] = Decoder.forProduct7[PgStatDatabaseConflictsViewRow, Option[/* oid */ Long], Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long]]("datid", "datname", "confl_tablespace", "confl_lock", "confl_snapshot", "confl_bufferpin", "confl_deadlock")(PgStatDatabaseConflictsViewRow.apply)
  implicit val encoder: Encoder[PgStatDatabaseConflictsViewRow] = Encoder.forProduct7[PgStatDatabaseConflictsViewRow, Option[/* oid */ Long], Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long]]("datid", "datname", "confl_tablespace", "confl_lock", "confl_snapshot", "confl_bufferpin", "confl_deadlock")(x => (x.datid, x.datname, x.conflTablespace, x.conflLock, x.conflSnapshot, x.conflBufferpin, x.conflDeadlock))
  implicit val read: Read[PgStatDatabaseConflictsViewRow] = new Read[PgStatDatabaseConflictsViewRow](
    gets = List(
      (Get[/* oid */ Long], Nullability.Nullable),
      (Get[String], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable),
      (Get[Long], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatDatabaseConflictsViewRow(
      datid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 0),
      datname = Get[String].unsafeGetNullable(rs, i + 1),
      conflTablespace = Get[Long].unsafeGetNullable(rs, i + 2),
      conflLock = Get[Long].unsafeGetNullable(rs, i + 3),
      conflSnapshot = Get[Long].unsafeGetNullable(rs, i + 4),
      conflBufferpin = Get[Long].unsafeGetNullable(rs, i + 5),
      conflDeadlock = Get[Long].unsafeGetNullable(rs, i + 6)
    )
  )
}
