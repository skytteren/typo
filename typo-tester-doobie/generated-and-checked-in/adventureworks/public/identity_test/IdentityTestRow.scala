/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import adventureworks.customtypes.Defaulted
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: public.identity-test
    Primary key: name */
case class IdentityTestRow(
  /** Identity ALWAYS, identityStart: 1, identityIncrement: 1, identityMaximum: 2147483647, identityMinimum: 1 */
  alwaysGenerated: Int,
  /** Identity BY DEFAULT, identityStart: 1, identityIncrement: 1, identityMaximum: 2147483647, identityMinimum: 1 */
  defaultGenerated: Int,
  name: IdentityTestId
){
   val id = name
   def toUnsavedRow(defaultGenerated: Defaulted[Int] = Defaulted.Provided(this.defaultGenerated)): IdentityTestRowUnsaved =
     IdentityTestRowUnsaved(name, defaultGenerated)
 }

object IdentityTestRow {
  implicit lazy val decoder: Decoder[IdentityTestRow] = Decoder.forProduct3[IdentityTestRow, Int, Int, IdentityTestId]("always_generated", "default_generated", "name")(IdentityTestRow.apply)(Decoder.decodeInt, Decoder.decodeInt, IdentityTestId.decoder)
  implicit lazy val encoder: Encoder[IdentityTestRow] = Encoder.forProduct3[IdentityTestRow, Int, Int, IdentityTestId]("always_generated", "default_generated", "name")(x => (x.alwaysGenerated, x.defaultGenerated, x.name))(Encoder.encodeInt, Encoder.encodeInt, IdentityTestId.encoder)
  implicit lazy val read: Read[IdentityTestRow] = new Read[IdentityTestRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (IdentityTestId.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => IdentityTestRow(
      alwaysGenerated = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      defaultGenerated = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
      name = IdentityTestId.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
  implicit lazy val text: Text[IdentityTestRow] = Text.instance[IdentityTestRow]{ (row, sb) =>
    Text.intInstance.unsafeEncode(row.alwaysGenerated, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.defaultGenerated, sb)
    sb.append(Text.DELIMETER)
    IdentityTestId.text.unsafeEncode(row.name, sb)
  }
}
