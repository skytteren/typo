/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `production.productcategory` which has not been persisted yet */
case class ProductcategoryRowUnsaved(
  /** Category description. */
  name: Name,
  /** Default: nextval('production.productcategory_productcategoryid_seq'::regclass)
      Primary key for ProductCategory records. */
  productcategoryid: Defaulted[ProductcategoryId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productcategoryidDefault: => ProductcategoryId, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): ProductcategoryRow =
    ProductcategoryRow(
      name = name,
      productcategoryid = productcategoryid match {
                            case Defaulted.UseDefault => productcategoryidDefault
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
object ProductcategoryRowUnsaved {
  implicit lazy val decoder: Decoder[ProductcategoryRowUnsaved] = Decoder.forProduct4[ProductcategoryRowUnsaved, Name, Defaulted[ProductcategoryId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("name", "productcategoryid", "rowguid", "modifieddate")(ProductcategoryRowUnsaved.apply)(Name.decoder, Defaulted.decoder(ProductcategoryId.decoder), Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ProductcategoryRowUnsaved] = Encoder.forProduct4[ProductcategoryRowUnsaved, Name, Defaulted[ProductcategoryId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("name", "productcategoryid", "rowguid", "modifieddate")(x => (x.name, x.productcategoryid, x.rowguid, x.modifieddate))(Name.encoder, Defaulted.encoder(ProductcategoryId.encoder), Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}