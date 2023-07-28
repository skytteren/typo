/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `production.productmodelproductdescriptionculture` */
case class ProductmodelproductdescriptioncultureId(productmodelid: ProductmodelId, productdescriptionid: ProductdescriptionId, cultureid: CultureId)
object ProductmodelproductdescriptioncultureId {
  implicit val decoder: Decoder[ProductmodelproductdescriptioncultureId] = Decoder.forProduct3[ProductmodelproductdescriptioncultureId, ProductmodelId, ProductdescriptionId, CultureId]("productmodelid", "productdescriptionid", "cultureid")(ProductmodelproductdescriptioncultureId.apply)
  implicit val encoder: Encoder[ProductmodelproductdescriptioncultureId] = Encoder.forProduct3[ProductmodelproductdescriptioncultureId, ProductmodelId, ProductdescriptionId, CultureId]("productmodelid", "productdescriptionid", "cultureid")(x => (x.productmodelid, x.productdescriptionid, x.cultureid))
  implicit val ordering: Ordering[ProductmodelproductdescriptioncultureId] = Ordering.by(x => (x.productmodelid, x.productdescriptionid, x.cultureid))
}
