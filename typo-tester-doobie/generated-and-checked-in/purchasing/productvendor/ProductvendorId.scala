/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json

/** Type for the composite primary key of table `purchasing.productvendor` */
case class ProductvendorId(productid: ProductId, businessentityid: BusinessentityId)
object ProductvendorId {
  implicit def ordering: Ordering[ProductvendorId] = Ordering.by(x => (x.productid, x.businessentityid))
  implicit val decoder: Decoder[ProductvendorId] =
    (c: HCursor) =>
      for {
        productid <- c.downField("productid").as[ProductId]
        businessentityid <- c.downField("businessentityid").as[BusinessentityId]
      } yield ProductvendorId(productid, businessentityid)
  implicit val encoder: Encoder[ProductvendorId] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "productid" := row.productid,
        "businessentityid" := row.businessentityid
      )}
}