/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import adventureworks.sales.currency.CurrencyId
import adventureworks.sales.currencyrate.CurrencyrateId
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
  /** Points to [[sales.currencyrate.CurrencyrateRow.currencyrateid]] */
  currencyrateid: Option[CurrencyrateId],
  /** Points to [[sales.currencyrate.CurrencyrateRow.currencyratedate]] */
  currencyratedate: Option[LocalDateTime],
  /** Points to [[sales.currencyrate.CurrencyrateRow.fromcurrencycode]] */
  fromcurrencycode: Option[CurrencyId],
  /** Points to [[sales.currencyrate.CurrencyrateRow.tocurrencycode]] */
  tocurrencycode: Option[CurrencyId],
  /** Points to [[sales.currencyrate.CurrencyrateRow.averagerate]] */
  averagerate: Option[BigDecimal],
  /** Points to [[sales.currencyrate.CurrencyrateRow.endofdayrate]] */
  endofdayrate: Option[BigDecimal],
  /** Points to [[sales.currencyrate.CurrencyrateRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object CrViewRow {
  implicit val decoder: Decoder[CrViewRow] =
    (c: HCursor) =>
      for {
        currencyrateid <- c.downField("currencyrateid").as[Option[CurrencyrateId]]
        currencyratedate <- c.downField("currencyratedate").as[Option[LocalDateTime]]
        fromcurrencycode <- c.downField("fromcurrencycode").as[Option[CurrencyId]]
        tocurrencycode <- c.downField("tocurrencycode").as[Option[CurrencyId]]
        averagerate <- c.downField("averagerate").as[Option[BigDecimal]]
        endofdayrate <- c.downField("endofdayrate").as[Option[BigDecimal]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield CrViewRow(currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate)
  implicit val encoder: Encoder[CrViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "currencyrateid" := row.currencyrateid,
        "currencyratedate" := row.currencyratedate,
        "fromcurrencycode" := row.fromcurrencycode,
        "tocurrencycode" := row.tocurrencycode,
        "averagerate" := row.averagerate,
        "endofdayrate" := row.endofdayrate,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[CrViewRow] =
    new Read[CrViewRow](
      gets = List(
        (Get[CurrencyrateId], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[CurrencyId], Nullability.Nullable),
        (Get[CurrencyId], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => CrViewRow(
        currencyrateid = Get[CurrencyrateId].unsafeGetNullable(rs, i + 0),
        currencyratedate = Get[LocalDateTime].unsafeGetNullable(rs, i + 1),
        fromcurrencycode = Get[CurrencyId].unsafeGetNullable(rs, i + 2),
        tocurrencycode = Get[CurrencyId].unsafeGetNullable(rs, i + 3),
        averagerate = Get[BigDecimal].unsafeGetNullable(rs, i + 4),
        endofdayrate = Get[BigDecimal].unsafeGetNullable(rs, i + 5),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 6)
      )
    )
  

}
