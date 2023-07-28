/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `person.businessentity` */
case class BusinessentityId(value: Int) extends AnyVal
object BusinessentityId {
  implicit val arrayGet: Get[Array[BusinessentityId]] = Get[Array[Int]].map(_.map(BusinessentityId.apply))
  implicit val arrayPut: Put[Array[BusinessentityId]] = Put[Array[Int]].contramap(_.map(_.value))
  implicit val decoder: Decoder[BusinessentityId] = Decoder[Int].map(BusinessentityId.apply)
  implicit val encoder: Encoder[BusinessentityId] = Encoder[Int].contramap(_.value)
  implicit val get: Get[BusinessentityId] = Get[Int].map(BusinessentityId.apply)
  implicit val ordering: Ordering[BusinessentityId] = Ordering.by(_.value)
  implicit val put: Put[BusinessentityId] = Put[Int].contramap(_.value)
}
