/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmi

import adventureworks.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
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

case class PmiViewRow(
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.illustrationid]] */
  illustrationid: Option[IllustrationId],
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PmiViewRow {
  implicit val reads: Reads[PmiViewRow] = Reads[PmiViewRow](json => JsResult.fromTry(
      Try(
        PmiViewRow(
          productmodelid = json.\("productmodelid").toOption.map(_.as[ProductmodelId]),
          illustrationid = json.\("illustrationid").toOption.map(_.as[IllustrationId]),
          modifieddate = json.\("modifieddate").toOption.map(_.as[TypoLocalDateTime])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PmiViewRow] = RowParser[PmiViewRow] { row =>
    Success(
      PmiViewRow(
        productmodelid = row[Option[ProductmodelId]](idx + 0),
        illustrationid = row[Option[IllustrationId]](idx + 1),
        modifieddate = row[Option[TypoLocalDateTime]](idx + 2)
      )
    )
  }
  implicit val writes: OWrites[PmiViewRow] = OWrites[PmiViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> Json.toJson(o.productmodelid),
      "illustrationid" -> Json.toJson(o.illustrationid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
