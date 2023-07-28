/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `sales.creditcard` */
case class CreditcardId(value: Int) extends AnyVal
object CreditcardId {
  implicit val arrayGet: Get[Array[CreditcardId]] = Get[Array[Int]].map(_.map(CreditcardId.apply))
  implicit val arrayPut: Put[Array[CreditcardId]] = Put[Array[Int]].contramap(_.map(_.value))
  implicit val decoder: Decoder[CreditcardId] = Decoder[Int].map(CreditcardId.apply)
  implicit val encoder: Encoder[CreditcardId] = Encoder[Int].contramap(_.value)
  implicit val get: Get[CreditcardId] = Get[Int].map(CreditcardId.apply)
  implicit val ordering: Ordering[CreditcardId] = Ordering.by(_.value)
  implicit val put: Put[CreditcardId] = Put[Int].contramap(_.value)
}
