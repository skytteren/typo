/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `production.productphoto` */
case class ProductphotoId(value: Int) extends AnyVal
object ProductphotoId {
  implicit val ordering: Ordering[ProductphotoId] = Ordering.by(_.value)
  implicit val encoder: Encoder[ProductphotoId] =
    Encoder[Int].contramap(_.value)
  implicit val decoder: Decoder[ProductphotoId] =
    Decoder[Int].map(ProductphotoId(_))
  implicit val metaArray: Meta[Array[ProductphotoId]] = Meta[Array[Int]].imap(_.map(ProductphotoId.apply))(_.map(_.value))
  implicit val meta: Meta[ProductphotoId] = Meta[Int].imap(ProductphotoId.apply)(_.value)
}