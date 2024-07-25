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

/** Domain `information_schema.character_data`
  * No constraint
  */
case class CharacterData(value: String)
object CharacterData {
  implicit lazy val arrayGet: Get[Array[CharacterData]] = adventureworks.StringArrayMeta.get.map(_.map(CharacterData.apply))
  implicit lazy val arrayPut: Put[Array[CharacterData]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CharacterData, String] = Bijection[CharacterData, String](_.value)(CharacterData.apply)
  implicit lazy val decoder: Decoder[CharacterData] = Decoder.decodeString.map(CharacterData.apply)
  implicit lazy val encoder: Encoder[CharacterData] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[CharacterData] = Meta.StringMeta.get.map(CharacterData.apply)
  implicit lazy val ordering: Ordering[CharacterData] = Ordering.by(_.value)
  implicit lazy val put: Put[CharacterData] = Meta.StringMeta.put.contramap(_.value)
  implicit lazy val text: Text[CharacterData] = new Text[CharacterData] {
    override def unsafeEncode(v: CharacterData, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: CharacterData, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}