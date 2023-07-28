/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productmodelillustration` which has not been persisted yet */
case class ProductmodelillustrationRowUnsaved(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to Illustration.IllustrationID.
      Points to [[illustration.IllustrationRow.illustrationid]] */
  illustrationid: IllustrationId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): ProductmodelillustrationRow =
    ProductmodelillustrationRow(
      productmodelid = productmodelid,
      illustrationid = illustrationid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelillustrationRowUnsaved {
  implicit val decoder: Decoder[ProductmodelillustrationRowUnsaved] = Decoder.forProduct3[ProductmodelillustrationRowUnsaved, ProductmodelId, IllustrationId, Defaulted[TypoLocalDateTime]]("productmodelid", "illustrationid", "modifieddate")(ProductmodelillustrationRowUnsaved.apply)
  implicit val encoder: Encoder[ProductmodelillustrationRowUnsaved] = Encoder.forProduct3[ProductmodelillustrationRowUnsaved, ProductmodelId, IllustrationId, Defaulted[TypoLocalDateTime]]("productmodelid", "illustrationid", "modifieddate")(x => (x.productmodelid, x.illustrationid, x.modifieddate))
}
