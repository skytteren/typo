/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package cr

import adventureworks.person.countryregion.CountryregionId
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

case class CrViewRow(
  /** Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: Option[CountryregionId],
  /** Points to [[person.countryregion.CountryregionRow.name]] */
  name: Option[Name],
  /** Points to [[person.countryregion.CountryregionRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object CrViewRow {
  implicit val decoder: Decoder[CrViewRow] =
    (c: HCursor) =>
      for {
        countryregioncode <- c.downField("countryregioncode").as[Option[CountryregionId]]
        name <- c.downField("name").as[Option[Name]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield CrViewRow(countryregioncode, name, modifieddate)
  implicit val encoder: Encoder[CrViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "countryregioncode" := row.countryregioncode,
        "name" := row.name,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[CrViewRow] =
    new Read[CrViewRow](
      gets = List(
        (Get[CountryregionId], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => CrViewRow(
        countryregioncode = Get[CountryregionId].unsafeGetNullable(rs, i + 0),
        name = Get[Name].unsafeGetNullable(rs, i + 1),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 2)
      )
    )
  

}
