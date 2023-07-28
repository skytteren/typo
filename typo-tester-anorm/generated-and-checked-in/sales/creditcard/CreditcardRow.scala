/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.TypoLocalDateTime
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class CreditcardRow(
  /** Primary key for CreditCard records. */
  creditcardid: CreditcardId,
  /** Credit card name. */
  cardtype: /* max 50 chars */ String,
  /** Credit card number. */
  cardnumber: /* max 25 chars */ String,
  /** Credit card expiration month. */
  expmonth: Int,
  /** Credit card expiration year. */
  expyear: Int,
  modifieddate: TypoLocalDateTime
)

object CreditcardRow {
  implicit val reads: Reads[CreditcardRow] = Reads[CreditcardRow](json => JsResult.fromTry(
      Try(
        CreditcardRow(
          creditcardid = json.\("creditcardid").as[CreditcardId],
          cardtype = json.\("cardtype").as[/* max 50 chars */ String],
          cardnumber = json.\("cardnumber").as[/* max 25 chars */ String],
          expmonth = json.\("expmonth").as[Int],
          expyear = json.\("expyear").as[Int],
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CreditcardRow] = RowParser[CreditcardRow] { row =>
    Success(
      CreditcardRow(
        creditcardid = row[CreditcardId](idx + 0),
        cardtype = row[/* max 50 chars */ String](idx + 1),
        cardnumber = row[/* max 25 chars */ String](idx + 2),
        expmonth = row[Int](idx + 3),
        expyear = row[Int](idx + 4),
        modifieddate = row[TypoLocalDateTime](idx + 5)
      )
    )
  }
  implicit val writes: OWrites[CreditcardRow] = OWrites[CreditcardRow](o =>
    new JsObject(ListMap[String, JsValue](
      "creditcardid" -> Json.toJson(o.creditcardid),
      "cardtype" -> Json.toJson(o.cardtype),
      "cardnumber" -> Json.toJson(o.cardnumber),
      "expmonth" -> Json.toJson(o.expmonth),
      "expyear" -> Json.toJson(o.expyear),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
