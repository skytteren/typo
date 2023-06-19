/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId

case class PersonRow(
  id: PersonId,
  /** Points to [[football_club.FootballClubRow.id]] */
  favouriteFootballClubId: FootballClubId,
  name: /* max 100 chars */ String,
  nickName: Option[/* max 30 chars */ String],
  blogUrl: Option[/* max 100 chars */ String],
  email: /* max 254 chars */ String,
  phone: /* max 8 chars */ String,
  likesPizza: Boolean,
  /** Points to [[marital_status.MaritalStatusRow.id]] */
  maritalStatusId: MaritalStatusId,
  workEmail: Option[/* max 254 chars */ String],
  sector: Sector
)

object PersonRow {
  val rowParser: RowParser[PersonRow] =
    RowParser[PersonRow] { row =>
      Success(
        PersonRow(
          id = row[PersonId]("id"),
          favouriteFootballClubId = row[FootballClubId]("favourite_football_club_id"),
          name = row[/* max 100 chars */ String]("name"),
          nickName = row[Option[/* max 30 chars */ String]]("nick_name"),
          blogUrl = row[Option[/* max 100 chars */ String]]("blog_url"),
          email = row[/* max 254 chars */ String]("email"),
          phone = row[/* max 8 chars */ String]("phone"),
          likesPizza = row[Boolean]("likes_pizza"),
          maritalStatusId = row[MaritalStatusId]("marital_status_id"),
          workEmail = row[Option[/* max 254 chars */ String]]("work_email"),
          sector = row[Sector]("sector")
        )
      )
    }
  implicit val oFormat: OFormat[PersonRow] = new OFormat[PersonRow]{
    override def writes(o: PersonRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "favourite_football_club_id" -> o.favouriteFootballClubId,
        "name" -> o.name,
        "nick_name" -> o.nickName,
        "blog_url" -> o.blogUrl,
        "email" -> o.email,
        "phone" -> o.phone,
        "likes_pizza" -> o.likesPizza,
        "marital_status_id" -> o.maritalStatusId,
        "work_email" -> o.workEmail,
        "sector" -> o.sector
      )
  
    override def reads(json: JsValue): JsResult[PersonRow] = {
      JsResult.fromTry(
        Try(
          PersonRow(
            id = json.\("id").as[PersonId],
            favouriteFootballClubId = json.\("favourite_football_club_id").as[FootballClubId],
            name = json.\("name").as[/* max 100 chars */ String],
            nickName = json.\("nick_name").toOption.map(_.as[/* max 30 chars */ String]),
            blogUrl = json.\("blog_url").toOption.map(_.as[/* max 100 chars */ String]),
            email = json.\("email").as[/* max 254 chars */ String],
            phone = json.\("phone").as[/* max 8 chars */ String],
            likesPizza = json.\("likes_pizza").as[Boolean],
            maritalStatusId = json.\("marital_status_id").as[MaritalStatusId],
            workEmail = json.\("work_email").toOption.map(_.as[/* max 254 chars */ String]),
            sector = json.\("sector").as[Sector]
          )
        )
      )
    }
  }
}
