/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package enabled_roles

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

case class EnabledRolesViewRow(
  roleName: Option[SqlIdentifier]
)

object EnabledRolesViewRow {
  implicit val reads: Reads[EnabledRolesViewRow] = Reads[EnabledRolesViewRow](json => JsResult.fromTry(
      Try(
        EnabledRolesViewRow(
          roleName = json.\("role_name").toOption.map(_.as[SqlIdentifier])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EnabledRolesViewRow] = RowParser[EnabledRolesViewRow] { row =>
    Success(
      EnabledRolesViewRow(
        roleName = row[Option[SqlIdentifier]](idx + 0)
      )
    )
  }
  implicit val writes: OWrites[EnabledRolesViewRow] = OWrites[EnabledRolesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "role_name" -> Json.toJson(o.roleName)
    ))
  )
}
