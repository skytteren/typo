/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_cluster

import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class PgStatProgressClusterViewRow(
  pid: Option[Int],
  datid: Option[/* oid */ Long],
  datname: Option[String],
  relid: Option[/* oid */ Long],
  command: Option[String],
  phase: Option[String],
  clusterIndexRelid: Option[/* oid */ Long],
  heapTuplesScanned: Option[Long],
  heapTuplesWritten: Option[Long],
  heapBlksTotal: Option[Long],
  heapBlksScanned: Option[Long],
  indexRebuildCount: Option[Long]
)

object PgStatProgressClusterViewRow {
  implicit val decoder: Decoder[PgStatProgressClusterViewRow] =
    (c: HCursor) =>
      for {
        pid <- c.downField("pid").as[Option[Int]]
        datid <- c.downField("datid").as[Option[/* oid */ Long]]
        datname <- c.downField("datname").as[Option[String]]
        relid <- c.downField("relid").as[Option[/* oid */ Long]]
        command <- c.downField("command").as[Option[String]]
        phase <- c.downField("phase").as[Option[String]]
        clusterIndexRelid <- c.downField("cluster_index_relid").as[Option[/* oid */ Long]]
        heapTuplesScanned <- c.downField("heap_tuples_scanned").as[Option[Long]]
        heapTuplesWritten <- c.downField("heap_tuples_written").as[Option[Long]]
        heapBlksTotal <- c.downField("heap_blks_total").as[Option[Long]]
        heapBlksScanned <- c.downField("heap_blks_scanned").as[Option[Long]]
        indexRebuildCount <- c.downField("index_rebuild_count").as[Option[Long]]
      } yield PgStatProgressClusterViewRow(pid, datid, datname, relid, command, phase, clusterIndexRelid, heapTuplesScanned, heapTuplesWritten, heapBlksTotal, heapBlksScanned, indexRebuildCount)
  implicit val encoder: Encoder[PgStatProgressClusterViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "pid" := row.pid,
        "datid" := row.datid,
        "datname" := row.datname,
        "relid" := row.relid,
        "command" := row.command,
        "phase" := row.phase,
        "cluster_index_relid" := row.clusterIndexRelid,
        "heap_tuples_scanned" := row.heapTuplesScanned,
        "heap_tuples_written" := row.heapTuplesWritten,
        "heap_blks_total" := row.heapBlksTotal,
        "heap_blks_scanned" := row.heapBlksScanned,
        "index_rebuild_count" := row.indexRebuildCount
      )}
  implicit val read: Read[PgStatProgressClusterViewRow] =
    new Read[PgStatProgressClusterViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[/* oid */ Long], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[/* oid */ Long], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[/* oid */ Long], Nullability.Nullable),
        (Get[Long], Nullability.Nullable),
        (Get[Long], Nullability.Nullable),
        (Get[Long], Nullability.Nullable),
        (Get[Long], Nullability.Nullable),
        (Get[Long], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PgStatProgressClusterViewRow(
        pid = Get[Int].unsafeGetNullable(rs, i + 0),
        datid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 1),
        datname = Get[String].unsafeGetNullable(rs, i + 2),
        relid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 3),
        command = Get[String].unsafeGetNullable(rs, i + 4),
        phase = Get[String].unsafeGetNullable(rs, i + 5),
        clusterIndexRelid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 6),
        heapTuplesScanned = Get[Long].unsafeGetNullable(rs, i + 7),
        heapTuplesWritten = Get[Long].unsafeGetNullable(rs, i + 8),
        heapBlksTotal = Get[Long].unsafeGetNullable(rs, i + 9),
        heapBlksScanned = Get[Long].unsafeGetNullable(rs, i + 10),
        indexRebuildCount = Get[Long].unsafeGetNullable(rs, i + 11)
      )
    )
  

}