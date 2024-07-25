/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Domain `information_schema.yes_or_no`
  * Constraint: CHECK (((VALUE)::text = ANY ((ARRAY['YES'::character varying, 'NO'::character varying])::text[])))
  */
case class YesOrNo(value: String)
object YesOrNo {
  implicit lazy val arrayGet: Get[Array[YesOrNo]] = adventureworks.StringArrayMeta.get.map(_.map(YesOrNo.apply))
  implicit lazy val arrayPut: Put[Array[YesOrNo]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[YesOrNo, String] = Bijection[YesOrNo, String](_.value)(YesOrNo.apply)
  implicit lazy val decoder: Decoder[YesOrNo] = Decoder.decodeString.map(YesOrNo.apply)
  implicit lazy val encoder: Encoder[YesOrNo] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[YesOrNo] = Meta.StringMeta.get.map(YesOrNo.apply)
  implicit lazy val ordering: Ordering[YesOrNo] = Ordering.by(_.value)
  implicit lazy val put: Put[YesOrNo] = Meta.StringMeta.put.contramap(_.value)
  implicit lazy val text: Text[YesOrNo] = new Text[YesOrNo] {
    override def unsafeEncode(v: YesOrNo, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: YesOrNo, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}