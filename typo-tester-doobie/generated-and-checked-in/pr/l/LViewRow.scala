/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import adventureworks.production.location.LocationId
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

case class LViewRow(
  id: Option[Int],
  /** Points to [[production.location.LocationRow.locationid]] */
  locationid: Option[LocationId],
  /** Points to [[production.location.LocationRow.name]] */
  name: Option[Name],
  /** Points to [[production.location.LocationRow.costrate]] */
  costrate: Option[BigDecimal],
  /** Points to [[production.location.LocationRow.availability]] */
  availability: Option[BigDecimal],
  /** Points to [[production.location.LocationRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object LViewRow {
  implicit val decoder: Decoder[LViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        locationid <- c.downField("locationid").as[Option[LocationId]]
        name <- c.downField("name").as[Option[Name]]
        costrate <- c.downField("costrate").as[Option[BigDecimal]]
        availability <- c.downField("availability").as[Option[BigDecimal]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield LViewRow(id, locationid, name, costrate, availability, modifieddate)
  implicit val encoder: Encoder[LViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "locationid" := row.locationid,
        "name" := row.name,
        "costrate" := row.costrate,
        "availability" := row.availability,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[LViewRow] =
    new Read[LViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[LocationId], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => LViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        locationid = Get[LocationId].unsafeGetNullable(rs, i + 1),
        name = Get[Name].unsafeGetNullable(rs, i + 2),
        costrate = Get[BigDecimal].unsafeGetNullable(rs, i + 3),
        availability = Get[BigDecimal].unsafeGetNullable(rs, i + 4),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 5)
      )
    )
  

}
