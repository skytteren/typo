/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_am

import adventureworks.TypoRegproc
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class PgAmRow(
  oid: PgAmId,
  amname: String,
  amhandler: TypoRegproc,
  amtype: String
)

object PgAmRow {
  implicit val decoder: Decoder[PgAmRow] =
    (c: HCursor) =>
      for {
        oid <- c.downField("oid").as[PgAmId]
        amname <- c.downField("amname").as[String]
        amhandler <- c.downField("amhandler").as[TypoRegproc]
        amtype <- c.downField("amtype").as[String]
      } yield PgAmRow(oid, amname, amhandler, amtype)
  implicit val encoder: Encoder[PgAmRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "oid" := row.oid,
        "amname" := row.amname,
        "amhandler" := row.amhandler,
        "amtype" := row.amtype
      )}
  implicit val read: Read[PgAmRow] =
    new Read[PgAmRow](
      gets = List(
        (Get[PgAmId], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[TypoRegproc], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PgAmRow(
        oid = Get[PgAmId].unsafeGetNonNullable(rs, i + 0),
        amname = Get[String].unsafeGetNonNullable(rs, i + 1),
        amhandler = Get[TypoRegproc].unsafeGetNonNullable(rs, i + 2),
        amtype = Get[String].unsafeGetNonNullable(rs, i + 3)
      )
    )
  

}