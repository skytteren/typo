/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package data_type_privileges

import adventureworks.information_schema.CharacterData
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

case class DataTypePrivilegesViewRow(
  objectCatalog: Option[SqlIdentifier],
  objectSchema: Option[SqlIdentifier],
  objectName: Option[SqlIdentifier],
  objectType: Option[CharacterData],
  /** Points to [[attributes.AttributesViewRow.dtdIdentifier]] */
  dtdIdentifier: Option[SqlIdentifier]
)

object DataTypePrivilegesViewRow {
  implicit val reads: Reads[DataTypePrivilegesViewRow] = Reads[DataTypePrivilegesViewRow](json => JsResult.fromTry(
      Try(
        DataTypePrivilegesViewRow(
          objectCatalog = json.\("object_catalog").toOption.map(_.as[SqlIdentifier]),
          objectSchema = json.\("object_schema").toOption.map(_.as[SqlIdentifier]),
          objectName = json.\("object_name").toOption.map(_.as[SqlIdentifier]),
          objectType = json.\("object_type").toOption.map(_.as[CharacterData]),
          dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[SqlIdentifier])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[DataTypePrivilegesViewRow] = RowParser[DataTypePrivilegesViewRow] { row =>
    Success(
      DataTypePrivilegesViewRow(
        objectCatalog = row[Option[SqlIdentifier]](idx + 0),
        objectSchema = row[Option[SqlIdentifier]](idx + 1),
        objectName = row[Option[SqlIdentifier]](idx + 2),
        objectType = row[Option[CharacterData]](idx + 3),
        dtdIdentifier = row[Option[SqlIdentifier]](idx + 4)
      )
    )
  }
  implicit val writes: OWrites[DataTypePrivilegesViewRow] = OWrites[DataTypePrivilegesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "object_catalog" -> Json.toJson(o.objectCatalog),
      "object_schema" -> Json.toJson(o.objectSchema),
      "object_name" -> Json.toJson(o.objectName),
      "object_type" -> Json.toJson(o.objectType),
      "dtd_identifier" -> Json.toJson(o.dtdIdentifier)
    ))
  )
}
