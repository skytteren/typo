/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `sales.specialofferproduct` */
case class SpecialofferproductId(specialofferid: SpecialofferId, productid: ProductId)
object SpecialofferproductId {
  implicit val decoder: Decoder[SpecialofferproductId] = Decoder.forProduct2[SpecialofferproductId, SpecialofferId, ProductId]("specialofferid", "productid")(SpecialofferproductId.apply)
  implicit val encoder: Encoder[SpecialofferproductId] = Encoder.forProduct2[SpecialofferproductId, SpecialofferId, ProductId]("specialofferid", "productid")(x => (x.specialofferid, x.productid))
  implicit val ordering: Ordering[SpecialofferproductId] = Ordering.by(x => (x.specialofferid, x.productid))
}
