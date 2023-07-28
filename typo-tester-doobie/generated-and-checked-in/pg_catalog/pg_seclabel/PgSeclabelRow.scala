/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabel

import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class PgSeclabelRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  objsubid: Int,
  provider: String,
  label: String
){
   val compositeId: PgSeclabelId = PgSeclabelId(objoid, classoid, objsubid, provider)
 }

object PgSeclabelRow {
  implicit val decoder: Decoder[PgSeclabelRow] =
    (c: HCursor) =>
      for {
        objoid <- c.downField("objoid").as[/* oid */ Long]
        classoid <- c.downField("classoid").as[/* oid */ Long]
        objsubid <- c.downField("objsubid").as[Int]
        provider <- c.downField("provider").as[String]
        label <- c.downField("label").as[String]
      } yield PgSeclabelRow(objoid, classoid, objsubid, provider, label)
  implicit val encoder: Encoder[PgSeclabelRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "objoid" := row.objoid,
        "classoid" := row.classoid,
        "objsubid" := row.objsubid,
        "provider" := row.provider,
        "label" := row.label
      )}
  implicit val read: Read[PgSeclabelRow] =
    new Read[PgSeclabelRow](
      gets = List(
        (Get[/* oid */ Long], Nullability.NoNulls),
        (Get[/* oid */ Long], Nullability.NoNulls),
        (Get[Int], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PgSeclabelRow(
        objoid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 0),
        classoid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 1),
        objsubid = Get[Int].unsafeGetNonNullable(rs, i + 2),
        provider = Get[String].unsafeGetNonNullable(rs, i + 3),
        label = Get[String].unsafeGetNonNullable(rs, i + 4)
      )
    )
  

}