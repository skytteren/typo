/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoUnknownCitext
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

/** Table: public.users
    Primary key: user_id */
case class UsersRow(
  userId: UsersId,
  name: String,
  lastName: Option[String],
  email: TypoUnknownCitext,
  password: String,
  /** Default: now() */
  createdAt: TypoInstant,
  verifiedOn: Option[TypoInstant]
){
   def toUnsavedRow(createdAt: Defaulted[TypoInstant] = Defaulted.Provided(this.createdAt)): UsersRowUnsaved =
     UsersRowUnsaved(userId, name, lastName, email, password, verifiedOn, createdAt)
 }

object UsersRow {
  implicit lazy val reads: Reads[UsersRow] = Reads[UsersRow](json => JsResult.fromTry(
      Try(
        UsersRow(
          userId = json.\("user_id").as(UsersId.reads),
          name = json.\("name").as(Reads.StringReads),
          lastName = json.\("last_name").toOption.map(_.as(Reads.StringReads)),
          email = json.\("email").as(TypoUnknownCitext.reads),
          password = json.\("password").as(Reads.StringReads),
          createdAt = json.\("created_at").as(TypoInstant.reads),
          verifiedOn = json.\("verified_on").toOption.map(_.as(TypoInstant.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[UsersRow] = RowParser[UsersRow] { row =>
    Success(
      UsersRow(
        userId = row(idx + 0)(UsersId.column),
        name = row(idx + 1)(Column.columnToString),
        lastName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        email = row(idx + 3)(TypoUnknownCitext.column),
        password = row(idx + 4)(Column.columnToString),
        createdAt = row(idx + 5)(TypoInstant.column),
        verifiedOn = row(idx + 6)(Column.columnToOption(TypoInstant.column))
      )
    )
  }
  implicit lazy val text: Text[UsersRow] = Text.instance[UsersRow]{ (row, sb) =>
    UsersId.text.unsafeEncode(row.userId, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.lastName, sb)
    sb.append(Text.DELIMETER)
    TypoUnknownCitext.text.unsafeEncode(row.email, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.password, sb)
    sb.append(Text.DELIMETER)
    TypoInstant.text.unsafeEncode(row.createdAt, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoInstant.text).unsafeEncode(row.verifiedOn, sb)
  }
  implicit lazy val writes: OWrites[UsersRow] = OWrites[UsersRow](o =>
    new JsObject(ListMap[String, JsValue](
      "user_id" -> UsersId.writes.writes(o.userId),
      "name" -> Writes.StringWrites.writes(o.name),
      "last_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.lastName),
      "email" -> TypoUnknownCitext.writes.writes(o.email),
      "password" -> Writes.StringWrites.writes(o.password),
      "created_at" -> TypoInstant.writes.writes(o.createdAt),
      "verified_on" -> Writes.OptionWrites(TypoInstant.writes).writes(o.verifiedOn)
    ))
  )
}
