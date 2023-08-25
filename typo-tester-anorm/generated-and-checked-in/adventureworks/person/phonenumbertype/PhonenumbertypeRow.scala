/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class PhonenumbertypeRow(
  /** Primary key for telephone number type records. */
  phonenumbertypeid: PhonenumbertypeId,
  /** Name of the telephone number type */
  name: Name,
  modifieddate: TypoLocalDateTime
)

object PhonenumbertypeRow {
  implicit lazy val reads: Reads[PhonenumbertypeRow] = Reads[PhonenumbertypeRow](json => JsResult.fromTry(
      Try(
        PhonenumbertypeRow(
          phonenumbertypeid = json.\("phonenumbertypeid").as(PhonenumbertypeId.reads),
          name = json.\("name").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PhonenumbertypeRow] = RowParser[PhonenumbertypeRow] { row =>
    Success(
      PhonenumbertypeRow(
        phonenumbertypeid = row(idx + 0)(PhonenumbertypeId.column),
        name = row(idx + 1)(Name.column),
        modifieddate = row(idx + 2)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PhonenumbertypeRow] = OWrites[PhonenumbertypeRow](o =>
    new JsObject(ListMap[String, JsValue](
      "phonenumbertypeid" -> PhonenumbertypeId.writes.writes(o.phonenumbertypeid),
      "name" -> Name.writes.writes(o.name),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}