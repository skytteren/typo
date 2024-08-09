/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

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
import testdb.hardcoded.customtypes.Defaulted
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId

/** Table: myschema.person
    person table
    Primary key: id */
case class PersonRow(
  /** Default: auto-increment */
  id: PersonId,
  /** Points to [[football_club.FootballClubRow.id]] */
  favouriteFootballClubId: FootballClubId,
  name: /* max 100 chars */ String,
  nickName: Option[/* max 30 chars */ String],
  blogUrl: Option[/* max 100 chars */ String],
  email: /* max 254 chars */ String,
  phone: /* max 8 chars */ String,
  likesPizza: Boolean,
  /** Default: some-value
      Points to [[marital_status.MaritalStatusRow.id]] */
  maritalStatusId: MaritalStatusId,
  workEmail: Option[/* max 254 chars */ String],
  /** Default: PUBLIC
      Identity ALWAYS */
  sector: Sector,
  /** Default: one */
  favoriteNumber: Number
){
   def toUnsavedRow(id: Defaulted[PersonId], maritalStatusId: Defaulted[MaritalStatusId] = Defaulted.Provided(this.maritalStatusId), favoriteNumber: Defaulted[Number] = Defaulted.Provided(this.favoriteNumber)): PersonRowUnsaved =
     PersonRowUnsaved(favouriteFootballClubId, name, nickName, blogUrl, email, phone, likesPizza, workEmail, id, maritalStatusId, favoriteNumber)
 }

object PersonRow {
  implicit lazy val reads: Reads[PersonRow] = Reads[PersonRow](json => JsResult.fromTry(
      Try(
        PersonRow(
          id = json.\("id").as(PersonId.reads),
          favouriteFootballClubId = json.\("favourite_football_club_id").as(FootballClubId.reads),
          name = json.\("name").as(Reads.StringReads),
          nickName = json.\("nick_name").toOption.map(_.as(Reads.StringReads)),
          blogUrl = json.\("blog_url").toOption.map(_.as(Reads.StringReads)),
          email = json.\("email").as(Reads.StringReads),
          phone = json.\("phone").as(Reads.StringReads),
          likesPizza = json.\("likes_pizza").as(Reads.BooleanReads),
          maritalStatusId = json.\("marital_status_id").as(MaritalStatusId.reads),
          workEmail = json.\("work_email").toOption.map(_.as(Reads.StringReads)),
          sector = json.\("sector").as(Sector.reads),
          favoriteNumber = json.\("favorite_number").as(Number.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PersonRow] = RowParser[PersonRow] { row =>
    Success(
      PersonRow(
        id = row(idx + 0)(PersonId.column),
        favouriteFootballClubId = row(idx + 1)(FootballClubId.column),
        name = row(idx + 2)(Column.columnToString),
        nickName = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        blogUrl = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        email = row(idx + 5)(Column.columnToString),
        phone = row(idx + 6)(Column.columnToString),
        likesPizza = row(idx + 7)(Column.columnToBoolean),
        maritalStatusId = row(idx + 8)(MaritalStatusId.column),
        workEmail = row(idx + 9)(Column.columnToOption(Column.columnToString)),
        sector = row(idx + 10)(Sector.column),
        favoriteNumber = row(idx + 11)(Number.column)
      )
    )
  }
  implicit lazy val text: Text[PersonRow] = Text.instance[PersonRow]{ (row, sb) =>
    PersonId.text.unsafeEncode(row.id, sb)
    sb.append(Text.DELIMETER)
    FootballClubId.text.unsafeEncode(row.favouriteFootballClubId, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.nickName, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.blogUrl, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.email, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.phone, sb)
    sb.append(Text.DELIMETER)
    Text.booleanInstance.unsafeEncode(row.likesPizza, sb)
    sb.append(Text.DELIMETER)
    MaritalStatusId.text.unsafeEncode(row.maritalStatusId, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.workEmail, sb)
    sb.append(Text.DELIMETER)
    Number.text.unsafeEncode(row.favoriteNumber, sb)
  }
  implicit lazy val writes: OWrites[PersonRow] = OWrites[PersonRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> PersonId.writes.writes(o.id),
      "favourite_football_club_id" -> FootballClubId.writes.writes(o.favouriteFootballClubId),
      "name" -> Writes.StringWrites.writes(o.name),
      "nick_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.nickName),
      "blog_url" -> Writes.OptionWrites(Writes.StringWrites).writes(o.blogUrl),
      "email" -> Writes.StringWrites.writes(o.email),
      "phone" -> Writes.StringWrites.writes(o.phone),
      "likes_pizza" -> Writes.BooleanWrites.writes(o.likesPizza),
      "marital_status_id" -> MaritalStatusId.writes.writes(o.maritalStatusId),
      "work_email" -> Writes.OptionWrites(Writes.StringWrites).writes(o.workEmail),
      "sector" -> Sector.writes.writes(o.sector),
      "favorite_number" -> Number.writes.writes(o.favoriteNumber)
    ))
  )
}
