/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `myschema.person` */
case class PersonId(value: Long) extends AnyVal
object PersonId {
  implicit val arrayGet: Get[Array[PersonId]] = Get[Array[Long]].map(_.map(PersonId.apply))
  implicit val arrayPut: Put[Array[PersonId]] = Put[Array[Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[PersonId] = Decoder[Long].map(PersonId.apply)
  implicit val encoder: Encoder[PersonId] = Encoder[Long].contramap(_.value)
  implicit val get: Get[PersonId] = Get[Long].map(PersonId.apply)
  implicit val ordering: Ordering[PersonId] = Ordering.by(_.value)
  implicit val put: Put[PersonId] = Put[Long].contramap(_.value)
}
