/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import adventureworks.TypoXml
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class IllustrationRow(
  /** Primary key for Illustration records. */
  illustrationid: IllustrationId,
  /** Illustrations used in manufacturing instructions. Stored as XML. */
  diagram: Option[TypoXml],
  modifieddate: LocalDateTime
)

object IllustrationRow {
  implicit val decoder: Decoder[IllustrationRow] =
    (c: HCursor) =>
      for {
        illustrationid <- c.downField("illustrationid").as[IllustrationId]
        diagram <- c.downField("diagram").as[Option[TypoXml]]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield IllustrationRow(illustrationid, diagram, modifieddate)
  implicit val encoder: Encoder[IllustrationRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "illustrationid" := row.illustrationid,
        "diagram" := row.diagram,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[IllustrationRow] =
    new Read[IllustrationRow](
      gets = List(
        (Get[IllustrationId], Nullability.NoNulls),
        (Get[TypoXml], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => IllustrationRow(
        illustrationid = Get[IllustrationId].unsafeGetNonNullable(rs, i + 0),
        diagram = Get[TypoXml].unsafeGetNullable(rs, i + 1),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 2)
      )
    )
  

}
