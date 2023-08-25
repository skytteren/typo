/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.userdefined.CustomCreditcardId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class CreditcardRow(
  /** Primary key for CreditCard records. */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Credit card name. */
  cardtype: /* max 50 chars */ String,
  /** Credit card number. */
  cardnumber: /* max 25 chars */ String,
  /** Credit card expiration month. */
  expmonth: Int,
  /** Credit card expiration year. */
  expyear: Int,
  modifieddate: TypoLocalDateTime
)

object CreditcardRow {
  implicit lazy val decoder: Decoder[CreditcardRow] = Decoder.forProduct6[CreditcardRow, /* user-picked */ CustomCreditcardId, /* max 50 chars */ String, /* max 25 chars */ String, Int, Int, TypoLocalDateTime]("creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")(CreditcardRow.apply)(CustomCreditcardId.decoder, Decoder.decodeString, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeInt, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CreditcardRow] = Encoder.forProduct6[CreditcardRow, /* user-picked */ CustomCreditcardId, /* max 50 chars */ String, /* max 25 chars */ String, Int, Int, TypoLocalDateTime]("creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")(x => (x.creditcardid, x.cardtype, x.cardnumber, x.expmonth, x.expyear, x.modifieddate))(CustomCreditcardId.encoder, Encoder.encodeString, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeInt, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CreditcardRow] = new Read[CreditcardRow](
    gets = List(
      (/* user-picked */ CustomCreditcardId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CreditcardRow(
      creditcardid = /* user-picked */ CustomCreditcardId.get.unsafeGetNonNullable(rs, i + 0),
      cardtype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      cardnumber = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      expmonth = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      expyear = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}