/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_description

import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgDescriptionRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  objsubid: Int,
  description: String
){
   val compositeId: PgDescriptionId = PgDescriptionId(objoid, classoid, objsubid)
 }

object PgDescriptionRow {
  implicit val decoder: Decoder[PgDescriptionRow] = Decoder.forProduct4[PgDescriptionRow, /* oid */ Long, /* oid */ Long, Int, String]("objoid", "classoid", "objsubid", "description")(PgDescriptionRow.apply)
  implicit val encoder: Encoder[PgDescriptionRow] = Encoder.forProduct4[PgDescriptionRow, /* oid */ Long, /* oid */ Long, Int, String]("objoid", "classoid", "objsubid", "description")(x => (x.objoid, x.classoid, x.objsubid, x.description))
  implicit val read: Read[PgDescriptionRow] = new Read[PgDescriptionRow](
    gets = List(
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgDescriptionRow(
      objoid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 0),
      classoid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 1),
      objsubid = Get[Int].unsafeGetNonNullable(rs, i + 2),
      description = Get[String].unsafeGetNonNullable(rs, i + 3)
    )
  )
}
