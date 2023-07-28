/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import cats.data.NonEmptyList
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.geometric.PGcircle

/** This represents circle datatype in PostgreSQL, consisting of a point and a radius */
case class TypoCircle(center: TypoPoint, radius: Double)

object TypoCircle {
  implicit val arrayGet: Get[Array[TypoCircle]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_circle"))
    .map(_.map(v => TypoCircle(TypoPoint(v.asInstanceOf[PGcircle].center.x, v.asInstanceOf[PGcircle].center.y), v.asInstanceOf[PGcircle].radius)))
  implicit val arrayPut: Put[Array[TypoCircle]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_circle"), "circle")
    .contramap(_.map(v => new PGcircle(v.center.x, v.center.y, v.radius)))
  implicit val decoder: Decoder[TypoCircle] = Decoder.forProduct2[TypoCircle, TypoPoint, Double]("center", "radius")(TypoCircle.apply)
  implicit val encoder: Encoder[TypoCircle] = Encoder.forProduct2[TypoCircle, TypoPoint, Double]("center", "radius")(x => (x.center, x.radius))
  implicit val get: Get[TypoCircle] = Get.Advanced.other[PGcircle](NonEmptyList.one("circle"))
    .map(v => TypoCircle(TypoPoint(v.center.x, v.center.y), v.radius))
  implicit val put: Put[TypoCircle] = Put.Advanced.other[PGcircle](NonEmptyList.one("circle")).contramap(v => new PGcircle(v.center.x, v.center.y, v.radius))
}
