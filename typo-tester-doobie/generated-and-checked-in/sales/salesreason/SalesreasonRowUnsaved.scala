/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesreason

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `sales.salesreason` which has not been persisted yet */
case class SalesreasonRowUnsaved(
  /** Sales reason description. */
  name: Name,
  /** Category the sales reason belongs to. */
  reasontype: Name,
  /** Default: nextval('sales.salesreason_salesreasonid_seq'::regclass)
      Primary key for SalesReason records. */
  salesreasonid: Defaulted[SalesreasonId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(salesreasonidDefault: => SalesreasonId, modifieddateDefault: => TypoLocalDateTime): SalesreasonRow =
    SalesreasonRow(
      name = name,
      reasontype = reasontype,
      salesreasonid = salesreasonid match {
                        case Defaulted.UseDefault => salesreasonidDefault
                        case Defaulted.Provided(value) => value
                      },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalesreasonRowUnsaved {
  implicit val decoder: Decoder[SalesreasonRowUnsaved] = Decoder.forProduct4[SalesreasonRowUnsaved, Name, Name, Defaulted[SalesreasonId], Defaulted[TypoLocalDateTime]]("name", "reasontype", "salesreasonid", "modifieddate")(SalesreasonRowUnsaved.apply)
  implicit val encoder: Encoder[SalesreasonRowUnsaved] = Encoder.forProduct4[SalesreasonRowUnsaved, Name, Name, Defaulted[SalesreasonId], Defaulted[TypoLocalDateTime]]("name", "reasontype", "salesreasonid", "modifieddate")(x => (x.name, x.reasontype, x.salesreasonid, x.modifieddate))
}
