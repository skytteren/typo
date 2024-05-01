/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.userdefined.CustomCreditcardId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: sales.creditcard
    Customer credit card information.
    Primary key: creditcardid */
case class CreditcardRow(
  /** Primary key for CreditCard records.
      Default: nextval('sales.creditcard_creditcardid_seq'::regclass) */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Credit card name. */
  cardtype: /* max 50 chars */ String,
  /** Credit card number. */
  cardnumber: /* max 25 chars */ String,
  /** Credit card expiration month. */
  expmonth: TypoShort,
  /** Credit card expiration year. */
  expyear: TypoShort,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(creditcardid: Defaulted[/* user-picked */ CustomCreditcardId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CreditcardRowUnsaved =
     CreditcardRowUnsaved(cardtype, cardnumber, expmonth, expyear, creditcardid, modifieddate)
 }

object CreditcardRow {
  implicit lazy val decoder: Decoder[CreditcardRow] = Decoder.forProduct6[CreditcardRow, /* user-picked */ CustomCreditcardId, /* max 50 chars */ String, /* max 25 chars */ String, TypoShort, TypoShort, TypoLocalDateTime]("creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")(CreditcardRow.apply)(CustomCreditcardId.decoder, Decoder.decodeString, Decoder.decodeString, TypoShort.decoder, TypoShort.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CreditcardRow] = Encoder.forProduct6[CreditcardRow, /* user-picked */ CustomCreditcardId, /* max 50 chars */ String, /* max 25 chars */ String, TypoShort, TypoShort, TypoLocalDateTime]("creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")(x => (x.creditcardid, x.cardtype, x.cardnumber, x.expmonth, x.expyear, x.modifieddate))(CustomCreditcardId.encoder, Encoder.encodeString, Encoder.encodeString, TypoShort.encoder, TypoShort.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CreditcardRow] = new Read[CreditcardRow](
    gets = List(
      (/* user-picked */ CustomCreditcardId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CreditcardRow(
      creditcardid = /* user-picked */ CustomCreditcardId.get.unsafeGetNonNullable(rs, i + 0),
      cardtype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      cardnumber = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      expmonth = TypoShort.get.unsafeGetNonNullable(rs, i + 3),
      expyear = TypoShort.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
  implicit lazy val text: Text[CreditcardRow] = Text.instance[CreditcardRow]{ (row, sb) =>
    /* user-picked */ CustomCreditcardId.text.unsafeEncode(row.creditcardid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.cardtype, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.cardnumber, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.expmonth, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.expyear, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
