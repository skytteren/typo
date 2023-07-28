/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cu

import adventureworks.public.Name
import adventureworks.sales.currency.CurrencyId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class CuViewRow(
  id: Option[/* bpchar */ String],
  /** Points to [[sales.currency.CurrencyRow.currencycode]] */
  currencycode: Option[CurrencyId],
  /** Points to [[sales.currency.CurrencyRow.name]] */
  name: Option[Name],
  /** Points to [[sales.currency.CurrencyRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object CuViewRow {
  implicit val decoder: Decoder[CuViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[/* bpchar */ String]]
        currencycode <- c.downField("currencycode").as[Option[CurrencyId]]
        name <- c.downField("name").as[Option[Name]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield CuViewRow(id, currencycode, name, modifieddate)
  implicit val encoder: Encoder[CuViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "currencycode" := row.currencycode,
        "name" := row.name,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[CuViewRow] =
    new Read[CuViewRow](
      gets = List(
        (Get[/* bpchar */ String], Nullability.Nullable),
        (Get[CurrencyId], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => CuViewRow(
        id = Get[/* bpchar */ String].unsafeGetNullable(rs, i + 0),
        currencycode = Get[CurrencyId].unsafeGetNullable(rs, i + 1),
        name = Get[Name].unsafeGetNullable(rs, i + 2),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 3)
      )
    )
  

}