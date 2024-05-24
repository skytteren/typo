/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import cats.data.NonEmptyList
import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.geometric.PGbox

/** This represents the box datatype in PostgreSQL */
case class TypoBox(x1: Double, y1: Double, x2: Double, y2: Double)

object TypoBox {
  implicit lazy val arrayGet: Get[Array[TypoBox]] = Get.Advanced.array[AnyRef](NonEmptyList.one("box[]"))
    .map(_.map(v => TypoBox(v.asInstanceOf[PGbox].point(0).x, v.asInstanceOf[PGbox].point(0).y, v.asInstanceOf[PGbox].point(1).x, v.asInstanceOf[PGbox].point(1).y)))
  implicit lazy val arrayPut: Put[Array[TypoBox]] = Put.Advanced.array[AnyRef](NonEmptyList.one("box[]"), "box")
    .contramap(_.map(v => new PGbox(v.x1, v.y1, v.x2, v.y2)))
  implicit lazy val decoder: Decoder[TypoBox] = Decoder.forProduct4[TypoBox, Double, Double, Double, Double]("x1", "y1", "x2", "y2")(TypoBox.apply)(Decoder.decodeDouble, Decoder.decodeDouble, Decoder.decodeDouble, Decoder.decodeDouble)
  implicit lazy val encoder: Encoder[TypoBox] = Encoder.forProduct4[TypoBox, Double, Double, Double, Double]("x1", "y1", "x2", "y2")(x => (x.x1, x.y1, x.x2, x.y2))(Encoder.encodeDouble, Encoder.encodeDouble, Encoder.encodeDouble, Encoder.encodeDouble)
  implicit lazy val get: Get[TypoBox] = Get.Advanced.other[PGbox](NonEmptyList.one("box"))
    .map(v => TypoBox(v.point(0).x, v.point(0).y, v.point(1).x, v.point(1).y))
  implicit lazy val ordering: Ordering[TypoBox] = Ordering.by(x => (x.x1, x.y1, x.x2, x.y2))
  implicit lazy val put: Put[TypoBox] = Put.Advanced.other[PGbox](NonEmptyList.one("box")).contramap(v => new PGbox(v.x1, v.y1, v.x2, v.y2))
  implicit lazy val text: Text[TypoBox] = new Text[TypoBox] {
    override def unsafeEncode(v: TypoBox, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"((${v.x1},${v.y1}),(${v.x2},${v.y2}))", sb)
    override def unsafeArrayEncode(v: TypoBox, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"((${v.x1},${v.y1}),(${v.x2},${v.y2}))", sb)
  }
}
