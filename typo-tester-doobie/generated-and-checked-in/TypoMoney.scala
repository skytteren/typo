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

/** Money and cash types in PostgreSQL */
case class TypoMoney(value: BigDecimal)

object TypoMoney {
  implicit val arrayGet: Get[Array[TypoMoney]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_money"))
    .map(_.map(v => TypoMoney(BigDecimal(v.asInstanceOf[java.math.BigDecimal]))))
  implicit val arrayPut: Put[Array[TypoMoney]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_money"), "money")
    .contramap(_.map(v => v.value.bigDecimal))
  implicit val decoder: Decoder[TypoMoney] = Decoder.decodeBigDecimal.map(TypoMoney.apply)
  implicit val encoder: Encoder[TypoMoney] = Encoder.encodeBigDecimal.contramap(_.value)
  implicit val get: Get[TypoMoney] = Get.Advanced.other[java.math.BigDecimal](NonEmptyList.one("money"))
    .map(v => TypoMoney(BigDecimal(v)))
  implicit val ordering: Ordering[TypoMoney] = Ordering.by(_.value)
  implicit val put: Put[TypoMoney] = Put.Advanced.other[java.math.BigDecimal](NonEmptyList.one("money")).contramap(v => v.value.bigDecimal)
}
