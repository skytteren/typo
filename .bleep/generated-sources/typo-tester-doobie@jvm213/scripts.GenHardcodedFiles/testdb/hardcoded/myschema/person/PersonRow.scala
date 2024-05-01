/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import testdb.hardcoded.customtypes.Defaulted
import testdb.hardcoded.myschema.Number
import testdb.hardcoded.myschema.Sector
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
  /** Default: PUBLIC */
  sector: Sector,
  /** Default: one */
  favoriteNumber: Number
){
   def toUnsavedRow(id: Defaulted[PersonId], maritalStatusId: Defaulted[MaritalStatusId] = Defaulted.Provided(this.maritalStatusId), sector: Defaulted[Sector] = Defaulted.Provided(this.sector), favoriteNumber: Defaulted[Number] = Defaulted.Provided(this.favoriteNumber)): PersonRowUnsaved =
     PersonRowUnsaved(favouriteFootballClubId, name, nickName, blogUrl, email, phone, likesPizza, workEmail, id, maritalStatusId, sector, favoriteNumber)
 }

object PersonRow {
  implicit lazy val decoder: Decoder[PersonRow] = Decoder.forProduct12[PersonRow, PersonId, FootballClubId, /* max 100 chars */ String, Option[/* max 30 chars */ String], Option[/* max 100 chars */ String], /* max 254 chars */ String, /* max 8 chars */ String, Boolean, MaritalStatusId, Option[/* max 254 chars */ String], Sector, Number]("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")(PersonRow.apply)(PersonId.decoder, FootballClubId.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Decoder.decodeString, Decoder.decodeBoolean, MaritalStatusId.decoder, Decoder.decodeOption(Decoder.decodeString), Sector.decoder, Number.decoder)
  implicit lazy val encoder: Encoder[PersonRow] = Encoder.forProduct12[PersonRow, PersonId, FootballClubId, /* max 100 chars */ String, Option[/* max 30 chars */ String], Option[/* max 100 chars */ String], /* max 254 chars */ String, /* max 8 chars */ String, Boolean, MaritalStatusId, Option[/* max 254 chars */ String], Sector, Number]("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")(x => (x.id, x.favouriteFootballClubId, x.name, x.nickName, x.blogUrl, x.email, x.phone, x.likesPizza, x.maritalStatusId, x.workEmail, x.sector, x.favoriteNumber))(PersonId.encoder, FootballClubId.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Encoder.encodeString, Encoder.encodeBoolean, MaritalStatusId.encoder, Encoder.encodeOption(Encoder.encodeString), Sector.encoder, Number.encoder)
  implicit lazy val read: Read[PersonRow] = new Read[PersonRow](
    gets = List(
      (PersonId.get, Nullability.NoNulls),
      (FootballClubId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (MaritalStatusId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Sector.get, Nullability.NoNulls),
      (Number.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PersonRow(
      id = PersonId.get.unsafeGetNonNullable(rs, i + 0),
      favouriteFootballClubId = FootballClubId.get.unsafeGetNonNullable(rs, i + 1),
      name = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      nickName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      blogUrl = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      email = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      phone = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      likesPizza = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 7),
      maritalStatusId = MaritalStatusId.get.unsafeGetNonNullable(rs, i + 8),
      workEmail = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9),
      sector = Sector.get.unsafeGetNonNullable(rs, i + 10),
      favoriteNumber = Number.get.unsafeGetNonNullable(rs, i + 11)
    )
  )
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
    Sector.text.unsafeEncode(row.sector, sb)
    sb.append(Text.DELIMETER)
    Number.text.unsafeEncode(row.favoriteNumber, sb)
  }
}
