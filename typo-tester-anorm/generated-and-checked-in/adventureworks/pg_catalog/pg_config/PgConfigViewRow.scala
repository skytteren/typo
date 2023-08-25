/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_config

import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgConfigViewRow(
  name: Option[String],
  setting: Option[String]
)

object PgConfigViewRow {
  implicit lazy val reads: Reads[PgConfigViewRow] = Reads[PgConfigViewRow](json => JsResult.fromTry(
      Try(
        PgConfigViewRow(
          name = json.\("name").toOption.map(_.as(Reads.StringReads)),
          setting = json.\("setting").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgConfigViewRow] = RowParser[PgConfigViewRow] { row =>
    Success(
      PgConfigViewRow(
        name = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        setting = row(idx + 1)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PgConfigViewRow] = OWrites[PgConfigViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.name),
      "setting" -> Writes.OptionWrites(Writes.StringWrites).writes(o.setting)
    ))
  )
}