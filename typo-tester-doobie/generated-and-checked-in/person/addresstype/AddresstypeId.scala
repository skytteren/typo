/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `person.addresstype` */
case class AddresstypeId(value: Int) extends AnyVal
object AddresstypeId {
  implicit val arrayGet: Get[Array[AddresstypeId]] = Get[Array[Int]].map(_.map(AddresstypeId.apply))
  implicit val arrayPut: Put[Array[AddresstypeId]] = Put[Array[Int]].contramap(_.map(_.value))
  implicit val decoder: Decoder[AddresstypeId] = Decoder[Int].map(AddresstypeId.apply)
  implicit val encoder: Encoder[AddresstypeId] = Encoder[Int].contramap(_.value)
  implicit val get: Get[AddresstypeId] = Get[Int].map(AddresstypeId.apply)
  implicit val ordering: Ordering[AddresstypeId] = Ordering.by(_.value)
  implicit val put: Put[AddresstypeId] = Put[Int].contramap(_.value)
}
