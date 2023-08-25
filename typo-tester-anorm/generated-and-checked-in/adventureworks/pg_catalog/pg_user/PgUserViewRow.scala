/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user

import adventureworks.customtypes.TypoOffsetDateTime
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

case class PgUserViewRow(
  /** Points to [[pg_shadow.PgShadowViewRow.usename]] */
  usename: Option[String],
  /** Points to [[pg_shadow.PgShadowViewRow.usesysid]] */
  usesysid: Option[/* oid */ Long],
  /** Points to [[pg_shadow.PgShadowViewRow.usecreatedb]] */
  usecreatedb: Option[Boolean],
  /** Points to [[pg_shadow.PgShadowViewRow.usesuper]] */
  usesuper: Option[Boolean],
  /** Points to [[pg_shadow.PgShadowViewRow.userepl]] */
  userepl: Option[Boolean],
  /** Points to [[pg_shadow.PgShadowViewRow.usebypassrls]] */
  usebypassrls: Option[Boolean],
  passwd: Option[String],
  /** Points to [[pg_shadow.PgShadowViewRow.valuntil]] */
  valuntil: Option[TypoOffsetDateTime],
  /** Points to [[pg_shadow.PgShadowViewRow.useconfig]] */
  useconfig: Option[Array[String]]
)

object PgUserViewRow {
  implicit lazy val reads: Reads[PgUserViewRow] = Reads[PgUserViewRow](json => JsResult.fromTry(
      Try(
        PgUserViewRow(
          usename = json.\("usename").toOption.map(_.as(Reads.StringReads)),
          usesysid = json.\("usesysid").toOption.map(_.as(Reads.LongReads)),
          usecreatedb = json.\("usecreatedb").toOption.map(_.as(Reads.BooleanReads)),
          usesuper = json.\("usesuper").toOption.map(_.as(Reads.BooleanReads)),
          userepl = json.\("userepl").toOption.map(_.as(Reads.BooleanReads)),
          usebypassrls = json.\("usebypassrls").toOption.map(_.as(Reads.BooleanReads)),
          passwd = json.\("passwd").toOption.map(_.as(Reads.StringReads)),
          valuntil = json.\("valuntil").toOption.map(_.as(TypoOffsetDateTime.reads)),
          useconfig = json.\("useconfig").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly)))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgUserViewRow] = RowParser[PgUserViewRow] { row =>
    Success(
      PgUserViewRow(
        usename = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        usesysid = row(idx + 1)(Column.columnToOption(Column.columnToLong)),
        usecreatedb = row(idx + 2)(Column.columnToOption(Column.columnToBoolean)),
        usesuper = row(idx + 3)(Column.columnToOption(Column.columnToBoolean)),
        userepl = row(idx + 4)(Column.columnToOption(Column.columnToBoolean)),
        usebypassrls = row(idx + 5)(Column.columnToOption(Column.columnToBoolean)),
        passwd = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        valuntil = row(idx + 7)(Column.columnToOption(TypoOffsetDateTime.column)),
        useconfig = row(idx + 8)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly)))
      )
    )
  }
  implicit lazy val writes: OWrites[PgUserViewRow] = OWrites[PgUserViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "usename" -> Writes.OptionWrites(Writes.StringWrites).writes(o.usename),
      "usesysid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.usesysid),
      "usecreatedb" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.usecreatedb),
      "usesuper" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.usesuper),
      "userepl" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.userepl),
      "usebypassrls" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.usebypassrls),
      "passwd" -> Writes.OptionWrites(Writes.StringWrites).writes(o.passwd),
      "valuntil" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.valuntil),
      "useconfig" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.useconfig)
    ))
  )
}