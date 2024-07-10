/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_dynamic

import adventureworks.public.Name
import adventureworks.userdefined.FirstName
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/**
 *SQL file: person_dynamic.sql */
case class PersonDynamicSqlRow(
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Name
)

object PersonDynamicSqlRow {
  implicit lazy val decoder: Decoder[PersonDynamicSqlRow] = Decoder.forProduct4[PersonDynamicSqlRow, Option[/* max 8 chars */ String], /* user-picked */ FirstName, Option[Name], Name]("title", "firstname", "middlename", "lastname")(PersonDynamicSqlRow.apply)(Decoder.decodeOption(Decoder.decodeString), FirstName.decoder, Decoder.decodeOption(Name.decoder), Name.decoder)
  implicit lazy val encoder: Encoder[PersonDynamicSqlRow] = Encoder.forProduct4[PersonDynamicSqlRow, Option[/* max 8 chars */ String], /* user-picked */ FirstName, Option[Name], Name]("title", "firstname", "middlename", "lastname")(x => (x.title, x.firstname, x.middlename, x.lastname))(Encoder.encodeOption(Encoder.encodeString), FirstName.encoder, Encoder.encodeOption(Name.encoder), Name.encoder)
  implicit lazy val read: Read[PersonDynamicSqlRow] = new Read[PersonDynamicSqlRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (/* user-picked */ FirstName.get, Nullability.NoNulls),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PersonDynamicSqlRow(
      title = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      firstname = /* user-picked */ FirstName.get.unsafeGetNonNullable(rs, i + 1),
      middlename = Name.get.unsafeGetNullable(rs, i + 2),
      lastname = Name.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
