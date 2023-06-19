/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

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
import java.util.UUID

case class AddresstypeRow(
  /** Primary key for AddressType records. */
  addresstypeid: AddresstypeId,
  /** Address type description. For example, Billing, Home, or Shipping. */
  name: Name,
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object AddresstypeRow {
  implicit val decoder: Decoder[AddresstypeRow] =
    (c: HCursor) =>
      for {
        addresstypeid <- c.downField("addresstypeid").as[AddresstypeId]
        name <- c.downField("name").as[Name]
        rowguid <- c.downField("rowguid").as[UUID]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield AddresstypeRow(addresstypeid, name, rowguid, modifieddate)
  implicit val encoder: Encoder[AddresstypeRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "addresstypeid" := row.addresstypeid,
        "name" := row.name,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[AddresstypeRow] =
    new Read[AddresstypeRow](
      gets = List(
        (Get[AddresstypeId], Nullability.NoNulls),
        (Get[Name], Nullability.NoNulls),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => AddresstypeRow(
        addresstypeid = Get[AddresstypeId].unsafeGetNonNullable(rs, i + 0),
        name = Get[Name].unsafeGetNonNullable(rs, i + 1),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 2),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 3)
      )
    )
  

}
