/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `purchasing.purchaseorderheader` */
case class PurchaseorderheaderId(value: Int) extends AnyVal
object PurchaseorderheaderId {
  implicit val ordering: Ordering[PurchaseorderheaderId] = Ordering.by(_.value)
  implicit val encoder: Encoder[PurchaseorderheaderId] =
    Encoder[Int].contramap(_.value)
  implicit val decoder: Decoder[PurchaseorderheaderId] =
    Decoder[Int].map(PurchaseorderheaderId(_))
  implicit val metaArray: Meta[Array[PurchaseorderheaderId]] = Meta[Array[Int]].imap(_.map(PurchaseorderheaderId.apply))(_.map(_.value))
  implicit val meta: Meta[PurchaseorderheaderId] = Meta[Int].imap(PurchaseorderheaderId.apply)(_.value)
}