/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_locks

import adventureworks.TypoXid
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.OffsetDateTime

case class PgLocksViewRow(
  locktype: Option[String],
  database: Option[/* oid */ Long],
  relation: Option[/* oid */ Long],
  page: Option[Int],
  tuple: Option[Int],
  virtualxid: Option[String],
  transactionid: Option[TypoXid],
  classid: Option[/* oid */ Long],
  objid: Option[/* oid */ Long],
  objsubid: Option[Int],
  virtualtransaction: Option[String],
  pid: Option[Int],
  mode: Option[String],
  granted: Option[Boolean],
  fastpath: Option[Boolean],
  waitstart: Option[OffsetDateTime]
)

object PgLocksViewRow {
  implicit val decoder: Decoder[PgLocksViewRow] =
    (c: HCursor) =>
      for {
        locktype <- c.downField("locktype").as[Option[String]]
        database <- c.downField("database").as[Option[/* oid */ Long]]
        relation <- c.downField("relation").as[Option[/* oid */ Long]]
        page <- c.downField("page").as[Option[Int]]
        tuple <- c.downField("tuple").as[Option[Int]]
        virtualxid <- c.downField("virtualxid").as[Option[String]]
        transactionid <- c.downField("transactionid").as[Option[TypoXid]]
        classid <- c.downField("classid").as[Option[/* oid */ Long]]
        objid <- c.downField("objid").as[Option[/* oid */ Long]]
        objsubid <- c.downField("objsubid").as[Option[Int]]
        virtualtransaction <- c.downField("virtualtransaction").as[Option[String]]
        pid <- c.downField("pid").as[Option[Int]]
        mode <- c.downField("mode").as[Option[String]]
        granted <- c.downField("granted").as[Option[Boolean]]
        fastpath <- c.downField("fastpath").as[Option[Boolean]]
        waitstart <- c.downField("waitstart").as[Option[OffsetDateTime]]
      } yield PgLocksViewRow(locktype, database, relation, page, tuple, virtualxid, transactionid, classid, objid, objsubid, virtualtransaction, pid, mode, granted, fastpath, waitstart)
  implicit val encoder: Encoder[PgLocksViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "locktype" := row.locktype,
        "database" := row.database,
        "relation" := row.relation,
        "page" := row.page,
        "tuple" := row.tuple,
        "virtualxid" := row.virtualxid,
        "transactionid" := row.transactionid,
        "classid" := row.classid,
        "objid" := row.objid,
        "objsubid" := row.objsubid,
        "virtualtransaction" := row.virtualtransaction,
        "pid" := row.pid,
        "mode" := row.mode,
        "granted" := row.granted,
        "fastpath" := row.fastpath,
        "waitstart" := row.waitstart
      )}
  implicit val read: Read[PgLocksViewRow] =
    new Read[PgLocksViewRow](
      gets = List(
        (Get[String], Nullability.Nullable),
        (Get[/* oid */ Long], Nullability.Nullable),
        (Get[/* oid */ Long], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[TypoXid], Nullability.Nullable),
        (Get[/* oid */ Long], Nullability.Nullable),
        (Get[/* oid */ Long], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[OffsetDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PgLocksViewRow(
        locktype = Get[String].unsafeGetNullable(rs, i + 0),
        database = Get[/* oid */ Long].unsafeGetNullable(rs, i + 1),
        relation = Get[/* oid */ Long].unsafeGetNullable(rs, i + 2),
        page = Get[Int].unsafeGetNullable(rs, i + 3),
        tuple = Get[Int].unsafeGetNullable(rs, i + 4),
        virtualxid = Get[String].unsafeGetNullable(rs, i + 5),
        transactionid = Get[TypoXid].unsafeGetNullable(rs, i + 6),
        classid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 7),
        objid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 8),
        objsubid = Get[Int].unsafeGetNullable(rs, i + 9),
        virtualtransaction = Get[String].unsafeGetNullable(rs, i + 10),
        pid = Get[Int].unsafeGetNullable(rs, i + 11),
        mode = Get[String].unsafeGetNullable(rs, i + 12),
        granted = Get[Boolean].unsafeGetNullable(rs, i + 13),
        fastpath = Get[Boolean].unsafeGetNullable(rs, i + 14),
        waitstart = Get[OffsetDateTime].unsafeGetNullable(rs, i + 15)
      )
    )
  

}