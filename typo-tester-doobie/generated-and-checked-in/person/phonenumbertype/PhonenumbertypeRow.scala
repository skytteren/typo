/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import adventureworks.public.Name
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class PhonenumbertypeRow(
  /** Primary key for telephone number type records. */
  phonenumbertypeid: PhonenumbertypeId,
  /** Name of the telephone number type */
  name: Name,
  modifieddate: LocalDateTime
)

object PhonenumbertypeRow {
  implicit val decoder: Decoder[PhonenumbertypeRow] =
    (c: HCursor) =>
      for {
        phonenumbertypeid <- c.downField("phonenumbertypeid").as[PhonenumbertypeId]
        name <- c.downField("name").as[Name]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield PhonenumbertypeRow(phonenumbertypeid, name, modifieddate)
  implicit val encoder: Encoder[PhonenumbertypeRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "phonenumbertypeid" := row.phonenumbertypeid,
        "name" := row.name,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[PhonenumbertypeRow] =
    new Read[PhonenumbertypeRow](
      gets = List(
        (Get[PhonenumbertypeId], Nullability.NoNulls),
        (Get[Name], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PhonenumbertypeRow(
        phonenumbertypeid = Get[PhonenumbertypeId].unsafeGetNonNullable(rs, i + 0),
        name = Get[Name].unsafeGetNonNullable(rs, i + 1),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 2)
      )
    )
  

}