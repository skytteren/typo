/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Domain `public.NameStyle`
  * No constraint
  */
case class NameStyle(value: Boolean) extends AnyVal
object NameStyle {
  implicit val arrayGet: Get[Array[NameStyle]] = Get[Array[Boolean]].map(_.map(NameStyle.apply))
  implicit val arrayPut: Put[Array[NameStyle]] = Put[Array[Boolean]].contramap(_.map(_.value))
  implicit val decoder: Decoder[NameStyle] = Decoder[Boolean].map(NameStyle.apply)
  implicit val encoder: Encoder[NameStyle] = Encoder[Boolean].contramap(_.value)
  implicit val get: Get[NameStyle] = Get[Boolean].map(NameStyle.apply)
  implicit val ordering: Ordering[NameStyle] = Ordering.by(_.value)
  implicit val put: Put[NameStyle] = Put[Boolean].contramap(_.value)
}
