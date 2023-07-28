/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `myschema.marital_status` */
case class MaritalStatusId(value: Long) extends AnyVal
object MaritalStatusId {
  implicit val arrayGet: Get[Array[MaritalStatusId]] = Get[Array[Long]].map(_.map(MaritalStatusId.apply))
  implicit val arrayPut: Put[Array[MaritalStatusId]] = Put[Array[Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[MaritalStatusId] = Decoder[Long].map(MaritalStatusId.apply)
  implicit val encoder: Encoder[MaritalStatusId] = Encoder[Long].contramap(_.value)
  implicit val get: Get[MaritalStatusId] = Get[Long].map(MaritalStatusId.apply)
  implicit val ordering: Ordering[MaritalStatusId] = Ordering.by(_.value)
  implicit val put: Put[MaritalStatusId] = Put[Long].contramap(_.value)
}
