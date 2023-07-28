/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class FootballClubRow(
  id: FootballClubId,
  name: /* max 100 chars */ String
)

object FootballClubRow {
  implicit val decoder: Decoder[FootballClubRow] = Decoder.forProduct2[FootballClubRow, FootballClubId, /* max 100 chars */ String]("id", "name")(FootballClubRow.apply)
  implicit val encoder: Encoder[FootballClubRow] = Encoder.forProduct2[FootballClubRow, FootballClubId, /* max 100 chars */ String]("id", "name")(x => (x.id, x.name))
  implicit val read: Read[FootballClubRow] = new Read[FootballClubRow](
    gets = List(
      (Get[FootballClubId], Nullability.NoNulls),
      (Get[/* max 100 chars */ String], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => FootballClubRow(
      id = Get[FootballClubId].unsafeGetNonNullable(rs, i + 0),
      name = Get[/* max 100 chars */ String].unsafeGetNonNullable(rs, i + 1)
    )
  )
}
