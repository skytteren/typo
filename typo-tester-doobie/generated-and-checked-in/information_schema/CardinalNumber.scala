/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Domain `information_schema.cardinal_number`
  * Constraint: CHECK ((VALUE >= 0))
  */
case class CardinalNumber(value: Int) extends AnyVal
object CardinalNumber {
  implicit val arrayGet: Get[Array[CardinalNumber]] = Get[Array[Int]].map(_.map(CardinalNumber.apply))
  implicit val arrayPut: Put[Array[CardinalNumber]] = Put[Array[Int]].contramap(_.map(_.value))
  implicit val decoder: Decoder[CardinalNumber] = Decoder[Int].map(CardinalNumber.apply)
  implicit val encoder: Encoder[CardinalNumber] = Encoder[Int].contramap(_.value)
  implicit val get: Get[CardinalNumber] = Get[Int].map(CardinalNumber.apply)
  implicit val ordering: Ordering[CardinalNumber] = Ordering.by(_.value)
  implicit val put: Put[CardinalNumber] = Put[Int].contramap(_.value)
}
