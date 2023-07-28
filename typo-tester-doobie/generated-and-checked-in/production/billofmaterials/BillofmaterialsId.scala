/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `production.billofmaterials` */
case class BillofmaterialsId(value: Int) extends AnyVal
object BillofmaterialsId {
  implicit val ordering: Ordering[BillofmaterialsId] = Ordering.by(_.value)
  implicit val encoder: Encoder[BillofmaterialsId] =
    Encoder[Int].contramap(_.value)
  implicit val decoder: Decoder[BillofmaterialsId] =
    Decoder[Int].map(BillofmaterialsId(_))
  implicit val metaArray: Meta[Array[BillofmaterialsId]] = Meta[Array[Int]].imap(_.map(BillofmaterialsId.apply))(_.map(_.value))
  implicit val meta: Meta[BillofmaterialsId] = Meta[Int].imap(BillofmaterialsId.apply)(_.value)
}