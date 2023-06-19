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
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

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
  val rowParser: RowParser[CuViewRow] =
    RowParser[CuViewRow] { row =>
      Success(
        CuViewRow(
          id = row[Option[/* bpchar */ String]]("id"),
          currencycode = row[Option[CurrencyId]]("currencycode"),
          name = row[Option[Name]]("name"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[CuViewRow] = new OFormat[CuViewRow]{
    override def writes(o: CuViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "currencycode" -> o.currencycode,
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CuViewRow] = {
      JsResult.fromTry(
        Try(
          CuViewRow(
            id = json.\("id").toOption.map(_.as[/* bpchar */ String]),
            currencycode = json.\("currencycode").toOption.map(_.as[CurrencyId]),
            name = json.\("name").toOption.map(_.as[Name]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
