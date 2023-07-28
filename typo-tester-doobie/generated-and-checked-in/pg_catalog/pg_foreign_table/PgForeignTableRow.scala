/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_table

import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class PgForeignTableRow(
  ftrelid: PgForeignTableId,
  ftserver: /* oid */ Long,
  ftoptions: Option[Array[String]]
)

object PgForeignTableRow {
  implicit val decoder: Decoder[PgForeignTableRow] =
    (c: HCursor) =>
      for {
        ftrelid <- c.downField("ftrelid").as[PgForeignTableId]
        ftserver <- c.downField("ftserver").as[/* oid */ Long]
        ftoptions <- c.downField("ftoptions").as[Option[Array[String]]]
      } yield PgForeignTableRow(ftrelid, ftserver, ftoptions)
  implicit val encoder: Encoder[PgForeignTableRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "ftrelid" := row.ftrelid,
        "ftserver" := row.ftserver,
        "ftoptions" := row.ftoptions
      )}
  implicit val read: Read[PgForeignTableRow] =
    new Read[PgForeignTableRow](
      gets = List(
        (Get[PgForeignTableId], Nullability.NoNulls),
        (Get[/* oid */ Long], Nullability.NoNulls),
        (Get[Array[String]], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PgForeignTableRow(
        ftrelid = Get[PgForeignTableId].unsafeGetNonNullable(rs, i + 0),
        ftserver = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 1),
        ftoptions = Get[Array[String]].unsafeGetNullable(rs, i + 2)
      )
    )
  

}