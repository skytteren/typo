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
import org.postgresql.util.PGobject

/** int2vector (via PGObject) */
case class TypoInt2Vector(value: String)

object TypoInt2Vector {
  implicit val arrayGet: Get[Array[TypoInt2Vector]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_int2vector"))
    .map(_.map(v => TypoInt2Vector(v.asInstanceOf[String])))
  implicit val arrayPut: Put[Array[TypoInt2Vector]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_int2vector"), "int2vector")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("int2vector")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit val decoder: Decoder[TypoInt2Vector] = Decoder.decodeString.map(TypoInt2Vector.apply)
  implicit val encoder: Encoder[TypoInt2Vector] = Encoder.encodeString.contramap(_.value)
  implicit val get: Get[TypoInt2Vector] = Get.Advanced.other[PGobject](NonEmptyList.one("int2vector"))
    .map(v => TypoInt2Vector(v.getValue))
  implicit val ordering: Ordering[TypoInt2Vector] = Ordering.by(_.value)
  implicit val put: Put[TypoInt2Vector] = Put.Advanced.other[PGobject](NonEmptyList.one("int2vector")).contramap(v => {
                                                                                val obj = new PGobject
                                                                                obj.setType("int2vector")
                                                                                obj.setValue(v.value)
                                                                                obj
                                                                              })
}
