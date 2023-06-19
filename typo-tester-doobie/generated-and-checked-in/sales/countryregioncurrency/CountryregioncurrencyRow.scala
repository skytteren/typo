/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.person.countryregion.CountryregionId
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

case class CountryregioncurrencyRow(
  /** ISO code for countries and regions. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** ISO standard currency code. Foreign key to Currency.CurrencyCode.
      Points to [[currency.CurrencyRow.currencycode]] */
  currencycode: CurrencyId,
  modifieddate: LocalDateTime
){
   val compositeId: CountryregioncurrencyId = CountryregioncurrencyId(countryregioncode, currencycode)
 }

object CountryregioncurrencyRow {
  implicit val decoder: Decoder[CountryregioncurrencyRow] =
    (c: HCursor) =>
      for {
        countryregioncode <- c.downField("countryregioncode").as[CountryregionId]
        currencycode <- c.downField("currencycode").as[CurrencyId]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield CountryregioncurrencyRow(countryregioncode, currencycode, modifieddate)
  implicit val encoder: Encoder[CountryregioncurrencyRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "countryregioncode" := row.countryregioncode,
        "currencycode" := row.currencycode,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[CountryregioncurrencyRow] =
    new Read[CountryregioncurrencyRow](
      gets = List(
        (Get[CountryregionId], Nullability.NoNulls),
        (Get[CurrencyId], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => CountryregioncurrencyRow(
        countryregioncode = Get[CountryregionId].unsafeGetNonNullable(rs, i + 0),
        currencycode = Get[CurrencyId].unsafeGetNonNullable(rs, i + 1),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 2)
      )
    )
  

}
