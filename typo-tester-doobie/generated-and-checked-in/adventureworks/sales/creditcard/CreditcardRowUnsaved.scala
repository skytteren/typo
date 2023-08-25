/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.userdefined.CustomCreditcardId
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `sales.creditcard` which has not been persisted yet */
case class CreditcardRowUnsaved(
  /** Credit card name. */
  cardtype: /* max 50 chars */ String,
  /** Credit card number. */
  cardnumber: /* max 25 chars */ String,
  /** Credit card expiration month. */
  expmonth: Int,
  /** Credit card expiration year. */
  expyear: Int,
  /** Default: nextval('sales.creditcard_creditcardid_seq'::regclass)
      Primary key for CreditCard records. */
  creditcardid: Defaulted[/* user-picked */ CustomCreditcardId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(creditcardidDefault: => /* user-picked */ CustomCreditcardId, modifieddateDefault: => TypoLocalDateTime): CreditcardRow =
    CreditcardRow(
      cardtype = cardtype,
      cardnumber = cardnumber,
      expmonth = expmonth,
      expyear = expyear,
      creditcardid = creditcardid match {
                       case Defaulted.UseDefault => creditcardidDefault
                       case Defaulted.Provided(value) => value
                     },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CreditcardRowUnsaved {
  implicit lazy val decoder: Decoder[CreditcardRowUnsaved] = Decoder.forProduct6[CreditcardRowUnsaved, /* max 50 chars */ String, /* max 25 chars */ String, Int, Int, Defaulted[/* user-picked */ CustomCreditcardId], Defaulted[TypoLocalDateTime]]("cardtype", "cardnumber", "expmonth", "expyear", "creditcardid", "modifieddate")(CreditcardRowUnsaved.apply)(Decoder.decodeString, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeInt, Defaulted.decoder(CustomCreditcardId.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[CreditcardRowUnsaved] = Encoder.forProduct6[CreditcardRowUnsaved, /* max 50 chars */ String, /* max 25 chars */ String, Int, Int, Defaulted[/* user-picked */ CustomCreditcardId], Defaulted[TypoLocalDateTime]]("cardtype", "cardnumber", "expmonth", "expyear", "creditcardid", "modifieddate")(x => (x.cardtype, x.cardnumber, x.expmonth, x.expyear, x.creditcardid, x.modifieddate))(Encoder.encodeString, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeInt, Defaulted.encoder(CustomCreditcardId.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
}