/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.public.Name
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

case class LViewRow(
  id: Option[Int],
  /** Points to [[production.location.LocationRow.locationid]] */
  locationid: Option[LocationId],
  /** Points to [[production.location.LocationRow.name]] */
  name: Option[Name],
  /** Points to [[production.location.LocationRow.costrate]] */
  costrate: Option[BigDecimal],
  /** Points to [[production.location.LocationRow.availability]] */
  availability: Option[BigDecimal],
  /** Points to [[production.location.LocationRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object LViewRow {
  implicit lazy val reads: Reads[LViewRow] = Reads[LViewRow](json => JsResult.fromTry(
      Try(
        LViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          locationid = json.\("locationid").toOption.map(_.as(LocationId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          costrate = json.\("costrate").toOption.map(_.as(Reads.bigDecReads)),
          availability = json.\("availability").toOption.map(_.as(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[LViewRow] = RowParser[LViewRow] { row =>
    Success(
      LViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        locationid = row(idx + 1)(Column.columnToOption(LocationId.column)),
        name = row(idx + 2)(Column.columnToOption(Name.column)),
        costrate = row(idx + 3)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        availability = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        modifieddate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[LViewRow] = OWrites[LViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "locationid" -> Writes.OptionWrites(LocationId.writes).writes(o.locationid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "costrate" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.costrate),
      "availability" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.availability),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}