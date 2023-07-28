/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_roles

import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.OffsetDateTime

case class PgRolesViewRow(
  rolname: Option[String],
  rolsuper: Option[Boolean],
  rolinherit: Option[Boolean],
  rolcreaterole: Option[Boolean],
  rolcreatedb: Option[Boolean],
  rolcanlogin: Option[Boolean],
  rolreplication: Option[Boolean],
  rolconnlimit: Option[Int],
  rolpassword: Option[String],
  rolvaliduntil: Option[OffsetDateTime],
  rolbypassrls: Option[Boolean],
  rolconfig: Option[Array[String]],
  oid: Option[/* oid */ Long]
)

object PgRolesViewRow {
  implicit val decoder: Decoder[PgRolesViewRow] =
    (c: HCursor) =>
      for {
        rolname <- c.downField("rolname").as[Option[String]]
        rolsuper <- c.downField("rolsuper").as[Option[Boolean]]
        rolinherit <- c.downField("rolinherit").as[Option[Boolean]]
        rolcreaterole <- c.downField("rolcreaterole").as[Option[Boolean]]
        rolcreatedb <- c.downField("rolcreatedb").as[Option[Boolean]]
        rolcanlogin <- c.downField("rolcanlogin").as[Option[Boolean]]
        rolreplication <- c.downField("rolreplication").as[Option[Boolean]]
        rolconnlimit <- c.downField("rolconnlimit").as[Option[Int]]
        rolpassword <- c.downField("rolpassword").as[Option[String]]
        rolvaliduntil <- c.downField("rolvaliduntil").as[Option[OffsetDateTime]]
        rolbypassrls <- c.downField("rolbypassrls").as[Option[Boolean]]
        rolconfig <- c.downField("rolconfig").as[Option[Array[String]]]
        oid <- c.downField("oid").as[Option[/* oid */ Long]]
      } yield PgRolesViewRow(rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolconnlimit, rolpassword, rolvaliduntil, rolbypassrls, rolconfig, oid)
  implicit val encoder: Encoder[PgRolesViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "rolname" := row.rolname,
        "rolsuper" := row.rolsuper,
        "rolinherit" := row.rolinherit,
        "rolcreaterole" := row.rolcreaterole,
        "rolcreatedb" := row.rolcreatedb,
        "rolcanlogin" := row.rolcanlogin,
        "rolreplication" := row.rolreplication,
        "rolconnlimit" := row.rolconnlimit,
        "rolpassword" := row.rolpassword,
        "rolvaliduntil" := row.rolvaliduntil,
        "rolbypassrls" := row.rolbypassrls,
        "rolconfig" := row.rolconfig,
        "oid" := row.oid
      )}
  implicit val read: Read[PgRolesViewRow] =
    new Read[PgRolesViewRow](
      gets = List(
        (Get[String], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[OffsetDateTime], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Array[String]], Nullability.Nullable),
        (Get[/* oid */ Long], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PgRolesViewRow(
        rolname = Get[String].unsafeGetNullable(rs, i + 0),
        rolsuper = Get[Boolean].unsafeGetNullable(rs, i + 1),
        rolinherit = Get[Boolean].unsafeGetNullable(rs, i + 2),
        rolcreaterole = Get[Boolean].unsafeGetNullable(rs, i + 3),
        rolcreatedb = Get[Boolean].unsafeGetNullable(rs, i + 4),
        rolcanlogin = Get[Boolean].unsafeGetNullable(rs, i + 5),
        rolreplication = Get[Boolean].unsafeGetNullable(rs, i + 6),
        rolconnlimit = Get[Int].unsafeGetNullable(rs, i + 7),
        rolpassword = Get[String].unsafeGetNullable(rs, i + 8),
        rolvaliduntil = Get[OffsetDateTime].unsafeGetNullable(rs, i + 9),
        rolbypassrls = Get[Boolean].unsafeGetNullable(rs, i + 10),
        rolconfig = Get[Array[String]].unsafeGetNullable(rs, i + 11),
        oid = Get[/* oid */ Long].unsafeGetNullable(rs, i + 12)
      )
    )
  

}