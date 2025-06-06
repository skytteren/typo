/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package issue142

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Table: public.issue142
    Primary key: tabellkode */
case class Issue142Row(
  tabellkode: Issue142Id
){
   val id = tabellkode
 }

object Issue142Row {
  implicit lazy val reads: Reads[Issue142Row] = Reads[Issue142Row](json => JsResult.fromTry(
      Try(
        Issue142Row(
          tabellkode = json.\("tabellkode").as(Issue142Id.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[Issue142Row] = RowParser[Issue142Row] { row =>
    Success(
      Issue142Row(
        tabellkode = row(idx + 0)(Issue142Id.column)
      )
    )
  }
  implicit lazy val text: Text[Issue142Row] = Text.instance[Issue142Row]{ (row, sb) =>
    Issue142Id.text.unsafeEncode(row.tabellkode, sb)
  }
  implicit lazy val writes: OWrites[Issue142Row] = OWrites[Issue142Row](o =>
    new JsObject(ListMap[String, JsValue](
      "tabellkode" -> Issue142Id.writes.writes(o.tabellkode)
    ))
  )
}
