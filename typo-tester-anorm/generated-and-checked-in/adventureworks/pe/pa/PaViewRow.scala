/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
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

/**
 *View: pe.pa */
case class PaViewRow(
  /** Points to [[person.password.PasswordRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[person.password.PasswordRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.password.PasswordRow.passwordhash]] */
  passwordhash: /* max 128 chars */ String,
  /** Points to [[person.password.PasswordRow.passwordsalt]] */
  passwordsalt: /* max 10 chars */ String,
  /** Points to [[person.password.PasswordRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[person.password.PasswordRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PaViewRow {
  implicit lazy val reads: Reads[PaViewRow] = Reads[PaViewRow](json => JsResult.fromTry(
      Try(
        PaViewRow(
          id = json.\("id").as(BusinessentityId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          passwordhash = json.\("passwordhash").as(Reads.StringReads),
          passwordsalt = json.\("passwordsalt").as(Reads.StringReads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PaViewRow] = RowParser[PaViewRow] { row =>
    Success(
      PaViewRow(
        id = row(idx + 0)(BusinessentityId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        passwordhash = row(idx + 2)(Column.columnToString),
        passwordsalt = row(idx + 3)(Column.columnToString),
        rowguid = row(idx + 4)(TypoUUID.column),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PaViewRow] = OWrites[PaViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> BusinessentityId.writes.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "passwordhash" -> Writes.StringWrites.writes(o.passwordhash),
      "passwordsalt" -> Writes.StringWrites.writes(o.passwordsalt),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
