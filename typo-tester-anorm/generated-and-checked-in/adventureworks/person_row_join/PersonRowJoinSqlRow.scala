/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_row_join

import adventureworks.customtypes.TypoRecord
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
 *SQL file: person_row_join.sql */
case class PersonRowJoinSqlRow(
  /** Points to [[sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  email: /* nullability unknown */ Option[Array[TypoRecord]],
  emails: /* nullability unknown */ Option[Array[TypoRecord]]
)

object PersonRowJoinSqlRow {
  implicit lazy val reads: Reads[PersonRowJoinSqlRow] = Reads[PersonRowJoinSqlRow](json => JsResult.fromTry(
      Try(
        PersonRowJoinSqlRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          email = json.\("email").toOption.map(_.as(Reads.ArrayReads[TypoRecord](using TypoRecord.reads, implicitly))),
          emails = json.\("emails").toOption.map(_.as(Reads.ArrayReads[TypoRecord](using TypoRecord.reads, implicitly)))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PersonRowJoinSqlRow] = RowParser[PersonRowJoinSqlRow] { row =>
    Success(
      PersonRowJoinSqlRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        email = row(idx + 1)(Column.columnToOption(TypoRecord.arrayColumn)),
        emails = row(idx + 2)(Column.columnToOption(TypoRecord.arrayColumn))
      )
    )
  }
  implicit lazy val writes: OWrites[PersonRowJoinSqlRow] = OWrites[PersonRowJoinSqlRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "email" -> Writes.OptionWrites(Writes.arrayWrites[TypoRecord](using implicitly, TypoRecord.writes)).writes(o.email),
      "emails" -> Writes.OptionWrites(Writes.arrayWrites[TypoRecord](using implicitly, TypoRecord.writes)).writes(o.emails)
    ))
  )
}
