/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collation_character_set_applicability

import adventureworks.information_schema.SqlIdentifier
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

case class CollationCharacterSetApplicabilityViewRow(
  collationCatalog: Option[SqlIdentifier],
  collationSchema: Option[SqlIdentifier],
  collationName: Option[SqlIdentifier],
  characterSetCatalog: Option[SqlIdentifier],
  characterSetSchema: Option[SqlIdentifier],
  characterSetName: Option[SqlIdentifier]
)

object CollationCharacterSetApplicabilityViewRow {
  implicit val reads: Reads[CollationCharacterSetApplicabilityViewRow] = Reads[CollationCharacterSetApplicabilityViewRow](json => JsResult.fromTry(
      Try(
        CollationCharacterSetApplicabilityViewRow(
          collationCatalog = json.\("collation_catalog").toOption.map(_.as[SqlIdentifier]),
          collationSchema = json.\("collation_schema").toOption.map(_.as[SqlIdentifier]),
          collationName = json.\("collation_name").toOption.map(_.as[SqlIdentifier]),
          characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[SqlIdentifier]),
          characterSetSchema = json.\("character_set_schema").toOption.map(_.as[SqlIdentifier]),
          characterSetName = json.\("character_set_name").toOption.map(_.as[SqlIdentifier])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CollationCharacterSetApplicabilityViewRow] = RowParser[CollationCharacterSetApplicabilityViewRow] { row =>
    Success(
      CollationCharacterSetApplicabilityViewRow(
        collationCatalog = row[Option[SqlIdentifier]](idx + 0),
        collationSchema = row[Option[SqlIdentifier]](idx + 1),
        collationName = row[Option[SqlIdentifier]](idx + 2),
        characterSetCatalog = row[Option[SqlIdentifier]](idx + 3),
        characterSetSchema = row[Option[SqlIdentifier]](idx + 4),
        characterSetName = row[Option[SqlIdentifier]](idx + 5)
      )
    )
  }
  implicit val writes: OWrites[CollationCharacterSetApplicabilityViewRow] = OWrites[CollationCharacterSetApplicabilityViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "collation_catalog" -> Json.toJson(o.collationCatalog),
      "collation_schema" -> Json.toJson(o.collationSchema),
      "collation_name" -> Json.toJson(o.collationName),
      "character_set_catalog" -> Json.toJson(o.characterSetCatalog),
      "character_set_schema" -> Json.toJson(o.characterSetSchema),
      "character_set_name" -> Json.toJson(o.characterSetName)
    ))
  )
}
