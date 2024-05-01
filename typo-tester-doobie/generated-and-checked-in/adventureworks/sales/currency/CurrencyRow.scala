/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: sales.currency
    Lookup table containing standard ISO currencies.
    Primary key: currencycode */
case class CurrencyRow(
  /** The ISO code for the Currency. */
  currencycode: CurrencyId,
  /** Currency name. */
  name: Name,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CurrencyRowUnsaved =
     CurrencyRowUnsaved(currencycode, name, modifieddate)
 }

object CurrencyRow {
  implicit lazy val decoder: Decoder[CurrencyRow] = Decoder.forProduct3[CurrencyRow, CurrencyId, Name, TypoLocalDateTime]("currencycode", "name", "modifieddate")(CurrencyRow.apply)(CurrencyId.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CurrencyRow] = Encoder.forProduct3[CurrencyRow, CurrencyId, Name, TypoLocalDateTime]("currencycode", "name", "modifieddate")(x => (x.currencycode, x.name, x.modifieddate))(CurrencyId.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CurrencyRow] = new Read[CurrencyRow](
    gets = List(
      (CurrencyId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CurrencyRow(
      currencycode = CurrencyId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
  implicit lazy val text: Text[CurrencyRow] = Text.instance[CurrencyRow]{ (row, sb) =>
    CurrencyId.text.unsafeEncode(row.currencycode, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
