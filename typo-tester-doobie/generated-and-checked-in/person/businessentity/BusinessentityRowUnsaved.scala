/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `person.businessentity` which has not been persisted yet */
case class BusinessentityRowUnsaved(
  /** Default: nextval('person.businessentity_businessentityid_seq'::regclass)
      Primary key for all customers, vendors, and employees. */
  businessentityid: Defaulted[BusinessentityId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(businessentityidDefault: => BusinessentityId, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): BusinessentityRow =
    BusinessentityRow(
      businessentityid = businessentityid match {
                           case Defaulted.UseDefault => businessentityidDefault
                           case Defaulted.Provided(value) => value
                         },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BusinessentityRowUnsaved {
  implicit val decoder: Decoder[BusinessentityRowUnsaved] = Decoder.forProduct3[BusinessentityRowUnsaved, Defaulted[BusinessentityId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "rowguid", "modifieddate")(BusinessentityRowUnsaved.apply)
  implicit val encoder: Encoder[BusinessentityRowUnsaved] = Encoder.forProduct3[BusinessentityRowUnsaved, Defaulted[BusinessentityId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "rowguid", "modifieddate")(x => (x.businessentityid, x.rowguid, x.modifieddate))
}
